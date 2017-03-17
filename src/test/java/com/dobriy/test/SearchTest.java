package com.dobriy.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import com.dobriy.pages.*;

public class SearchTest {
	private String article;
	private String searchStr;

	@Test
	public void searchTest() {
		Page currentPage = MainPage.open();
		assertTrue(currentPage instanceof MainPage);
		currentPage = ((MainPage) currentPage).clickToMenu(article);
		assertTrue(currentPage instanceof JobPage);
		currentPage = ((JobPage) currentPage).search(searchStr);
		assertTrue(currentPage instanceof FindJobPage);
		assertTrue(((FindJobPage) currentPage).listFullConformity().size() > 0);
		((FindJobPage) currentPage).writeListFullConformity(System.out);
		assertTrue(((FindJobPage) currentPage).listPartialConformity().size() > 0);
		((FindJobPage) currentPage).writeListPartialConformity(System.out);
	}

	@Parameters({ "article", "searchstr" })
	@BeforeTest
	public void beforeTest(String article, String searchStr) {
		this.article = article;
		this.searchStr = searchStr;
		Page.initChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		Page.driverQuit();
	}

}
