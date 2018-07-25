package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicioPostventaIdentificationNIFPage {

	public WebDriver driver;
	
	public ServicioPostventaIdentificationNIFPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='customerId']")
	private WebElement NIFText;
	//Since no test case other than NIF not adding list items
	
	@FindBy(xpath="//input[@name='birthDate']")
	private WebElement ClientFecha;
	
	@FindBy(xpath="//input[@onclick='javascript:return acceptIdentifyCustomer();']")
	private WebElement NIFAceptar;
	
	@FindBy(xpath ="//input[@name='cpCode']")
	private WebElement CodePostal;
	
	public void ProvideNIF(String f)
	{
		System.out.println("enetering NIF");
		NIFText.sendKeys(f);
		
	}
	
	public void ProvideClientFecha(String f)
	{
		System.out.println("enetering client birth date");
		ClientFecha.sendKeys(f);
		CodePostal.sendKeys("00000");
		
	}
	
	public void ClickAcceptar()
	{
		NIFAceptar.click();
	}

}
