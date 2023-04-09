package Jupiter.toys.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Jupiter.toys.Assertions.Assertion2;
import Jupiter.toys.Base.Base;
import Jupiter.toys.Pages.Contact;

//Successful submission message verification
public class TC2_SuccesssfulSubmissionMessage extends Base {

	@Test(invocationCount = 5)
	public void ValidateSubmissionMessage() throws InterruptedException {

		Contact cont = new Contact(driver, pr);
		cont.ContactPageLink();

		cont.PopulateMandatoryFields("Testuser1", "testuser1@gmail.com", "Hi, Welcome, This is a test message.");

		cont.ClickSubmitButton();

		Assert.assertTrue(Assertion2.VerifyMessages("we appreciate your feedback.", cont.SuccessMesssage(),
				"TC2_SuccessfulSubmissionMessage"));

	}

}
