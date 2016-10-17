package com.HRM.testcases.Recruiting;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Recruiting_SmokeTest extends CommonFunctions {

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
	public void verifyUserAbleCreateJobPostingTemp() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobPostTemp_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
		String JobPostingPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(JobPostingPageTitle, "Job Posting Template");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_PostTemp_main_1']/input[2]")).sendKeys("FT");
		driver.findElement(By.xpath(".//*[@id='C_PostTempName_main_1']/input[2]")).sendKeys("Full Time");
		driver.findElement(By.xpath(".//*[@id='TabTitle__Posting Setup']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_PstReq_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_PstJobDesc_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_PstJobTitle_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		/*WebElement table = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table"));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    for (WebElement cell : cells) {
		        System.out.println("content >>   " + cell.getText());
		        
		       if(cell.getText().contains("FT")){
		    	   System.out.println("FT Found");
		    	   
		    	  // cell.click();
		    	 //  break;
		       }
		    }
		}*/
		
	/*	List<WebElement> CustList = driver.findElements(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table/tbody"));

		for(int i=0;i<CustList.size();i++){
		    String ActCustName = CustList.get(i).getText();
		    System.out.println(ActCustName);

		    Thread.sleep(1000);
		    if(ActCustName.contains("FT")){
		    	System.out.println("");
		        CustList.get(i).click();
		    }
		} 
		*/
		/* WebElement table = driver.findElement(By.xpath(".//*[@id='Datasheet-_main_1_Body']/table"));

		    //get all rows
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));

		    //iterate through the rows
		    for (WebElement row : allRows) {
		            //get the rowCells in each row
		            List<WebElement> rowCells = row.findElements(By.tagName("td"));

		            //get the column which contains the project name and get text
		            String projectName = rowCells.get(1).getText();

		            //Compare if the project name equals TEST1
		            if (projectName.equals("FT")) {
		                System.out.println("Table Data : " + projectName);
		                System.out.println("Table Row : " + rowCells.indexOf(projectName));

		                //get the column containing the link and click on it.
		                rowCells.get(1).click();

		                //webdriver.findElement(By.id("493")).click();
		                //Img is contained within the row containing the project Name
		                //So, find the Img in the row and click
		                row.findElement(By.className("link")).click();           
		    }
		}*/
		
		
	/*	try{
			webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table/tbody", "FT", "link");
			//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		   // log.debug("Exception in finding date");
		  //  log.debug(e);
		   // webtableclass1(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "1", "link");
		//	System.out.println("Error");
		    //WebElement date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
		   // driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}*/

		
		webtableElementTextAssert("//table[@class='datasheet']//td", "FT");
		webtableElementClick("//table[@class='datasheet']//td", "FT", "link");
		Thread.sleep(5000);
		/*String JobPostingTempName = driver.findElement(By.xpath(".//*[@id='C_PostTemp_main_2']")).getText();
		s_assert.assertEquals(JobPostingTempName, "FT");
		
		driver.findElement(By.xpath(".//*[@id='C_PostTemp_main_2']")).click();
		
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		Delete();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleCreateCandidateProfileTemp() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobAppTemp_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
		String CandProfilePageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(CandProfilePageTitle, "Candidate Profile Template");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_CssStp_main_1']/input[2]")).sendKeys("Full Time");
		driver.findElement(By.xpath(".//*[@id='C_CssStpNme_main_1']/input[2]")).sendKeys("Full Time");
		driver.findElement(By.xpath(".//*[@id='TabTitle_CSSTemplateTabs_Resume Data']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_RsmCvrLtrDsp_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_RsmResumeDsp_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_RsmImpFileNameDsp_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		webtableElementTextAssert("//table[@class='datasheet']//td", "Full Time");
		webtableElementClick("//table[@class='datasheet']//td", "Full Time", "link");
		Thread.sleep(5000);

		//String CandProfileTempName = driver.findElement(By.xpath(".//*[@id='C_CssStp_main_2']")).getText();
		//s_assert.assertEquals(CandProfileTempName, "Full Time");
		
		//driver.findElement(By.xpath(".//*[@id='C_CssStp_main_2']")).click();
		
		Delete();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleCreatePostingSite() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_CrsFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobPstSites_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
		String PostingSitePageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PostingSitePageTitle, "Posting Sites");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_RcrPst_main_1']/input[2]")).sendKeys("New");
		driver.findElement(By.xpath(".//*[@id='C_RcrPstName_main_1']/input[2]")).sendKeys("New");
		/*Select DropJobPostingType = new Select(
				driver.findElement(By.xpath(".//*[@id='C_RcrPstTmp_main_1']/select")));
		//DropJobPostingType.selectByValue("PT");
		DropJobPostingType.selectByIndex(1);*/
		/*Select DropCandProfileType = new Select(
				driver.findElement(By.xpath(".//*[@id='C_RcrAppTmp_main_1']/select")));
		//DropCandProfileType.selectByValue("Part Time");
		DropCandProfileType.selectByIndex(1);*/


		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		

		//String CandProfileTempName = driver.findElement(By.xpath(".//*[@id='C_RcrPst_main_3']")).getText();
		//s_assert.assertEquals(CandProfileTempName, "New");
		
		webtableElementTextAssert("//table[@class='datasheet']//td", "New");
		webtableElementClick("//table[@class='datasheet']//td", "New", "link");
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='C_RcrPst_main_3']")).click();
		
		Delete();
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleCreateNewRequisition() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		driver.findElement(By.xpath(".//*[@id='C_ReqFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']")).click();
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String RequisitionPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(RequisitionPageTitle, "Requisitions");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']/input[2]")).sendKeys("10001");
		driver.findElement(By.xpath(".//*[@id='C_ReqName_main_1']/input[2]")).sendKeys("Test");
		Select DropRequisitionStatus = new Select(
				driver.findElement(By.xpath(".//*[@id='C_ReqStatus_main_1']/select")));
		DropRequisitionStatus.selectByValue("Open");
		
		Select DropLocation = new Select(
				driver.findElement(By.xpath(".//*[@id='C_Loc_main_1']/select")));
		//DropLocation.selectByValue("ATL");
		DropLocation.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='TabTitle__Posting']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_dsOfReqPosted_dsOfReqPosted_0']")).click();
		
		Select DropPostingSite = new Select(
				driver.findElement(By.xpath(".//*[@id='C_RcrPst_dsOfReqPosted_0']/select")));
		//DropPostingSite.selectByValue("PartTime");
		DropPostingSite.selectByIndex(1);
		String CurrentDate = new CommonFunctions().GetCurrentDate();
		String CurrentDateAdd10 = new CommonFunctions().GetCurrentDateAdd10();
		
		driver.findElement(By.xpath(".//*[@id='C_PostDt_dsOfReqPosted_0']/input[2]")).sendKeys(CurrentDate);
		driver.findElement(By.xpath(".//*[@id='C_PostEndDt_dsOfReqPosted_0']/input[2]")).sendKeys(CurrentDateAdd10);
		
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_dsOfReqPosted_dsOfReqPosted_0']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']/input[2]")).sendKeys("10001");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		

		//String RequisitionNoV = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		//s_assert.assertEquals(RequisitionNoV, "10001");
		webtableElementTextAssert("//table[@class='datasheet']//td", "10001");
		webtableElementClick("//table[@class='datasheet']//td", "10001", "link");
		
		//driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		
		/*driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();*/
		Delete();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	//
	
	@Test(enabled = false, priority = 5, groups = {"Smoke"})
	public void verifyManageAbleCreateNewRequisition_HRAbleToApprove_HRAbleToChangePendingReqToOpen_MSSUserAbleToViewOpenReq() throws InterruptedException {
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
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RequisitionAdd_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
		String RequisitionPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(RequisitionPageTitle, "Requisitions");

	//	driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']/input[2]")).sendKeys("1000");
		driver.findElement(By.xpath(".//*[@id='C_ReqName_main_1']/input[2]")).sendKeys("Test1");
	
		
		Select DropLocation = new Select(
				driver.findElement(By.xpath(".//*[@id='C_Loc_main_1']/select")));
		DropLocation.selectByValue("ATL");
		//driver.findElement(By.xpath(".//*[@id='C_AuthSubmit_Img']")).click();
		Save();
		
		Thread.sleep(5000);
		
		String PopupVer1 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer1,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();
		logOut();
		logIn("welcome", "nuview");
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
		logOut();
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		driver.findElement(By.xpath(".//*[@id='C_ReqFind_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String RequisitionPageTitle1 = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(RequisitionPageTitle1, "Requisitions");
		
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']/input[2]")).sendKeys("1000");
		Select DropRequisitionStatus = new Select(
				driver.findElement(By.xpath(".//*[@id='C_ReqStatus_main_1']/select")));
		DropRequisitionStatus.selectByValue("Pending");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		

		String RequisitionNoV = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(RequisitionNoV, "1000");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		Select DropRequisitionStatusChangeToOpen = new Select(
				driver.findElement(By.xpath(".//*[@id='C_ReqStatus_main_1']/select")));
		DropRequisitionStatusChangeToOpen.selectByValue("Open");
		
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		
		Thread.sleep(5000);
		
		/*driver.switchTo().defaultContent();
		logOut();
		logIn("welcome", "nuview");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");*/
		
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0ECNAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSReq_main_1']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String RequisitionPageTitleOpen = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(RequisitionPageTitleOpen, "Requisitions");
		
		driver.findElement(By.xpath(".//*[@id='C_Req_main_1']/input[2]")).sendKeys("1000");
		
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		
		String RequisitionNoMSS = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(RequisitionNoMSS, "1000");
		
		String RequisitionNameMSS = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_1']")).getText();
		s_assert.assertEquals(RequisitionNameMSS, "Test1");
		
		String RequisitionStatusMSS = driver.findElement(By.xpath(".//*[@id='C_Lbl4_main_1']")).getText();
		s_assert.assertEquals(RequisitionStatusMSS, "Open");
		
		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
		 Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		
        Thread.sleep(5000);
		
		String PopupVer2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText();
		s_assert.assertEquals(PopupVer2,
				"   Your request will be sent to Sam Adams, Jerry Berman, Felicia Adams etc for approval.");
		
		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		driver.switchTo().defaultContent();
		logOut();
		
		logIn("welcome", "nuview");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_AuthApprove_Img']")).click();
		String PopupApprovalConfirmation2 = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td"))
				.getText();
		s_assert.assertEquals(PopupApprovalConfirmation2,
				"   This authorization has been approved and the record(s) will be saved.");
		// driver.switchTo().defaultContent();

		driver.findElement(By.xpath(".//*[@id='F_MsgOk']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();
		

	}
	
	@Test(enabled = true, priority = 6, groups = {"Smoke","Nightly"})
	public void verifyUserAblePublishPostingCSSAndWorkflow() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn(SYSPARAM.getProperty("Username") , SYSPARAM.getProperty("Password") );

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Recruiting']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PublishToCSS_main_1']")).click();
	//	driver.findElement(By.xpath(".//*[@id='C_Req_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		//driver.switchTo().frame("edit");
		
		String RequisitionPageTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(RequisitionPageTitle, "Publish to CSS");
		
		Click(".//*[@id='C_CSSPostJobs__1']");
		
		String PopUpValidation = driver.findElement(By.xpath(".//*[@id='PopupText']/table/tbody/tr[1]/td")).getText().trim();
		s_assert.assertEquals(PopUpValidation, "CSSPostJobs has been added to the task queue.\nYou may continue to work while this process runs.");
         Click(".//*[@id='F_MsgOk']");
		
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}


	
}
