package com.HRM.testcases.MSS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class MSS_SmokeTest extends CommonFunctions {

	SoftAssert s_assert = new SoftAssert();

	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException {
		initData();
   
	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() {
		closeBrowser();
	}
	

	/*	C786818	Verify sub-ordinate are displaying in search Result			
	    C786819	Verify the sub-ordinate profile */

	/*@Test(enabled = false, priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifySupervisorAndSubordinateIsdisplayedInSearchResult() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EFNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSPrsPrf_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

		String PersonalinfPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersonalinfPage, "Managed Employees");
		
		String SupervisonNos = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");
		s_assert.assertEquals(SupervisonNos, "999503");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String EmpManagedName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpManagedName, "Adams, Felicia");
		
		String EmpManagedNos = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpManagedNos, "100");

		String EmpManagedName1 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_2']")).getText();
		s_assert.assertEquals(EmpManagedName1, "Whelton, Renee");
		
		String EmpManagedNos1 = driver.findElement(By.xpath(".//*[@id='C_Emp_main_2']")).getText();
		s_assert.assertEquals(EmpManagedNos1, "541");
		
		String EmpManagedName2 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).getText();
		s_assert.assertEquals(EmpManagedName2, "White, Donna");
		
		String EmpManagedNos2 = driver.findElement(By.xpath(".//*[@id='C_Emp_main_3']")).getText();
		s_assert.assertEquals(EmpManagedNos2, "798");


		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}*/
	
	@Test(enabled = false, priority = 2, groups = {"Smoke"})
	public void verifyManagerAble2RequestSubordinateTimeoffAndSupervisorAble2Approve() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EFNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTimOff_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

	String PersonalinfPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersonalinfPage, "Managed Employees");
		
		String SupervisonNos = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");
		s_assert.assertEquals(SupervisonNos, "999503");
		
		driver.switchTo().defaultContent();*/
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String EmpManagedName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpManagedName, "Adams, Felicia");
		
		String EmpManagedNos = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpManagedNos, "100");

		String EmpManagedName1 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpManagedName1, "Whelton, Renee");
		
		String EmpManagedNos1 = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpManagedNos1, "541");
		
		String EmpManagedName2 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_2']")).getText();
		s_assert.assertEquals(EmpManagedName2, "White, Donna");
		
		String EmpManagedNos2 = driver.findElement(By.xpath(".//*[@id='C_Emp_main_2']")).getText();
		s_assert.assertEquals(EmpManagedNos2, "798");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();


		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		Thread.sleep(15000);
		
		
List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='calendar']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("5"))
			{
				ele.click();
				break;
			}
			
		}
		
/*
		DateFormat dateFormat2 = new SimpleDateFormat("dd");
		Date date2 = new Date();

		String today = dateFormat2.format(date2);
		System.out.println(today);

		// find the calendar
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='C_TimeCal_main_1']/table/tbody"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		// comparing the text of cell with today's date and clicking it.
		for (WebElement cell : columns) {
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}*/
		
		
		Thread.sleep(10000);
		System.out.println("Todays Date Selected, Please Proceed");
		
		Select DropActivity = new Select(driver.findElement(By.xpath(".//*[@id='C_TimAct_main_0']/select")));
		DropActivity.selectByValue("JuryDuty");
		driver.findElement(By.xpath(".//*[@id='C_Hours_main_0']/input[2]")).sendKeys("8");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_main_main_0']")).click();
		// String EmpLeaveStatusP =
		// driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]")).getText();
		// s_assert.assertEquals(EmpLeaveStatusP, "Pending");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PopupVer = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer, "   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		//Thread.sleep(15000);

	    String TimeOffPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TimeOffPage, "Employee Time");
		
		String Status = driver.findElement(By.xpath(".//*[@id='C_SysStatus_main_0']/input[2]")).getAttribute("value");
		s_assert.assertEquals(Status, "Pending");
		
	

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	
	
	
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyEmpAbsenceHistory() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EFNAANA' or @display='Employee Personal Info' and @tip='MSSEmpFind']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTimOff_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

	String PersonalinfPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersonalinfPage, "Managed Employees");
		
		String SupervisonNos = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");
		s_assert.assertEquals(SupervisonNos, "999503");
		
		driver.switchTo().defaultContent();*/
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String EmpManagedName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpManagedName, "Adams, Felicia");
		
		String EmpManagedNos = driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).getText();
		s_assert.assertEquals(EmpManagedNos, "100");

		
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();


		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		Thread.sleep(15000);
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Absence History']")).click();
		
		webtableElementGetText("//table[@class='datasheet']//td", "05/08/2010");
		webtableElementGetText("//table[@class='datasheet']//td", "Vacation");

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyEmpAble2OpenAuthorizationTrace() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EINAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EINAANA' or @display='Authorizations' and @tip='MSSAth']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTrace_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

	String PersonalinfPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersonalinfPage, "Managed Employees");
		
		String SupervisonNos = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");
		s_assert.assertEquals(SupervisonNos, "999503");
		
		driver.switchTo().defaultContent();*/
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("list");
		
		String PageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PageTitle, "Authorization Trace");
		
		Find();
		
		String PageTitleN = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PageTitleN, "Authorization Trace");
		
		/*String ToDoName = driver.findElement(By.xpath(".//*[@id='GroupHeader--2_main_1_Label-To Do Name']")).getText();
		s_assert.assertEquals(ToDoName, "To Do Name:");*/

		

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	
	@Test(enabled = true, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifySupervisorAndSubordinateIsdisplayedInSearchResult() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EINAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EINAANA' or @display='Authorizations' and @tip='MSSAth']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSTrace_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		/*driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		

	String PersonalinfPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersonalinfPage, "Managed Employees");
		
		String SupervisonNos = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");
		s_assert.assertEquals(SupervisonNos, "999503");
		
		driver.switchTo().defaultContent();*/
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("list");
		
		String PageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PageTitle, "Authorization Trace");
		
		Find();
		
		String PageTitleN = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PageTitleN, "Authorization Trace");
		
		/*String ToDoName = driver.findElement(By.xpath(".//*[@id='GroupHeader--2_main_1_Label-To Do Name']")).getText();
		s_assert.assertEquals(ToDoName, "To Do Name:");*/

		

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}
	
	
	
	
}
