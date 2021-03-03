package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn = By.xpath("//*[text()='Login']");
	
	private By title = By.xpath("//*[@class=\"text-center\"]/h2");
	
	private By navBar = By.xpath("//*[@class='nav navbar-nav navbar-right']");
	
	
	public LandingPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		LoginPage lp = new LoginPage(driver);
		
		return lp;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
