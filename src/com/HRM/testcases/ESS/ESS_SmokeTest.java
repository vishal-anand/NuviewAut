package com.HRM.testcases.ESS;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class ESS_SmokeTest extends CommonFunctions {

	SoftAssert s_assert = new SoftAssert();

	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException {
		initData();

	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() {
		closeBrowser();
	}
	// Pay-Payroll

	@Test(enabled = true, priority = 1, groups = {"Smoke"})
	public void verifyUserCreatePayRollDirectDeposits() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
	
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Direct DepositDialog");
		String PayDirDepTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PayDirDepTitle, "Payroll Direct Deposit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Select DropDirectDepCode = new Select(driver.findElement(By.xpath(".//*[@id='C_PayDir_main_1']/select")));
		DropDirectDepCode.selectByValue("2");

		driver.findElement(By.xpath(".//*[@id='C_EmpPayDirEffDt_main_1']/input[2]")).sendKeys(s);
		Select DropAmtType = new Select(driver.findElement(By.xpath(".//*[@id='C_AmtType_main_1']/select")));
		DropAmtType.selectByValue("F");
		driver.findElement(By.xpath(".//*[@id='N_SysAmtMny_main_1']")).sendKeys("10");
		Select DropCurrency = new Select(driver.findElement(By.xpath(".//*[@id='N_SysAmtMnycur_main_1']")));
		DropCurrency.selectByValue("USD");
		Select DropBankAcntType = new Select(driver.findElement(By.xpath(".//*[@id='C_DirType_main_1']/select")));
		DropBankAcntType.selectByValue("S");
		driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();
		//Save();

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer,
				"   Your request will be sent to Jerry Berman, Sam Adams and Keith Washington for approval.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		//driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		logOut();
		Thread.sleep(5000);
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		//Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		logOut();
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();*/
		// logOut();
		Thread.sleep(10000);

		logIn("nvsuperuser1", "nuview");

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		driver.switchTo().frame("login");
		Actions action1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		action1.moveToElement(mainMenu1).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Direct DepositDialog");
		String PayDirDepTitle1 = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PayDirDepTitle1, "Payroll Direct Deposit");
		String DirectDepCodeV = driver.findElement(By.xpath(".//*[@id='C_PayDir_main_2']")).getText();
		s_assert.assertEquals(DirectDepCodeV, "2");
		String AmountTypeV = driver.findElement(By.xpath(".//*[@id='C_AmtType_main_2']")).getText();
		s_assert.assertEquals(AmountTypeV, "F");

		driver.findElement(By.xpath(".//*[@id='C_PayDir_main_2']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		driver.switchTo().defaultContent();
		logOut();
		
		
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent(); */
		logIn("fulldemo", "nuview");
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation1,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// driver.switchTo().frame("login");
		// driver.switchTo().frame("nav");
		// .findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();
		// Thread.sleep(5000);
		logOut();

		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserCanViewChecks() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);
		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		action.moveToElement(mainMenu).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[1]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("View ChecksDialog");
		String PayDirDepTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PayDirDepTitle, "Employee Check Information");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpName, "Adams, Sam");

		driver.findElement(By.xpath(".//*[@id='C_link_main_1']")).click();

		Thread.sleep(15000);

		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		String EarningStatementTitle = driver
				.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/div[2]/div/table[1]/tbody/tr/td[2]/b/h1"))
				.getText();
		s_assert.assertEquals(EarningStatementTitle, "EARNINGS STATEMENT");
		String EmpNameEarningStatement = driver.findElement(By.xpath(".//*[@id='C_EmpName_main_1']")).getText();
		s_assert.assertEquals(EmpNameEarningStatement, "Sam Adams");
		System.out.println("Verified Checks for Sam Adams");
		driver.close();

		Thread.sleep(15000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();

		// driver.switchTo().frame("login");
		// driver.switchTo().frame("nav");
		// .findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 3, groups = {"Smoke"})
	public void verifyUserAbleToReqTimeOffSingleDay() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[3]/div[2]/ul/li[1]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Request Time OffDialog");
		String TimeoffTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(TimeoffTitle, "Employee Time");
		System.out.println("User is on the Request Time off Page");

		DateFormat dateFormat2 = new SimpleDateFormat("dd");
		Date date2 = new Date();

		String today = dateFormat2.format(date2);

		// find the calendar
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='C_TimeCal_main_1']/table/tbody"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}
		Thread.sleep(50000);
		System.out.println("Todays Date Selected, Please Proceed");
		Select DropActivity = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_main_0']/select")));
		DropActivity.selectByValue("JuryDuty");
		driver.findElement(By.xpath(".//*[@id='C_Hours_main_0']/input[2]")).sendKeys("8");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_main_main_0']")).click();
		// String EmpLeaveStatusP =
		// driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]")).getText();
		// s_assert.assertEquals(EmpLeaveStatusP, "Pending");
		driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer, "   Your request will be sent to Harrison Ahern for approval.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		/*driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);*/
		
		
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		//driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		logOut();
		Thread.sleep(5000);
		
		
		
		
		logIn("hahern", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();
		// logOut();
		Thread.sleep(10000);
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmationS = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmationS,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();*/
		logOut();
		/*
		 * Thread.sleep(10000);
		 * 
		 * logIn("nvsuperuser1", "nuview"); Thread.sleep(5000); //String s = new
		 * CommonFunctions().GetCurrentDate();
		 * //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.switchTo().frame("nav");
		 * 
		 * driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		 * Thread.sleep(10000);
		 * 
		 * // driver.switchTo().parentFrame();
		 * //driver.switchTo().defaultContent();
		 * driver.switchTo().frame("login"); Actions actionV = new
		 * Actions(driver); WebElement mainMenuV =
		 * driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		 * actionV.moveToElement(mainMenuV).build().perform();
		 * //Thread.sleep(5000L); driver.findElement(By.xpath(
		 * ".//*[@id='menu_icon_0-menu']/div[3]/div[2]/ul/li[1]/a")).click();
		 * //.moveToElement(driver.findElement(By.xpath(
		 * ".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().
		 * build().perform(); Thread.sleep(15000);
		 * driver.switchTo().defaultContent(); driver.switchTo().frame("login");
		 * //driver.switchTo().frame(driver.findElement(By.name(
		 * "Direct DepositDialog"))); driver.switchTo().frame(
		 * "Request Time OffDialog"); String TimeoffTitleV =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(TimeoffTitleV, "Employee Time");
		 * System.out.println("User is on the Request Time off Page");
		 * 
         * 
		 * 
		 * DateFormat dateFormat3 = new SimpleDateFormat("dd"); Date date3 = new
		 * Date();
		 * 
		 * String today1 = dateFormat3.format(date3);
		 * 
		 * //find the calendar WebElement dateWidget1 =
		 * driver.findElement(By.xpath(
		 * ".//*[@id='C_TimeCal_main_1']/table/tbody")); List<WebElement>
		 * columns1=dateWidget1.findElements(By.tagName("td"));
		 * 
		 * //comparing the text of cell with today's date and clicking it. for
		 * (WebElement cell : columns1) { if (cell.getText().equals(today1)) {
		 * cell.click();
		 * 
		 * break; } } Thread.sleep(50000); String EmpLeaveStatusF =
		 * driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]"
		 * )).getText(); s_assert.assertEquals(EmpLeaveStatusF, "Approved");
		 * 
		 * System.out.println("Validation Complete");
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("login");
		 * driver.findElement(By.xpath(".//*[@id='logout']")).click();
		 */

		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 4, groups = {"Smoke"})
	public void verifyUserAbleToReqTimeOffMultipleDay() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[3]/div[2]/ul/li[1]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Request Time OffDialog");
		String TimeoffTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(TimeoffTitle, "Employee Time");
		System.out.println("User is on the Request Time off Page");

		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAACABABAAABAA3A']")).click();

		String Dayplus1 = new CommonFunctions().GetCurrentDateAdd1();
		String Dayplus2 = new CommonFunctions().GetCurrentDateAdd2();
		/*
		 * String tplus1 = new CommonFunctions().GetTplus1day();
		 * 
		 * //find the calendar WebElement dateWidget =
		 * driver.findElement(By.xpath(
		 * ".//*[@id='C_TimeCal_main_1']/table/tbody")); List<WebElement>
		 * columns=dateWidget.findElements(By.tagName("td"));
		 * 
		 * //comparing the text of cell with today's date and clicking it. for
		 * (WebElement cell : columns) { if (cell.getText().equals(tplus1)) {
		 * cell.click(); break; } } Thread.sleep(50000); System.out.println(
		 * "Todays Date Selected, Please Proceed");
		 */

		Select DropActivity = new Select(driver.findElement(By.xpath(".//*[@id='C_MultiTimAct_none_1']/select")));
		DropActivity.selectByValue("JuryDuty");
		driver.findElement(By.xpath(".//*[@id='C_MultiEmpTimEffDt_none_1']/input[2]")).sendKeys(Dayplus1);
		driver.findElement(By.xpath(".//*[@id='C_MultiEmpTimEfdDt_none_1']/input[2]")).sendKeys(Dayplus2);
		driver.findElement(By.xpath(".//*[@id='C_MultiHours_none_1']/input[2]")).sendKeys("8");
		// String EmpLeaveStatusP =
		// driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]")).getText();
		// s_assert.assertEquals(EmpLeaveStatusP, "Pending");

		driver.findElement(By.xpath(".//*[@id='C_MultiOk_none_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer, "   Your request will be sent to Harrison Ahern for approval.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		//driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		logOut();
		Thread.sleep(5000);
		
		
		
		
		/*driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);*/
		logIn("hahern", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();*/
		 logOut();
		Thread.sleep(10000);
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmationS = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmationS,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();*/
		 logOut();
		/*
		 * Thread.sleep(10000);
		 * 
		 * logIn("nvsuperuser1", "nuview"); Thread.sleep(5000); //String s = new
		 * CommonFunctions().GetCurrentDate();
		 * //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.switchTo().frame("nav");
		 * 
		 * driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		 * Thread.sleep(10000);
		 * 
		 * // driver.switchTo().parentFrame();
		 * //driver.switchTo().defaultContent();
		 * driver.switchTo().frame("login"); Actions actionV = new
		 * Actions(driver); WebElement mainMenuV =
		 * driver.findElement(By.xpath(".//*[@id='menu_icon_0']/span"));
		 * actionV.moveToElement(mainMenuV).build().perform();
		 * //Thread.sleep(5000L); driver.findElement(By.xpath(
		 * ".//*[@id='menu_icon_0-menu']/div[3]/div[2]/ul/li[1]/a")).click();
		 * //.moveToElement(driver.findElement(By.xpath(
		 * ".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().
		 * build().perform(); Thread.sleep(15000);
		 * driver.switchTo().defaultContent(); driver.switchTo().frame("login");
		 * //driver.switchTo().frame(driver.findElement(By.name(
		 * "Direct DepositDialog"))); driver.switchTo().frame(
		 * "Request Time OffDialog"); String TimeoffTitleV =
		 * driver.findElement(By.xpath(
		 * "html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText(
		 * ); s_assert.assertEquals(TimeoffTitleV, "Employee Time");
		 * System.out.println("User is on the Request Time off Page");
		 * 
		 * 
		 * DateFormat dateFormat3 = new SimpleDateFormat("dd"); Date date3 = new
		 * Date();
		 * 
		 * String today1 = dateFormat3.format(date3);
		 * 
		 * //find the calendar WebElement dateWidget1 =
		 * driver.findElement(By.xpath(
		 * ".//*[@id='C_TimeCal_main_1']/table/tbody")); List<WebElement>
		 * columns1=dateWidget1.findElements(By.tagName("td"));
		 * 
		 * //comparing the text of cell with today's date and clicking it. for
		 * (WebElement cell : columns1) { if (cell.getText().equals(today1)) {
		 * cell.click();
		 * 
		 * break; } } Thread.sleep(50000); String EmpLeaveStatusF =
		 * driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]"
		 * )).getText(); s_assert.assertEquals(EmpLeaveStatusF, "Approved");
		 * 
		 * System.out.println("Validation Complete");
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.switchTo().frame("login");
		 * driver.findElement(By.xpath(".//*[@id='logout']")).click();
		 */

		s_assert.assertAll();

	}

	// Company Calendar
	
	@Test(enabled = true, priority = 6, groups = {"Smoke" , "Nightly" })
	public void verifyUserCanSeeCompanyCalendar() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_Calendar_main_1']")).click();
		// Thread.sleep(10000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		String CalendarTitlePage = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CalendarTitlePage, "Calendar");

		Select DropCalType = new Select(driver.findElement(By.xpath(".//*[@id='C_Calendar_main_1']/select")));
		DropCalType.selectByValue("company");

		// String CalendarCompV =
		// driver.findElement(By.xpath(".//*[@id='C_Calendar_main_1']/select")).getAttribute("Value");
		// s_assert.assertEquals(CalendarCompV, "company");

		driver.switchTo().defaultContent();
		logOut();

		s_assert.assertAll();

	}

	// Personal Benefit Change

	@Test(enabled = true, priority = 7, groups = {"Smoke"})
	public void verifyUserAbleToChangeAddress() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[2]/div[2]/ul/li[1]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Address ChangeDialog");
		String PersAddressChangeTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[3]/tbody/tr/td[1]/div")).getText();
		s_assert.assertEquals(PersAddressChangeTitle, "Address Change:");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='L_ZipPostal_main_1']")).sendKeys("Update
		// Address");

		Select DropAddressType = new Select(driver.findElement(By.xpath(".//*[@id='C_AdrTyp_main_1']/select")));
		DropAddressType.selectByValue("Forwarding");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.findElement(By.xpath(".//*[@id='N_Done_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		driver.switchTo().defaultContent();
		logOut();
		Thread.sleep(5000);
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();*/
		logOut();
		Thread.sleep(10000);

		logIn("nvsuperuser1", "nuview");

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		driver.switchTo().frame("login");
		Actions action1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action1.moveToElement(mainMenu1).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[2]/div[2]/ul/li[1]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Address ChangeDialog");

		String PersAddressChangeTitleF = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[3]/tbody/tr/td[1]/div")).getText();
		s_assert.assertEquals(PersAddressChangeTitleF, "Address Change:");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);

		String AddressChangeVerification = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		s_assert.assertEquals(AddressChangeVerification, "Forwarding");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='L_ZipPostal_main_1']")).sendKeys("Update
		// Address");

		Select DropAddressTypeOld = new Select(driver.findElement(By.xpath(".//*[@id='C_AdrTyp_main_1']/select")));
		DropAddressTypeOld.selectByValue("Home");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);

		String PopupVer1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer1,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.findElement(By.xpath(".//*[@id='N_Done_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent();
		logOut();
		Thread.sleep(5000);
		logIn("fulldemo", "nuview");
		Thread.sleep(10000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation1,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// driver.switchTo().frame("login");
		// driver.switchTo().frame("nav");
		// .findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();
		// Thread.sleep(5000);
		logOut();
		s_assert.assertAll();
	}

	@Test(enabled = true, priority = 8, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToChangeMaritalStatus() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000); 

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[2]/div[2]/ul/li[2]/a")).click();

		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Marital Status ChangeDialog");
		String PersMaritalStatusChangeTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[3]/tbody/tr/td[1]/div")).getText();
		s_assert.assertEquals(PersMaritalStatusChangeTitle, "Marital Status Change:");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='TabTitle__Demographics']")).click();
		// driver.findElement(By.xpath(".//*[@id='L_ZipPostal_main_1']")).sendKeys("Update
		// Address");

		Select DropMaritalStatusType = new Select(
				driver.findElement(By.xpath(".//*[@id='C_MaritalStatus_main_1']/select")));
		DropMaritalStatusType.selectByValue("O");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='N_Done_main_1']")).click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		Actions action1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action1.moveToElement(mainMenu1).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[2]/div[2]/ul/li[2]/a")).click();

		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Marital Status ChangeDialog");
		String PersMaritalStatusChangeTitleF = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[3]/tbody/tr/td[1]/div")).getText();
		s_assert.assertEquals(PersMaritalStatusChangeTitleF, "Marital Status Change:");

		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='TabTitle__Demographics']")).click();
		// driver.findElement(By.xpath(".//*[@id='L_ZipPostal_main_1']")).sendKeys("Update
		// Address");

		Select DropMaritalStatusTypeR = new Select(
				driver.findElement(By.xpath(".//*[@id='C_MaritalStatus_main_1']/select")));
		DropMaritalStatusTypeR.selectByValue("M");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='N_Done_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		
		driver.findElement(By.xpath(".//*[@id='backToHR']")).click();
		//driver.findElement(By.xpath(".//*[@id='logout']")).click();
		//driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		logOut();
		//driver.findElement(By.xpath(".//*[@id='logout']/img")).click();

		s_assert.assertAll();
	}

	@Test(enabled = true, priority = 9, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToAddandDeleteDependent() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='N_ESSUI_none_1']")).click();
		Thread.sleep(10000);

		// driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[2]/div[2]/ul/li[3]/a")).click();

		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("New Dependent(s)Dialog");
		String PersDependentChangeTitle = driver
				.findElement(By.xpath("html/body/form/table[1]/tbody/tr[1]/td/table[3]/tbody/tr/td[1]/div")).getText();
		s_assert.assertEquals(PersDependentChangeTitle, "New Dependents / Family:");
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_DepFirstName_main_1']/input[2]")).sendKeys("Test");
		// Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_DepLastName_main_1']/input[2]")).sendKeys("Adams");
		Select DropRelationStatusType = new Select(
				driver.findElement(By.xpath(".//*[@id='C_DepRelation_main_1']/select")));
		DropRelationStatusType.selectByValue("Child");
		// Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Dependent_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='TabTitle__Benefit Info']")).click();

		driver.findElement(By.xpath(".//*[@id='C_DepSSNSIN_main_1']/input[2]")).sendKeys("123456789");
		driver.findElement(By.xpath(".//*[@id='C_DepBirthDt_main_1']/input[2]")).sendKeys(s);
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Thread.sleep(5000);

		String PersDependentAddedConfirmation = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_3']")).getText();
		s_assert.assertEquals(PersDependentAddedConfirmation, "Test Adams");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_3']")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_Next_Img']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='N_Done_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='logout']/img")).click();

		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 10, groups = {"Smoke"} , description = "Verify Manager is able to Request for sub-ordinate time off/Verify Supervisor is able to approve request time off/Verify status of request time off at managers   ")
	public void VerifyManagerAble2RequestSubordinateTimeoffSupervisorAble2ApproveReqAndVerifyTimeoffStatus () throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EFNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTimOff_main_1']")).click();
		
		Switch2Right();
		
		webtableElementClick("//table[@class='datasheet']//td", "Adams, Felicia", "link");
		
		Switch2Middle();
		DateFormat dateFormat2 = new SimpleDateFormat("dd");
		Date date2 = new Date();

		String today = dateFormat2.format(date2);

		// find the calendar
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='C_TimeCal_main_1']/table/tbody"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
		if (cell.getText().equals(today)) {
		cell.click();
		break;
		}
		}
		Thread.sleep(50000);
		System.out.println("Todays Date Selected, Please Proceed");
		Select DropActivity = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_main_0']/select")));
		DropActivity.selectByValue("JuryDuty");
		driver.findElement(By.xpath(".//*[@id='C_Hours_main_0']/input[2]")).sendKeys("8");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_main_main_0']")).click();
		// String EmpLeaveStatusP =
		// driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]")).getText();
		// s_assert.assertEquals(EmpLeaveStatusP, "Pending");
		driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();
		s_assert.assertEquals(PopupVer, "Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		//driver.switchTo().defaultContent();
        Switch2Left();
		driver.switchTo().defaultContent();
		logOut();
		
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmationS = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText().trim();
		s_assert.assertEquals(PopupApprovalConfirmationS,
				"This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		driver.switchTo().defaultContent();

		logOut();
		
		logIn("nvsuperuser1", "nuview");
		Thread.sleep(5000);
		// String s = new CommonFunctions().GetCurrentDate();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EFNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTimOff_main_1']")).click();
		
		Switch2Right();
		
		webtableElementClick("//table[@class='datasheet']//td", "Adams, Felicia", "link");
		
		
		Switch2Middle();
		
		// find the calendar
		WebElement dateWidget1 = driver.findElement(By.xpath(".//*[@id='C_TimeCal_main_1']/table/tbody"));
		List<WebElement> columns1 = dateWidget1.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns1) {
		if (cell.getText().equals("Approved")) {
		cell.click();
		break;
		}
		}
		
		String Activity = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_main_0']/select"))).getFirstSelectedOption().getAttribute("value");
		s_assert.assertEquals( Activity, "JuryDuty");
		
		String Status = driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]"))
				.getAttribute("value");
		s_assert.assertEquals(Status,
				"Approved");
		
		Click(".//*[@id='C_DatasheetRemove_main_main_0']");
		driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();
		
		String PopupVerN = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();
		s_assert.assertEquals(PopupVerN, "Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		//driver.switchTo().defaultContent();
        Switch2Left();
		driver.switchTo().defaultContent();
		logOut();
		
		logIn("fulldemo", "nuview");
		// driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmationN = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText().trim();
		s_assert.assertEquals(PopupApprovalConfirmationN,
				"This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		driver.switchTo().defaultContent();

		logOut();

		s_assert.assertAll();

	}


}
