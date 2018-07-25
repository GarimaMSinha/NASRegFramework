package utility;


import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
	
		public void ScreenshotMethod(WebDriver driver) throws Exception{
			Date d = new Date();
			Timestamp t = new Timestamp(d.getTime());
			String time = t.toString();
			time = time.replace(":","_");
			time = time.replace(".","_");
		File Evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Evidence, new File("C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\Workspace_Automation_Selenium\\Evidence\\screenAt"+time+".png"));
		
		
	}

}
