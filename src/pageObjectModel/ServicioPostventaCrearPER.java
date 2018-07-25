package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ServicioPostventaCrearPER {
	
	public WebDriver driver;
	
	public ServicioPostventaCrearPER(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath = "//input[@name='customerMsisdn']")
	private WebElement MSISDN;

	@FindBy(xpath = "//input[@onclick='return acceptValidateMsisdn();']")
	private WebElement Acceptar;
	
	public void ProvideMSISDN(String s) {
		System.out.println("entering MSISDN");
		MSISDN.sendKeys(s);
		Acceptar.click();
	}
}
