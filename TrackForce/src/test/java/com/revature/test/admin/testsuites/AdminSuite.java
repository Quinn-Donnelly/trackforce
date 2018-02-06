package com.revature.test.admin.testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.revature.test.admin.pom.Logout;
import com.revature.test.utils.DriverUtil;
import com.revature.test.utils.LoginUtil;

//import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class AdminSuite extends AbstractTestNGCucumberTests {

	public static WebDriver wd = DriverUtil.getChromeDriver();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("================== TRACKFORCE TESTS ==================");
		System.out.println("Logging In");
		try {
			wd.get("http://52.207.66.231:4200");
			LoginUtil.loginAsAdmin(wd);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Logging out");
		Logout.logout(wd).click();
		wd.quit();
	}
}
