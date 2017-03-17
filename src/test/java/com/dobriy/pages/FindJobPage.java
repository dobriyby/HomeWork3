package com.dobriy.pages;

import java.io.PrintStream;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dobriy.components.ListResult;

public class FindJobPage extends Page {

	@SuppressWarnings("unused")
	private final String URL = "https://jobs.tut.by/search/vacancy";
	private String searchStr;
	private ListResult list = new ListResult(Page.initChromeDriver()
			.findElements(By.xpath("//div[contains(@class,'search-result-item search-result')]")));

	public FindJobPage(String searcStr) {
		this.searchStr = searcStr;
	}

	public List<WebElement> listFullConformity() {
		return list.fullConformity(searchStr);

	}

	public List<WebElement> listPartialConformity() {
		return list.partialConformity(searchStr, 100);

	}

	public List<WebElement> listPartialConformity(double percent) {
		return list.partialConformity(searchStr, percent);

	}

	public void writeListFullConformity(PrintStream out) {
		for (WebElement elem : listFullConformity()) {
			out.println(elem.findElement(list.headListXpath).getText());
		}
	}

	public void writeListPartialConformity(PrintStream out) {
		for (WebElement elem : listPartialConformity()) {
			out.println(elem.findElement(list.headListXpath).getText());
		}
	}

	public void writeListPartialConformity(PrintStream out, double percent) {
		for (WebElement elem : listPartialConformity(percent)) {
			out.println(elem.findElement(list.headListXpath).getText());
		}
	}

}
