package testCases;

import org.testng.annotations.Test;

//import pageObjectModel.InformationCambioDeTarjetaSimPage;
import pageObjectModel.ServicioLoginPage;
import pageObjectModel.ServicioPostventaIdentificationNIFPage;
import pageObjectModel.ServicioPostventaIdentificationPage;
import pageObjectModel.ServicioPostventaPage;
import testCore.TestCore_NormalClass;

public class Reg_GD_E2E513_TC000_Cambio_de_SIM_Microsim_Prepago extends TestCore_NormalClass {

	@Test
	public void Main() throws Exception {
		ServicioLoginPage LoginHome = new ServicioLoginPage(driver);
		ServicioPostventaPage Test1 = new ServicioPostventaPage(driver);
		ServicioPostventaIdentificationPage MSISDN = new ServicioPostventaIdentificationPage(driver);
		ServicioPostventaIdentificationNIFPage NIF = new ServicioPostventaIdentificationNIFPage(driver);
		//InformationCambioDeTarjetaSimPage changesim = new InformationCambioDeTarjetaSimPage(driver);
		try {
			String user = Reader.getCellData("TestData", 1, 2);
			String pass = Reader.getCellData("TestData", 2, 2);
			System.out.println("value to be entered are  :"+user+" " +pass);
			log.debug("Trying to login");
			LoginHome.Login(user,pass);	
			Test1.GestionDeSim(driver);
			log.debug("Giving MSISDN");
			MSISDN.ProvideMSISDN("634130474");
			log.debug("Giving NIF");
			NIF.ProvideNIF("X5559327C");
			log.debug("Giving Date");
			NIF.ProvideClientFecha("10/02/1972");
			log.debug("Acceptar");
			NIF.ClickAcceptar();}
		catch(Exception e) {
			log.debug("Got Error") ;
			  evidence.ScreenshotMethod(driver);
			  log.debug("Screenshot Captured");
			  e.getMessage();
		  }

	}
}
