package com.revature.test.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	static WebElement e = null;
	
	public static WebElement logout(WebDriver d) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		e = d.findElement(By.xpath("/html/body/app/div/app-root/div/app-navbar/nav/div/ul[1]/li[6]/a"));
		return e;
	}

}