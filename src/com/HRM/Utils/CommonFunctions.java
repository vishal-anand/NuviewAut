package com.HRM.Utils;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.asserts.SoftAssert;

import com.HRM.Locators.Locators;



public class CommonFunctions {
public static WebDriver element ;
public static WebDriver driver=null; 
public boolean browserAlreadyOpen=false;
public static Properties SYSPARAM =null;
public boolean isAlreadyLogIn=false;
static SoftAssert s_assert = new SoftAssert();
public static Logger log = Logger.getLogger("devpinoyLogger");

//public static Logger log4jlogger =Logger.getLogger(CommonFunctions.class.getName());

//To Initialize .properties file.
public void initData() throws IOException{
 SYSPARAM = new Properties();
 FileInputStream Ist = new FileInputStream(System.getProperty("user.dir")+"//src//Properties//SYSPARAM.properties");
 SYSPARAM.load(Ist);
 
}

public static void clickWebelement(WebElement element) {
	try {
		boolean elementIsClickable = element.isEnabled();
		while (elementIsClickable) {
			element.click();
		}

	} catch (Exception e) {
		System.out.println("Element is not enabled");
		e.printStackTrace();
	}
}

public static void clickCheckboxFromList(String xpathOfElement,
		String valueToSelect) {

	List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
	for (int i = 0; i < lst.size(); i++) {
		List<WebElement> dr = lst.get(i).findElements(By.tagName("display"));
		for (WebElement f : dr) {
			System.out.println("value in the list : " + f.getText());
			if (valueToSelect.equals(f.getText())) {
				f.click();
				break;
			}
		}
	}
}

public void EnterText(String element, String text) {

	driver.findElement(By.xpath(element)).sendKeys(text);

	System.out.println("Entered:" + text);
	
	
}

public  void SelectDropDownValue(String element, String obj) {
	Select select = new Select(driver.findElement(By.xpath(element)));
	select.selectByValue(obj);
	System.out.println("Selected the Value:" + obj);
	//selectByVisibleText(obj);
	
}

public  void SelectDropDownIndex(String element, int index) {
	Select select = new Select(driver.findElement(By.xpath(element)));
	select.selectByIndex(index);
	//.selectByValue(obj);
	//System.out.println("Selected the Value:" + obj);
	//selectByVisibleText(obj);
	
}

/*public static void radiobutton_Select(WebElement Radio) {
	boolean checkstatus;
	checkstatus = Radio.isSelected();
	if (checkstatus == true) {
		System.out.println("RadioButton is already checked");
	} else {
		Radio.click();
		System.out.println("Selected the Radiobutton");
	}
}*/

public static void radiobutton_Select(String xpath) {
	boolean checkstatus;
	WebElement Radio = driver.findElement(By.xpath(xpath));
	checkstatus = Radio.isSelected();
	if (checkstatus == true) {
		System.out.println("RadioButton is already checked");
	} else {
		Radio.click();
		System.out.println("Selected the Radiobutton");
	}
}


public void initBrowser(){
 //Check If browser Is already opened during previous test execution.
 if(!browserAlreadyOpen){
  //Read value of 'BrowserToTestIn' key from SYSPARAM.properties file.
  //If key value Is MMF then execute If statement
  //If key value Is CHRM then execute else statement.
  if(SYSPARAM.getProperty("BrowserToTestIn").equals("MFF")){
   driver = new FirefoxDriver(); 
  
   log.info("Firefox Browser Initialised");
   
   
   
  }else if(SYSPARAM.getProperty("BrowserToTestIn").equals("CHRM")){
   //Write lines to open chrome browser.
	//  For Windows
  // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
	  //For MAc
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver");
	  driver = new ChromeDriver();
   log.info("Chrome Browser Initialised");

  }
  else if(SYSPARAM.getProperty("BrowserToTestIn").equals("IE")){
	   //Write lines to open IE browser.
	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		
		log.info("IE Browser Initialised");

	  }
 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 driver.manage().window().maximize();
 //At last browserAlreadyOpen flag will becomes true to not open new browser when start executing next test.
 browserAlreadyOpen=true;
 }
}



public static void webtableElementGetText(String xpath, String strText)
{
//WebElement ele1 = driver.findElement(By.xpath(xpath));
List<WebElement> allElements=driver.findElements(By.xpath(xpath));

for(WebElement ele: allElements)
{
	
	String PrefixName=ele.getText();
			//getAttribute("display");
		//	getText();
	//System.out.println("Name:"+ PrefixName);
	
	
	if(PrefixName.equalsIgnoreCase(strText)){
		System.out.println("Text Found:" + PrefixName);
	   
        s_assert.assertTrue(true, "Pass");
	    
	    	break;
	    }
	    else {
	    	continue;
	    }
	    

	
}
}

public static void webtableElementTextAssert(String xpath, String strText)
{
//WebElement ele1 = driver.findElement(By.xpath(xpath));
List<WebElement> allElements=driver.findElements(By.xpath(xpath));

for(WebElement ele: allElements)
{
	
	String PrefixName=ele.getText();
			//getAttribute("display");
		//	getText();
	//System.out.println("Name:"+ PrefixName);
	
	
	if(PrefixName.equalsIgnoreCase(strText)){
		System.out.println("Text Found:" + PrefixName);
	   
        s_assert.assertTrue(true, "Pass");
	    
	    	break;
	    }
	    else {
	    	continue;
	    }
	    
	
	//	ele.findElement(By.className(strLink)).click();
		
	//	ele.getAttribute("link")
		//String s= ele.getAttribute("id");
		//System.out.println(s);
		//ele.click();
		//break;
	
	
}
}

public static void webtableElementClick(String xpath, String strText, String strLink)
{
//WebElement ele1 = driver.findElement(By.xpath(xpath));
List<WebElement> allElements=driver.findElements(By.xpath(xpath));

for(WebElement ele: allElements)
{
	
	String PrefixName=ele.getText();
			//getAttribute("display");
		//	getText();
	//System.out.println("Name:"+ PrefixName);
	
	
	if(PrefixName.equalsIgnoreCase(strText)){
		System.out.println("Text Found:" + PrefixName);
	    ele.findElement(By.className(strLink)).click();
        s_assert.assertTrue(true, "Pass");
	    
	    	break;
	    }
	    else {
	    	continue;
	    }
	    
	
	//	ele.findElement(By.className(strLink)).click();
		
	//	ele.getAttribute("link")
		//String s= ele.getAttribute("id");
		//System.out.println(s);
		//ele.click();
		//break;
	
	
}
}

public static void webtableclass(WebDriver driver, String xpath, String strText, String strLink, int colVal)
{ 
WebElement tblData = driver.findElement(By.xpath(xpath));

List<WebElement> tblRows = tblData.findElements(By.tagName("tr"));

for (WebElement tblRow: tblRows)
{
List<WebElement> tblCols = tblRow.findElements(By.tagName("td"));

for (WebElement tblCol: tblCols)
{
if(tblCol.getText().equals(strText))
	//System.out.println("Found the Txt" +tblCol.getText());
{
List<WebElement> actions = tblCols.get(colVal).findElements(By.tagName(strLink));
actions.get(0).click();
}
}
}
}

public static void webtableclass1(WebDriver driver, String xpath, String strText, String strLink)
{ 
WebElement tblData = driver.findElement(By.xpath(xpath));

List<WebElement> tblRows = tblData.findElements(By.tagName("tr"));

for (WebElement tblRow: tblRows)
	//System.out.println("Found the Txt: " + tblRow.getText());

{
List<WebElement> tblCols = tblData.findElements(By.tagName("td"));

for (WebElement tblCol: tblCols)
	System.out.println("Found the Txt: " + tblCol.getText());
{

if(tblData.getText().equals(strText))
	System.out.println("Found the Txt: " + tblData.getText());
{
//List<WebElement> actions = tblCols.get(colVal).findElements(By.tagName(strLink));
//actions.get(0).click();
	tblData.findElement(By.className(strLink)).click();
	
	break;
	
}
}
}
}

public static void webtableclass2(WebDriver driver, String xpath, String strText)
{ 
WebElement tblData = driver.findElement(By.xpath(xpath));

List<WebElement> tblRows = tblData.findElements(By.tagName("tr"));

for (WebElement tblRow: tblRows)
{
List<WebElement> tblCols = tblRow.findElements(By.tagName("td"));

for (WebElement tblCol: tblCols)
{
if(tblCol.getText().equals(strText))
	//System.out.println("Found the Txt: " + tblCol.getText());
{
//List<WebElement> actions = tblCols.get(colVal).findElements(By.tagName(strLink));
//actions.get(0).click();
	//String Actual = tblData.findElement(By.className(Txt)).getAttribute("display");
	//s_assert.assertEquals(Actual, strText);
	System.out.println("Found"+ tblCol.getText());
}
}
}
}

public static void webtableclass3(WebDriver driver, String xpath, String strText, String strLink, int colVal)
{ 
WebElement tblData = driver.findElement(By.xpath(xpath));

List<WebElement> tblRows = tblData.findElements(By.tagName("tr"));

for (WebElement tblRow: tblRows)
{
List<WebElement> tblCols = tblRow.findElements(By.tagName("td"));

for (WebElement tblCol: tblCols)
{
if(tblCol.getText().equals(strText))


   log.debug("Found the Txt: " + tblCol.getText());
{
List<WebElement> actions = tblCols.get(colVal).findElements(By.className((strLink)));
actions.get(0).click();
	//tblCol.findElement(By.partialLinkText(strLink)).click();
	
}
}
}
}

/*public void initBrowser(String browser){
	if(!browserAlreadyOpen)
	try {
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		browserAlreadyOpen=true;

	} catch (WebDriverException e) {
		System.out.println(e.getMessage());

	}
	 //Check If browser Is already opened during previous test execution.
	
	}*/

//Can accept userID and password as a string
public void logIn(String userID, String password) throws InterruptedException{
 //To check If already login previously then don't execute this function.
 if(!isAlreadyLogIn){
  //If Not login then login In to your account.
  driver.switchTo().frame("login");
  driver.findElement(By.xpath(Locators.Username)).sendKeys(userID);
  driver.findElement(By.xpath(Locators.Password)).sendKeys(password);
  driver.findElement(By.xpath(Locators.LoginBtn)).click();
  Thread.sleep(5000);
  //driver.switchTo().defaultContent();
  isAlreadyLogIn=true;
 }
}

public void logInN(String userID, String password){
	 //To check If already login previously then don't execute this function.
	
	  //If Not login then login In to your account.
	  driver.switchTo().frame("login");
	  driver.findElement(By.xpath(Locators.Username)).sendKeys(userID);
	  driver.findElement(By.xpath(Locators.Password)).sendKeys(password);
	  driver.findElement(By.xpath(Locators.LoginBtn)).click();
	  //driver.switchTo().defaultContent();
	
	 
	}

public static WebElement getObject(String xpathKey) {
    try{
          return driver.findElement(By.xpath(xpathKey));
    }catch(Throwable t){
          // report error
         // takeScreenShot(xpathKey);
         // Assert.assertTrue(t.getMessage(),false);
          s_assert.assertTrue(false, t.getMessage());
        //  assertTrue(t.getMessage(),false);
         
          return null;
    }

   
}


public static void doubleClick(String xpath)
		throws InterruptedException {
	
	WebElement element = driver.findElement(By.xpath(xpath));
	Actions builder = new Actions(driver);
	builder.doubleClick(element).perform();
	Thread.sleep(2000);

}

public static void Click(String element) {
	try {
		
		 driver.findElement(By.xpath(element)).click();
		 System.out.println("Element Clicked");
		//boolean elementIsClickable = element.isEnabled();
		//while (elementIsClickable) {
		//	element.click();
		

	}
	catch (Exception e) {
		System.out.println("Element is not enabled");
		e.printStackTrace();
	}

 
}

public static void Add() throws InterruptedException {
	driver.findElement(By.xpath(".//*[@id='C_Add_Img']")).click();
	Thread.sleep(5000);
    log.debug("Creating Element");
	
}

public boolean isAlertPresent() {
    try {
        driver.switchTo().alert();
        return true;
    } // try
    catch (Exception e) {
        return false;
    } // catch
}

protected static boolean isDialogPresent() {
    try {
        driver.getTitle();
        return true;
    } catch (UnhandledAlertException e) {
        // Modal dialog showed
        return false;
    }
}

public static void Find() throws InterruptedException {
	driver.findElement(By.xpath(".//*[@id='C_Find_Img']")).click();
	Thread.sleep(5000);
    log.debug("Finding Search Element");
	
}


public static void Save() throws InterruptedException {
	driver.findElement(By.xpath(".//*[@id='C_Save_Img']")).click();
	Thread.sleep(5000);
    log.debug("Record Saved");
	
}


public static void Delete() throws InterruptedException {
	driver.findElement(By.xpath(".//*[@id='C_Delete_Img']")).click();
	checkAlert_Accept();
	Thread.sleep(5000);
    log.debug("Webelement Deleted");
	//Alert alertOK = driver.switchTo().alert();
	//alertOK.accept();
}

public static boolean checkAlert_Accept() {
	try {
		Alert a = driver.switchTo().alert();
		String str = a.getText();
		System.out.println(str);

		a.accept();
		return true;

	} catch (Exception e) {

		System.out.println("no alert ");
		return false;

	}
}


public static void switchToNewWindow() {
Set<String> s = driver.getWindowHandles();
Iterator<String> itr = s.iterator();
String w1 = (String) itr.next();
String w2 = (String) itr.next();
driver.switchTo().window(w2);

}

public static void switchToOldWindow() {
Set<String> s = driver.getWindowHandles();
Iterator<String> itr = s.iterator();
String w1 = (String) itr.next();
String w2 = (String) itr.next();
driver.switchTo().window(w1);
}

public static void switchToOldWindowClose() {
Set<String> s = driver.getWindowHandles();
Iterator<String> itr = s.iterator();
String w1 = (String) itr.next();
//String w2 = (String) itr.next();
driver.switchTo().window(w1);
}

public void Switch2LeftLogin()
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	//driver.switchTo().defaultContent();
	driver.switchTo().parentFrame();
	driver.switchTo().frame("login");
	driver.switchTo().frame("nav");

}


