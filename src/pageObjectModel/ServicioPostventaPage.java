package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicioPostventaPage {
	
	public WebDriver driver;
	
	public ServicioPostventaPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#']")
	private WebElement Actividades;
	
	@FindBy(xpath="//ul/li[5]")
	private WebElement GestionDeSim;
	
	@FindBy(xpath="//ul/li[5]/ul/li[1]/a") 
	private WebElement CambioDeTarjetaSim;
	
	//@FindBy(xpath = "//a[contains(@text ='Gestión de PERs')]")
	@FindBy(xpath = "//ul/li[3]")
	private WebElement GestionDePer;
	
	@FindBy(xpath="//ul/li[3]/ul/li[1]/a")
	private WebElement CrearPER;
	
	
	
	

	public void GestionDeSim(WebDriver driver) {
		System.out.println("fuction to click gesion de sim");
		Actividades.click();		
		System.out.println("clicked actividades");
		Actions action = new Actions(driver);
		action.moveToElement(GestionDeSim).moveToElement(CambioDeTarjetaSim).click().build().perform();
		System.out.println("GestionDeSim success");
		
	}
	
	public void CrearPER(WebDriver driver)
	{
		System.out.println("Fuction to click Crear PER");
		Actividades.click();		
		System.out.println("clicked actividades");
		Actions action1 = new Actions(driver);
		action1.moveToElement(GestionDePer).moveToElement(CrearPER).click().build().perform();
		System.out.println("CrearPER success");
		
	}
	

}
