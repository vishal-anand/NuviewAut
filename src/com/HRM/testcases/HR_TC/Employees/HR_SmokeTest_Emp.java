package com.HRM.testcases.HR_TC.Employees;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class HR_SmokeTest_Emp extends CommonFunctions {

	//WebDriver driver;
	SoftAssert s_assert = new SoftAssert();

	/*
	 * Browser Initialization Firefox, Chrome and IE 9 Browser Supported for
	 * Cross Browser Testing Scenario Browser Information is Picked form the
	 * TestNG.xml File
	 */

	/*@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browser) {

		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("IE")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						false);
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());

		}
	}*/

	@BeforeTest(alwaysRun = true)
	public void StartBrowser_NavURL() throws IOException {
		initData();  
	}

	@AfterTest(alwaysRun = true)
	public void ClosingBrowser() {  
		closeBrowser();  
	}

	/*
	 * Login to the ORange HRM Application Parameters Passed: username and
	 * password Function does Home/Admin Screen Validation
	 */

	/*@Parameters({ "username", "password" })
	@Test(enabled = true, priority = 1)
	public void Login(String username, String password) {
		driver.get(Locators.NuviewURL);
		driver.findElement(By.xpath(Locators.Username)).sendKeys(username);
		driver.findElement(By.xpath(Locators.Password)).sendKeys(password);
		driver.findElement(By.xpath(Locators.LoginBtn)).click();
		driver.switchTo().frame("dsp");
		String Title_HomePage = driver.findElement(By.xpath(Locators.HomePageTitle)).getText();

		s_assert.assertEquals(Title_HomePage, "Home Page");


		driver.switchTo().parentFrame();
		s_assert.assertAll();

	}*/
// The Below Automation Test Case for New Hires Takes care of 6 Testcases(3 -HR and 1-Benefit , 1-TimeSheet 1-Compensation

	@Test(enabled = false, priority = 1, groups = {"Smoke"})
	public void AddNewHireRehireTerminateDeleteEmpRec() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Amit");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
		

		Thread.sleep(5000);
		

		//Emergency Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Emergency']")).click();

		driver.findElement(By.xpath(".//*[@id='C_ConFirstName_main_1']/input[2]")).sendKeys("Shivani");
		driver.findElement(By.xpath(".//*[@id='C_ConLastName_main_1']/input[2]")).sendKeys("Kumari");
		Select dropdownRelation = new Select(driver.findElement(By.xpath(".//*[@id='C_ConRel_main_1']/select")));
		dropdownRelation.selectByValue("Spouse");

		//Immigiration Tab
		driver.findElement(By.xpath(".//*[@id='TabTitle__Immigration']")).click();

		Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_ImgCty_main_1']/select")));
		dropdownCountry.selectByValue("USA");

		//Employment Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Employment']")).click();
		Select dropdownCompGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_CpsGrp_main_1']/select")));
		dropdownCompGrp.selectByValue("Corp");
		Select dropdownTimesheetGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_TimCrdGrp_main_1']/select")));
		dropdownTimesheetGrp.selectByValue("CLOCK");

		//Situation Tab
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Situation']")).click();
		  
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("Account");
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys(Keys.ENTER);
		  
		  // Get and store both window handles in array
		  Set<String> AllWindowHandles = driver.getWindowHandles();
		  String window1 = (String) AllWindowHandles.toArray()[0];
		  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		  String window2 = (String) AllWindowHandles.toArray()[1];
		  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
		  
		  //Switch to window2(child window) and performing actions on it.
		  driver.switchTo().window(window2);
		  driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
		  driver.close();
			
		
		  Thread.sleep(15000);
		  
		  //Switch to window1(parent window) and performing actions on it.
		  driver.switchTo().window(window1);
		  
		  Alert alertOK1 = driver.switchTo().alert();

		  alertOK1.accept();
		
		  Thread.sleep(5000);
		  
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("login");
		  driver.switchTo().frame("dsp");



		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");

		//driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Amit");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(HiredEmp, "Kumar, Amit");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Terminate_main_1']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_Termination_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		String TerminatedEmp = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();

		Assert.assertEquals(TerminatedEmp, "Kumar, Amit");
		System.out.println("Terminated  Emp  Confirmed");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_TrmDt_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_TrmDt_main_1']/input[2]")).sendKeys("08/05/2016 2:01:12 pm");

		driver.findElement(By.xpath(".//*[@id='C_Process_main_1']")).click();

		Thread.sleep(5000);

		String TerminatedConfirmation= driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		Assert.assertEquals(TerminatedConfirmation, "   Termination was successfully processed.");

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();

		//Alert alertOK = driver.switchTo().alert();
		//String TerminatedConfirmation = alertOK.getText();
		//Assert.assertEquals(TerminatedConfirmation, "Termination  was successfully processed.");


		//alertOK.accept();

		System.out.println("Termination Processed");

		driver.switchTo().defaultContent();

		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_Rehire Summary_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Amit");

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		String RehireEmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		Assert.assertEquals(RehireEmpName, "Kumar, Amit");
		System.out.println("Rehire  Emp  Confirmed");

		driver.findElement(By.xpath(".//*[@id='C_Chk_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Rehire_main_1']")).click();

		Thread.sleep(5000);


		String RehireEmpNameConfirm = driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).getText();
		Assert.assertEquals(RehireEmpNameConfirm, "Kumar, Amit");
		System.out.println("  Emp Rehire  Confirmed");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Thread.sleep(5000);

		Alert alertOK = driver.switchTo().alert();

		alertOK.accept();

		System.out.println("Employee Records Deleted");



		driver.switchTo().defaultContent();

		logOut();

} 

	@Test(enabled = false, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyBenefitsRecalculateEligibilityButton() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_ID0EDJALAANA_Image']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenCurr_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String PromotedEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(PromotedEmp, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='C_RecalElig_main_0']")).click();
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();

		driver.switchTo().defaultContent();
		logOut();




		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 

	@Test(enabled = false, priority = 3, groups = {"Smoke" , "Nightly" })

	public void verifyEmpBenefitsDetail() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EJALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_ID0EDJALAANA_Image']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String PromotedEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(PromotedEmp, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		String BenefitDetail = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		Assert.assertEquals(BenefitDetail, "Benefit Details");
		//driver.findElement(By.xpath("//*[@id='C_RecalElig_main_0']")).click();
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();

		driver.switchTo().defaultContent();
		logOut();



		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 


	@Test(enabled = false, priority = 4, groups = {"Smoke" , "Nightly" } )
	public void verifyEmpDetailUpdates() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String UpdEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(UpdEmp, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		//String BenefitDetail = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		//Assert.assertEquals(BenefitDetail, "Benefit Details");
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();

		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='C_WrkSts_main_1']/select")));

		dropdown.selectByValue("CN");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();;
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();

		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String EmpUpdChange = driver.findElement(By.xpath(".//*[@id='C_WrkSts_main_1']/select")).getAttribute("value");
		System.out.println(EmpUpdChange);
		Assert.assertEquals(EmpUpdChange, "CN");

		driver.switchTo().defaultContent();

		logOut();



		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 


	@Test(enabled = false, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifyEmpTraining() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpTrnPrg_main_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String EmpTraining = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(EmpTraining, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		String TrainingName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();

		Assert.assertEquals(TrainingName, "Leadership");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Select Picktraining = new Select(driver.findElement(By.xpath(".//*[@id='C_TrnPrg_main_1']/select")));
		Picktraining.selectByValue("Finance-Adv");

		driver.findElement(By.xpath(".//*[@id='C_EmpTrnPrgEffDt_main_1']/input[2]")).sendKeys("02/08/2016");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String TrainingNamenew = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_2']")).getText();
		Assert.assertEquals(TrainingNamenew, "Finance-Adv");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_2']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		logOut();



		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 


	@Test(enabled = false, priority = 6, groups = {"Smoke" , "Nightly" })
	public void verifyEmpBonusChanges() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EIALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpIcv_main_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String EmpTraining = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(EmpTraining, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		//String TrainingName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();

		//Assert.assertEquals(TrainingName, "Leadership");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		Select PickEmpid = new Select(driver.findElement(By.xpath(".//*[@id='C_Eml_main_1']/select")));
		PickEmpid.selectByValue("1");

		Select PickbonusPlan = new Select(driver.findElement(By.xpath(".//*[@id='C_IcvPln_main_1']/select")));
		PickbonusPlan.selectByValue("SpotAward");

		driver.findElement(By.xpath(".//*[@id='C_EmpIcvEffDt_main_1']/input[2]")).sendKeys("02/08/2016");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String VerifyBonus = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();
		System.out.println(VerifyBonus);
		s_assert.assertEquals(VerifyBonus, "SpotAward");

		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		logOut();

		s_assert.assertAll();



		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 


	@Test(enabled = false, priority = 7, groups = {"Smoke" , "Nightly" })
	public void verifyEmpSalaryChanges() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EIALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpSalChg_main_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]
		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);


		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String EmpTraining = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(EmpTraining, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		//String TrainingName = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_1']")).getText();

		//Assert.assertEquals(TrainingName, "Leadership");

		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		Select salchangreason = new Select(driver.findElement(By.xpath(".//*[@id='C_SalChgRsn_main_1']/select")));
		salchangreason.selectByValue("Annual");
		//driver.findElement(By.xpath(".//*[@id='L_SysSalChgAmt_main_1']"));
		driver.findElement(By.xpath(".//*[@id='C_SysSalChgAmt_main_1']/input[2]")).sendKeys("1000");
		driver.findElement(By.xpath(".//*[@id='C_SysSalChgPct_main_1']/input[2]")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		logOut();

		s_assert.assertAll();



		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		/*driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();*/

	} 

	/*
	 * Teardown Method Called Driver Quit Browser Closed
	 */

	/*@AfterTest
	public void teardown() {
		driver.quit();

	}*/
	
	
	@Test(enabled = false, priority = 8, groups = {"Smoke" , "Nightly" })
	public void verifyPromoteEmployee() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("nav");
		
		Switch2LeftLogin();

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Tab_Menu_Human Resources']/div[2]/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlChanges_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlPromotion_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));'
		
		Switch2Middle();
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		Switch2Right();
		/*driver.switchTo().defaultContent();

		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");*/
		String PromotedEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(PromotedEmp, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		Switch2Middle();
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");*/

		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		// driver.switchTo().defaultContent();

		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("ACCOUNTS-SLO");
		driver.findElement(By.xpath(".//*[@id='C_Save']")).click();
		 
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		String Promotion_Title = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]"))
				.getAttribute("value");
		System.out.println(Promotion_Title);
		Assert.assertEquals(Promotion_Title, "ACCOUNTS-SLO {Accounts Manager-Slough}");
		driver.switchTo().defaultContent();
		logOut();

	}
	
	@Test(enabled = false, priority = 9, groups = {"Smoke" , "Nightly" })
	public void AddESSNewHireEmpWithUSADataRegulatorAndPrimaryCountry() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		//driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA' or @display='Processes' and @tip='HR Tasks']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		if(driver.findElements(By.xpath(".//*[@id='C_Add_Img']")).size()!=0){
			
			
			driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		}
		
		else
		{	
		log.info("Find Element No Present");
		}

		//General Tab


		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
		Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
		dropdownDataReg.selectByValue("USA");
		Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
		dropdownCountry.selectByValue("USA");

		Thread.sleep(5000);
		
		

		
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		/*Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");*/

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
		/*driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "vtest, vtest", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "vtest, vtest");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		
		
		driver.switchTo().defaultContent();

		logOut();
		
	//	driver.switchTo().parentFrame();
	//	driver.switchTo().frame("login");
		Thread.sleep(10000);
		logIn("vtest", "nuview");
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		
		Thread.sleep(10000);
		
		String EssEmpVer = driver.findElement(By.xpath(".//*[@id='greeting']")).getText();
        s_assert.assertTrue(EssEmpVer.contains("vtest vtest"));
        
      //  driver.switchTo().defaultContent();
        
        driver.findElement(By.xpath(".//*[@id='logout']/img")).click();
        
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
        logInN("nvsuperuser1", "nuview");
        Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		
		// driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp1 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(HiredEmp1, "vtest, vtest");
		//System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys("{vtest, vtest}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		
		
		
		
		
		driver.switchTo().defaultContent();

		
		
		
		logOut();
		s_assert.assertAll();

} 
	
	@Test(enabled = false, priority = 10, groups = {"Smoke"})
	public void AddSupervisorNewHireEmpWithUSADataRegulatorAndPrimaryCountry() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
		Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
		dropdownDataReg.selectByValue("USA");
		Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
		dropdownCountry.selectByValue("USA");

		Thread.sleep(5000);
		

		
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		/*Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");*/

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		
		Select dropdownRole = new Select(driver.findElement(By.xpath(".//*[@id='C_Rol_HirSumRol_0']/select")));
		dropdownRole.selectByValue("Supervisor");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
		/*driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "vtest, vtest", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);

		
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "vtest, vtest");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		//need to fix
	/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

		s_assert.assertEquals(PrimeCountryVer, "USA");
		
		String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

		s_assert.assertEquals(DataRegVer, "USA");  */
		
		
		driver.switchTo().defaultContent();

		logOut();
		
	//	driver.switchTo().parentFrame();
	//	driver.switchTo().frame("login");
		Thread.sleep(10000);
		logIn("vtest", "nuview");
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		
		Thread.sleep(10000);
		
		String UserRoleESS = driver.findElement(By.xpath(".//*[@id='C_RolName_PortalRoles_1']")).getText();
        s_assert.assertEquals(UserRoleESS, "Employee Self Service");
        String UserRoleSup = driver.findElement(By.xpath(".//*[@id='C_RolName_PortalRoles_2']")).getText();
        s_assert.assertEquals(UserRoleSup, "Supervisor");
        
        driver.switchTo().defaultContent();
		logOut();
        
      //  driver.switchTo().defaultContent();
        
      /*  driver.findElement(By.xpath(".//*[@id='logout']/img")).click();
        
        driver.switchTo().defaultContent();*/
        Thread.sleep(10000);
        logInN("nvsuperuser1", "nuview");
        Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		
		// driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp1 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(HiredEmp1, "vtest, vtest");
		//System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys("{vtest, vtest}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		 Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		
		
		
		
		
		driver.switchTo().defaultContent();

		
		
		
		logOut();
		s_assert.assertAll();

} 
	
	//DemoGraphics TestCases
	
	@Test(enabled = false, priority = 11, groups = {"Smoke"})
	public void verifyuserAble2AddEmpContacts() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmDep_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		EnterText(".//*[@id='C_LastName_main_1']/input[2]","Adams");
		EnterText(".//*[@id='C_FirstName_main_1']/input[2]","Sam");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		//SelectDropDownValue(".//*[@id='C_StpOp_steps_0']/select", "<=");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

	

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String SearchedEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(SearchedEmp, "Adams, Sam");
		System.out.println("Found Emp");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		Thread.sleep(5000);
		//clickCheckboxFromList("//table[@class='datasheet']//td", "Test Test");
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		EnterText(".//*[@id='C_DepFirstName_main_1']/input[2]","Test1");
		EnterText(".//*[@id='C_DepLastName_main_1']/input[2]","Test1");
		
		radiobutton_Select(".//*[@id='C_Dependent_main_1']/input[2]");
		
		
	//	webtableElementClick("//table[@class='datasheet']//td", "Test Test", "link");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Benefit Info']")).click();
		
		EnterText(".//*[@id='C_DepSSNSIN_main_1']/input[2]","564321");
		
		EnterText(".//*[@id='C_DepBirthDt_main_1']/input[2]","09/06/2016");
		
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "Test1 Test1", "link");
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		
		Alert alertOK1 = driver.switchTo().alert();

		  alertOK1.accept();
		
		
		
		
		
		driver.switchTo().defaultContent();

		
		
		
		logOut();
		s_assert.assertAll();

} 
	
	@Test(enabled = false, priority = 12, groups = {"Smoke" , "Nightly" })
	public void AddNewHireEmpWithTodaysDate() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		String CurrentD = new CommonFunctions().GetCurrentDate();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		//driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		if(driver.findElements(By.xpath(".//*[@id='C_Add_Img']")).size()!=0){
			
			
			driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		}
		
		else
		{	
		log.info("Find Element No Present");
		}

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
	Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
		dropdownDataReg.selectByValue("USA");
	Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
	dropdownCountry.selectByValue("USA");

		Thread.sleep(5000);
		

		
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		/*Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");*/

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
		/*driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "vtest, vtest", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "vtest, vtest");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Hire']")).click();
		
		String HireDateVerification = driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).getAttribute("value");

		s_assert.assertEquals(HireDateVerification, CurrentD);
		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys("{vtest, vtest}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		
		
		
		
		
		driver.switchTo().defaultContent();

		
		
		
		logOut();
		s_assert.assertAll();
		
	

} 



	//Hire an employee with Save and then Hire Option
	//Hire an Employee with Past Date  
	@Test(enabled = false, priority = 13, groups = {"Smoke" , "Nightly" }, description = "Hire an employee with Save and then Hire Option,Hire an Employee with Past Date" )
	public void AddNewHireEmpWithPastDateWithOKThenHireButton() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		String PastDate = new CommonFunctions().GetCurrentDateSub5();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
	Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
		dropdownDataReg.selectByValue("USA");
	Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
	dropdownCountry.selectByValue("USA");
	
	driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
	driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys(PastDate);

		Thread.sleep(5000);
		

		
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		/*Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");*/

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
		/*driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
		driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "vtest, vtest", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "vtest, vtest");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Hire']")).click();
		
		String HireDateVerification = driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).getAttribute("value");

		s_assert.assertEquals(HireDateVerification, PastDate);
		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys("{vtest, vtest}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
	
   
		
		
		driver.switchTo().defaultContent();

	
		
		
		logOut();
		s_assert.assertAll();
		

} 



	@Test(enabled = false, priority = 14, groups = {"Smoke" , "Nightly" }, description = "Hire an Employee with Future Date " )
	public void AddNewHireEmpFutureDate() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		String FutureDate = new CommonFunctions().GetCurrentDateAdd2();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest1");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest1");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
	Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
		dropdownDataReg.selectByValue("USA");
	Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
	dropdownCountry.selectByValue("USA");
	
	driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
	driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys(FutureDate);

		Thread.sleep(5000);
		

	/*
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest1");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
	//	driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
	//	driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "vtest1, vtest1", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
	/*	
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");*/
		
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("vtest1");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("vtest1");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "vtest1, vtest1");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		String EmpID = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Hire']")).click();
		
		String HireDateVerification = driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).getAttribute("value");

		s_assert.assertEquals(HireDateVerification, FutureDate);
		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys(EmpID+" {vtest1, vtest1}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
	/*	String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
	*/
   
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();		


} 
	
	@Test(enabled = false, priority = 15, groups = {"Smoke" , "Nightly" }, description = "Hire an Employee by changing Auto populated values" )
	public void AddNewHireHireBychangingAutoPopulated() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		//String FutureDate = new CommonFunctions().GetCurrentDateAdd2();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("ctest1");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("ctest1");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
