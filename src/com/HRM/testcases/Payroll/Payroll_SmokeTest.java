
package com.HRM.testcases.Payroll;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.Level;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Payroll_SmokeTest extends CommonFunctions {
	
	

	SoftAssert s_assert = new SoftAssert();
	

	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException {
		initData();

	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() {
		closeBrowser();
	}



	//@Test(enabled = false, priority = 1)
	
	@Test(priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2CreatePayrollPrefix() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Switch2LeftLogin();
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		//getObject(".//*[@id='TabTitle_Menu_Payroll']").click();
		//clickWebelement(WebElement ".//*[@id='TabTitle_Menu_Payroll']"");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Payroll']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Prefix_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PayPfx_main_1']")).click();

		/*driver.switchTo().defaultContent();

		Thread.sleep(5000);

		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");*/
		
		Switch2MidException();
		//driver.switchTo().frame("edit");

		String PrefixPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PrefixPage, "Payroll Prefix");
		//String today = new CommonFunctions().GetCurrentDate();
		
		Add();
	//	driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_PayPfx_main_1']/input[2]")).sendKeys("Test");
		
		Select dropdownInterface = new Select(driver.findElement(By.xpath(".//*[@id='C_Type_main_1']/select")));
		dropdownInterface.selectByValue("Payroll");
		
		Save();
		
		//driver.findElement(By.xpath(".//*[@id='C_Save']")).click();
		
		
		
		Thread.sleep(5000);
		
		Find();
		
		//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		
/*List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='datasheet']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String PrefixName=ele.getText();
					//getAttribute("display");
				//	getText();
			System.out.println("Name:"+ PrefixName);
			
			if(PrefixName.equalsIgnoreCase("Test"))
			{

				ele.findElement(By.className("link")).click();
				
			//	ele.getAttribute("link")
				//String s= ele.getAttribute("id");
				//System.out.println(s);
				//ele.click();
				break;
			}
			
		}*/
		
		webtableElementClick("//table[@class='datasheet']//td", "Test", "link");
		
	//	driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_43']")).click();
		
		Thread.sleep(25000);
		
          Delete();
	/*	driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	//@Test(enabled = false, priority = 2)
	@Test(priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserAble2CreatePayrollGroup() throws InterruptedException {
		
		
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Switch2LeftLogin();
        
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		log.info("Test");
		//getObject(".//*[@id='TabTitle_Menu_Payroll']").click();
		//clickWebelement(WebElement ".//*[@id='TabTitle_Menu_Payroll']"");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Payroll']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PayGrp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MainPayGrp_main_1']")).click();

		// driver.switchTo().parentFrame();
	/*	driver.switchTo().defaultContent();

		Thread.sleep(5000);

		
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Switch2Middle();

		

		String GroupPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(GroupPage, "Payroll Groups");
		//String today = new CommonFunctions().GetCurrentDate();
		
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Add();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_PayGrp_main_1']/input[2]")).sendKeys("Test1");
		
		driver.findElement(By.xpath(".//*[@id='C_PayGrpName_main_1']/input[2]")).sendKeys("Test1");
		
		Select dropdownInterface = new Select(driver.findElement(By.xpath(".//*[@id='C_PayrollPrefix_main_1']/select")));
		dropdownInterface.selectByValue("ADPUK");
		
		
		Save();
		//driver.findElement(By.xpath(".//*[@id='C_Save']")).click();
		
		
		
		Switch2Right();
		
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		
		
		//driver.findElement(By.xpath(".//*[@id='C_Find']")).click();
		
		Find();
		
		
/*List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='datasheet']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String PrefixName=ele.getText();
					//getAttribute("display");
				//	getText();
			System.out.println("Name:"+ PrefixName);
			
			if(PrefixName.equalsIgnoreCase("Test1"))
			{
				
				ele.findElement(By.className("link")).click();
				
			//	ele.getAttribute("link")
				//String s= ele.getAttribute("id");
				//System.out.println(s);
				//ele.click();
				break;
			}
			
		}*/
		
		webtableElementClick("//table[@class='datasheet']//td", "Test1", "link");
		
	//	driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_43']")).click();
		
		Thread.sleep(25000);
		
		Switch2Middle();
		
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		
		Delete();

		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	/*//@Test(enabled = true, priority = 3)
	@Test(enabled = false, priority = 3,groups = { "Smoke", "Nightly" })
	public void test() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
	
	   log.debug("Test");
	
		
		//getObject(".//*[@id='TabTitle_Menu_Payroll']").click();
		//clickWebelement(WebElement ".//*[@id='TabTitle_Menu_Payroll']"");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Payroll']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Prefix_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PayPfx_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");

		

		String PrefixPage = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PrefixPage, "Payroll Prefix");
		//String today = new CommonFunctions().GetCurrentDate();
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		Thread.sleep(5000);
		
		
		
		
		
List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='datasheet']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String PrefixName=ele.getText();
					//getAttribute("display");
				//	getText();
			System.out.println("Name:"+ PrefixName);
			
			if(PrefixName.equalsIgnoreCase("ADPUK"))
			{
				
				ele.findElement(By.className("link")).click();
				
			//	ele.getAttribute("link")
				//String s= ele.getAttribute("id");
				//System.out.println(s);
				//ele.click();
				break;
			}
			
		}
		
	//	webtableclassT(driver, "//table[@class='datasheet']//td", "ADPUK", "link");
		
		webtableElementClick("//table[@class='datasheet']//td", "ADPUK", "link");
		
		//webtableclass1(driver, "//table[@class='datasheet']//td", "ADPUK", "link");
		Thread.sleep(15000);
		
	//	driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_43']")).click();
		
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}*/
}
