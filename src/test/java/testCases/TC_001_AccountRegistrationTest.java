package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	public void test_account_Registration() {
		logger.info("*** Starting test case TC_001_AccountRegistrationTest ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account Link");
			hp.clickRegister();
			logger.info("Clicked on Registration Link");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("providing customer info");
			regpage.setFirstName(randomeString());
			regpage.setLastName(randomeString());
			regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setTelephone(randomeNumber());
			String password = randomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("clicked on continue button");
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		} catch (Exception e) {
			Assert.fail();

		}
		logger.info("registration test completed");
	}
}
