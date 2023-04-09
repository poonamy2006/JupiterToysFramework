package Jupiter.toys.Pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Contact  {
	
	ChromeDriver driver;
	Properties pr;
		
		
	public Contact (ChromeDriver driver, Properties pr) {	
	this.driver=driver;
	this.pr=pr;
		}

	public void ContactPageLink() {
		WebElement contactlink= driver.findElement(By.linkText(pr.getProperty("ContactLink")));
		contactlink.click();
		
	}
	
	public void ClickSubmitButton() {
		WebElement SubmitButton= driver.findElement(By.xpath(pr.getProperty("SubmitButton")));
		SubmitButton.click();
		
	}
	
	
	public void PopulateMandatoryFields(String Username, String EmailAddress, String Message) {
		WebElement Forename_textfield = driver.findElement(By.id(pr.getProperty("Forename_textfield")));
		Forename_textfield.sendKeys(Username);
		WebElement Email_textfield = driver.findElement(By.id(pr.getProperty("Email_textfield")));
		Email_textfield.sendKeys(EmailAddress);
		WebElement Message_textfield = driver.findElement(By.id(pr.getProperty("Message_textfield")));
		Message_textfield.sendKeys(Message);
	}
	
	public String SuccessMesssage() {
		WebElement message= driver.findElement(By.xpath(pr.getProperty("SuccessMessage")));
		return message.getText();
		
		
	}
	
	public String ForenameError() {
		String actual_ErrorMessage= driver.findElement(By.xpath(pr.getProperty("ForenameError"))).getText();
		return actual_ErrorMessage;
	}
	
	public String EmailError() {
		String actual_EmailError= driver.findElement(By.xpath(pr.getProperty("EmailError"))).getText();
		return actual_EmailError;
	}
	
	public String MessageError() {
		String actual_MessageError= driver.findElement(By.xpath(pr.getProperty("MessageError"))).getText();
		return actual_MessageError;
	}
	
	public boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
  }

	public String HeaderErrorMessage() {
		String actual_Error= driver.findElement(By.xpath(pr.getProperty("Headermessage"))).getText();
		return actual_Error;
	}
	
}
