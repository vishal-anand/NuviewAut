package com.HRM.Locators;

public class Locators {

		
	//URL
	
//public static final String NuviewURL="http://172.16.104.51/lbp/WrkFlw.aspx?F_NavForm=Login";
//public static final String NuviewURL="http://172.16.100.165/lbp/";
  public static final String NuviewURL="http://172.16.97.219/lbp/";
// public static final String NuviewURL="http://172.16.97.222/lbp/";
	
	
	//Login Page and Add Emp Display page
		
public static final String Username= ".//*[@id='C_User_main_1']/input[2]";
public static final String Password= ".//*[@id='C_Pswd_main_1']/input[2]";
public static final String LoginBtn=".//*[@id='N_Login_main_1']";

//HRMS Home Page

public static final String HomePageTitle="html/body/form/table/tbody/tr/td/table[2]/tbody/tr/td[1]";
public static final String LogoutBtn=".//*[@id='welcome-menu']/ul/li[2]/a";


public static final String AddEmpMenu=".//*[@id='menu_pim_addEmployee']";

//Human Resources Elements
public static final String HR_TAB=".//*[@id='TabTitle_Menu_Human Resources']";



//User Details
public static final String Firstname=".//*[@id='firstName']";
public static final String Lastname=".//*[@id='lastName']";
public static final String ChkLogin=".//*[@id='chkLogin']";

public static final String NewUsername=".//*[@id='user_name']";
public static final String NewUserPass=".//*[@id='user_password']";
public static final String NewUserConfirmPass=".//*[@id='re_password']";
public static final String ProfileNameValid=".//*[@id='profile-pic']/h1";

public static final String Edit_Save=".//*[@id='btnSave']";



//Relogin with New User PAge Details

public static final String AdminViewMenu=".//*[@id='menu_admin_viewAdminModule']/b";
public static final String SearchBoxNewUser=".//*[@id='searchSystemUser_userName']";
public static final String SearchBtn=".//*[@id='searchBtn']";
public static final String SearchResult=".//*[@id='resultTable']/tbody/tr/td[2]/a";
}
