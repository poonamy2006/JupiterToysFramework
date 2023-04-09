package Jupiter.toys.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;
import Jupiter.toys.Assertions.Assertion1;
import Jupiter.toys.Base.Base;
import Jupiter.toys.Pages.Contact;

public class TC1_ContactPageMandatoryFields extends Base {

	// Verify the mandatory fields error messages
	@Test
	public void VerifyErrorMessages() throws IOException {

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

		// Verify the mandatory fields messages are not displayed when data entered.

		File f = new File("..//JupiterToys/Messages.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook xs = new XSSFWorkbook(fi);
		XSSFSheet xt = xs.getSheetAt(0);
		int r = xt.getPhysicalNumberOfRows();
		for (int i = 0; i < r; i++) {

			XSSFRow xr = xt.getRow(i);

			int c = xr.getPhysicalNumberOfCells();
			for (int j = 0; j < c; j++) {

				XSSFCell xc = xr.getCell(j);
				boolean Flag = con.isTextPresent(xc.getStringCellValue());
				Assert.assertFalse(Flag);
			}
		}

	}

}