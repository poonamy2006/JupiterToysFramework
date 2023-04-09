package Jupiter.toys.TestScripts;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import Jupiter.toys.Assertions.Assertion1;
import Jupiter.toys.Base.Base;
import Jupiter.toys.Pages.Contact;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC1_ContactPageMandatoryFields extends Base {

	
	//Verify the mandatory fields error messages
	@Test
	public void VerifyErrorMessages() throws InterruptedException, BiffException, IOException {

		Contact con = new Contact(driver, pr);
		con.ContactPageLink();

		con.ClickSubmitButton();

		Assert.assertTrue(
				Assertion1.VerifyMessages("Forename is required", con.ForenameError(), "TC1_ContactPageVerification"));
		Assert.assertTrue(
				Assertion1.VerifyMessages("Email is required", con.EmailError(), "TC1_ContactPageVerification"));
		Assert.assertTrue(
				Assertion1.VerifyMessages("Message is required", con.MessageError(), "TC1_ContactPageVerification"));
		Assert.assertTrue(Assertion1.VerifyMessages(
				"We welcome your feedback - but we won't get it unless you complete the form correctly.",
				con.HeaderErrorMessage(), "TC1_ContactPageVerification"));

		con.PopulateMandatoryFields("Testuser1", "testuser1@gmail.com", "Hi, Welcome, This is a test message.");

		
		//Verify the mandatory fields messages are not displayed when data entered into textfields on contact page.
		
		File f = new File("..//JupiterToys/ErrorMessages.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet ws = wk.getSheet(0);
		int r = ws.getRows();
		int c = ws.getColumns();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Cell c1 = ws.getCell(j, i);

				boolean Flag = con.isTextPresent(c1.getContents());
				Assert.assertFalse(Flag);
			}
		}

	}

}