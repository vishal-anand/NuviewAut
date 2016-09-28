package com.HRM.testcases.Comp_TC.Compensation;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Comp_SmokeTest extends CommonFunctions {

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
						true);
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
	@Test(enabled = false, priority = 1)
	public void Login(String username, String password) {
		driver.get(Locators.NuviewURL);
		driver.findElement(By.xpath(Locators.Username)).sendKeys(username);
		driver.findElement(By.xpath(Locators.Password)).sendKeys(password);
		driver.findElement(By.xpath(Locators.LoginBtn)).click();
		driver.switchTo().frame("dsp");
		String Title_HomePage = driver.findElement(By.xpath(Locators.HomePageTitle)).getText();

		Assert.assertEquals(Title_HomePage, "Home Page");
		driver.switchTo().parentFrame();

	}*/

	@Test(enabled = true, priority = 1, groups = {"Smoke" , "Nightly" })
	public void verifyCreationCompensationGroup() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Compensation']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBJAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_IcvGrp_main_1']")).click();
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



		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_CpsGrp_main_1']/input[2]")).sendKeys("Vishal Group");
		driver.findElement(By.xpath(".//*[@id='C_CpsGrpName_main_1']/input[2]")).sendKeys("Vishal");
		driver.findElement(By.xpath(".//*[@id='C_CpsGrpDesc_main_1']/textarea")).sendKeys("Vishal Compensation");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		String NewCompGrp = driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_6']")).getText();//Change to 6 for old systems

		Assert.assertEquals(NewCompGrp, "Vishal Group");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk1_main_6']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		driver.switchTo().defaultContent();
		logOut();

		

	}
	
	@Test(enabled = false, priority = 2, groups = {"Smoke"})
	public void verifyCreationCompensationPlan() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Compensation']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Plans_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).click();
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



		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnYr_main_1']/input[2]")).sendKeys("2016");
		//.sendKeys("Vishal Group");
		driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']/input[2]")).sendKeys("VCompPlan");
		
		Select dropdowntype = new Select(driver.findElement(By.xpath(".//*[@id='C_PlnTyp_main_1']/select")));
		dropdowntype.selectByValue("Periodic");
		
		Thread.sleep(5000);
		
		Select dropdownsalchngreason = new Select(driver.findElement(By.xpath(".//*[@id='C_SalChgRsn_main_1']/select")));
		dropdownsalchngreason.selectByValue("Other");
		
		Thread.sleep(5000);
		Select dropdownempchngreason = new Select(driver.findElement(By.xpath(".//*[@id='C_EmlChgRsn_main_1']/select")));
		//Select dropdownempchngreason = new Select(driver.findElement(By.xpath(".//*[@id='C_EmlChgRsn_main_1']/select/optgroup[5]")));
		//dropdownempchngreason.selectByIndex(4);
		dropdownempchngreason.selectByValue("Progression");
		
		Thread.sleep(5000);
		
		Select dropdownhierarchy = new Select(driver.findElement(By.xpath(".//*[@id='C_CpsPlnHrch_main_1']/table/tbody/tr/td[1]/select")));
		dropdownhierarchy.selectByValue("Cmp");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnHrch_main_1']/table/tbody/tr/td[2]/img[1]")).click();
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Components']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_CpsPlnTyp_CpsPlnTyp_0']")).click();
		
		Select dropdownComp = new Select(driver.findElement(By.xpath(".//*[@id='C_CpsComp_CpsPlnTyp_0']/select")));
		dropdownComp.selectByValue("Base");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_CpsPlnTyp_CpsPlnTyp_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		
		String CompPlannew = driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).getText();

		Assert.assertEquals(CompPlannew, "VCompPlan");
		
		driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		/*driver.findElement(By.xpath(".//*[@id='TabTitle__Components']")).click();
		driver.findElement(By.xpath(".//*[@id='F_CpsComp_CpsPlnTyp_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetRemove_CpsPlnTyp_CpsPlnTyp_0']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnYr_main_1']/input[2]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).click();*/
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		logOut();

		

	}
	
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyEmpCompensationPlan() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Compensation']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CpsPlnImp_main_1']")).click();

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

		String CompPlanTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		Assert.assertEquals(CompPlanTitle, "Compensation Plans");

		driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		String EmpCompPlanData = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		Assert.assertEquals(EmpCompPlanData, "Employee Compensation Plan Data");
		
		String CompPlan = driver.findElement(By.xpath(".//*[@id='C_ConPln_main_1']")).getText();

		Assert.assertEquals(CompPlan, "2012_HrFin2_Periodic (Jan 01, 2012)");
		//Assert.assertEquals(CompPlan, "2016_TestPlan_Periodic (Sep 01, 2016)");
		
		
		
	
		
		driver.switchTo().defaultContent();
		logOut();

		

	}

	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyEmpCompensationScenarioDesign() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Compensation']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Plans_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PlnDtl_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		//driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		// driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).click();
		// *[@id='C_LastName_main_1']/input[2]

		// String test
		// =driver.findElement(By.xpath(".//*[@id='TabSet_Menu']")).getText();

		// System.out.println(test);
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
        driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
        
        driver.switchTo().defaultContent();
        driver.switchTo().frame("login");
        driver.switchTo().frame("dsp");
        driver.switchTo().frame("list");

		//String CompPlanStatus = driver.findElement(By.xpath(".//*[@id='C_CpsPlnSts_main_1']")).getText();

		//Assert.assertEquals(CompPlanStatus, "Plan Modeling");

		//driver.findElement(By.xpath(".//*[@id='C_CpsPln_main_1']")).click();
		
		webtableElementClick("//table[@class='datasheet']//td", "HrFin2", "link");
		

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String EmpCompScenarioDsgn = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		Assert.assertEquals(EmpCompScenarioDsgn, "Scenario Design");
		
		String Scenarioname = driver.findElement(By.xpath(".//*[@id='C_HrchName_listMain_1']")).getText();

		Assert.assertEquals(Scenarioname, "Hier");
		
		driver.switchTo().defaultContent();
		logOut();

		

	}
	
	@Test(enabled = true, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifyEmpCompensationProfile() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Compensation']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CpsEmp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpCpsPrf_main_1']")).click();

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

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Janet");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String EmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(EmpName, "Amber, Janet");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		//Thread.sleep(5000);
		String EmpCompProTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();

		s_assert.assertEquals(EmpCompProTitle, "Employee Compensation Profile");
		
		String EmpNameProPage = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		s_assert.assertEquals(EmpNameProPage, "Amber, Janet");
		
		String EmpCompPlan = driver.findElement(By.xpath(".//*[@id='C_CpsPlnCon_CpsPlnLst_1']")).getText();

		s_assert.assertEquals(EmpCompPlan, "2012_HRFin1_Periodic (Jan 01, 2012)");
		
		
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
	
	
/*	@Test(enabled = false, priority = 6)
	public void VerifyCompGroupNewHire() throws InterruptedException {
		
		 initBrowser();
		  driver.get(Locators.NuviewURL);
		  //Enter your real Userd ID and Password of FB bellow.
		 logIn("nvsuperuser1", "nuview");
//New Hire Started

		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Human Resources']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EBLAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_New Hire_main_1']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().defaultContent();

		Thread.sleep(10000);


		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Amit");
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_HireDt_main_1']/input[2]")).sendKeys("08/05/2016 1:01:12 pm");

		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='TabTitle__Immigration']")).click();
		
		Select dropdownCountry = new Select(driver.findElement(By.xpath(".//*[@id='C_ImgCty_main_1']/select")));
		dropdownCountry.selectByValue("USA");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle__Employment']")).click();
		
		Select dropdownCompGroup = new Select(driver.findElement(By.xpath(".//*[@id='C_CpsGrp_main_1']/select")));
		dropdownCompGroup.selectByValue("Corp");
		
		
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
		
		//New Hire End
		
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(10000);
		
		System.out.println("Verification of Compensation Group for new Hire Completed");

		
		driver.switchTo().frame("dsp");
		
		List<WebElement> CompNewHireProc = driver.findElements(By.xpath("//*[contains(text(),'Compensation New Hire Processing')]"));
		Assert.assertEquals("Text not found!", CompNewHireProc.size() > 0);
		
		
		
		//String Status = driver.findElement(By.xpath(".//*[@id='C_Sts_main_2']")).getText();

		//Assert.assertEquals(Status, "Completed");
		
		
		
		driver.switchTo().defaultContent();
		
		System.out.println("Verification of Compensation Group for new Hire Completed");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmlCurr_main_1']")).click();
		
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Amit");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String HiredEmp = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();

		Assert.assertEquals(HiredEmp, "Kumar, Amit");
		System.out.println("New Emp Hired");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_EmlEffDt_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Terminate_main_1']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_Termination_main_1']")).click();
		
		driver.switchTo().defaultContent();
		
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
		
		/*driver.switchTo().defaultContent();
		
        driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_EmpFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EGALAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Eml_main_1']")).click();*/
		
		
		
		/*driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_Rehire Summary_main_1']")).click();
		
		driver.switchTo().defaultContent();
		
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
		 
		 Alert alertOK1 = driver.switchTo().alert();
		
         alertOK1.accept();
			
	     System.out.println("Employee Records Deleted");
			
			
		
		driver.switchTo().defaultContent();
		
		logOut();
		
		
		
		

		

	} */
	
	/*
	 * Teardown Method Called Driver Quit Browser Closed
	 */

	/*@AfterTest
	public void teardown() {
		driver.quit();

	}*/

}

