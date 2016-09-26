package com.HRM.testcases.System;


import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;


public class System_SmokeTest extends CommonFunctions {

	SoftAssert s_assert = new SoftAssert();
	//public static Logger log = Logger.getLogger("devpinoyLogger");
	
   // PropertyConfigurator.configure(log4jConfigFile);


	
	


	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException {
		
		initData();

	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() {
		
		closeBrowser();
	}
	
	

	@Test(enabled = true, priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2SearchEmp() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_System']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECBAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_SecFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Sec_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

		String UsersPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(UsersPage, "User Accounts");
		
		driver.findElement(By.xpath(".//*[@id='N_LnkCde_main_1_Img']")).click();
		
		
		/*Set<String> AllWindowHandles = driver.getWindowHandles();
		  String window1 = (String) AllWindowHandles.toArray()[0];
		  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		  String window2 = (String) AllWindowHandles.toArray()[1];
		  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);*/

		
		switchToNewWindow();
		
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("78");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		String EmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpName, "Nelson, Allen");
		
		String EmpNos = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpNos, "78");
		
		//driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		//driver.close();
		
	//	driver.switchTo().window("CDwindow-9d218017-4016-4b8a-9f5a-460b30344341");
		
      /*  driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String UserLog = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		s_assert.assertEquals(UserLog, "nvess");
		*/
		switchToOldWindow();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2ChangePassword() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_System']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECBAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_SecFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Sec_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String UsersPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(UsersPage, "User Accounts");
		
        driver.findElement(By.xpath(".//*[@id='C_Sec_main_1']/input[2]")).sendKeys("nvess");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String UserLog = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		s_assert.assertEquals(UserLog, "nvess");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();

		

		
		
	//	driver.findElement(By.xpath(".//*[@id='N_LnkCde_main_1_Img']")).click();
		
		/*Set<String> AllWindowHandles = driver.getWindowHandles();
		  String window1 = (String) AllWindowHandles.toArray()[0];
		  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		  String window2 = (String) AllWindowHandles.toArray()[1];
		  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);*/

		
		//switchToNewWindow();
		
		
		
        
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Password_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Password_main_1']/input[2]")).sendKeys("nuview123");
		
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		 driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2Rebuild() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		//String s  = GetCurrentDate();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_System']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECBAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_SecFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Sec_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		
		String UsersPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(UsersPage, "User Accounts");
		
        driver.findElement(By.xpath(".//*[@id='C_Sec_main_1']/input[2]")).sendKeys("nvess");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String UserLog = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		s_assert.assertEquals(UserLog, "nvess");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();

		

		
		
	//	driver.findElement(By.xpath(".//*[@id='N_LnkCde_main_1_Img']")).click();
		
		/*Set<String> AllWindowHandles = driver.getWindowHandles();
		  String window1 = (String) AllWindowHandles.toArray()[0];
		  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		  String window2 = (String) AllWindowHandles.toArray()[1];
		  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);*/

		
		//switchToNewWindow();
		
		
		
        
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		//driver.findElement(By.xpath(".//*[@id='C_Password_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_Password_main_1']/input[2]")).sendKeys("nuview123");
		
		driver.findElement(By.xpath(".//*[@id='C_SecRebuildUser_main_1']")).click();
		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();
		s_assert.assertEquals(Message, "Security Build has been added to the task queue.\nYou may continue to work while this process runs.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();
		
		
		logOut();
		s_assert.assertAll();
		
	}
	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2LoginWithChangedPassword() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvess", "nuview123");
		
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		
		String UsersName = driver.findElement(By.xpath(".//*[@id='greeting']")).getText().trim();
		s_assert.assertEquals(UsersName, "Allen Nelson (78)");
		
		

	}
}
