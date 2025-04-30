import requests
import json
import sys
import re

# ✅ Force UTF-8 Encoding for Jenkins Output
sys.stdout.reconfigure(encoding='utf-8')

# 🔹 Confluence API Details
CONFLUENCE_USER = "documentation@thinktime.in"
API_TOKEN = "ATATT3xFfGF0ZPqDH2NNlaxVr1cT7tRwFqoZv8vjOqt9B8saRojjujz9Fj5guUkJavKTKck8ZBIi_a3GEuS2vIFFOogJzx229f5rDzCg-kK_G3YmQop0SmeFAvORCJ2mABI5xxf5d7s8yM-pagzqkD-lSYwHUH3Fud8cPC81Mh8MRz0qb3ezeAY=C8B6D312"
CONFLUENCE_URL = "https://thinktime-qahub.atlassian.net/wiki/rest/api/content"

def debug_print_html(html):
    """Helper function to print HTML content for debugging"""
    print("\n🔹 DEBUG - HTML Content (first 1000 chars):")
    print(html[:1000])
    print("... [truncated] ...\n")

# 🔹 Jenkins Job Details (Passed as Arguments)
if len(sys.argv) < 5:
    print("❌ Missing Arguments! Usage: python update_confluence.py <Scenario_Name> <Status> <Execution_Time> <Page_ID>")
    sys.exit(1)

scenario_name = sys.argv[1]  # e.g., SU_TC01_Register_with_valid_credentials
build_status = sys.argv[2]   # e.g., PASSED or FAILED
execution_time = sys.argv[3] # e.g., 2025-03-26 06:13:24
PAGE_ID = sys.argv[4]        # e.g., 6291841

print(f"\n🔹 Starting update for scenario: {scenario_name}")
print(f"🔹 Status: {build_status}")
print(f"🔹 Execution Time: {execution_time}")
print(f"🔹 Page ID: {PAGE_ID}\n")

# 🔹 Add Emoji based on status (New addition)
status_with_emoji = build_status  # Default to original status
if build_status.upper() == "PASSED":
    status_with_emoji = "✅ PASSED"
elif build_status.upper() == "FAILED":
    status_with_emoji = "❌ FAILED"

# 🔹 Fetch Confluence Page Content
auth = (CONFLUENCE_USER, API_TOKEN)
headers = {"Content-Type": "application/json"}

try:
    response = requests.get(
        f"{CONFLUENCE_URL}/{PAGE_ID}?expand=body.storage,version", 
        auth=auth, 
        headers=headers,
        timeout=10
    )
    response.raise_for_status()
except requests.exceptions.RequestException as e:
    print(f"❌ API Request Failed! Error: {str(e)}")
    if hasattr(e, 'response') and e.response:
        print(f"🔹 Status Code: {e.response.status_code}")
        print(f"🔹 Response: {e.response.text[:500]}")  # Print first 500 chars of error
    sys.exit(1)

page_data = response.json()
page_body = page_data["body"]["storage"]["value"]
version_number = page_data["version"]["number"]

print("\n✅ Confluence Page Retrieved Successfully!\n")

# 🔹 Debug: Print page body if needed
debug_print_html(page_body)

# 🔹 Find Table in Confluence Page
# More flexible table search pattern
table_match = re.search(r'<table[^>]*>.*?</table>', page_body, re.DOTALL | re.IGNORECASE)

if not table_match:
    print("\n❌ No Table Found in Confluence Page!")
    print("Possible reasons:")
    print("1. The page doesn't contain any tables")
    print("2. The table is using a different HTML structure")
    print("3. The page might be using a different storage format")
    print("\n🔹 Please check the page content manually:")
    print(f"https://thinktime-qahub.atlassian.net/wiki/spaces/~6341f86e4a69e10069e8b8a4/pages/{PAGE_ID}")
    sys.exit(1)

table_html = table_match.group(0)
print(f"\n🔹 Found table with {len(table_html)} characters")

# 🔹 Find the Row Matching the Scenario Name
# More flexible row pattern that handles various HTML structures
row_pattern = rf'(<tr[^>]*>\s*<td[^>]*>\s*(?:<[^>]+>)*\s*{re.escape(scenario_name)}\s*(?:</[^>]+>)*\s*</td>\s*<td[^>]*>.*?</td>\s*<td[^>]*>.*?</td>\s*<td[^>]*>.*?</td>\s*<td[^>]*>)(.*?)(</td>\s*<td[^>]*>)(.*?)(</td>)'
row_match = re.search(row_pattern, table_html, re.DOTALL | re.IGNORECASE)

# ✅ Center-aligned values using Confluence Macros
execution_time_centered = f'<ac:structured-macro ac:name="center"><ac:rich-text-body>{execution_time}</ac:rich-text-body></ac:structured-macro>'
# Updated to use status_with_emoji instead of build_status
build_status_centered = f'<ac:structured-macro ac:name="center"><ac:rich-text-body>{status_with_emoji}</ac:rich-text-body></ac:structured-macro>'

if row_match:
    print(f"\n🔄 Updating existing scenario '{scenario_name}'...\n")
    
    # Replace the "Last Trigger Time" and "Status" columns with Confluence center-aligned values
    updated_row = f'{row_match.group(1)}{execution_time_centered}{row_match.group(3)}{build_status_centered}{row_match.group(5)}'
    updated_table = re.sub(row_pattern, updated_row, table_html, flags=re.DOTALL | re.IGNORECASE)
else:
    print(f"\n⚠ No matching scenario found for '{scenario_name}'. Adding a new row!\n")
    
    # Create a new row with placeholders and center-aligned execution time & status
    new_row = f'''<tr>
        <td><p>{scenario_name}</p></td>
        <td><p>-</p></td>
        <td><p>-</p></td>
        <td><p>-</p></td>
        <td>{execution_time_centered}</td>
        <td>{build_status_centered}</td>
        <td><p>-</p></td>
    </tr>'''
    
    # Insert new row before the closing table tag
    if "</tbody>" in table_html:
        updated_table = table_html.replace("</tbody>", f"{new_row}\n</tbody>")
    else:
        updated_table = table_html.replace("</table>", f"{new_row}\n</table>")

# 🔹 Replace the old table with the updated table in the page content
updated_body = page_body.replace(table_html, updated_table)

# 🔹 Prepare Payload to Update Confluence
update_payload = {
    "id": PAGE_ID,
    "type": "page",
    "title": page_data["title"],
    "version": {"number": version_number + 1},
    "body": {"storage": {"value": updated_body, "representation": "storage"}}
}

# 🔹 Send Update Request to Confluence
try:
    update_response = requests.put(
        f"{CONFLUENCE_URL}/{PAGE_ID}",
        auth=auth,
        headers=headers,
        data=json.dumps(update_payload),
        timeout=10
    )
    update_response.raise_for_status()
except requests.exceptions.RequestException as e:
    print(f"\n❌ API Request Failed! Error: {str(e)}")
    if hasattr(e, 'response') and e.response:
        print(f"🔹 Status Code: {e.response.status_code}")
        print(f"🔹 Response: {e.response.text[:500]}")  # Print first 500 chars of error
    sys.exit(1)

if update_response.status_code == 200:
    print("\n✅ Confluence Page Updated Successfully!\n")
    print(f"🔹 Updated Page URL: https://thinktime-qahub.atlassian.net/wiki/spaces/~6341f86e4a69e10069e8b8a4/pages/{PAGE_ID}")
else:
    print(f"\n❌ Unexpected Status Code: {update_response.status_code}")
    print(f"🔹 Response: {update_response.text[:500]}")
