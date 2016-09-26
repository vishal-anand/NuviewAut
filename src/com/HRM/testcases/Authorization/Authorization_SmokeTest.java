package com.HRM.testcases.Authorization;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Authorization_SmokeTest extends CommonFunctions {

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
	public void verifyUserCreate3LevelAuthorization() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='C_AthFind_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String AuthorizationPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(AuthorizationPageTitle, "Authorization Rules");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_WrkFlwName_main_1']/input[2]")).sendKeys("ESS to Test to HRAdmin");
		Select DropAdministrator = new Select(
				driver.findElement(By.xpath(".//*[@id='C_AthAdmin_main_1']/select")));
		DropAdministrator.selectByValue("HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String Workflow = driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).getText();
		s_assert.assertEquals(Workflow, "ESS-TEST-HRAdmin");

		System.out.println("Verified 3 Level Authorization");
		
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserCreate3LevelHierarchy() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='C_AthFind_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String AuthorizationPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(AuthorizationPageTitle, "Authorization Rules");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_WrkFlwName_main_1']/input[2]")).sendKeys("ESS to Test to HRAdmin");
		Select DropAdministrator = new Select(
				driver.findElement(By.xpath(".//*[@id='C_AthAdmin_main_1']/select")));
		DropAdministrator.selectByValue("HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String Workflow = driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).getText();
		s_assert.assertEquals(Workflow, "ESS-TEST-HRAdmin");

		System.out.println("Created 3 Level Authorization");
		
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_AthHirarchy_main_1']")).click();
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		String AuthorizationHierarchyTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(AuthorizationHierarchyTitle, "Authorization Hierarchy");
		
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']/input[2]")).sendKeys("1");
		Select DropRole1 = new Select(
				driver.findElement(By.xpath(".//*[@id='C_Rol_main_1']/select")));
		DropRole1.selectByValue("ESS");
		driver.findElement(By.xpath(".//*[@id='C_RutEmpHierarchy_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_CanChange_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_CanInitiate_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']/input[2]")).sendKeys("2");
		Select DropRole2 = new Select(
				driver.findElement(By.xpath(".//*[@id='C_Rol_main_1']/select")));
		DropRole2.selectByValue("Supervisor");
		driver.findElement(By.xpath(".//*[@id='C_RutEmpHierarchy_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_CanChange_main_1']/input[2]")).click();
		//driver.findElement(By.xpath(".//*[@id='C_CanInitiate_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']/input[2]")).sendKeys("3");
		Select DropRole3 = new Select(
				driver.findElement(By.xpath(".//*[@id='C_Rol_main_1']/select")));
		DropRole3.selectByValue("HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_RutEmpHierarchy_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_CanChange_main_1']/input[2]")).click();
		//driver.findElement(By.xpath(".//*[@id='C_CanInitiate_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		//Assert  Hierarchy
		
		String AuthorizationHierarchy1 = driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']")).getText();
		s_assert.assertEquals(AuthorizationHierarchy1, "1");
		String AuthorizationHierarchy2 = driver.findElement(By.xpath(".//*[@id='C_Ord_main_2']")).getText();
		s_assert.assertEquals(AuthorizationHierarchy2, "2");
		String AuthorizationHierarchy3 = driver.findElement(By.xpath(".//*[@id='C_Ord_main_3']")).getText();
		s_assert.assertEquals(AuthorizationHierarchy3, "3");
		
		System.out.println("3 Way Hierarchy Verified");
		
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_2']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK2 = driver.switchTo().alert();
		alertOK2.accept();
		driver.findElement(By.xpath(".//*[@id='C_Ord_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK3 = driver.switchTo().alert();
		alertOK3.accept();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_AthRul_main_1']")).click();
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	/*@Test(enabled = true, priority = 3)
	public void verifyUserCreate3LevelAuthorizationTest() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='C_AthFind_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String AuthorizationPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(AuthorizationPageTitle, "Authorization Rules");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_WrkFlwName_main_1']/input[2]")).sendKeys("ESS to Test to HRAdmin");
		Select DropAdministrator = new Select(
				driver.findElement(By.xpath(".//*[@id='C_AthAdmin_main_1']/select")));
		DropAdministrator.selectByValue("HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-SUP-HR");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String Workflow = driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).getText();
		s_assert.assertEquals(Workflow, "ESS-SUP-HR");

		System.out.println("Verified 3 Level Authorization");
		
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_AthHirarchy_main_1']")).click();
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		
		// Grab the table 
		WebElement table = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table"));

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		// And iterate over them, getting the cells 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    // Print the contents of each cell
		    for (WebElement cell : cells) { 
		        System.out.println(cell.getText());
		        if(cell.getText().equals("1"))
		        {
		        	table.findElement(By.className("link")).click();
		        		//	id("C_Ord_main_1")).click();
		        	
		        }
		        	
		        }
		    }
		
		
		try{
			webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
			driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		   // log.debug("Exception in finding date");
		  //  log.debug(e);
		    webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
		    //WebElement date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
		    driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		
		//webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
		
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		

		Thread.sleep(5000);
		
		
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	*/
	
	// Prerequisite Please make sure Authorization is already created with the name  ESS-SUP-HR
	
	@Test(enabled = true, priority = 3, groups = {"Smoke"})
	public void verifyUseruserable2AssignAuthorization2form  () throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='C_AthFind_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String AuthorizationPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(AuthorizationPageTitle, "Authorization Rules");

		/*driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-TEST-HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_WrkFlwName_main_1']/input[2]")).sendKeys("ESS to Test to HRAdmin");
		Select DropAdministrator = new Select(
				driver.findElement(By.xpath(".//*[@id='C_AthAdmin_main_1']/select")));
		DropAdministrator.selectByValue("HRAdmin");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();*/

		driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']/input[2]")).sendKeys("ESS-SUP-HR");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String Workflow = driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).getText();
		s_assert.assertEquals(Workflow, "ESS-SUP-HR");

		System.out.println("Verified 3 Level Authorization");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGBAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Forms_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FrmPrp_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String FormDesignPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(FormDesignPageTitle, "Form Design Wizard");
		
		driver.findElement(By.xpath(".//*[@id='C_FndForm_main_1']/input[2]")).sendKeys("Empadr");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String FormSearchResult = driver.findElement(By.xpath(".//*[@id='C_Obj_main_1']")).getText();
		s_assert.assertEquals(FormSearchResult, "EmpAdr");
		
		driver.findElement(By.xpath(".//*[@id='C_Obj_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		try{
			webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "Authorization WorkFlow", "link");
			//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		   // log.debug("Exception in finding date");
		  //  log.debug(e);
		    webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "Authorization WorkFlow", "link");
		    //WebElement date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
		   // driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		
		String ObjPropTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ObjPropTitle, "Object Properties");
		System.out.println("We are on Object Properties Page, Please enter the value");
		
		driver.findElement(By.xpath(".//*[@id='C_PrpVal_main_1']/textarea")).clear();
		driver.findElement(By.xpath(".//*[@id='C_PrpVal_main_1']/textarea")).sendKeys("ESS-SUP-HR");
		
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Rebuild_main_1']")).click();
		Thread.sleep(25000);
		
		
			
		//driver.findElement(By.xpath(".//*[@id='C_WrkFlw_main_1']")).click();

	/*	driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	
}
