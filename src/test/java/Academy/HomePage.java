package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize () throws IOException {
		driver=initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password,String text) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		Thread.sleep(5);
		LoginPage lp =l.getLogin();
		lp.getEmail().sendKeys(userName); 
	    lp.getPassword().sendKeys(password);
	    lp.getlogIn().click(); 
	    log.info(text);
	    //System.out.println(text);
		 
	}
		
	  @DataProvider 
	  public Object[][] getData() { 
	  Object[][] data = new Object[2][3]; 
	  data[0][0]= "nonrestricteduser@qw.com"; 
	  data[0][1]= "123456";
	  data[0][2]= "Nonrestricteduser"; 
	  data[1][0]= "restricteduser@qw.com"; data[1][1]= "789012";
 	  data[1][2]="Restricteduser";
		 
	  
	  return data;  
	  }
	  
	  @AfterTest
		public void tearDown () {
			driver.quit();
		}
	 
}