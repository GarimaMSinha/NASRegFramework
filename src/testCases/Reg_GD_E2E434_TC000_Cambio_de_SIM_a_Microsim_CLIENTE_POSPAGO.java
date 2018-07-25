package testCases;

import org.testng.annotations.Test;

import testCore.TestCore_NormalClass;
import pageObjectModel.ServicioLoginPage;
import pageObjectModel.InformationCambioDeTarjetaSimPage;
//import pageObjectModel.NuevoPERPage;
//import pageObjectModel.ServicioPostventaCrearPER;
import pageObjectModel.ServicioPostventaIdentificationNIFPage;
import pageObjectModel.ServicioPostventaIdentificationPage;
import pageObjectModel.ServicioPostventaPage;

public class Reg_GD_E2E434_TC000_Cambio_de_SIM_a_Microsim_CLIENTE_POSPAGO extends TestCore_NormalClass {
  @Test
  public void MainTest() throws Exception {
	  
	  ServicioLoginPage LoginHome = new ServicioLoginPage(driver);
	  ServicioPostventaIdentificationPage MSISDN = new ServicioPostventaIdentificationPage(driver);
	  ServicioPostventaIdentificationNIFPage NIF = new ServicioPostventaIdentificationNIFPage(driver);
	  InformationCambioDeTarjetaSimPage changesim = new InformationCambioDeTarjetaSimPage(driver);
	  ServicioPostventaPage Test1 = new ServicioPostventaPage(driver);
	  try {
	  String user = Reader.getCellData("TestData", 1, 2);
	  String pass = Reader.getCellData("TestData", 2, 2);
	  System.out.println("value to be entered are  :"+user+" " +pass);
	  log.debug("Trying to login");
	  	LoginHome.Login(user,pass);	
		  log.debug("Clicking on Gestion de Sim");
		Test1.GestionDeSim(driver);		
		  log.debug("Giving MSISDN");
		MSISDN.ProvideMSISDN("603712743");
		  log.debug("Giving NIF");
		NIF.ProvideNIF("46727318N");
		  log.debug("Clicking Accept");
		NIF.ClickAcceptar();	
		  log.debug("Clicking on Cambio");
		changesim.Cambio(driver);		
		changesim.NewIcc(driver,"5530232042999");
	  }
	  catch(Exception e)
	  {
		  log.debug("Got Error") ;
		  evidence.ScreenshotMethod(driver);
		  log.debug("Screenshot Captured");
		  e.getMessage();
	  }
  }
}
