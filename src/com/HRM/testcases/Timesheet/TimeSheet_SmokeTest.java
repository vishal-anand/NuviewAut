package com.HRM.testcases.Timesheet;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class TimeSheet_SmokeTest extends CommonFunctions {
	
	SoftAssert s_assert = new SoftAssert();
	
	
	@BeforeTest(alwaysRun = true)
	 public void StartBrowser_NavURL() throws IOException {
	  initData();  
	 }
	
	@AfterTest(alwaysRun = true)
	 public void ClosingBrowser() {  
	  closeBrowser();  
	 }
	
	
	

	
	@Test(enabled = true, priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifyTimeSheetActivity() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");
		 Switch2LeftLogin();
		 Thread.sleep(15000);
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
	//	driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		System.out.println("Clicked");
		
		driver.findElement(By.xpath(".//*[@id='C_TimAct_main_1']")).click();

		Thread.sleep(5000);

		Switch2MidException();
		
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		Add();
		
		String TimeActTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(TimeActTitle, "Timesheet Activities");
		
		driver.findElement(By.xpath(".//*[@id='C_TimAct_main_1']/input[2]")).sendKeys("VicAct");
		driver.findElement(By.xpath(".//*[@id='C_TimActName_main_1']/input[2]")).sendKeys("Vic");
		Select DropAct = new Select(driver.findElement(By.xpath(".//*[@id='C_AbsCat_main_1']/select")));
		DropAct.selectByValue("Holiday");
		
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);
		
		String Activity = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_16']")).getText();

		s_assert.assertEquals(Activity, "VicAct");
		
		String ActivityName = driver.findElement(By.xpath(".//*[@id='C_Lbl2_main_16']")).getText();

		s_assert.assertEquals(ActivityName, "Vic");
		
		String ActivityCat = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_16']")).getText();

		s_assert.assertEquals(ActivityCat, "Holiday");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_16']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
		Delete();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();
		 
	} 
	
	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyTimeSheetGroupCreation() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		 Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']")).click();


		Thread.sleep(5000);

		Switch2MidException();


		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		Add();
		
		String TimeGrpTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(TimeGrpTitle, "Timesheet Group");
		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/input[2]")).sendKeys("VicGrp");
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_main_1']/input[2]")).sendKeys("VicT");
		Select DropWeekStrtDay = new Select(driver.findElement(By.xpath(".//*[@id='C_WrkWkStrDay_main_1']/select")));
		DropWeekStrtDay.selectByValue("Monday");
		
		driver.findElement(By.xpath(".//*[@id='C_SunWkEnd_main_1']/input[2]")).click();
		
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_PayGrpAct_PayGrpAct_0']")).click();
		
		Select DropTmGrpAct = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_PayGrpAct_0']/select")));
		DropTmGrpAct.selectByValue("AM");
		driver.findElement(By.xpath(".//*[@id='C_TimActDef_PayGrpAct_0']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_PayGrpAct_PayGrpAct_0']")).click();
		
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncCstCde_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncPos_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncJob_main_1']/input[2]")).click();
		
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);
		
		String TmGroup = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroup, "VicGrp");
		
		String TmGroupName = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroupName, "VicT");
		

		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
		Delete();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		 logOut();
		 s_assert.assertAll();
		 

		 
		

		

	} 
	
	@Test(enabled = true, priority = 3)
	public void verifyTimeSheetPeriodCreation() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");


		 Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_TimePd_main_1']")).click();

		Thread.sleep(5000);

		
		Switch2MidException();

		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		Add();
		
		String TimePeriodTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(TimePeriodTitle, "Timesheet Period");
		
		Select DropTimeSheetGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		DropTimeSheetGrp.selectByValue("CA_OT");
		
		driver.findElement(By.xpath(".//*[@id='C_PdYr_main_1']/input[2]")).sendKeys("2017");
		driver.findElement(By.xpath(".//*[@id='C_PdNum_main_1']/input[2]")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='C_TimPdStrDt_main_1']/input[2]")).sendKeys("01/01/2017");
		driver.findElement(By.xpath(".//*[@id='C_TimPdEndDt_main_1']/input[2]")).sendKeys("12/31/2017");
		driver.findElement(By.xpath(".//*[@id='C_TimPdLck_main_1']/input[2]")).click();
		Select DropTmPeriodStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_TimPdSts_main_1']/select")));
		DropTmPeriodStatus.selectByValue("Open");
		

		
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_PdYr_main_1']/input[2]")).sendKeys("2017");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		String TmGroup = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpLbl_main_1']")).getText();

		s_assert.assertEquals(TmGroup, "CA_OT");
		
		String PrdStartDate = driver.findElement(By.xpath(".//*[@id='C_TimPdStrDtLbl_main_1']")).getText();

		s_assert.assertEquals(PrdStartDate, "01/01/2017");
		
		String PrdEndDate = driver.findElement(By.xpath(".//*[@id='C_TimPdEndDtLbl_main_1']")).getText();

		s_assert.assertEquals(PrdEndDate, "12/31/2017");
		

		
		driver.findElement(By.xpath(".//*[@id='C_Pd_main_1']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
		Delete();
		
		 Thread.sleep(5000);
		 driver.switchTo().defaultContent();
		 logOut();
		 s_assert.assertAll();
		 
	} 
	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyAssignTimeSheet2Employee() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		 Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();


		Thread.sleep(5000);

		Switch2Middle();

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Adams");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");
		
        //driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Find();

        Switch2Right();
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Switch2Middle();
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		
		Select DropTimeSheetGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		DropTimeSheetGrp.selectByValue("CLOCK");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();
		
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		
		String TmShtGrp = driver.findElement(By.name("O_TimCrdGrp_main_1")).getAttribute("Value");

		s_assert.assertEquals(TmShtGrp, "CLOCK");
		
		Select DropTimeSheetGrpReset = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		DropTimeSheetGrpReset.selectByValue("");
		Alert alertre = driver.switchTo().alert();
		alertre.accept();
	//	driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();
	
	} 
	
	@Test(enabled = true, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifyTimeSheetGroupCreationWithWorkWeekStartDay() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		 Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']")).click();


		Thread.sleep(5000);

		Switch2MidException();


		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		Add();
		
		String TimeGrpTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(TimeGrpTitle, "Timesheet Group");
		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/input[2]")).sendKeys("Test1");
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_main_1']/input[2]")).sendKeys("Test1");
		Select DropWeekStrtDay = new Select(driver.findElement(By.xpath(".//*[@id='C_WrkWkStrDay_main_1']/select")));
		DropWeekStrtDay.selectByValue("Monday");
		
		driver.findElement(By.xpath(".//*[@id='C_SunWkEnd_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_SatWkEnd_main_1']/input[2]")).click();
		
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_PayGrpAct_PayGrpAct_0']")).click();
		
		//Select DropTmGrpAct = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_PayGrpAct_0']/select")));
		//DropTmGrpAct.selectByValue("AM");
		driver.findElement(By.xpath(".//*[@id='C_TimActDef_PayGrpAct_0']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_PayGrpAct_PayGrpAct_0']")).click();
		
	/*	driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncCstCde_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncPos_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncJob_main_1']/input[2]")).click();*/
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Controls']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_IncWkd_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncInOutTim_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpSubmit_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_AlwApv_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_AlwUnaprv_main_1']/input[2]")).click();
		
		
	//	driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);
		
		String TmGroup = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroup, "Test1");
		
		String TmGroupName = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroupName, "Test1");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
		Delete();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		 logOut();
		 s_assert.assertAll();
		 

		 
		

		

	} 
	
	
	@Test(enabled = true, priority = 6, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToAsssignNewlyCreatedTimeSheetGroup() throws InterruptedException {

		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		 Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']")).click();


		Thread.sleep(5000);

		Switch2MidException();


		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		Add();
		
		String TimeGrpTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(TimeGrpTitle, "Timesheet Group");
		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/input[2]")).sendKeys("Test1");
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_main_1']/input[2]")).sendKeys("Test1");
		Select DropWeekStrtDay = new Select(driver.findElement(By.xpath(".//*[@id='C_WrkWkStrDay_main_1']/select")));
		DropWeekStrtDay.selectByValue("Monday");
		
		driver.findElement(By.xpath(".//*[@id='C_SunWkEnd_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_SatWkEnd_main_1']/input[2]")).click();
		
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_PayGrpAct_PayGrpAct_0']")).click();
		
		//Select DropTmGrpAct = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_PayGrpAct_0']/select")));
		//DropTmGrpAct.selectByValue("AM");
		driver.findElement(By.xpath(".//*[@id='C_TimActDef_PayGrpAct_0']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_PayGrpAct_PayGrpAct_0']")).click();
		
	/*	driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAADAAABAAWA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncCstCde_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncPos_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncJob_main_1']/input[2]")).click();*/
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Controls']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_IncWkd_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_IncInOutTim_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpSubmit_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_AlwApv_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_AlwUnaprv_main_1']/input[2]")).click();
		
		
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);
		
		String TmGroup = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroup, "Test1");
		
		String TmGroupName = driver.findElement(By.xpath(".//*[@id='C_TimCrdGrpName_Listmain_8']")).getText();

		s_assert.assertEquals(TmGroupName, "Test1");
		
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();


		Thread.sleep(5000);

		Switch2Middle();

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Adams");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");
		
        //driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Find();

        Switch2Right();
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Switch2Middle();
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		
		Select DropTimeSheetGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		DropTimeSheetGrp.selectByValue("Test1");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();
		
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		
		String TmShtGrp = driver.findElement(By.name("O_TimCrdGrp_main_1")).getAttribute("Value");

		s_assert.assertEquals(TmShtGrp, "Test1");

	
		Select DropTimeSheetGrpReset = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		DropTimeSheetGrpReset.selectByValue("");
		Alert alertre = driver.switchTo().alert();
		alertre.accept();
		Save();
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Time Attendance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']")).click();
	    Switch2MidException();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_Listmain_8']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();*/
		
		Delete();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		 logOut();
		 s_assert.assertAll();
		
	} 


}
