package com.HRM.testcases.Reporting;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;



public class Reporting_SmokeTest extends CommonFunctions {
	


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
	public void verifyComplianceReportsEEO1() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDDAANA']")).click();
		driver.findElement(By.xpath(".//*[@display='Compliance Report' and @tip='Compliance Report']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EEO1_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String EEO1Page = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(EEO1Page, "Compliance Report EEO1");
		String today = new CommonFunctions().GetCurrentDate();
		Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_CmpName_none_1']/select")));
		//dropdownCompany.selectByValue("IGS");
		dropdownCompany.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='C_RangeStart_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_RangeEnd_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("targetFrame");
		
		String Message = driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td[2]")).getText().trim();
		
		s_assert.assertEquals(Message, "EQUAL EMPLOYMENT OPPORTUNITY\nEMPLOYER INFORMATION REPORT EEO - 1");

		

		
		

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	
	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyComplianceReportsEEO4() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDDAANA']")).click();
		driver.findElement(By.xpath(".//*[@display='Compliance Report' and @tip='Compliance Report']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EEO4_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String EEO4Page = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(EEO4Page, "EEO4");
		String today = new CommonFunctions().GetCurrentDate();
		Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Company_main_1']/select")));
		//dropdownCompany.selectByValue("IGS");
		dropdownCompany.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='C_StartDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_EndDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("targetFrame");
		
		String Message = driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td")).getText().trim();
		
		s_assert.assertEquals(Message, "EQUAL EMPLOYMENT OPPORTUNITY COMMISSION STATE AND LOCAL GOVERNMENT INFORMATION (EEO-4) EXCLUDE SCHOOL SYSTEMS AND EDUCATIONAL INSTITUTIONS(Read attached instructions prior to completing this form)");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();
		
		

	}
	
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyComplianceReportsVets100() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		log.info("Clicked on Reporting");
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDDAANA']")).click();
		driver.findElement(By.xpath(".//*[@display='Compliance Report' and @tip='Compliance Report']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Vets100_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String VETS100APage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(VETS100APage, "Vets 100");
		String today = new CommonFunctions().GetCurrentDate();
		Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_CmpName_none_1']/select")));
		//dropdownCompany.selectByValue("IGS");
		dropdownCompany.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='C_StartDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_EndDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("targetFrame");
		
		String Message = driver.findElement(By.xpath("html/body/table[1]/tbody/tr[2]/td")).getText().trim();
		
		s_assert.assertEquals(Message, "REPORT VETS-100");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();
		
		

	}
	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyComplianceReportsVets100A() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		log.info("Clicked on Reporting");
		driver.findElement(By.xpath(".//*[@display='Compliance Report' and @tip='Compliance Report']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDDAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Vets 100A_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String VETS100APage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(VETS100APage, "Vets 100A");
		String today = new CommonFunctions().GetCurrentDate();
		Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Company_none_1']/select")));
		//dropdownCompany.selectByValue("IGS");
		dropdownCompany.selectByIndex(1);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_StartDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_EndDate_none_1']/input[2]")).sendKeys("01/01/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("targetFrame");
		
		String Message = driver.findElement(By.xpath("html/body/table[1]/tbody/tr[2]/td")).getText().trim();
		
		s_assert.assertEquals(Message, "REPORT VETS-100A");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();
		
		

	}
	
	@Test(enabled = true, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2PreviewLetter() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		log.info("Clicked on Reporting");
		driver.findElement(By.xpath(".//*[@id='C_Letters_main_1']")).click();
		
		//driver.findElement(By.xpath(".//*[@id='C_Vets 100A_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String LetterPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(LetterPage, "Letters");
	//	String today = new CommonFunctions().GetCurrentDate();
	//	Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Company_none_1']/select")));
	//	dropdownCompany.selectByValue("IGS");
		driver.findElement(By.xpath(".//*[@id='C_Ltr_main_1']/input[2]")).sendKeys("ForgotPassword ");
		//Enter Letter
		
		//driver.findElement(By.xpath(".//*[@id='C_EndDate_none_1']/input[2]")).sendKeys(today);
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		
		
		String Message = driver.findElement(By.xpath(".//*[@id='C_Ltr_main_1']")).getText();
		
		s_assert.assertEquals(Message, "ForgotPassword");
		
		driver.findElement(By.xpath(".//*[@id='C_Preview_main_1']")).click();
		
		switchToNewWindow();
		
        String MessageLetter = driver.findElement(By.xpath(".//*[@id='view_list']/div[1]")).getText().trim();
		
		s_assert.assertEquals(MessageLetter, "Letter: ForgotPassword - ForgotPassword");
		
		//driver.close();
		
		switchToOldWindow();
		
		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();
		
		

	}
	
	@Test(enabled = true, priority = 6, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2PreviewResultOfReports() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		Click(".//*[@id='TabTitle_Menu_Reporting']");
		//driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Reporting']")).click();
		log.info("Clicked on Reporting");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_RptFind_main_1']")).click();
		
		//driver.findElement(By.xpath(".//*[@id='C_Vets 100A_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String ReportsPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ReportsPage, "Reports");
	//	String today = new CommonFunctions().GetCurrentDate();
	//	Select dropdownCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Company_none_1']/select")));
	//	dropdownCompany.selectByValue("IGS");
		driver.findElement(By.xpath(".//*[@id='C_Rpt_main_1']/input[2]")).sendKeys("Address");
		//Enter Letter
		
		//driver.findElement(By.xpath(".//*[@id='C_EndDate_none_1']/input[2]")).sendKeys(today);
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		
		
		String ReportFind = driver.findElement(By.xpath(".//*[@id='C_Rpt_main_1']")).getText();
		
		s_assert.assertEquals(ReportFind, "Address");
		
		driver.findElement(By.xpath(".//*[@id='C_Preview_main_1']")).click();
		
		switchToNewWindow();
		
        String MessageLetter = driver.findElement(By.xpath(".//*[@id='view_list']/div[1]")).getText().trim();
		
		s_assert.assertEquals(MessageLetter, "Report: Address - * Address List Parameter Attached");
		
		//driver.close();
		
		switchToOldWindow();
		
		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();
		}
}
