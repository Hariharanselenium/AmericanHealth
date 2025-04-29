package com.thinktimetechno.projects.website.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class QuizPage {

	public void click_quiz_button() {
		WebUI.clickElement(By.xpath("//div[@class='left-take-quiz ']/a[contains(text(),'Take Quiz')]"));
	}

	public void click_reattemptquiz_button() {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'RE-ATTEMPT QUIZ')])[1]"));
	}

	public void verify_quizPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Hc Fa | Quiz - American Health Care Academy"));
	}

	public void verify_quiz_PageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Takequiz | Express - American Health Care Academy"));

	}

	public void verify_successquizDisplays(String msg) {

		WebElement successquiz = WebUI.waitForElementVisible(By.xpath(
				"//div[contains(text(),'You have successfully passed the test. Please follow the instructions below.')]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, msg);
	}

	public void verify_failedquizDisplays(String msg) {

		WebElement successquiz = WebUI.waitForElementVisible(By.xpath(
				"//div[contains(text(),'You did not reach a passing score of 75% or higher. You may re-attempt the quiz at no additional charge.')]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, msg);
	}

	public void verify_successquizPageDisplays() {

		WebElement successquiz = WebUI
				.waitForElementVisible(By.xpath("//div[contains(text(),'Congratulations, you passed the quiz!')]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, "Congratulations, you passed the quiz!");
	}
	

	public void verify_quizsuccessPageDisplays() {

		WebElement successquiz = WebUI
				.waitForElementVisible(By.xpath("(//h2[contains(text(),'CONGRATULATIONS!')])[1]"));
		String successquiztext = successquiz.getText();
		
		Assert.assertEquals(successquiztext, "CONGRATULATIONS!");
	}
	public void verify_failedquizPageDisplays() {

		WebElement successquiz = WebUI.waitForElementVisible(By.xpath("(//h2[contains(text(),'SORRY!')])[1]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, "SORRY!");
	}

	public void question__answer() throws InterruptedException {
		List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
		int i = 0;

		for (WebElement question : questions) {
			String questionText = question.getText().trim();
			String cleanText = questionText.split("\\) ")[1];
			String correctAnswer = getwrongAnswer(cleanText); // This should return something like "D. Both B and C"

			if (!correctAnswer.isEmpty()) {
				// Corrected XPath to locate <input> preceding the matching <label>
				By answerLocator = By.xpath("//label[text()='" + correctAnswer
						+ "']/preceding-sibling::input[@class='input-radio-answer']");
				WebUI.clickElementWithJs(answerLocator);
				i++;
			}

			// Click "Next" every 4 answers
			if (i % 4 == 0 && i < 20) {
				WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));
				if (nextButton.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
				}
			}
		}
	}

	public void question_and_answer() throws InterruptedException {

		List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
		int i = 0;
		for (WebElement question : questions) {
			String questionText = question.getText().trim();
			String cleanText = questionText.split("\\) ")[1];
			String correctAnswer = getCorrectAnswer(cleanText);

			if (!correctAnswer.isEmpty()) {

				WebUI.clickElementWithJs(
						By.xpath("//input[@class='input-radio-answer' and following-sibling::label[contains(text(), '"
								+ correctAnswer + "')]]"));

				i++;
			}
			if (i % 4 == 0 && i < 20) {
//				Thread.sleep(2000);

				WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));

				if (nextButton.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
//					Thread.sleep(2000);
				}
			}

		}

	}

	public void question_and_wronganswer() throws InterruptedException {

		List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
		int i = 0;
		for (WebElement question : questions) {
			String questionText = question.getText().trim();
			String cleanText = questionText.split("\\) ")[1];
			String correctAnswer = getwrongAnswer(cleanText);

			if (!correctAnswer.isEmpty()) {

				WebUI.clickElementWithJs(
						By.xpath("//input[@class='input-radio-answer' and following-sibling::label[contains(text(), '"
								+ correctAnswer + "')]]"));

				i++;
			}
			if (i % 4 == 0 && i < 20) {
//				Thread.sleep(2000);

				WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));

				if (nextButton.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
//					Thread.sleep(2000);
				}
			}

		}

	}

	public void submitQuiz() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//input[@id='submit_btn']"));
//		Thread.sleep(10000);

	}

	public String getwrongAnswer(String questionText) {

		switch (questionText) {
		case "What is Hands-Only CPR?":
			return "When you use whatever hand you want";
		case "What should you check for before you respond to an emergency situation?":
			return "If someone else can respond instead";
		case "What is the recommended rate for performing chest compressions for victims of all ages?":
			return "At least 10 compressions per minute";
		case "What is the correct hand placement when performing chest compressions on an adult?":
			return "One fist over the other";
		case "When performing CPR on an adult, you should push the chest at least _____ inches deep.":
			return "2 inches, but no more than 2.4";
		case "What steps should you follow to open the airway?":
			return "Tilt the head back and lift the chin";
		case "During infant CPR, you should push down ______ inches deep at a rate of at least ______ compressions per minute.":
			return "1.5, 100 to 120";
		case "When giving chest compressions to an infant you should use _____.":
			return "2 fingers";
		case "Before pushing the \"shock\" button on an AED, you should _______.":
			return "All of the above";
		case "When helping a choking child, you should give ________.":
			return "Thrusts into the abdomen";
		case "Which of these is NOT a nervous system emergency?":
			return "Heart attack";
		case "A patient suffering from an _________ attack would carry an inhaler.":
			return "Asthma";
		case "For which medical emergency would one use an epinephrine drug or epi-pen?":
			return "Allergy emergency";
		case "What is an allergic reaction?":
			return "When something a person is allergic to enters the body";
		case "What step should you take if a person is having a seizure?":
			return "Remove nearby objects that may hurt the person";
		case "Which of the following are causes for choking emergencies?":
			return "Talking or laughing while eating";
		case "What should you do if someone is on fire?":
			return "Both A and B";
		case "The two major classifications of wounds are:":
			return "Open wounds and closed wounds";
		case "If you are stung by a wasp or a bee, and they leave behind a poison sac, you should NOT ______.":
			return "Squeeze the sac";
		case "If you experience a sprain or strain, what method should you follow?":
			return "Follow RICE: rest, immobilize, cold and elevate";
		default:
			return "";
		}
	}
	
	

	public String getCorrectAnswer(String questionText) {

		switch (questionText) {
		case "What is Hands-Only CPR?":
			return "Both B and C";
		case "What should you check for before you respond to an emergency situation?":
			return "Your safety";
		case "What is the recommended rate for performing chest compressions for victims of all ages?":
			return "At least 100 to 120 compressions per minute";
		case "What is the correct hand placement when performing chest compressions on an adult?":
			return "Place one hand on top of the other, interlacing the fingers";
		case "When performing CPR on an adult, you should push the chest at least _____ inches deep.":
			return "2 inches, but no more than 2.4";
		case "What steps should you follow to open the airway?":
			return "Tilt the head back and lift the chin";
		case "During infant CPR, you should push down ______ inches deep at a rate of at least ______ compressions per minute.":
			return "1.5, 100 to 120";
		case "When giving chest compressions to an infant you should use _____.":
			return "2 fingers";
		case "Before pushing the \"shock\" button on an AED, you should _______.":
			return "All of the above";
		case "When helping a choking child, you should give ________.":
			return "Thrusts into the abdomen";
		case "Which of these is NOT a nervous system emergency?":
			return "Heart attack";
		case "A patient suffering from an _________ attack would carry an inhaler.":
			return "Asthma";
		case "For which medical emergency would one use an epinephrine drug or epi-pen?":
			return "Allergy emergency";
		case "What is an allergic reaction?":
			return "When something a person is allergic to enters the body";
		case "What step should you take if a person is having a seizure?":
			return "Remove nearby objects that may hurt the person";
		case "Which of the following are causes for choking emergencies?":
			return "Talking or laughing while eating";
		case "What should you do if someone is on fire?":
			return "Tell the person to stop, drop and roll";
		case "The two major classifications of wounds are:":
			return "Open wounds and closed wounds";
		case "If you are stung by a wasp or a bee, and they leave behind a poison sac, you should NOT ______.":
			return "Squeeze the sac";
		case "If you experience a sprain or strain, what method should you follow?":
			return "Follow RICE: rest, immobilize, cold and elevate";
		default:
			return "";
		}
	}

	public void answerQuestions(int questionCount) throws InterruptedException {
		List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
		int answered = 0;

		for (WebElement question : questions) {
			if (answered >= questionCount)
				break;

			String questionText = question.getText().trim();
			String cleanText = questionText.split("\\) ")[1];
			String correctAnswer = getCorrectAnswer(cleanText); // Your logic here

			if (!correctAnswer.isEmpty()) {
				By answerLocator = By.xpath("//label[text()='" + correctAnswer
						+ "']/preceding-sibling::input[@class='input-radio-answer']");
				WebUI.clickElementWithJs(answerLocator);
				answered++;
			}

			// Click "Next" every 4 questions, or after last question in this batch
			if ((answered % 4 == 0 || answered == questionCount) && answered < 20) {
				WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));
				if (nextButton != null && nextButton.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
					Thread.sleep(1000); // Adjust wait if needed
				}
			}
		}
	}

	public void answerQuestionsFrom13To20() throws InterruptedException {
	    int i = 12;
	    List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
	    
	    for (WebElement question : questions) {
	        String questionText = question.getText().trim();

	        // Check if the question text contains the expected pattern and split it
	        String cleanText = "";
	        if (questionText.contains(") ")) {
	            String[] splitText = questionText.split("\\) ");
	            if (splitText.length > 1) {
	                cleanText = splitText[1];
	            } else {
	                // Log an issue if the text doesn't split as expected
//	                System.out.println("Skipping malformed question: " + questionText);
	                continue; // Skip this question if it's malformed
	            }
	        } else {
	            // Handle the case where the question doesn't contain the expected format
//	            System.out.println("Skipping question with unexpected format: " + questionText);
	            continue; // Skip this question
	        }

	        // Get the correct answer based on the clean question text
	        String correctAnswer = getCorrectAnswer(cleanText); // This should return something like "D. Both B and C"

	        if (!correctAnswer.isEmpty()) {
	            // Corrected XPath to locate <input> preceding the matching <label>
	            By answerLocator = By.xpath("//label[text()='" + correctAnswer
	                    + "']/preceding-sibling::input[@class='input-radio-answer']");
	            WebUI.clickElementWithJs(answerLocator);
	            i++;
	        }

	        // Click "Next" every 4 answers
	        if (i % 4 == 0 && i < 20) {
	            WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));
	            if (nextButton != null && nextButton.isDisplayed()) {
	                WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
	            }
	        }
	    }
	}


	public void quiz_register(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) throws InterruptedException {

		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Username = username.replace("johndoe", "johndoe" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);

		WebUI.getJsExecutor().executeScript("document.getElementById('first_name').blur();");

		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.clickElement(By.xpath("//input[@id='phone_number']"));
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);

		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

		WebUI.setText(By.xpath("//input[@id='username']"), Username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
		WebUI.clickElement(By.xpath("//input[@id='register-button']"));

	}
	
	public String getCorrectAnswer1(String questionText) {
	    switch (questionText) {
	        case "What is Hands-Only CPR?":
	            return "Both B and C";
	        case "What should you check for before you respond to an emergency situation?":
	            return "Your safety";
	        case "What is the recommended rate for performing chest compressions for victims of all ages?":
	            return "At least 100 to 120 compressions per minute";
	        case "What is the correct hand placement when performing chest compressions on an adult?":
	            return "Place one hand on top of the other, interlacing the fingers";
	        case "When performing CPR on an adult, you should push the chest at least _____ inches deep.":
	            return "2 inches, but no more than 2.4";
	        case "What steps should you follow to open the airway?":
	            return "Tilt the head back and lift the chin";
	        case "During infant CPR, you should push down ______ inches deep at a rate of at least ______ compressions per minute.":
	            return "1.5, 100 to 120";
	        case "When giving chest compressions to an infant you should use _____.":
	            return "2 fingers";
	        case "Before pushing the 'shock' button on an AED, you should _______.":
	            return "All of the above";
	        case "When helping a choking child, you should give ________.":
	            return "Thrusts into the abdomen";
	        case "What should you do if someone is on fire?":
	            return "Both A and B";
	        case "Which of these is NOT a nervous system emergency?":
	            return "Heart attack";
	        case "A patient suffering from an _________ attack would carry an inhaler.":
	            return "Asthma";
	        case "The two major classifications of wounds are:":
	            return "Open wounds and closed wounds";
	        case "For which medical emergency would one use an epinephrine drug or epi-pen?":
	            return "Allergy emergency";
	        case "What is an allergic reaction?":
	            return "When something a person is allergic to enters the body";
	        case "What step should you take if a person is having a seizure?":
	            return "Remove nearby objects that may hurt the person";
	        case "If you are stung by a wasp or a bee, and they leave behind a poison sac, you should NOT ______.":
	            return "Squeeze the sac";
	        case "If you experience a sprain or strain, what method should you follow?":
	            return "Follow RICE: rest, immobilize, cold and elevate";
	        case "Which of the following are causes for choking emergencies?":
	            return "Both A and B";
	        default:
	            return "";
	    }
	}


}