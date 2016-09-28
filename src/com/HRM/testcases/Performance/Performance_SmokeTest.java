package com.HRM.testcases.Performance;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;
import com.HRM.Utils.CommonFunctions;

public class Performance_SmokeTest extends CommonFunctions {

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
	public void verifyUserCreatePerformanceGroup() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']/input[2]")).sendKeys("VishalGrp");
		driver.findElement(By.xpath(".//*[@id='C_PrfGrpName_main_1']/input[2]")).sendKeys("VisGrp");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PerfGrp = driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_10']")).getText();
		s_assert.assertEquals(PerfGrp, "VishalGrp");

		String PerfGrpName = driver.findElement(By.xpath(".//*[@id='C_PrfGrpName_main_10']")).getText();
		s_assert.assertEquals(PerfGrpName, "VisGrp");

		driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_10']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 2, groups = {"Smoke" , "Nightly" })
	public void verifyUserCreatePerformanceFactor() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PrfFct_main_1']")).click();

		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PrfFct_main_1']/input[2]")).sendKeys("VishalFactor");
		driver.findElement(By.xpath(".//*[@id='C_PrfFctName_main_1']/input[2]")).sendKeys("VisFct");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String Factor = driver.findElement(By.xpath(".//*[@id='C_PrfFct_main_7']")).getText();
		s_assert.assertEquals(Factor, "VishalFactor");

		String FctName = driver.findElement(By.xpath(".//*[@id='C_PrfFctName_main_7']")).getText();
		s_assert.assertEquals(FctName, "VisFct");

		driver.findElement(By.xpath(".//*[@id='C_PrfFct_main_7']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		driver.switchTo().defaultContent();

		logOut();
		s_assert.assertAll();

	}

	// Incomplete- Need to know how to delete Position Skill
	@Test(enabled = true, priority = 3, groups = {"Smoke" , "Nightly" })
	public void verifyCreateNewPos() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPosSkl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
		driver.findElement(By.xpath(".//*[@id='C_PosTitle_main_1']/input[2]")).sendKeys("VisPos");
		driver.findElement(By.xpath(".//*[@id='C_PosEffDt_main_1']/input[2]")).sendKeys("08/10/2016");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Situation']")).click();
		Select DropEntity = new Select(driver.findElement(By.xpath(".//*[@id='C_Ent_main_1']/select")));
		DropEntity.selectByValue("Ent1");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Supervisor and Pay']")).click();

		Select DropManLev = new Select(driver.findElement(By.xpath(".//*[@id='C_SubLevel_main_1']/select")));
		DropManLev.selectByValue("Hourly");
		driver.findElement(By.xpath(".//*[@id='C_WorkHours_main_1']/input[2]")).sendKeys("8");
		driver.findElement(By.xpath(".//*[@id='C_WrkDays_main_1']/input[2]")).sendKeys("40");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println("Position Created");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
	//	driver.findElement(By.xpath(".//*[@id='C_IncludeInactive_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String Position = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(Position, "VishalPosition");

		String PosTitle = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_1']")).getText();
		s_assert.assertEquals(PosTitle, "VisPos");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_More']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_CommonTables']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EHEAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PosFind_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
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

	@Test(enabled = true, priority = 4, groups = {"Smoke" , "Nightly" })
	public void verifyUserNewSkillAssignAndEditForNewPos() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPosSkl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
		driver.findElement(By.xpath(".//*[@id='C_PosTitle_main_1']/input[2]")).sendKeys("VisPos");
		driver.findElement(By.xpath(".//*[@id='C_PosEffDt_main_1']/input[2]")).sendKeys("08/10/2016");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Situation']")).click();
		Select DropEntity = new Select(driver.findElement(By.xpath(".//*[@id='C_Ent_main_1']/select")));
		DropEntity.selectByValue("Ent1");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Supervisor and Pay']")).click();

		Select DropManLev = new Select(driver.findElement(By.xpath(".//*[@id='C_SubLevel_main_1']/select")));
		DropManLev.selectByValue("Hourly");
		driver.findElement(By.xpath(".//*[@id='C_WorkHours_main_1']/input[2]")).sendKeys("8");
		driver.findElement(By.xpath(".//*[@id='C_WrkDays_main_1']/input[2]")).sendKeys("40");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println("Position Created");
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
	//	driver.findElement(By.xpath(".//*[@id='C_IncludeInactive_main_1']/input[2]")).click();

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String Position = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(Position, "VishalPosition");