public void Switch2Left() throws InterruptedException
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	driver.switchTo().frame("login");
	driver.switchTo().frame("nav");

}

public void Switch2Middle() throws InterruptedException
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	driver.switchTo().frame("login");
	driver.switchTo().frame("dsp");
	driver.switchTo().frame("edit");

}

public void Switch2Right() throws InterruptedException
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	driver.switchTo().frame("login");
	driver.switchTo().frame("dsp");
	driver.switchTo().frame("list");

}

public void Switch2MidException() throws InterruptedException
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	driver.switchTo().frame("login");
	driver.switchTo().frame("dsp");

}

public int GetCurrentYear() {
	  

	int year = Calendar.getInstance().get(Calendar.YEAR);
    return year;
	   //get current date time with Calendar()
	 //  Calendar cal = Calendar.getInstance();
	 //  System.out.println(dateFormat.format(cal.getTime()));


}


public String GetCurrentDate() {
  

	   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
       return dateFormat.format(date);
	   //get current date time with Calendar()
	 //  Calendar cal = Calendar.getInstance();
	 //  System.out.println(dateFormat.format(cal.getTime()));

  
}

public String GetCurrentDateAdd10() {
	  

	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, 10);
	 return dateFormat.format(cal.getTime());
	 // System.out.println(dateFormat.format(cal.getTime()));


}