//	Select dropdownDataReg = new Select(driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']/select")));
	//	dropdownDataReg.selectByValue("USA");
//	Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']/select")));
//	dropdownCountry.selectByValue("USA");
	
	//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
	//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys(FutureDate);

		Thread.sleep(5000);
		//Situation Tab
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Situation']")).click();
		  
		driver.findElement(By.xpath(".//*[@id='N_Pos_main_1_Img']")).click();

		
	//	driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys(Keys.ENTER);
		  
		  // Get and store both window handles in array
		  Set<String> AllWindowHandles = driver.getWindowHandles();
		  String window1 = (String) AllWindowHandles.toArray()[0];
		  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
		  String window2 = (String) AllWindowHandles.toArray()[1];
		  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
		  
		  //Switch to window2(child window) and performing actions on it.
		  driver.switchTo().window(window2);
		  driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("Accounts");
		  Find();
		  driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
		 // driver.close();
			
		
		  Thread.sleep(15000);
		  
		  //Switch to window1(parent window) and performing actions on it.
		  driver.switchTo().window(window1);
		  
			if (isAlertPresent()) {
			    driver.switchTo().alert();
			    driver.switchTo().alert().accept();
			    driver.switchTo().defaultContent();
			}
		  
			driver.switchTo().parentFrame();
			// driver.switchTo().frame(driver.findElement(By.name("dsp")));
			driver.switchTo().frame("login");
			driver.switchTo().frame("dsp");
			
	
		  
		  
			driver.findElement(By.xpath(".//*[@id='N_Job_main_1_Img']")).click();

			
			//	driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys(Keys.ENTER);
				  
				  // Get and store both window handles in array
				  Set<String> AllWindowHandles1 = driver.getWindowHandles();
				  String window1_1 = (String) AllWindowHandles1.toArray()[0];
				  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
				  String window2_2 = (String) AllWindowHandles1.toArray()[1];
				  System.out.print("\nwindow2 handle code = "+AllWindowHandles1.toArray()[1]);
				  
				  //Switch to window2(child window) and performing actions on it.
				  driver.switchTo().window(window2_2);
				  driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("CFO");
				  Find();
				  driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
				 // driver.close();
					
				
				  Thread.sleep(15000);
				  
				  //Switch to window1(parent window) and performing actions on it.
				  driver.switchTo().window(window1_1);
				  
					driver.switchTo().parentFrame();
					// driver.switchTo().frame(driver.findElement(By.name("dsp")));
					driver.switchTo().frame("login");
					driver.switchTo().frame("dsp");
				  
		  
		

	
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "ctest1, ctest1", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle__Situation']")).click();
		
		String Pos = driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).getAttribute("value");

		s_assert.assertEquals(Pos, "ACCOUNTS-SLO");
		
		String Job = new Select(driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/select"))).getFirstSelectedOption().getAttribute("value");

		s_assert.assertEquals(Job, "CFO");
		
		String Comp = new Select(driver.findElement(By.xpath(".//*[@id='C_Cmp_main_1']/select"))).getFirstSelectedOption().getAttribute("value");
		

		s_assert.assertEquals(Comp, "WH");
		String Loc = new Select(driver.findElement(By.xpath(".//*[@id='C_Loc_main_1']/select"))).getFirstSelectedOption().getAttribute("value");

		s_assert.assertEquals(Loc, "SLO");
		
		String Div = new Select(driver.findElement(By.xpath(".//*[@id='C_Div_main_1']/select"))).getFirstSelectedOption().getAttribute("value");

		s_assert.assertEquals(Div, "Paper");
		
		String Dept = new Select(driver.findElement(By.xpath(".//*[@id='C_Dpt_main_1']/select"))).getFirstSelectedOption().getAttribute("value");

		s_assert.assertEquals(Dept, "SLS");
		String Supervisor = driver.findElement(By.xpath(".//*[@id='C_Sup_main_1']/input[2]")).getAttribute("value");

		s_assert.assertEquals(Supervisor, "999296 {Brent, David}");
		
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
	/*	
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");*/
		
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("ctest1");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("ctest1");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "ctest1, ctest1");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		String EmpID = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		
	//	driver.findElement(By.xpath(".//*[@id='TabTitle__Hire']")).click();
		
	//	String HireDateVerification = driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).getAttribute("value");

	//	s_assert.assertEquals(HireDateVerification, FutureDate);
		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys(EmpID+" {ctest1, ctest1}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
	/*	String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
	*/
   
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();		

} 
	
	@Test(enabled = false, priority = 16, groups = {"Smoke"}, description = "Hire multiple employees through Hire-All option" )
	public void AddHireMultipleEmplHireAll() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
	//	String FutureDate = new CommonFunctions().GetCurrentDateAdd2();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("mtest1");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("mtest1");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
	
	
	

		Thread.sleep(5000);
		

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("mtest2");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("mtest2");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");
	
	
	

		Thread.sleep(5000);
		

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();


		Thread.sleep(5000);
		
	//	webtableElementClick("//table[@class='datasheet']//td", "vtest1, vtest1", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcessAll_main_1']")).click();
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, " New Hire has been added to the task queue.\nYou may continue to work while this process runs.");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		
		
	/*	
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[4]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");*/
		
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("mtest1");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("mtest1");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "mtest1, mtest1");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		String EmpID = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		

		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys(EmpID+" {mtest1, mtest1}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		
		driver.findElement(By.xpath(".//*[@id='C_Find']")).click();
		
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("mtest2");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("mtest2");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp2 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp2, "mtest2, mtest2");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		String EmpID2 = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
		

		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys(EmpID2+" {mtest2, mtest2}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();

		
	/*	String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
	*/
   
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();		


} 
	
	@Test(enabled = false, priority = 17, groups = {"Smoke" , "Nightly" }, description = "Hiring an employee with SSN/SIN" )
	public void AddNewHireEmpWithSSN() throws InterruptedException {

		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		
		//String FutureDate = new CommonFunctions().GetCurrentDateAdd2();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		//General Tab

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("stest1");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("stest1");
		//driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_SSNSIN_main_1']/input[2]")).sendKeys("673456789");
	
	
	

		Thread.sleep(5000);
		

	/*
		//Access Tab

		driver.findElement(By.xpath(".//*[@id='TabTitle__Access']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("Amit1");
		//driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");
		
		driver.findElement(By.xpath(".//*[@id='C_Login_main_1']/input[2]")).sendKeys("vtest1");
		driver.findElement(By.xpath(".//*[@id='C_PIN_main_1']/input[2]")).sendKeys("nuview");

		Select dropdownProfile = new Select(driver.findElement(By.xpath(".//*[@id='C_Pfl_main_1']/select")));
		dropdownProfile.selectByValue("Df");

		Select dropdownTheme = new Select(driver.findElement(By.xpath(".//*[@id='C_Thm_main_1']/select")));
		dropdownTheme.selectByValue("NuTheme");

		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_HirSumRol_HirSumRol_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_HirSumRol_HirSumRol_0']")).click();
		
	//	driver.findElement(By.xpath(".//*[@id='TabTitle__Dates']")).click();
	//	driver.findElement(By.xpath(".//*[@id='C_FirstHireDt_main_1']/input[2]")).sendKeys("08/05/2016");*/
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		Thread.sleep(5000);
		
		webtableElementClick("//table[@class='datasheet']//td", "stest1, stest1", "link");

	//	driver.findElement(By.xpath(".//*[@id='C_FullName_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_HireProcess_main_1']")).click();
		
		Thread.sleep(5000);
		
		
		
		String Message1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message1, "Add Employee Salary Components has been added to the task queue.\nYou may continue to work while this process runs.");
		
	/*	String Message2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message2, "Add/Delete Records on Employee Data Privacy Fields has been added to the task queue.\nYou may continue to work while this process runs.");*/
		
		String Message3 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[2]/td")).getText().trim();

		s_assert.assertEquals(Message3, "TimeAccElig has been added to the task queue.\nYou may continue to work while this process runs.");
		
		String Message4 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[3]/td")).getText().trim();

		s_assert.assertEquals(Message4, "New Employee(s) have been successfully entered into the HR system. They are now available under Human Resources / Employees.");
		
		//driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ELALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Emp_main_1']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("stest1");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("stest1");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(HiredEmp, "stest1, stest1");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Thread.sleep(5000);
		
		String EmpID = driver.findElement(By.xpath(".//*[@id='C_EmpDsp_main_1']")).getText();
		
		//need to fix
		/*	String PrimeCountryVer = driver.findElement(By.xpath(".//*[@id='C_PrimCty_main_1']")).getAttribute("value");

			s_assert.assertEquals(PrimeCountryVer, "USA");
			
			String DataRegVer = driver.findElement(By.xpath(".//*[@id='C_Reg_main_1']")).getAttribute("value");

			s_assert.assertEquals(DataRegVer, "USA");  */
	
		
        driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_SysEmp_main_1']/input[2]")).sendKeys(EmpID+" {stest1, stest1}");
		
		driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		
	//	driver.findElement(By.xpath(".//*[@id='C_TransferProcess_main_1']")).click();
		

		
		String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

		s_assert.assertEquals(Message, "Update Child Dependencies and Delete Parent has been added to the task queue.\nYou may continue to work while this process runs.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
	
   
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();			
			
} 
	
	@Test(enabled = false, priority = 18, groups = {"Smoke"})
	public void RehireMultipleEmp() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		//Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Rehire Summary_main_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpTrnPrg_main_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpBenDepRvw_main_1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		
		Find();
		
		//Click(".//*[@id='C_ChkAll_main_1']");
		Click(".//*[@id='C_Rehire_main_1']");
		
		if (isDialogPresent()) {
			String Message = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();

			Assert.assertEquals(Message, "Please checked an employee to Rehire.");
			
		    //driver.switchTo().alert();
		    Click(".//*[@id='F_MsgOk']");
		    System.out.println("No Emp for Hire");
		    //driver.switchTo().defaultContent();
		}
		
		

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();	


		

	} 

	

}

