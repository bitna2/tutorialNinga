package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {
	@Test
	public void test_Login() {
		logger.info("*** Starting test case TC_002_LoginTest ***");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("*** clicked on my account link***");

			hp.clickLogin();
			logger.info("*** clicked on my login link***");
			LoginPage lp = new LoginPage(driver);

			lp.setEmail(rb.getString("email"));

			lp.setPassword(rb.getString("password"));

			lp.clickLogin();
			logger.info("*** clicked on login button***");
			MyAccountPage myacc = new MyAccountPage(driver);

			boolean targetpage = myacc.isMyAccountPageExists();

			Assert.assertEquals(targetpage, true);

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** login test finished***");

	}

}
