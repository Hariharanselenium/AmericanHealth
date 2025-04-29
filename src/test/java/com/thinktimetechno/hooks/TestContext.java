package com.thinktimetechno.hooks;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.driver.TargetFactory;
import com.thinktimetechno.projects.website.Multipages.CorporateDashboardPage;
import com.thinktimetechno.projects.website.Multipages.CorporateInvitePage;
import com.thinktimetechno.projects.website.Multipages.CorporateLoginPage;
import com.thinktimetechno.projects.website.Multipages.CorporateRegistrationPage;
import com.thinktimetechno.projects.website.Multipages.CorporateResetPasswordPage;
import com.thinktimetechno.projects.website.pages.BillingPage;
import com.thinktimetechno.projects.website.pages.CourseSelectionPage;
import com.thinktimetechno.projects.website.pages.DashboardPage;
import com.thinktimetechno.projects.website.pages.FieldOfStudyPage;
import com.thinktimetechno.projects.website.pages.LoginPage;
import com.thinktimetechno.projects.website.pages.PaymentPage;
import com.thinktimetechno.projects.website.pages.QuizPage;
import com.thinktimetechno.projects.website.pages.RegistrationPage;
import com.thinktimetechno.projects.website.pages.ResetPasswordPage;
import com.thinktimetechno.projects.website.pages.TypeOfProfessionPage;
import com.thinktimetechno.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

	private WebDriver driver;

	public TestContext() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = ThreadGuard.protect(new TargetFactory().createInstance());
		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
		LogUtils.info("Driver in TestContext: " + getDriver());
	}


	private DashboardPage dashboardPage;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private ResetPasswordPage resetpasswordPage;
	private FieldOfStudyPage fieldOfStudyPage;
	private TypeOfProfessionPage typeOfProfessionPage;
	private CourseSelectionPage courseSelectionPage;
	private QuizPage quizpage;
	private PaymentPage paymentPage;
	private BillingPage billingPage;
	private CorporateDashboardPage corporatedashboardPage;
	private CorporateLoginPage corporateloginPage;
	private CorporateResetPasswordPage corporateresetpasswordPage;
	private CorporateRegistrationPage corporateregistrationPage;
	private CorporateInvitePage corporateinvitePage;
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	public CorporateInvitePage getCorporateInvitePage() {
		if (corporateinvitePage == null) {
			corporateinvitePage = new CorporateInvitePage();
		}
		return corporateinvitePage;
	}
	public QuizPage getQuizPage() {
		if (quizpage == null) {
			quizpage = new QuizPage();
		}
		return quizpage;
	}
	public BillingPage getBillingPage() {
		if (billingPage == null) {
			billingPage = new BillingPage();
		}
		return billingPage;
	}
	public PaymentPage getPaymentPage() {
		if (paymentPage == null) {
			paymentPage = new PaymentPage();
		}
		return paymentPage;
	}
	public CourseSelectionPage getCourseSelectionPage() {
		if (courseSelectionPage == null) {
			courseSelectionPage = new CourseSelectionPage();
		}
		return courseSelectionPage;
	}
	public FieldOfStudyPage getFieldOfStudyPage() {
		if (fieldOfStudyPage == null) {
			fieldOfStudyPage = new FieldOfStudyPage();
		}
		return fieldOfStudyPage;
	}
	public TypeOfProfessionPage getTypeOfProfessionPage() {
		if (typeOfProfessionPage == null) {
			typeOfProfessionPage = new TypeOfProfessionPage();
		}
		return typeOfProfessionPage;
	}
	public ResetPasswordPage getResetPasswordPage() {
		if (resetpasswordPage == null) {
			resetpasswordPage = new ResetPasswordPage();
		}
		return resetpasswordPage;
	}
	public CorporateResetPasswordPage getCorporateResetPasswordPage() {
		if (corporateresetpasswordPage == null) {
			corporateresetpasswordPage = new CorporateResetPasswordPage();
		}
		return corporateresetpasswordPage;
	}
	
	public CorporateRegistrationPage getCorporateRegistrationPage() {
		if (corporateregistrationPage == null) {
			corporateregistrationPage = new CorporateRegistrationPage();
		}
		return corporateregistrationPage;
	}

	public CorporateLoginPage getCorporateLoginPage() {
		if (corporateloginPage == null) {
			corporateloginPage = new CorporateLoginPage();
		}
		return corporateloginPage;
	}


	public CorporateDashboardPage getCorporateDashboardPage() {
		if (corporatedashboardPage == null) {
			corporatedashboardPage = new CorporateDashboardPage();
		}
		return corporatedashboardPage;
	}
	public RegistrationPage getRegistrationPage() {
		if (registrationPage == null) {
			registrationPage = new RegistrationPage();
		}
		return registrationPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}


	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}



	
}
