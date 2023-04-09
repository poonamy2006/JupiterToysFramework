package Jupiter.toys.Base;

	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;


	public class Base {
	public ChromeDriver driver;
	public Properties pr;
	
		
@BeforeMethod
	public void BrowserLaunch() throws InterruptedException, IOException {
	File f = new File("..///JupiterToys/object.properties");
	FileReader fr= new FileReader(f);
	pr=new Properties();
	pr.load(fr);
	System.setProperty("webdriver.chrome.driver", "..///JupiterToys/chromedriver.exe");
	driver =new ChromeDriver();
	driver.get(" http://jupiter.cloud.planittesting.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	}

@AfterMethod
	public void BrowserClose() {
	driver.close();
	}
	
	}

