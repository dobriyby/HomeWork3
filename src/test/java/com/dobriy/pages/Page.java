package com.dobriy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {
	private static WebDriver driver;

	public static WebDriver initChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void driverQuit() {
		Page.initChromeDriver().quit();
	}

}
