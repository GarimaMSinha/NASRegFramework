set classpath=C:\Users\IBM_ADMIN\Desktop\selenium\Workspace_Automation_Selenium\NASRegFramework\bin;C:\Users\IBM_ADMIN\Desktop\selenium\Workspace_Automation_Selenium\NASRegFramework\libs\*;C:\Users\IBM_ADMIN\Desktop\selenium\Workspace_Automation_Selenium\NASRegFramework\libs\TestNG\*;

cd C:\Users\IBM_ADMIN\Desktop\selenium\Workspace_Automation_Selenium\NASRegFramework\src


set errorlevel=
java org.testng.TestNG -testclass %1

pause
