package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicioPostventaIdentificationPage {
	
	public WebDriver driver;
	
	public ServicioPostventaIdentificationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@name='msisdn']")
	private WebElement MSISDNText;
	
	@FindBy(xpath="//input[@class='boton']")
	private WebElement Acceptar;
	
	public void ProvideMSISDN(String x)
	{
		System.out.println("entering MSISDN");
		MSISDNText.sendKeys(x);
		Acceptar.click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
