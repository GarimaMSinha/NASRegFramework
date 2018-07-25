package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NuevoPERPage {
	public WebDriver driver;
	
	public NuevoPERPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//select[@name='clientContactSchedules']")
	private WebElement HorarioDeContacto;
	
	@FindBy (xpath="//select[@name='platform']")
	private WebElement Platform;
	
	@FindBy (xpath="//input[@name='contactCustomer']")
	private WebElement PersonContacto;

	@FindBy (xpath="//input[@onclick='javascript: return acceptClientData();']")
	private WebElement AcceptarClientData;
	
	@FindBy (xpath="//input[@name='imei']")
	private WebElement IMEI;
	
	@FindBy (xpath ="//select[@name='brand']")
	private WebElement brand;
	
	@FindBy (xpath ="//select[@name='model']")
	private WebElement model;
	
	@FindBy (xpath ="//input[@onclick ='javascript:return acceptSelectMaterial();']")
	private WebElement AcceptarSelectMaterial;
	
	@FindBy (xpath ="//input[@onclick='javascript: return AcceptDeliveryZone();']")
	private WebElement AcceptarDeliveryZone;
	
	@FindBy (xpath ="//select[@name='perTypeSelected']")
	private WebElement Opciones;
	
	@FindBy (xpath ="//input[@onclick='javascript: return acceptPerType();']")
	private WebElement AcceptarPerType;
	
	@FindBy (xpath ="//select[@name='breakdownTypologyCode']")
	private WebElement Tipology;

	@FindBy (xpath ="//select[@name='breakdownCode']")
	private WebElement Sintoma;
	
	@FindBy (xpath ="//select[@name='addressTypeCode']")
	private WebElement TipoVia;
	
	@FindBy (xpath ="//input[@onclick='javascript: return acceptRepair();']")
	private WebElement AcceptarRepair;
	
	@FindBy (xpath ="//*[contains(text(),'Existe un PER sin finalizar con el mismo Imei']")
	private WebElement Error;
	
	public void ProvideData(String c) {
		System.out.println("Providing values under Datos de Cliente");
		Select Drpdown1 = new Select(HorarioDeContacto);
		Select Drpdown2 = new Select(Platform);		
		Drpdown1.selectByValue("1");
		PersonContacto.sendKeys(c);
		Drpdown2.selectByVisibleText("1442");
		AcceptarClientData.click();
				
	}
	
	public void ProvideIMEI(String imei,WebDriver driver) throws Exception {
		System.out.println("Providing IMEI");
		IMEI.sendKeys(imei);
		Select DropBrand = new Select(brand);
		Select DropModel = new Select(model);
		Actions action = new Actions(driver);
		if (Error.isDisplayed()){
			System.out.println("IMEI is already used");
			driver.close();
		}else {
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		DropBrand.selectByIndex(1);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		DropModel.selectByIndex(1);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		AcceptarSelectMaterial.click();
		System.out.println("IMEI provided successfully with brand and model");
		Thread.sleep(2000);
		System.out.println("Accpeting Delivery zone");
		AcceptarDeliveryZone.click();
		System.out.println("Delivery zone Accepted");
		}
	}
	
	public void SelectOption(String option, WebDriver driver) throws Exception {
		Select OptionType = new Select(Opciones);
		OptionType.selectByVisibleText(option);
		AcceptarPerType.click();
		System.out.println("Option selected");
		Thread.sleep(2000);
		Select TipologyType = new Select(Tipology);
		TipologyType.selectByIndex(2);
		Select SintomaType = new Select(Sintoma);
		System.out.println("Tipology and Sintoma selected");
		SintomaType.selectByIndex(1);
		JavascriptExecutor JS = ((JavascriptExecutor)driver);
		JS.executeScript("arguments[0].scrollIntoView(true);", TipoVia);
		Select TipoDeVia = new Select(TipoVia);
		TipoDeVia.selectByVisibleText("Calle");
		System.out.println("Tipo code selected");
		AcceptarRepair.click();
		System.out.println("Accepted Repair");		
		
	}
	
}
