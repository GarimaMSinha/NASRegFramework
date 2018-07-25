package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InformationCambioDeTarjetaSimPage {
	public WebDriver driver;
	
	public InformationCambioDeTarjetaSimPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(name = "destinySimType")
	@FindBy(xpath = "//select[@onchange='javascript:checkSim();']")
	private WebElement Destino;
	//Since no test case other than NIF not adding list items
	
	@FindBy(name = "changeSimMotive")
	private WebElement Motivo;
	
	@FindBy(xpath = "//input[@onclick='javascript: return acceptChangeSimCard();']")
	//@FindBy(xpath = "//input[@class='boton']")
	private WebElement Aceptar;
	
	//@FindBy(xpath ="//input[@name='customerNewIccValue']")
	@FindBy(name="customerNewIccValue")
	private WebElement NewICC;
	
	@FindBy(xpath="//input[@onclick='javascript:return acceptChanges();']")
	private WebElement Aceptar_SimChange;
	
	@FindBy(xpath="//input[@onclick='javascript:return acceptPrice();']")
	private WebElement Aceptar_NextPage;
	
	
	public void Cambio(WebDriver driver)
	{
		System.out.println("CambioDetarjetaSim Destino and Motivo");
		Select object = new Select(Destino);
		object.selectByVisibleText("Micro SIM");
		Select object1 = new Select(Motivo);
		object1.selectByVisibleText("SE - Error RAC");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Aceptar.click();
		driver.switchTo().alert().accept();
		
		
		
		}
	public void NewIcc(WebDriver driver,String s)
	{
		NewICC.sendKeys(s);
		Aceptar_SimChange.click();
		driver.switchTo().alert().accept();	
	}
	
	public void NextPage()
	{
		Aceptar_NextPage.click();
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