		String PosTitle = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_1']")).getText();
		s_assert.assertEquals(PosTitle, "VisPos");

		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		Select DropSkill = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkill.selectByValue("ACTG");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String SkillPosition = driver.findElement(By.xpath(".//*[@id='C_PosName_main_1']")).getText();
		s_assert.assertEquals(SkillPosition, "VishalPosition (VisPos)");

		String SkillPos = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(SkillPos, "ACTG");

		// Edit Pos Skill

		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();

		Select DropSkillEdit = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkillEdit.selectByValue("ANALYSIS");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String SkillPositionEdit = driver.findElement(By.xpath(".//*[@id='C_PosName_main_1']")).getText();
		s_assert.assertEquals(SkillPositionEdit, "VishalPosition (VisPos)");

		String SkillPosEdit = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(SkillPosEdit, "ANALYSIS");

		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertSkillDel = driver.switchTo().alert();
		alertSkillDel.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_More']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_CommonTables']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EHEAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PosFind_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Pos_main_1']/input[2]")).sendKeys("VishalPosition");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
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

	// Three Test Cases are covered

	@Test(enabled = true, priority = 5, groups = {"Smoke" , "Nightly" })
	public void verifyUserCreatesNewJobAssignAndEditSkillNewJob() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwJobSkl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_JobTitle_main_1']/input[2]")).sendKeys("VisJob");
		Select DropJobEEO = new Select(driver.findElement(By.xpath(".//*[@id='C_JobEeo_main_1']/select")));
		DropJobEEO.selectByValue("Tech");
		Select DropJobGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_JobGrp_main_1']/select")));
		DropJobGrp.selectByValue("Exec");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		// driver.switchTo().defaultContent();
		System.out.println("Position Created");
		// driver.switchTo().defaultContent();

		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String Job = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(Job, "VishalJob");

		String JobTitle = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_1']")).getText();
		s_assert.assertEquals(JobTitle, "VisJob");

		String JobEEO = driver.findElement(By.xpath(".//*[@id='C_Lbl4_main_1']")).getText();
		s_assert.assertEquals(JobEEO, "Tech");

		String JobGrp = driver.findElement(By.xpath(".//*[@id='C_Lbl5_main_1']")).getText();
		s_assert.assertEquals(JobGrp, "Exec");
		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		Select DropSkill = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkill.selectByValue("ACTG");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String SkillPosition = driver.findElement(By.xpath(".//*[@id='C_JobName_main_1']")).getText();
		s_assert.assertEquals(SkillPosition, "VishalJob( VisJob)");

		String SkillPos = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(SkillPos, "ACTG");

		// Edit Job Skill
		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();

		Select DropSkillEdit = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkillEdit.selectByValue("ANALYSIS");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String SkillPositionEdit = driver.findElement(By.xpath(".//*[@id='C_JobName_main_1']")).getText();
		s_assert.assertEquals(SkillPositionEdit, "VishalJob( VisJob)");

		String SkillPosEdit = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(SkillPosEdit, "ANALYSIS");

		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertSkillDel = driver.switchTo().alert();
		alertSkillDel.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_More']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_CommonTables']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EHEAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobFind_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
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

	@Test(enabled = true, priority = 6, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToAssignAccountabilityToNewJob() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobAcc_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_JobTitle_main_1']/input[2]")).sendKeys("VisJob");
		Select DropJobEEO = new Select(driver.findElement(By.xpath(".//*[@id='C_JobEeo_main_1']/select")));
		DropJobEEO.selectByValue("Tech");
		Select DropJobGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_JobGrp_main_1']/select")));
		DropJobGrp.selectByValue("Exec");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		// driver.switchTo().defaultContent();
		System.out.println("Position Created");
		// driver.switchTo().defaultContent();

		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String Job = driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).getText();
		s_assert.assertEquals(Job, "VishalJob");

		String JobTitle = driver.findElement(By.xpath(".//*[@id='C_Lbl3_main_1']")).getText();
		s_assert.assertEquals(JobTitle, "VisJob");

		String JobEEO = driver.findElement(By.xpath(".//*[@id='C_Lbl4_main_1']")).getText();
		s_assert.assertEquals(JobEEO, "Tech");

		String JobGrp = driver.findElement(By.xpath(".//*[@id='C_Lbl5_main_1']")).getText();
		s_assert.assertEquals(JobGrp, "Exec");
		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_JobAcc_main_1']/input[2]")).sendKeys("VishalAccountability");
		driver.findElement(By.xpath(".//*[@id='C_JobAccName_main_1']/input[2]")).sendKeys("VisAccount");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String SkillPosition = driver.findElement(By.xpath(".//*[@id='C_JobName_main_1']")).getText();
		s_assert.assertEquals(SkillPosition, "VishalJob( VisJob)");

		String SkillAccoutability = driver.findElement(By.xpath(".//*[@id='C_JobAcc_main_1']")).getText();
		s_assert.assertEquals(SkillAccoutability, "VishalAccountab");

		driver.findElement(By.xpath(".//*[@id='C_JobAcc_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertSkillDel = driver.switchTo().alert();
		alertSkillDel.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_More']")).click();
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_CommonTables']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EHEAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_JobFind_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Job_main_1']/input[2]")).sendKeys("VishalJob");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Lnk2_main_1']")).click();
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

	@Test(enabled = true, priority = 7,groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToCreateNewCourseAndAssignSkillToCourse() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwCrsFind_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("Applied Stats");
		driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']/input[2]")).sendKeys("App Stats");
		driver.findElement(By.xpath(".//*[@id='C_Internal_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Days_main_1']/input[2]")).sendKeys("7");

		Select DropCourseGrp = new Select(driver.findElement(By.xpath(".//*[@id='C_CrsGrp_main_1']/select")));
		DropCourseGrp.selectByValue("CAREER");
		Select DropCourseTyp = new Select(driver.findElement(By.xpath(".//*[@id='C_CrsTyp_main_1']/select")));
		DropCourseTyp.selectByValue("DEVACT");

		driver.findElement(By.xpath(".//*[@id='TabTitle__Provider']")).click();
		Select DropCourseProvider = new Select(driver.findElement(By.xpath(".//*[@id='C_CrsPrv_main_1']/select")));
		DropCourseProvider.selectByValue("ARTHR");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		// driver.switchTo().defaultContent();
		System.out.println("Course Created");
		// driver.switchTo().defaultContent();

		// driver.switchTo().frame("dsp");
		// driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("Applied Stats");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		String Course = driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).getText();
		s_assert.assertEquals(Course, "Applied Stats");

		String CourseTitle = driver.findElement(By.xpath(".//*[@id='C_CrsTitle_main_1']")).getText();
		s_assert.assertEquals(CourseTitle, "App Stats");

		System.out.println("Course Creation Verfied");

		// driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_RvwCrsSkl_main_1']")).click();

		driver.switchTo().defaultContent();
		System.out.println("Click Course skill");
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		System.out.println("Enter the Skill");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("Applied Stats");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		Select DropSkill = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkill.selectByValue("ACTG");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Skill Saved to Course");

		String SkillCourse = driver.findElement(By.xpath(".//*[@id='C_CrsName_main_1']")).getText();
		s_assert.assertEquals(SkillCourse, "Applied Stats( App Stats)");

		String Skill = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(Skill, "ACTG");

		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();

		Select DropSkillEdit = new Select(driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']/select")));
		DropSkillEdit.selectByValue("ANALYSIS");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Edited Skill Saved to Course");

		String SkillCourseEd = driver.findElement(By.xpath(".//*[@id='C_CrsName_main_1']")).getText();
		s_assert.assertEquals(SkillCourseEd, "Applied Stats( App Stats)");

		String SkillEd = driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).getText();
		s_assert.assertEquals(SkillEd, "ANALYSIS");

		System.out.println("Edited Skill Verified");

		driver.findElement(By.xpath(".//*[@id='C_Skl_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertSkillDel = driver.switchTo().alert();
		alertSkillDel.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_RvwCrsFind_main_1']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']/input[2]")).sendKeys("Applied Stats");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_Crs_main_1']")).click();
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

	@Test(enabled = true, priority = 8, groups = {"Smoke" , "Nightly" })
	public void verifyCreateNewBusinessEntityGoal() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CmpGol_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleBusinessEntPage = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleBusinessEntPage, "Business Entity Goals");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Select DropCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Cmp_main_1']/select")));
		DropCompany.selectByValue("NuCo");
		driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_1']/input[2]")).sendKeys("Perf Samp Goal");
		driver.findElement(By.xpath(".//*[@id='C_CmpGolStrDt_main_1']/input[2]")).sendKeys("08/15/2016");
		driver.findElement(By.xpath(".//*[@id='C_CmpGolEndDt_main_1']/input[2]")).sendKeys("08/30/2016");
		

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Position Created");
		
	/*	try{
			webtableclass2(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "NuCo");
			//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		   // log.debug("Exception in finding date");
		  //  log.debug(e);
		    webtableclass2(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "NuCo");
		    //WebElement date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
		   // driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}*/
		
	/*	try{
			webtableclass3(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "NuCo", "link", 0);
			//driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		   // log.debug("Exception in finding date");
		  //  log.debug(e);
		    webtableclass3(driver, ".//*[@id='Datasheet-_main_1_Body']/table", "NuCo", "link", 0);
		    //WebElement date = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[4]/a/font"));
		   // driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		}*/
		
		String TitleCompany = driver.findElement(By.xpath(".//*[@id='C_Cmp_main_3']")).getText();
		s_assert.assertEquals(TitleCompany, "NuCo");
		String CompanyGoalName = driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_3']")).getText();
		s_assert.assertEquals(CompanyGoalName, "Perf Samp Goal");

		driver.findElement(By.xpath(".//*[@id='C_Cmp_main_3']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 9, groups = {"Smoke" , "Nightly" })
	public void verifyEditNewlyBusinessEntityGoal() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_CmpGol_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleBusinessEntPage = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleBusinessEntPage, "Business Entity Goals");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Select DropCompany = new Select(driver.findElement(By.xpath(".//*[@id='C_Cmp_main_1']/select")));
		DropCompany.selectByValue("NuCo");
		driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_1']/input[2]")).sendKeys("Perf Samp Goal");
		driver.findElement(By.xpath(".//*[@id='C_CmpGolStrDt_main_1']/input[2]")).sendKeys("08/15/2016");
		driver.findElement(By.xpath(".//*[@id='C_CmpGolEndDt_main_1']/input[2]")).sendKeys("08/30/2018");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Business goal Created");
		String TitleCompany = driver.findElement(By.xpath(".//*[@id='C_Cmp_main_2']")).getText();
		s_assert.assertEquals(TitleCompany, "NuCo");
		String CompanyGoalName = driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_2']")).getText();
		s_assert.assertEquals(CompanyGoalName, "Perf Samp Goal");

		driver.findElement(By.xpath(".//*[@id='C_Cmp_main_2']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_1']/input[2]")).clear();

		driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_1']/input[2]")).sendKeys("Perf Samp Goal Edit");

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		System.out.println("Business goal edited");

		String CompanyGoalNameEd = driver.findElement(By.xpath(".//*[@id='C_EntGolName_main_2']")).getText();
		s_assert.assertEquals(CompanyGoalNameEd, "Perf Samp Goal Edit");

		driver.findElement(By.xpath(".//*[@id='C_Cmp_main_2']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 10, groups = {"Smoke" , "Nightly" })
	public void verifyCreateNewPerfCompModel() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EAHAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleBusinessEntPage = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleBusinessEntPage, "Performance Components Model");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']/input[2]")).sendKeys("Individual Perf");
		driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_1']/input[2]")).sendKeys("Ind Perf");
		driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlDesc_main_1']/textarea"))
		.sendKeys("This is a Sample Per Model");
		driver.findElement(By.xpath(".//*[@id='C_GolPctTot_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_GolPctTot_main_1']/input[2]")).sendKeys("25.00");
		driver.findElement(By.xpath(".//*[@id='C_SklPctTot_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_SklPctTot_main_1']/input[2]")).sendKeys("25.00");
		driver.findElement(By.xpath(".//*[@id='C_JobAccPctTot_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_JobAccPctTot_main_1']/input[2]")).sendKeys("25.00");
		driver.findElement(By.xpath(".//*[@id='C_PrfFctPctTot_main_1']/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='C_PrfFctPctTot_main_1']/input[2]")).sendKeys("25.00");
		Actions act = new Actions(driver);
		act.moveToElement(driver
				.findElement(By.xpath(".//*[@id='C_GeneralCommentsTo_main_1']/table/tbody/tr/td[1]/select/option[1]")))
		.doubleClick().build().perform();
		driver.findElement(By.xpath(".//*[@id='C_DatasheetNew_PrfCompStp_PrfCompStp_0']")).click();
		Select DropPerfComp = new Select(driver.findElement(By.xpath(".//*[@id='C_PrfComp_PrfCompStp_0']/select")));
		DropPerfComp.selectByValue("EmpGol");
		driver.findElement(By.xpath(".//*[@id='C_DatasheetOk_PrfCompStp_PrfCompStp_0']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Perf Component Model Created");
		String PerfCompModel = driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).getText();
		s_assert.assertEquals(PerfCompModel, "Individual Perf");
		String PerfCompModelName = driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_2']")).getText();
		s_assert.assertEquals(PerfCompModelName, "Ind Perf");

		driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 11, groups = {"Smoke" , "Nightly" })
	public void verifyUserAbleToAssignGoalToEmp() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleReviewPeriod = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleReviewPeriod, "Review Period");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']/input[2]")).sendKeys("TestVishal");
		driver.findElement(By.xpath(".//*[@id='C_RvwDt_main_1']/input[2]")).sendKeys("08/01/2016");
		Select DropReviewCycle = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']/select")));
		DropReviewCycle.selectByValue("Periodic");
		Actions PerfGrp = new Actions(driver);
		PerfGrp.moveToElement(
				driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']/table/tbody/tr/td[1]/select/option[1]")))
		.doubleClick().build().perform();
		Select PerfCompModel = new Select(driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']/select")));
		PerfCompModel.selectByValue("Company");
		driver.findElement(By.xpath(".//*[@id='C_RvwPdStDt_main_1']/input[2]")).sendKeys("08/01/2016");

		driver.findElement(By.xpath(".//*[@id='C_RvwPdEndDt_main_1']/input[2]")).sendKeys("08/01/2021");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
		driver.switchTo().defaultContent();

		System.out.println("Review Period Created");
		/*
		 * String PerfCompModel =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModel, "Individual Perf");
		 * String PerfCompModelName =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModelName, "Ind Perf");
		 */
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_PerfEmpGol_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Felicia");

		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");

		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		String PerGoalTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PerGoalTitle, "Personal Goals");
		String PersGoalEmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(PersGoalEmpName, "Adams, Felicia");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		Select RevPeriod = new Select(driver.findElement(By.xpath(".//*[@id='C_SysRvwYrPdCycDt_main_1']/select")));
		RevPeriod.selectByValue("2016TestVishal_Periodic (20160801)");

		driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']/input[2]")).sendKeys("Performance Goal");
		driver.findElement(By.xpath(".//*[@id='C_EmpGolName_main_1']/input[2]")).sendKeys("PerfGoal");

		Select GoalStatus = new Select(driver.findElement(By.xpath(".//*[@id='C_EmpGolSts_main_1']/select")));
		GoalStatus.selectByValue("Not Started");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PerGoalTitle1 = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PerGoalTitle1, "Personal Goals");
		String PersGoalEmpName1 = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(PersGoalEmpName1, "Adams, Felicia");

		String RevYear = driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']")).getText();
		s_assert.assertEquals(RevYear, "2016");
		String RevPeriod1 = driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).getText();
		s_assert.assertEquals(RevPeriod1, "TestVishal");

		String Goal = driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']")).getText();
		s_assert.assertEquals(Goal, "Performance Goal");

		String GoalStatus1 = driver.findElement(By.xpath(".//*[@id='C_EmpGolSts_main_1']")).getText();
		s_assert.assertEquals(GoalStatus1, "Not Started");

		driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");

		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 12, groups = {"Smoke" , "Nightly" })
	public void verify_user_is_able_to_CreatePeriodicMngRevPrdEmpMngrObjectives() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		String CurrentAdd10 = new CommonFunctions().GetCurrentDateAdd10();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleReviewPeriod = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleReviewPeriod, "Review Period");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']/input[2]")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='C_RvwDt_main_1']/input[2]")).sendKeys(Current);
		Select DropReviewCycle = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']/select")));
		DropReviewCycle.selectByValue("Periodic");
		Actions PerfGrp = new Actions(driver);
		PerfGrp.moveToElement(
				driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']/table/tbody/tr/td[1]/select/option[5]")))
		.doubleClick().build().perform();
		Select PerfCompModel = new Select(driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']/select")));
		PerfCompModel.selectByValue("Company");
		Select PerfCompModelProc = new Select(driver.findElement(By.xpath(".//*[@id='C_JobGolRvwPrc_main_1']/select")));
		PerfCompModelProc.selectByValue("EM");
		driver.findElement(By.xpath(".//*[@id='C_RvwPdStDt_main_1']/input[2]")).sendKeys(Current);

		driver.findElement(By.xpath(".//*[@id='C_RvwPdEndDt_main_1']/input[2]")).sendKeys(CurrentAdd10);
		driver.findElement(By.xpath(".//*[@id='C_RvwSlf_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Review Period Created");
		/*
		 * String PerfCompModel =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModel, "Individual Perf");
		 * String PerfCompModelName =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModelName, "Ind Perf");
		 */

		// driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		String ReviewYr = driver.findElement(By.xpath(".//*[@id='C_LblRvwYr_main_1']")).getText();
		s_assert.assertEquals(ReviewYr, "2016");
		String ReviewCycle = driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']")).getText();
		s_assert.assertEquals(ReviewCycle, "Periodic");
		String ReviewPrd = driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).getText();
		s_assert.assertEquals(ReviewPrd, "1");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	@Test(enabled = true, priority = 13, groups = {"Smoke" , "Nightly" })
	public void verify_user_is_able_to_CreateGoalsforEmp() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		String CurrentAdd10 = new CommonFunctions().GetCurrentDateAdd10();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleReviewPeriod = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleReviewPeriod, "Review Period");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']/input[2]")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='C_RvwDt_main_1']/input[2]")).sendKeys(Current);
		Select DropReviewCycle = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']/select")));
		DropReviewCycle.selectByValue("Periodic");
		Actions PerfGrp = new Actions(driver);
		PerfGrp.moveToElement(
				driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']/table/tbody/tr/td[1]/select/option[5]")))
		.doubleClick().build().perform();
		Select PerfCompModel = new Select(driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']/select")));
		PerfCompModel.selectByValue("Company");
		Select PerfCompModelProc = new Select(driver.findElement(By.xpath(".//*[@id='C_JobGolRvwPrc_main_1']/select")));
		PerfCompModelProc.selectByValue("EM");
		driver.findElement(By.xpath(".//*[@id='C_RvwPdStDt_main_1']/input[2]")).sendKeys(Current);

		driver.findElement(By.xpath(".//*[@id='C_RvwPdEndDt_main_1']/input[2]")).sendKeys(CurrentAdd10);
		driver.findElement(By.xpath(".//*[@id='C_RvwSlf_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Review Period Created");
		/*
		 * String PerfCompModel =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModel, "Individual Perf");
		 * String PerfCompModelName =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModelName, "Ind Perf");
		 */

		// driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		String ReviewYr = driver.findElement(By.xpath(".//*[@id='C_LblRvwYr_main_1']")).getText();
		s_assert.assertEquals(ReviewYr, "2016");
		String ReviewCycle = driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']")).getText();
		s_assert.assertEquals(ReviewCycle, "Periodic");
		String ReviewPrd = driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).getText();
		s_assert.assertEquals(ReviewPrd, "1");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_PerfEmpGol_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");

		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Parker");
		driver.findElement(By.xpath(".//*[@id='C_FirstName_main_1']/input[2]")).sendKeys("Connie");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String SearchName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(SearchName, "Parker, Connie");
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
		String PerGoalTitle = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PerGoalTitle, "Personal Goals");
		Select AddReviewPrd = new Select(driver.findElement(By.xpath(".//*[@id='C_SysRvwYrPdCycDt_main_1']/select")));
		// AddReviewPrd.selectByValue("Company");
		AddReviewPrd.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']/input[2]")).sendKeys("Test1");
		driver.findElement(By.xpath(".//*[@id='C_EmpGolName_main_1']/input[2]")).sendKeys("Test1");
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		String PerGoalTitle1 = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]"))
				.getText();
		s_assert.assertEquals(PerGoalTitle1, "Personal Goals");
		String EmpName = driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpName, "Parker, Connie");
		String GoalName = driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']")).getText();
		s_assert.assertEquals(GoalName, "Test1");
		System.out.println("Goal Assigned to Employee");
		driver.findElement(By.xpath(".//*[@id='C_EmpGol_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}

	/*@Test(enabled = true, priority = 14)
	public void verify_user_is_able_to_OpenPerfObjectives() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("nvsuperuser1", "nuview");
		String Current = new CommonFunctions().GetCurrentDate();
		String CurrentAdd10 = new CommonFunctions().GetCurrentDateAdd10();
		String NextDay = new CommonFunctions().GetCurrentDateAdd1();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Performance']")).click();
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		// driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']")).click();

		// driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("dsp")));
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		// driver.switchTo().frame("edit");

		String TitleReviewPeriod = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(TitleReviewPeriod, "Review Period");

		driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']/input[2]")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='C_RvwDt_main_1']/input[2]")).sendKeys(Current);
		Select DropReviewCycle = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']/select")));
		DropReviewCycle.selectByValue("Periodic");
		Actions PerfGrp = new Actions(driver);
		PerfGrp.moveToElement(
				driver.findElement(By.xpath(".//*[@id='C_PrfGrp_main_1']/table/tbody/tr/td[1]/select/option[5]")))
		.doubleClick().build().perform();
		Select PerfCompModel = new Select(driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_1']/select")));
		PerfCompModel.selectByValue("Company");
		Select PerfCompModelProc = new Select(driver.findElement(By.xpath(".//*[@id='C_JobGolRvwPrc_main_1']/select")));
		PerfCompModelProc.selectByValue("EM");
		driver.findElement(By.xpath(".//*[@id='C_RvwPdStDt_main_1']/input[2]")).sendKeys(Current);

		driver.findElement(By.xpath(".//*[@id='C_RvwPdEndDt_main_1']/input[2]")).sendKeys(CurrentAdd10);
		driver.findElement(By.xpath(".//*[@id='C_RvwSlf_main_1']/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();

		System.out.println("Review Period Created");
		
		 * String PerfCompModel =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdl_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModel, "Individual Perf");
		 * String PerfCompModelName =
		 * driver.findElement(By.xpath(".//*[@id='C_PrfCompMdlName_main_2']")).
		 * getText(); s_assert.assertEquals(PerfCompModelName, "Ind Perf");
		 

		// driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		// driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		String ReviewYr = driver.findElement(By.xpath(".//*[@id='C_LblRvwYr_main_1']")).getText();
		s_assert.assertEquals(ReviewYr, "2016");
		String ReviewCycle = driver.findElement(By.xpath(".//*[@id='C_RvwCyc_main_1']")).getText();
		s_assert.assertEquals(ReviewCycle, "Periodic");
		String ReviewPrd = driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).getText();
		s_assert.assertEquals(ReviewPrd, "1");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		Select SearchReviewPrd = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']/select")));
		// AddReviewPrd.selectByValue("Company");
		SearchReviewPrd.selectByValue("1");

		// driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_JobGolOpenBtn_main_1']")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		driver.switchTo().defaultContent();

		Thread.sleep(30000);
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_ToDo_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.findElement(By.xpath(".//*[@id='C_StartDt_none_1']/input[2]")).sendKeys(Current);
		driver.findElement(By.xpath(".//*[@id='C_EndDt_none_1']/input[2]")).sendKeys(NextDay);
		driver.findElement(By.xpath(".//*[@id='C_Search_none_1']")).click();

		String ToDoName = driver.findElement(By.xpath(".//*[@id='C_Dsp_main_1']")).getText();
		s_assert.assertEquals(ToDoName, "Performance Objectives Review Open Workflow");

		String Status = driver.findElement(By.xpath(".//*[@id='C_Sts_main_1']")).getText();
		s_assert.assertEquals(Status, "Completed");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");

		driver.findElement(By.xpath(".//*[@id='C_RvwYr_main_1']/input[2]")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();

		driver.findElement(By.xpath(".//*[@id='C_RvwPd_main_1']")).click();

		driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();

		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
		driver.switchTo().defaultContent();
		logOut();
		s_assert.assertAll();

	}
	
	@Test(enabled = true, priority = 15)
	public void verify_ESS_Employee_Able_SubmitPerformanceobj() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("cparker", "nuview");
		
		Thread.sleep(10000);
		//driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[3]/div[2]/ul/li[2]/a")).click();

		Thread.sleep(15000);
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		//driver.switchTo().frame("New Dependent(s)Dialog");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("Update ObjectivesDialog");
		
		String PersPerformanceObjTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersPerformanceObjTitle, "Performance Objectives");
		driver.findElement(By.xpath(".//*[@id='C_LnkEmp_main_1']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='C_SysNewGoalGenComments_main_1']/input[2]")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_RvwItmMsr_SkillJobGolRvwDtl_1']/textarea")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_PctComplete_SkillJobGolRvwDtl_1']/input[2]")).sendKeys("10");
		Select DropWeight = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwItmWgt_SkillJobGolRvwDtl_1']/select")));
		DropWeight.selectByValue("1");
		driver.findElement(By.xpath(".//*[@id='C_SaveBtn_EmpCom_1']")).click();
		//driver.findElement(By.xpath(".//*[@id='C_EmpSubBtn_EmpCom_1']")).click();
		//Alert alertOK1 = driver.switchTo().alert();
		//alertOK1.accept();
	
		
		System.out.println("ESS Employee Submitted the performance objectives Complete");
		
		driver.findElement(By.xpath(".//*[@id='C_LnkEmp_main_1']")).click();
		
		driver.findElement(By.xpath(".//*[@id='C_RvwItmMsr_SkillJobGolRvwDtl_1']/textarea")).clear();
		driver.findElement(By.xpath(".//*[@id='C_PctComplete_SkillJobGolRvwDtl_1']/input[2]")).clear();
		Select DropWeightC = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwItmWgt_SkillJobGolRvwDtl_1']/select")));
		DropWeightC.selectByValue("");
		driver.findElement(By.xpath(".//*[@id='C_SaveBtn_EmpCom_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='logout']/img")).click();

		s_assert.assertAll();

		

	}


	//Run and Verify it before committing
	@Test(enabled = true, priority = 16)
	public void verify_ESS_Manager_Approves_Performanceobj() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initBrowser();
		driver.get(Locators.NuviewURL);
		// Enter your real Userd ID and Password of FB bellow.
		logIn("cparker", "nuview");
		
		Thread.sleep(10000);
		//driver.switchTo().frame("login");
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='menu_icon_1']/span"));
		action.moveToElement(mainMenu).build().perform();
		// Thread.sleep(5000L);
		driver.findElement(By.xpath(".//*[@id='menu_icon_1-menu']/div[3]/div[2]/ul/li[2]/a")).click();

		Thread.sleep(15000);
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("login");
		// driver.switchTo().frame(driver.findElement(By.name("Direct
		// DepositDialog")));
		//driver.switchTo().frame("New Dependent(s)Dialog");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("Update ObjectivesDialog");
		
		String PersPerformanceObjTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(PersPerformanceObjTitle, "Performance Objectives");
		driver.findElement(By.xpath(".//*[@id='C_LnkEmp_main_1']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='C_SysNewGoalGenComments_main_1']/input[2]")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_RvwItmMsr_SkillJobGolRvwDtl_1']/textarea")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_PctComplete_SkillJobGolRvwDtl_1']/input[2]")).sendKeys("10");
		Select DropWeight = new Select(driver.findElement(By.xpath(".//*[@id='C_RvwItmWgt_SkillJobGolRvwDtl_1']/select")));
		DropWeight.selectByValue("1");
		//driver.findElement(By.xpath(".//*[@id='C_SaveBtn_EmpCom_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_EmpSubBtn_EmpCom_1']")).click();
		Alert alertOK1 = driver.switchTo().alert();
		alertOK1.accept();
	
		
		System.out.println("ESS Employee Submitted the performance objectives Complete");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.findElement(By.xpath(".//*[@id='logout']/img")).click();
		
		logIn("ckearney", "nuview");
		
		driver.switchTo().frame("nav");
		driver.findElement(By.xpath(".//*[@id='TabTitle_Menu_Managers']")).click();
		driver.findElement(By.xpath(".//*[@id='Branch_Title_ID0EDCAANA']")).click();
		driver.findElement(By.xpath(".//*[@id='C_MSSGolPln_main_1']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		String ManagerObjectiveTitle = driver
				.findElement(By.xpath("html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]")).getText();
		s_assert.assertEquals(ManagerObjectiveTitle, "Managed Employees");
		
		driver.findElement(By.xpath(".//*[@id='C_LastName_main_1']/input[2]")).sendKeys("Parker");
		driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("list");
		String EmpSearch = driver
				.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).getText();
		s_assert.assertEquals(EmpSearch, "Parker, Connie");
		
		driver.findElement(By.xpath(".//*[@id='C_FullName_main_1']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("login");
		driver.switchTo().frame("dsp");
		driver.switchTo().frame("edit");
		
		driver.findElement(By.xpath(".//*[@id='C_LnkEmp_main_1']")).click();
		driver.findElement(By.xpath(".//*[@id='C_SysNewGoalGenComments_main_1']/input[2]")).sendKeys("Test");
		driver.findElement(By.xpath(".//*[@id='C_SaveBtn_EmpCom_1']")).click();
		
		driver.switchTo().defaultContent();
		logOut();
		
		s_assert.assertAll();

		

	}
*/
}
