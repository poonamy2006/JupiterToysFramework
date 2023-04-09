package Jupiter.toys.Pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Jupiter.toys.Assertions.Assertion3;

public class Cart {

	ChromeDriver driver;
	Properties pr;

	public Cart(ChromeDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void CartLink() {

		WebElement cartlink = driver.findElement(By.xpath(pr.getProperty("CartLink")));
		cartlink.click();

	}

	public void VerifyCartItems(String ExpectedProductName, Float ExpectedProductPrice, Float ExpectedST)
			throws InterruptedException {

		List<WebElement> rows = driver.findElements(By.xpath(pr.getProperty("CartTable")));
		int count = rows.size();

		for (int i = 1; i <= count; i++) {

			String BeforeXpath = pr.getProperty("CartRow");
			String Afterxpath = "]/td[1]";
			String actualxpath = BeforeXpath + i + Afterxpath;
			String CartProductName = driver.findElement(By.xpath(actualxpath)).getText();

			if (CartProductName.equals(ExpectedProductName)) {
				String Afterxpath1 = "]/td[2]";
				String PriceXpath = BeforeXpath + i + Afterxpath1;
				WebElement CartPrice = driver.findElement(By.xpath(PriceXpath));
				String CartProductPrice = CartPrice.getText();
				String Act_Price = CartProductPrice.replace("$", "");
				Float Actual_Price = Float.parseFloat(Act_Price);

				Assert.assertTrue(Assertion3.TotalAssertion(ExpectedProductPrice, Actual_Price, "TC3_CartPage"));

				String Afterxpath2 = "]/td[4]";
				String Actualxpath2 = BeforeXpath + i + Afterxpath2;
				WebElement Cart_Stotal = driver.findElement(By.xpath(Actualxpath2));
				String CartSubTotal = Cart_Stotal.getText();

				String Cart_ST = CartSubTotal.replace("$", "");

				Float Actual_SubTotal = Float.parseFloat(Cart_ST);
				Assert.assertTrue(Assertion3.TotalAssertion(ExpectedST, Actual_SubTotal, "TC3_CartPage"));

			}
		}
	}

	public Float ProductTotal() {
		String CartTotal = driver.findElement(By.xpath(pr.getProperty("ProductTotal"))).getText();
		String Act_Total = CartTotal.replace("Total: ", "");
		Float Actual_Total = Float.parseFloat(Act_Total);
		return Actual_Total;

	}

}
