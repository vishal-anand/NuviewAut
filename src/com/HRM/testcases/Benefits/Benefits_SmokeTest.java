package com.HRM.testcases.Benefits;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Benefits_SmokeTest extends CommonFunctions {

	SoftAssert s_assert = new SoftAssert();

	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException, InterruptedException {
		initData();
		BenefitDataCreation();

	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() throws Throwable, InterruptedException {
		BenefitDataTearDown();
		closeBrowser();
	}
/*Prerequisites to Run Benefits Test Cases
 * 
 * 
 * Follow this Below steps to get2016 Benefits.

Navigate > Benefits > Benefits Control > Enrollment Periods          
Select an Enrollment Period Open-2013 
Click on Copy Button          
"AT General tab:
 
Update the Number as '2016'
Select Copy from value as 'Open-2013' from the drop down list.
Update the  Start Date as 01/01/2016 (Static) and Enter the End Date as 12/31/2016 (Static)" 
"At Open Enrollment Tab:

Update the Open Enrollment Start Date as 01/01/2016 (Static)
Update the Open Enrollment End date as 12/31/2016 (Static)" 
Click on Save button. 
Click on Enrollment Period  'Open-2016' from the list. 
Click on Open Enrollment Process Tab
Click on Process button for Step 1 : Create Benefits
Click Ok button.  
Click on Enrollment Period  'Open-2016' 
At Open Enrollment Process Tab
Click on Process Button for Step 2 : Process Eligibility
Click ok button. 
Click on Enrollment Period  'Open-2016' 
At Open Enrollment Process Tab
Click on Process Button for Step 3 : Start Enrollment" 
Click on Ok Button. 

Navigate To do's,
Wait till Workflows are completed.
 * 
 * 

 */
	@Test(enabled = false, priority = 1, groups = {"Smoke"})
	public void verifyExistingEmpEnrolledToBenefitElections() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999141");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Allman, Jim");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
	//	driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']")).click();
	//	driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Allman");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String BenefitsExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(BenefitsExistingEmpExists, "Allman, Jim");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Allman, Jim");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyExistingEmpEnrolledToBenefitDetailsAndSummary() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999141");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Allman, Jim");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEEmpBenSum_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Allman");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String BenefitsExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(BenefitsExistingEmpExists, "Allman, Jim");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsSumTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsSumTitle, "Benefit Summary");

		//String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		//s_assert.assertEquals(EmpName, "Allman, Jim");
		
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		String PlanType = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanType, "Company Provided Life Insurance");

		String BenefitName = driver.findElement(By.xpath(".//*[@id='C_BenName_main_1']")).getText();

		s_assert.assertEquals(BenefitName, "Basic Life Insurance-Company Paid");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyCreateEnrollmentPeriod() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Insurance_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		String EnrollPeriodTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(EnrollPeriodTitle, "Enrollment Periods");
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Select DropEnrollmentType = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrTyp_main_1']/select")));
		DropEnrollmentType.selectByValue("Open");
		driver.findElement(By.xpath(".//*[@id='C_EnrNum_main_1']/input[2]")).sendKeys("2030");
		Select DropCopyFrom = new Select(driver.findElement(By.xpath(".//*[@id='C_CopyFr_main_1']/select")));
		DropCopyFrom.selectByValue("Open-2013");
		driver.findElement(By.xpath(".//*[@id='C_EnrStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_EnrEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='C_DedStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_DedEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='TabTitle_top_Open Enrollment']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_OEEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		// String xpath =
		// ".//*[@id='Datasheet-_main_1_Body']/table[1]/tbody/tr[%s]/td[%s]";
		// String cellvaues = driver.findElement(By.xpath(String.format(xpath,
		// getrowvalue, getcolumnvalue))).getText();
		// String ExistingEmpExists =
		// driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		//String EnrollmentName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_11']")).getText();

		//s_assert.assertEquals(EnrollmentName, "Open-2030");
		
		webtableElementGetText("//table[@class='datasheet']//td", "Open-2030");
		
		webtableElementClick("//table[@class='datasheet']//td", "Open-2030", "link");
		
		
		//driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_10']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertok = driver.switchTo().alert();
		alertok.accept();*/
		Delete();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 4, groups = {"Smoke"})
	public void verifyExistingEmpEnrolledToMedicalCoverage() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_BenPln_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		String BenefitsPlanTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		String BenefitsPlanTitleEdit = driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']")).getText();
		s_assert.assertEquals(BenefitsPlanTitleEdit, "Blue Cross Blue Shield");
		driver.findElement(By.xpath(".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999141");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Allman, Jim");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Allman, Jim");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		String PlanTypeName = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_1']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_1']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_BenPln_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		String BenefitsPlanTitleDel = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPlanTitleDel, "Benefit Plans");
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		String BenefitsPlanNameDel = driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']")).getText();
		s_assert.assertEquals(BenefitsPlanNameDel, "Blue Cross Blue Shield");
		driver.findElement(By.xpath(".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 5, groups = {"Smoke"})
	public void verifyBenefitsEmpMgmtHistory() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999141");

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Allman, Jim");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_SysNotifyEmp_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_RecalElig_main_1']")).click();

		if (driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().contains(
				"    Reenrollment eligibility has been added to the task queue.You may continue to work while this process runs.")) {
			System.out.println("Reenrolment Started. Wait for To Do Task to Complete");
		}

		else {
			System.out.println("Something Went Wrong");
		}
		// s_assert.assertEquals(ReenrolmentMessage, " Reenrollment eligibility
		// has been added to the task queue."
		// + "You may continue to work while this process runs.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();

		Thread.sleep(70000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBen_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String EmpBenTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();

		s_assert.assertEquals(EmpBenTitle, "Employee Benefits");

		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		String Benefit1 = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();

		//s_assert.assertEquals(Benefit1, "BasicLifeIns 16");
		s_assert.assertEquals(Benefit1, "BCBSBC_E1 16");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertok = driver.switchTo().alert();
		alertok.accept();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 6, groups = {"Smoke"})
	public void verifyUserCanChooseHealthCareFlexBenefits() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_7']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 7, groups = {"Smoke"})
	public void verifyUserCanSeeHealthCareFlexBenefitsInDetails() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_OEEmpBenDepRvw_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsDetailTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsDetailTitle, "Benefit Details");

		String EmpNameDetails = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpNameDetails, "Android, Dan");
		String EnrollmentPeriodDetails = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriodDetails, "Open-2016");

		String PlanTypeDetails = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanTypeDetails, "Health Care Flexible Spending Account");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_7']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 8, groups = {"Smoke"})
	public void verifyUserCanEnterAnnualElecForHealthCareFlexBenefitsInDetails() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_OEEmpBenDepRvw_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsDetailTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsDetailTitle, "Benefit Details");

		String EmpNameDetails = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpNameDetails, "Android, Dan");
		String EnrollmentPeriodDetails = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriodDetails, "Open-2016");

		String PlanTypeDetails = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanTypeDetails, "Health Care Flexible Spending Account");

		driver.findElement(By.xpath(".//*[@id='N_AnnElectAmt_main_1']")).clear();
		driver.findElement(By.xpath(".//*[@id='N_AnnElectAmt_main_1']")).sendKeys("2000");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PayPeriodDeduction = driver.findElement(By.xpath(".//*[@id='C_PayrollDeduction_main_1']")).getText();

		s_assert.assertEquals(PayPeriodDeduction, "76.92");
		String Currency = driver.findElement(By.xpath(".//*[@id='C_PayrollDeductionCur_main_1']")).getText();

		s_assert.assertEquals(Currency, "USD");

		System.out.println("verifyUserCanEnterAnnualElecForHealthCareFlexBenefitsInDetails Passed ");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_7']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_7']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 9, groups = {"Smoke"})
	public void verifyUserCanChooseDependentHealthCareFlexBenefits() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_9']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 10, groups = {"Smoke"})
	public void verifyUserCanSeeDependentHealthCareFlexBenefitsInDetails() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * 
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_OEEmpBenDepRvw_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsDetailTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsDetailTitle, "Benefit Details");

		String EmpNameDetails = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpNameDetails, "Android, Dan");
		String EnrollmentPeriodDetails = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriodDetails, "Open-2016");

		String PlanTypeDetails = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanTypeDetails, "Dependent Care Flexible Spending Account");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_9']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = false, priority = 11, groups = {"Smoke"})
	public void verifyUserCanEnterAnnualElecForDependentHealthCareFlexBenefitsInDetails() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();
		driver.switchTo().defaultContent();

		/*
		 * driver.switchTo().frame("dsp"); String BenefitsPlanTitle =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(BenefitsPlanTitle, "Benefit Plans");
		 * driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_15']")).click();
		 * String BenefitsPlanTitleEdit =
		 * driver.findElement(By.xpath(".//*[@id='C_BenPlnNameHeader_main_1']"))
		 * .getText(); s_assert.assertEquals(BenefitsPlanTitleEdit,
		 * "Blue Cross Blue Shield"); driver.findElement(By.xpath(
		 * ".//*[@id='C_IsAutoEnroll_main_1']/input[2]")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("nav");
		 * driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).
		 * click();
		 * driver.findElement(By.xpath(
		 * ".//*[@id='TabTitle_Menu_Human Resources']")).click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).
		 * click();
		 * driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDJALAANA']"))
		 * .click();
		 * driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click
		 * ();
		 * 
		 * 
		 * // driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999019");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String ExistingEmpExists = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(ExistingEmpExists, "Android, Dan");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsPageTitle, "Current Benefits");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Android, Dan");
		String EnrollmentPeriod = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriod, "Open-2016");

		// String PlanTypeName =
		// driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		// s_assert.assertEquals(PlanTypeName, "Medical Coverage");

		WebElement element = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"));
		if (!element.isSelected()) {
			element.click();
		}

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		String IsCheckedPlan = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");

		s_assert.assertEquals(IsCheckedPlan, "Yes");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_OEEmpBenDepRvw_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String BenefitsDetailTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitsDetailTitle, "Benefit Details");

		String EmpNameDetails = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();

		s_assert.assertEquals(EmpNameDetails, "Android, Dan");
		String EnrollmentPeriodDetails = driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).getText();

		s_assert.assertEquals(EnrollmentPeriodDetails, "Open-2016");

		String PlanTypeDetails = driver.findElement(By.xpath(".//*[@id='C_PlnTypName_main_1']")).getText();

		s_assert.assertEquals(PlanTypeDetails, "Dependent Care Flexible Spending Account");

		driver.findElement(By.xpath(".//*[@id='N_DepAnnElectAmt_main_1']")).clear();
		driver.findElement(By.xpath(".//*[@id='N_DepAnnElectAmt_main_1']")).sendKeys("1500");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PayPeriodDeduction = driver.findElement(By.xpath(".//*[@id='C_PayrollDeduction_main_1']")).getText();

		s_assert.assertEquals(PayPeriodDeduction, "57.69");
		String Currency = driver.findElement(By.xpath(".//*[@id='C_PayrollDeductionCur_main_1']")).getText();

		s_assert.assertEquals(Currency, "USD");

		System.out.println("verifyUserCanEnterAnnualElecForDependentHealthCareFlexBenefitsInDetails Passed ");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_OEBenCurr_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_SysChooseNone_main_9']")).click();

		String IsCheckedPlanNew = driver.findElement(By.xpath(".//*[@id='C_Chosen_main_9']/input[2]"))
				.getAttribute("Value");
		s_assert.assertEquals(IsCheckedPlanNew, "");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = false, priority = 12, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2CreateBenefitGroupAndAddStandardPeriod() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAKAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		String BenefitGroupTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitGroupTitle, "Benefit Groups");
		Add();
	//	Select DropEnrollmentType = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrTyp_main_1']/select")));
	//	DropEnrollmentType.selectByValue("Open");
		driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']/input[2]")).sendKeys("TestGroup");
		driver.findElement(By.xpath(".//*[@id='C_BenGrpName_main_1']/input[2]")).sendKeys("TestGroupName");
		Click(".//*[@id='TabTitle__ACA Setup']");
		radiobutton_Select(".//*[@id='C_OfferCov1B_none_1']/input[2]");
		//radiobutton_Select(".//*[@id='C_OfferCov1B_none_1']/input[2]");
		SelectDropDownValue(".//*[@id='C_SafeHarbor_main_1']/select", "2F");
		SelectDropDownValue(".//*[@id='C_SafeHarbor_main_1']/select", "2F");
		radiobutton_Select(".//*[@id='C_SelfInsured_main_1']/input[2]");
		SelectDropDownValue(".//*[@id='C_CmpAdrSrc_main_1']/select", "UserEntryAdd");
		
		Click(".//*[@id='TabTitle__Measurement Setup']");
		
		SelectDropDownValue(".//*[@id='C_SpecialLeave_main_1']/select", "Credit");
		
		Click(".//*[@id='TabTitle__Initial Measurement Period']");
		
		SelectDropDownValue(".//*[@id='C_InitialStart_main_1']/select", "HireDt");
		SelectDropDownValue(".//*[@id='C_RehireContWeeks_main_1']/select", "13");
		
		Save();
		
		webtableElementClick("//table[@class='datasheet']//td", "TestGroup", "link");
		Click(".//*[@id='TabTitle__Standard Measurement Periods']");
		Click(".//*[@id='C_AddStdBtn_none_1']");
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		
		driver.findElement(By.xpath(".//*[@id='C_MsmtPrdStartDt_main_1']/input[2]")).sendKeys("01/01/2016");
		driver.findElement(By.xpath(".//*[@id='C_MsmtPrdEndDt_main_1']/input[2]")).sendKeys("12/31/2016");
		driver.findElement(By.xpath(".//*[@id='C_StabilityPrdStartDt_main_1']/input[2]")).sendKeys("01/01/2016");
		driver.findElement(By.xpath(".//*[@id='C_StabilityPrdEndDt_main_1']/input[2]")).sendKeys("12/31/2016");
		Save();
		driver.switchTo().window(window1);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		webtableElementClick("//table[@class='datasheet']//td", "TestGroup", "link");
		Click(".//*[@id='TabTitle__Standard Measurement Periods']");
		String MsmtPrdStartDt = driver.findElement(By.xpath(".//*[@id='C_MsmtPrdStartDt_StandardPeriods_1']")).getText();

		s_assert.assertEquals(MsmtPrdStartDt, "01/01/2016");
		String MsmtPrdEndDt = driver.findElement(By.xpath(".//*[@id='C_MsmtPrdEndDt_StandardPeriods_1']")).getText();

		s_assert.assertEquals(MsmtPrdEndDt, "12/31/2016");
		
		String StabilityPrdStartDt = driver.findElement(By.xpath(".//*[@id='C_StabilityPrdStartDt_StandardPeriods_1']")).getText();

		s_assert.assertEquals(StabilityPrdStartDt, "01/01/2016");
		
		String StabilityPrdEndDt = driver.findElement(By.xpath(".//*[@id='C_StabilityPrdEndDt_StandardPeriods_1']")).getText();

		s_assert.assertEquals(StabilityPrdEndDt, "12/31/2016");
		
			Delete();
		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = false, priority = 13, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2AssignBenifitGroup2Emp() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAKAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		String BenefitGroupTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(BenefitGroupTitle, "Benefit Groups");
		Add();
	//	Select DropEnrollmentType = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrTyp_main_1']/select")));
	//	DropEnrollmentType.selectByValue("Open");
		driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']/input[2]")).sendKeys("TestGroup");
		driver.findElement(By.xpath(".//*[@id='C_BenGrpName_main_1']/input[2]")).sendKeys("TestGroupName");
		Click(".//*[@id='TabTitle__ACA Setup']");
		radiobutton_Select(".//*[@id='C_OfferCov1B_none_1']/input[2]");
		//radiobutton_Select(".//*[@id='C_OfferCov1B_none_1']/input[2]");
		SelectDropDownValue(".//*[@id='C_SafeHarbor_main_1']/select", "2F");
		SelectDropDownValue(".//*[@id='C_SafeHarbor_main_1']/select", "2F");
		radiobutton_Select(".//*[@id='C_SelfInsured_main_1']/input[2]");
		SelectDropDownValue(".//*[@id='C_CmpAdrSrc_main_1']/select", "UserEntryAdd");
		
		Click(".//*[@id='TabTitle__Measurement Setup']");
		
		SelectDropDownValue(".//*[@id='C_SpecialLeave_main_1']/select", "Credit");
		
		Click(".//*[@id='TabTitle__Initial Measurement Period']");
		
		SelectDropDownValue(".//*[@id='C_InitialStart_main_1']/select", "HireDt");
		SelectDropDownValue(".//*[@id='C_RehireContWeeks_main_1']/select", "13");
		
		Save();
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();
		
		Switch2Middle();
		
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']/input[2]")).sendKeys("999503");
		Find();
		
		Switch2Right();
		
		webtableElementGetText("//table[@class='datasheet']//td", "Adams, Sam");
		
		webtableElementClick("//table[@class='datasheet']//td", "Adams, Sam", "link");
		
		
		Switch2Middle();
		
		webtableElementClick("//table[@class='datasheet']//td", "1", "link");
		
		SelectDropDownValue(".//*[@id='C_BenGrp_main_1']/select", "TestGroup");
		
		Save();
		
		webtableElementClick("//table[@class='datasheet']//td", "1", "link");
		
		String BenefitGroup = new Select(driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']/select"))).getFirstSelectedOption().getAttribute("value");
		s_assert.assertEquals( BenefitGroup, "TestGroup");
		
		SelectDropDownValue(".//*[@id='C_BenGrp_main_1']/select", "Home");
		Save();
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAKAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_BenGrp_main_1']")).click();
		
		Switch2MidException();
		
		webtableElementClick("//table[@class='datasheet']//td", "TestGroup", "link");
		Delete();
		
		
	
		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 14, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2ALEGroupSetup() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		int Year = GetCurrentYear();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAKAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_ALEGrpMnu_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		String ALEGroupTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ALEGroupTitle, "ALE Groups");
	//	Add();
	//	Select DropEnrollmentType = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrTyp_main_1']/select")));
	//	DropEnrollmentType.selectByValue("Open");
		driver.findElement(By.xpath(".//*[@id='C_ALECde_main_1']/input[2]")).sendKeys("TestALEGroup");
		driver.findElement(By.xpath(".//*[@id='C_Year_main_1']/input[2]")).sendKeys(String.valueOf(Year));
		doubleClick(".//*[@id='C_Cmp_main_1']/table/tbody/tr/td[1]/select/option[1]");
		SelectDropDownValue(".//*[@id='C_Sec4980H_main_1']/select", "B");
		Save();
		webtableElementGetText("//table[@class='datasheet']//td", "TestALEGroup");
	//	webtableElementClick("//table[@class='datasheet']//td", "TestALEGroup", "link");
	//	Thread.sleep(5000);
	//	Delete();
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = false, priority = 15, groups = {"Smoke" , "Nightly" } , description = "Verify that under dependents tab, dependents should not show up. ")
	public void verifyDependentsDontshowup() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		//int Year = GetCurrentYear();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBen_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Find();
		
		Switch2Right();
		
		//webtableElementGetText("//table[@class='datasheet']//td", "TestALEGroup");
		webtableElementClick("//table[@class='datasheet']//td", "Bing, Chandler", "link");
	//	Thread.sleep(5000);
	//	Delete();
		Switch2Middle();
		
		webtableElementClick("//table[@class='datasheet']//td", "BasicLifeIns 12", "link");
		Click(".//*[@id='TabTitle__Dependents']");
		
		 if(driver.findElements(By.xpath(".//*[@id='F_Dep_dependents_1']")).isEmpty()){
		        //THEN CLICK ON THE SUBMIT BUTTON
			 
			 s_assert.assertTrue(true);
			 System.out.println("Dependent Not Found");
		    }else{
		    	
		    	System.out.println("Dependent Found");
		        //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
		    	s_assert.fail();
		    }
		
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = false, priority = 16, groups = {"Smoke" , "Nightly" } , description = "Verify that under the Beneficiaries Tab, Beneficiaries should not showup.  ")
	public void verifyBeneficiariesDontshowup() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		//int Year = GetCurrentYear();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBen_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Find();
		
		Switch2Right();
		
		//webtableElementGetText("//table[@class='datasheet']//td", "TestALEGroup");
		webtableElementClick("//table[@class='datasheet']//td", "Bing, Chandler", "link");
	//	Thread.sleep(5000);
	//	Delete();
		Switch2Middle();
		
		webtableElementClick("//table[@class='datasheet']//td", "BasicLifeIns 12", "link");
		Click(".//*[@id='TabTitle__Beneficiaries']");
		
		 if(driver.findElements(By.xpath(".//*[@id='F_BnfNum_beneficiaries_1']")).isEmpty()){
		        //THEN CLICK ON THE SUBMIT BUTTON
			 
			 s_assert.assertTrue(true);
			 System.out.println("Beneficiary Not Found");
		    }else{
		    	
		    	System.out.println("Beneficiary Found");
		        //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
		    	s_assert.fail();
		    }
		
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 17, groups = {"Smoke" , "Nightly" })
	public void verifyCreateEnrollmentPeriodNew() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Benefits']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Insurance_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EnrSum_main_1']")).click();

		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		String EnrollPeriodTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(EnrollPeriodTitle, "Enrollment Periods");
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		if(driver.findElements(By.xpath(".//*[@id='C_Add_Img']")).size()!=0){
			
			
			driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		}
		
		else
		{	
		log.info("Find Element No Present");
		}
		Select DropEnrollmentType = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrTyp_main_1']/select")));
		DropEnrollmentType.selectByValue("Open");
		//DropEnrollmentType.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='C_EnrNum_main_1']/input[2]")).sendKeys("2030");
		Select DropCopyFrom = new Select(driver.findElement(By.xpath(".//*[@id='C_CopyFr_main_1']/select")));
		//DropCopyFrom.selectByValue("Open-2013");
		DropCopyFrom.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='C_EnrStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_EnrEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='C_DedStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_DedEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='TabTitle_top_Open Enrollment']")).click();
		driver.findElement(By.xpath(".//*[@id='C_OEStartDt_main_1']/input[2]")).sendKeys("01/01/2030");
		driver.findElement(By.xpath(".//*[@id='C_OEEndDt_main_1']/input[2]")).sendKeys("12/31/2030");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		// String xpath =
		// ".//*[@id='Datasheet-_main_1_Body']/table[1]/tbody/tr[%s]/td[%s]";
		// String cellvaues = driver.findElement(By.xpath(String.format(xpath,
		// getrowvalue, getcolumnvalue))).getText();
		// String ExistingEmpExists =
		// driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		//String EnrollmentName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_11']")).getText();

		//s_assert.assertEquals(EnrollmentName, "Open-2030");
		
		webtableElementGetText("//table[@class='datasheet']//td", "2030");
		
		webtableElementClick("//table[@class='datasheet']//td", "Open-2030", "link");
		
		
		//driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_10']")).click();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertok = driver.switchTo().alert();
		alertok.accept();*/
		Delete();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

}
