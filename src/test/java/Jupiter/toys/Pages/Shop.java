package Jupiter.toys.Pages;


import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Shop {
	
	
		ChromeDriver driver;
		Properties pr;
			
			
		public Shop (ChromeDriver driver, Properties pr) {	
		this.driver=driver;
		this.pr=pr;
			}
		
		public void ShopLink() {
			WebElement Shoplink= driver.findElement(By.linkText(pr.getProperty("ShopLink")));
			Shoplink.click();
		}
		
		public  void ProductSelectionBasedUponIndex(int Index) {
			List<WebElement> Products=driver.findElements(By.xpath(pr.getProperty("ProductButtonItems")));
			Products.get(Index).click();
		}
	
		public  String ShopProductPrice(int Index) {
			List<WebElement> Pp=driver.findElements(By.xpath(pr.getProperty("ProductItems_Price")));
			String ProductPrice = Pp.get(Index).getText();
			return ProductPrice;
		}
		
		}
		
		
		
		
		
		
		


