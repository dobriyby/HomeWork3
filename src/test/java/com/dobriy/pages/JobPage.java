package com.dobriy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPage extends Page {
	
	@SuppressWarnings("unused")
	private final String URL = "https://job.tut.by/";

	@FindBy(xpath = "//input[contains(@class,'VacancyMainSearch')]")
	private WebElement txtSearch;

	@FindBy(tagName = "button")
	private WebElement btnSearch;

	public JobPage() {
		PageFactory.initElements(Page.initChromeDriver(), this);
	}

	public FindJobPage search(String searchStr) {
		txtSearch.sendKeys(searchStr);
		btnSearch.click();
		return (new FindJobPage(searchStr));
	}
}
