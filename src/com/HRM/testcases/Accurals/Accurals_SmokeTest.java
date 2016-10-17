package com.HRM.testcases.Accurals;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Accurals_SmokeTest extends CommonFunctions {

	SoftAssert s_assert = new SoftAssert();
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
   // PropertyConfigurator.configure(log4jConfigFile);


	
	


	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException, InterruptedException {
		
		initData();
		TimeSheetDataCreation();
	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() throws IOException, InterruptedException  {
		TimeSheetDataTearDown();
		closeBrowser();
	}
	
	@Test(enabled = true, priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2CreateAccuralAndAddAccrualCatForEmp () throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		//logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Tct_main_1']")).click();
	//	driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECALAANA']")).click();
	//	driver.findElement(By.xpath(".//*[@id='C_EmpAbsCat_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
	//	driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		if(driver.findElements(By.xpath(".//*[@id='C_Add_Img']")).size()!=0){
			
			
			driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		}
		
		else
		{	
		log.info("Find Element No Present");
		}
		
		driver.findElement(By.xpath(".//*[@id='C_Tcl_main_1']/input[2]")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_TclName_main_1']/input[2]")).sendKeys("Test");
		//SelectDropDownValue(".//*[@id='C_AbsCat_main_1']/select", "Vacation");
		SelectDropDownIndex(".//*[@id='C_AbsCat_main_1']/select", 1);
		radiobutton_Select(".//*[@id='C_IsScheduled_main_1']/input[2]");
		SelectDropDownValue(".//*[@id='C_TclPeriod_main_1']/select", "Yearly");
		SelectDropDownValue(".//*[@id='C_SysSchOnYear_main_1']/select", "YearStart");
		SelectDropDownValue(".//*[@id='C_StartFld_main_1']/select", "AccElgDt");
		SelectDropDownValue(".//*[@id='C_BeginDtFld_main_1']/select", "AccElgDt");
		SelectDropDownValue(".//*[@id='N_TclMnth_main_1']", "1");
		SelectDropDownValue(".//*[@id='N_TclDay_main_1']", "1");
		SelectDropDownValue(".//*[@id='C_RoundRule_main_1']/select", "None");
		SelectDropDownValue(".//*[@id='C_DisallowNegBal_main_1']/select", "NoRestrictions");
		SelectDropDownValue(".//*[@id='C_NewStpRule_main_1']/select", "Step Changes");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Steps']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_steps_steps_0']")).click();
		
		EnterText(".//*[@id='C_TclStp_steps_0']/input[2]","01");
		SelectDropDownValue(".//*[@id='C_StpOp_steps_0']/select", "<=");
		EnterText(".//*[@id='C_TclRate_steps_0']/input[2]","40");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_steps_steps_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Thread.sleep(5000);
		
	    webtableElementClick("//table[@class='datasheet']//td", "Test", "link");
	    Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		
	//	driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Austin");
	//	driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Austin");
		
	/*	driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpTclCat_main_1']")).click();
		
          driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		EnterText(".//*[@id='C_LastName_main_1']/input[2]","Berry");
		EnterText(".//*[@id='C_FirstName_main_1']/input[2]","Holly");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
         driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		SelectDropDownValue(".//*[@id='C_Tcl_main_1']/select", "Test");
	
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		webtableElementClick("//table[@class='datasheet']//td", "Test", "link");
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		
		
	/*	
		String UserLog = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table/tbody[2]/tr[1]/td[1]")).getText().trim();
		s_assert.assertEquals(UserLog, "Absence Category");
		
		String AbsCat1 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_1']")).getText().trim();
		s_assert.assertEquals(AbsCat1, "Sick Time");
		
		String AbsCat2 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_2']")).getText().trim();
		s_assert.assertEquals(AbsCat2, "Vacation");*/
		

	/*	driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Tct_main_1']")).click();
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
        webtableElementClick("//table[@class='datasheet']//td", "Test", "link");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();*/
		
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

		
		
	}
	
	@Test(enabled = false, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2AddAccrualCatForEmp () throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
	
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		//driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECALAANA' or @display='Time/Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpTclCat_main_1' or @display='Accrual Eligibility']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECALAANA']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpTclCat_main_1']")).click();
		
          driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		EnterText(".//*[@id='C_LastName_main_1']/input[2]","Berry");
		EnterText(".//*[@id='C_FirstName_main_1']/input[2]","Holly");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
         driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		SelectDropDownValue(".//*[@id='C_Tcl_main_1']/select", "Vacation");
	
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		webtableElementClick("//table[@class='datasheet']//td", "Vacation", "link");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		
		Thread.sleep(10000);
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Alert alertOK = driver.switchTo().alert();
	    alertOK.accept();
	    
	    Alert alertOK1 = driver.switchTo().alert();
	    alertOK1.accept();
		
		
	/*	
		String UserLog = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table/tbody[2]/tr[1]/td[1]")).getText().trim();
		s_assert.assertEquals(UserLog, "Absence Category");
		
		String AbsCat1 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_1']")).getText().trim();
		s_assert.assertEquals(AbsCat1, "Sick Time");
		
		String AbsCat2 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_2']")).getText().trim();
		s_assert.assertEquals(AbsCat2, "Vacation");*/
		

	/*	driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Tct_main_1']")).click();
		
        driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
        webtableElementClick("//table[@class='datasheet']//td", "Test", "link");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();*/
		
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

		
		
	}

	@Test(enabled = false, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2CheckAccuralCategoryForAbsences  () throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpAbsCat_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

	//	String UsersPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		//s_assert.assertEquals(UsersPage, "User Accounts");
		
	//	driver.findElement(By.xpath(".//*[@id='N_LnkCde_main_1_Img']")).click();
		
	
		
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Austin");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String EmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpName, "Austin, Steven");
		
		String EmpNos = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpNos, "999552");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
	//	driver.switchTo().window("CDwindow-9d218017-4016-4b8a-9f5a-460b30344341");
		
       driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		
		
		String UserLog = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table/tbody[2]/tr[1]/td[1]")).getText().trim();
		s_assert.assertEquals(UserLog, "Absence Category");
		
		String AbsCat1 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_1']")).getText().trim();
		s_assert.assertEquals(AbsCat1, "Sick Time");
		
		String AbsCat2 = driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_2']")).getText().trim();
		s_assert.assertEquals(AbsCat2, "Vacation");
		
		

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
}
