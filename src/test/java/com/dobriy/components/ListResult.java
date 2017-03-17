package com.dobriy.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListResult {

	public By headListXpath = By.xpath(".//div[contains(@class,'search-result-item__head')]");

	private List<WebElement> list;

	public ListResult(List<WebElement> list) {
		this.list = list;
	}

	/*
	 * Ищет элементы в результатах поиска с полным совпадением(строка искомая
	 * содержиться в строке результата)
	 */
	public List<WebElement> fullConformity(String str) {
		List<WebElement> finalList = new ArrayList<WebElement>();
		for (WebElement elem : list) {
			if (elem.findElement(headListXpath).getText().toLowerCase().contains(str.toLowerCase())) {
				finalList.add(elem);
			}
		}
		return finalList;
	}

	/*
	 * Ищет элементы в результатах поиска с частичным совпадением(слова в
	 * искомом строке присутствуют в строке результата) и с определенным
	 * процентом совпадения.
	 * 
	 * @param percent процент, необходимый, чтобы строка результата
	 * удовлетворяла условию частичного совпадения
	 */
	public List<WebElement> partialConformity(String str, double percent) {
		List<WebElement> finalList = new ArrayList<WebElement>();
		String[] splitStr = str.trim().replaceAll(" +", " ").toLowerCase().split(" ");
		double percentPerWord = 100.0 / (splitStr.length);
		for (WebElement elem : list) {
			double curPercent = 0.0;
			for (String word : splitStr) {
				if (elem.findElement(headListXpath).getText().toLowerCase().contains(word)) {
					curPercent += percentPerWord;
				}
			}
			if (curPercent >= percent) {
				finalList.add(elem);
			}
		}
		return finalList;
	}

}
