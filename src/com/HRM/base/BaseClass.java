package com.HRM.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.HRM.Utils.sendmail;

public class BaseClass {
	
	sendmail sm;
	@BeforeSuite

    public void Before(){

        System.out.println("Test Run Started");

        }


	
	 @AfterSuite

	    public void Sendmail(){

	        sm.Reporting();

	        }

}
