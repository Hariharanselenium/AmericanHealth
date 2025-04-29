/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.thinktimetechno.utils;

import com.thinktimetechno.constants.FrameworkConstants;
import com.thinktimetechno.mail.EmailAttachmentsSender;

import javax.mail.MessagingException;

import static com.thinktimetechno.mail.EmailConfig.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailSendUtils {

    private EmailSendUtils() {
        super();
    }

    public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        if (FrameworkConstants.SEND_EMAIL_TO_USERS.trim().equalsIgnoreCase(FrameworkConstants.YES)) {
            System.out.println("****************************************");
            System.out.println("Send Email - START");
            System.out.println("****************************************");

            System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());

            String messageBody = getTestCasesCountInFormat(count_totalTCs, count_passedTCs, count_failedTCs,
                    count_skippedTCs);
            //System.out.println(messageBody);

            String attachmentFile_ExtentReport = FrameworkConstants.getExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
                        attachmentFile_ExtentReport);

                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("Send Email - END");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

    private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs,
            int count_failedTCs, int count_skippedTCs) {
		
		//String clientName = "Satnam";        
		String executionDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd '&' HH:mm.ss"));
	    
		String companyName = "ThinkTime Automation Team";
		
		return "<html>" +
		"<body style=\"font-family:Arial, sans-serif; font-size:14px; color:#333\">" +
		"<p>Hi Team,</p>" +
	    "<p>Please find below the summary of the <strong>Automation Test Execution Report</strong> for the latest run.</p>" +
	    
	    "<p><strong>Execution Date & Time:</strong> " + executionDate + "<br/>" +
	    "<p><strong>Test Summary:</strong></p>" +
	    "<table border='1' cellpadding='8' cellspacing='0' style='border-collapse:collapse; text-align:left;'>" +
	    "<tr style='background-color:#f4f4f4;'>" +
	    "<th>Total</th>" +
	    "<th>Passed</th>" +
	    "<th>Failed</th>" +
	    "<th>Skipped</th>" +
	    "</tr>" +
	    "<tr>" +
	    "<td style='text-align:center;'>" + count_totalTCs + "</td>" +
	    "<td style='color:green; text-align:center;'>" + count_passedTCs + "</td>" +
	    "<td style='color:red; text-align:center;'>" + count_failedTCs + "</td>" +
	    "<td style='color:orange; text-align:center;'>" + count_skippedTCs + "</td>" +
	    "</tr>" +
	    "</table>" +
		"<br/>" +
		"<p>You can find the detailed test results in the above attached report.</p>" +
		"<p>Please feel free to reach out in case of any queries or clarifications.</p>" +
		"<br/>" +
		"<p>Best regards,<br/>" +
		companyName+"."+
		
		"</body></html>";
		}
}