public String GetCurrentDateAdd1() {
	  

	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, 1);
	 return dateFormat.format(cal.getTime());
	 // System.out.println(dateFormat.format(cal.getTime()));


}

public String GetCurrentDateSub5() {
	  

	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, -5);
	 return dateFormat.format(cal.getTime());
	 // System.out.println(dateFormat.format(cal.getTime()));


}

public String GetCurrentDateAdd2() {

	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, 2);
	 return dateFormat.format(cal.getTime());
	 // System.out.println(dateFormat.format(cal.getTime()));

}


public String GetTplus1day() {
	
	  

	 DateFormat dateFormat = new SimpleDateFormat("dd");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, 1);
	 return dateFormat.format(cal.getTime());
	//  System.out.println(dateFormat.format(cal.getTime()));

}

public String GetTplus2day() {
	
	  

	 DateFormat dateFormat = new SimpleDateFormat("dd");
	  // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	  // System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, 2);
	 return dateFormat.format(cal.getTime());
	//  System.out.println(dateFormat.format(cal.getTime()));

}


public void logOut()
{
 //driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	//driver.switchTo().defaultContent();
	driver.switchTo().frame("login");
	driver.switchTo().frame("nav");
    driver.findElement(By.xpath(".//*[@id='N_Logout_none_1']")).click();   
    isAlreadyLogIn=false;
}
 //To Close Browser
public void closeBrowser(){
 driver.quit();
 browserAlreadyOpen=false;
} 
}
