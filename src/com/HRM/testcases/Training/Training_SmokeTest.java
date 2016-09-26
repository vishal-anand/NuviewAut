package com.HRM.testcases.Training;

import java.io.IOException;
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

public class Training_SmokeTest extends CommonFunctions {

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
	public void verifyUserAbleCreateCourses() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		// driver.switchTo().parentFrame();
		Switch2Middle();

		String CoursesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CoursesMainPageTitle, "Courses");

		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Add();

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']/input[2]")).sendKeys("MTTest");

		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		Find();
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		Switch2Right();

		String CourseName = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(CourseName, "MTTest");

		System.out.println("Verified Course Creation");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();
		
		Delete();

		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleCreateClasses() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		String CurrentPlus10 = new CommonFunctions().GetCurrentDateAdd10();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2LeftLogin();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		// driver.switchTo().parentFrame();
		/*driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
*/
		Switch2Middle();
		String CoursesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CoursesMainPageTitle, "Courses");

		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Add();

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']/input[2]")).sendKeys("MTTest");

		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		Find();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		
		Switch2Right();

		Thread.sleep(10000);
		String CourseName = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(CourseName, "MTTest");

		System.out.println("Verified Course Creation");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='C_CrsCls_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		String ClassesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ClassesMainPageTitle, "Class");

		// driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Cls_main_1']/input[2]")).sendKeys("1");
		Select DropClassStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_ClsSts_main_1']/select")));
		DropClassStatus.selectByValue("Open");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Schedule']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FromDate_main_1']/input[2]")).sendKeys(Current);
		driver.findElement(By.xpath(".//*[@id='C_ToDate_main_1']/input[2]")).sendKeys(CurrentPlus10);
		driver.findElement(By.xpath(".//*[@id='C_FromTime_main_1']/input[2]")).sendKeys("10:00:00 am");
		driver.findElement(By.xpath(".//*[@id='C_ToTime_main_1']/input[2]")).sendKeys("11:00:00 am");
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		try {
			webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
			// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			// log.debug("Exception in finding date");
			// log.debug(e);
			// webtableclass1(driver,
			// ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
			// System.out.println("Error");
			// WebElement date =
			// driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
			// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}

		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		
		Delete();

	/*	driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();
	/*	driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
*/
		Delete();
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2Enroll2ClassAndPresentInClassCalendar() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		// String CurrentPlus10 = new CommonFunctions().GetCurrentDateAdd10();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2LeftLogin();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		// driver.switchTo().parentFrame();
		/*driver.switchTo().defaultContent();

		Thread.sleep(5000);
		

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		String CoursesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CoursesMainPageTitle, "Courses");

		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Add();

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']/input[2]")).sendKeys("MTTest");

		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		Find();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		
		Switch2Right();

		Thread.sleep(10000);
		String CourseName = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(CourseName, "MTTest");

		System.out.println("Verified Course Creation");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

/*		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='C_CrsCls_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		String ClassesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ClassesMainPageTitle, "Class");

		// driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Cls_main_1']/input[2]")).sendKeys("1");
		Select DropClassStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_ClsSts_main_1']/select")));
		DropClassStatus.selectByValue("Open");

		/*
		 * driver.findElement(By.xpath(".//*[@id='TabTitle__Schedule']")).click(
		 * );
		 * driver.findElement(By.xpath(".//*[@id='C_FromDate_main_1']/input[2]")
		 * ).sendKeys(Current);
		 * driver.findElement(By.xpath(".//*[@id='C_ToDate_main_1']/input[2]")).
		 * sendKeys(CurrentPlus10);
		 * driver.findElement(By.xpath(".//*[@id='C_FromTime_main_1']/input[2]")
		 * ).sendKeys("10:00:00 am");
		 * driver.findElement(By.xpath(".//*[@id='C_ToTime_main_1']/input[2]")).
		 * sendKeys("11:00:00 am");
		 */
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Save();

		/*
		 * try{ webtableclass1(driver,
		 * ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
		 * //driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click(); }
		 * catch(org.openqa.selenium.StaleElementReferenceException ex) { //
		 * log.debug("Exception in finding date"); // log.debug(e); //
		 * webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table",
		 * "1", "link"); // System.out.println("Error"); //WebElement date =
		 * driver.findElement(By.xpath(
		 * "/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font")); //
		 * driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click(); }
		 */

		webtableElementClick("//table[@class='datasheet']//td", "1", "link");

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='C_CrsEnrCls_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.switchTo().frame("Cls");
		driver.findElement(By.xpath(".//*[@id='C_ClsLnk_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.switchTo().frame("Fnd");
		driver.findElement(By.xpath(".//*[@id='C_SysLastName_none_1']/input[2]")).sendKeys("Adams");
		driver.findElement(By.xpath(".//*[@id='C_Find_none_1']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_EnrDt_none_1']/input[2]")).sendKeys(Current);

		driver.findElement(By.xpath(".//*[@id='C_EmpSel_EmpSelect_2']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Enr_none_1']")).click();

		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.switchTo().frame("Dsp");

		String EmpName = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		s_assert.assertEquals(EmpName, "999503 {Adams, Sam}");
		// Fix Below
		String EnrollStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_EnrSts_main_1']/select"))).getFirstSelectedOption().getAttribute("value");
		s_assert.assertEquals( EnrollStatus, "Enrolled");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_ClsCal_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		driver.findElement(By.xpath(".//*[@id='C_EmpTrngHist_none_1']")).click();

		switchToNewWindow();

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Adams");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Sam");

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		String EmpNameE = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpNameE, "Adams, Sam");

		String EnrollStatusF = driver.findElement(By.xpath(".//*[@id='C_Lbl4_main_1']")).getText();
		s_assert.assertEquals(EnrollStatusF, "Enrolled Not Waitlisted");

		switchToOldWindow();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();

		driver.findElement(By.xpath(".//*[@id='C_CrsEnrCls_main_1']")).click();

		Thread.sleep(10000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.switchTo().frame("Dsp");

		driver.findElement(By.xpath(".//*[@id='C_Del_main_1']")).click();

	/*	driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2Left();

		driver.findElement(By.xpath(".//*[@id='C_CrsCls_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		Switch2Middle();

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();

		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/

		Delete();
		
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();
		
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();*/
		
		Delete();

		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
//Blocked _Dont Enable this 
	@Test(enabled = false, priority = 5)
	public void verifyESSUserEnroll2Class() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("welcome", "nuview");
		Thread.sleep(5000);
	//	String s = new CommonFunctions().GetCurrentDate();
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
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[4]/div[2]/ul/li[4]/a")).click();
		// .moveToElement(driver.findElement(By.xpath(".//*[@id='menu_icon_0-menu']/div[2]/div[2]/ul/li[6]/a"))).click().build().perform();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		driver.switchTo().frame("Class EnrollmentDialog");
		String ClassEnrollTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ClassEnrollTitle, "Employee Classes");

		driver.findElement(By.xpath(".//*[@id='N_Crs_main_1_Img']")).click();
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		String CoursesTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(CoursesTitle, "Courses");
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("VTTEST");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		String CourseName = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(CourseName, "VTTEST");
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();
		System.out.println("Verified Course is Present");
		driver.close();

		Thread.sleep(5000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);

		driver.findElement(By.xpath(".//*[@id='N_Cls_main_1_Img']")).click();
		Set<String> AllWindowHandles1 = driver.getWindowHandles();
		String window1_1 = (String) AllWindowHandles1.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles1.toArray()[0]);
		String window2_2 = (String) AllWindowHandles1.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles1.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2_2);
		String ClassTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(ClassTitle, "Class");
		// driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("VTTEST");
		// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		String ClassName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		s_assert.assertEquals(ClassName, "1");
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();
		System.out.println("Verified Class is Present");
		driver.close();

		Thread.sleep(5000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1_1);

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		// *******************************************************************
		// Till Here Completed********************

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer,
				"   Your request will be sent to Jerry Berman, Sam Adams and Keith Washington for approval.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent();
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
		String PopupApprovalConfirmation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();
		// logOut();
		Thread.sleep(10000);

		logIn("nvsuperuser1", "nuview");

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
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		driver.switchTo().defaultContent();
		logIn("fulldemo", "nuview");
		Thread.sleep(10000);
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

	@Test(enabled = true, priority = 6,groups = {"Smoke" , "Nightly" })
	public void verifyMSSUserAble2Enroll2Class() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		// String CurrentPlus10 = new CommonFunctions().GetCurrentDateAdd10();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2LeftLogin();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		// driver.switchTo().parentFrame();
		/*driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		String CoursesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CoursesMainPageTitle, "Courses");

		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Add();

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']/input[2]")).sendKeys("MTTest");

		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		Find();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		
		Switch2Right();

		Thread.sleep(10000);
		String CourseName = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(CourseName, "MTTest");

		System.out.println("Verified Course Creation");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='C_CrsCls_main_1']")).click();

		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		String ClassesMainPageTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ClassesMainPageTitle, "Class");

		

		driver.findElement(By.xpath(".//*[@id='C_Cls_main_1']/input[2]")).sendKeys("1");
		Select DropClassStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_ClsSts_main_1']/select")));
		DropClassStatus.selectByValue("Open");
		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		/*
		 * driver.findElement(By.xpath(".//*[@id='TabTitle__Schedule']")).click(
		 * );
		 * driver.findElement(By.xpath(".//*[@id='C_FromDate_main_1']/input[2]")
		 * ).sendKeys(Current);
		 * driver.findElement(By.xpath(".//*[@id='C_ToDate_main_1']/input[2]")).
		 * sendKeys(CurrentPlus10);
		 * driver.findElement(By.xpath(".//*[@id='C_FromTime_main_1']/input[2]")
		 * ).sendKeys("10:00:00 am");
		 * driver.findElement(By.xpath(".//*[@id='C_ToTime_main_1']/input[2]")).
		 * sendKeys("11:00:00 am");
		 */

		/*
		 * try{ webtableclass1(driver,
		 * ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
		 * //driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click(); }
		 * catch(org.openqa.selenium.StaleElementReferenceException ex) { //
		 * log.debug("Exception in finding date"); // log.debug(e); //
		 * webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table",
		 * "1", "link"); // System.out.println("Error"); //WebElement date =
		 * driver.findElement(By.xpath(
		 * "/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font")); //
		 * driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click(); }
		 */

		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EANAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSEmpCls_main_1']")).click();

		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		
		Switch2Right();

		webtableElementClick("//table[@class='datasheet']//td", "Whelton, Renee", "link");

		Thread.sleep(5000);

	/*	driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		driver.findElement(By.xpath(".//*[@id='N_Crs_main_1_Img']")).click();

		/*
		 * String Parent_Window = driver.getWindowHandle(); // Switching from
		 * parent window to child window for (String Child_Window :
		 * driver.getWindowHandles()) { driver.switchTo().window(Child_Window);
		 */

		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);
		driver.switchTo().window(window2);

		String TB1 = driver.getTitle();
		System.out.println(TB1);

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		driver.switchTo().window(window1);

		// driver.close();

		// driver.switchTo().window(Parent_Window);

		// driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='N_Cls_main_1_Img']")).click();

		Set<String> AllWindowHandlesCl = driver.getWindowHandles();
		String windowCl1 = (String) AllWindowHandlesCl.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandlesCl.toArray()[0]);
		String windowcl2 = (String) AllWindowHandlesCl.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandlesCl.toArray()[1]);
		driver.switchTo().window(windowcl2);

		// String TB1 = driver.getTitle();
		// System.out.println(TB1);

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();

		driver.switchTo().window(windowCl1);

		driver.switchTo().parentFrame();

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_EmpClsEffDt_main_1']/input[2]")).sendKeys(Current);

		//driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Save();

		Thread.sleep(5000);

		webtableElementClick("//table[@class='datasheet']//td", "MTTest", "link");
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		Delete();
		
		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		Switch2Left();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Training']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();
		
		
		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();
		
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("MTTest");
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Find();

		
		Switch2Right();
		
		webtableElementClick("//table[@class='datasheet']//td", "MTTest", "link");
		

		
		Switch2Middle();
	
		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='C_CrsCls_main_1']")).click();

		
		Switch2Middle();
		
		
		webtableElementClick("//table[@class='datasheet']//td", "1", "link");
		Delete();

		Switch2Left();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		
		Switch2Middle();
		webtableElementClick("//table[@class='datasheet']//td", "MTTest", "link");
		Delete();
		

		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

		
	}
	
	
}
