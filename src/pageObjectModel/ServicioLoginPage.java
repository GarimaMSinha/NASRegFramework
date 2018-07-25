package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicioLoginPage {
	
	public WebDriver driver;
	
	public ServicioLoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement UserName;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@class='boton']")
	private WebElement Acceptar;
	
	@FindBy(xpath = "//img[@class='boton']")
	private WebElement Cancelar;
	
	public void Login(String user,String pass) {
		
		UserName.sendKeys(user);
		Password.sendKeys(pass);
		Acceptar.click();
		System.out.println("login success");
		
	}

	

}
