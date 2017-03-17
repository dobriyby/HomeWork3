package com.dobriy.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dobriy.pages.JobPage;
import com.dobriy.pages.Page;

public class MainMenu {

	@FindBy(id = "mainmenu")
	private WebElement menuLink;

	public MainMenu() {
		PageFactory.initElements(Page.initChromeDriver(), this);
	}

	public Page clickTo(String str) {
		menuLink.findElement(By.xpath(".//*[text()='" + str + "']")).click();
		switch (str) {
		case "Работа":
			return new JobPage();
		default:
			return null;

		}
	}
}
