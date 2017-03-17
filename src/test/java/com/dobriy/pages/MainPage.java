package com.dobriy.pages;

import com.dobriy.components.MainMenu;

public class MainPage extends Page {
	private final String URL = "https://www.tut.by/";

	private MainMenu menu;
	
	public MainPage(){
		menu = new MainMenu();
	}

	public Page clickToMenu(String str) {
		return menu.clickTo(str);
	}

	public static MainPage open() {
		MainPage page = new MainPage();
		Page.initChromeDriver().get(page.URL);
		return page;
	}

}
