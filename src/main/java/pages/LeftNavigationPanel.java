package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import amazon.config.BaseFunctions;

public class LeftNavigationPanel extends BaseFunctions {
	String filtersAppliedXpath = "//div[@id='s-refinements']//span[text()='textTotReplace']";
	String categoryInListXpath = "//*[text()='textTotReplace']/ancestor::li";
	final String TEXT_TO_REPLACE = "textTotReplace";
	
	public LeftNavigationPanel() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean navigateToCategory(String section, String categoryName, String subCategoryName) throws Exception {
		scrollToElement(driver.findElement(By.xpath(categoryInListXpath.replace(TEXT_TO_REPLACE, section))));
		if(!isElementPresent(driver.findElement(By.xpath(categoryInListXpath.replace(TEXT_TO_REPLACE, categoryName)))))
		{
			By expandingList = By.xpath("(//div[text()='"+categoryName+"']/ancestor::li/following::li//div[text()='see all'])[1]");
			click(driver.findElement(expandingList));
			scrollToElement(driver.findElement(By.xpath(categoryInListXpath.replace(TEXT_TO_REPLACE, categoryName))));
		}
		click(driver.findElement(By.xpath(categoryInListXpath.replace(TEXT_TO_REPLACE, categoryName))));
		waitUntilElementFound(By.xpath("//ul[contains(@class,'hmenu-visible')]//a[contains(@class,'back-button')]"),3);
		click(driver.findElement(By.xpath(categoryInListXpath.replace(TEXT_TO_REPLACE, subCategoryName))));
		return waitUntilElementFound(By.xpath(filtersAppliedXpath.replace(TEXT_TO_REPLACE, subCategoryName)),3);
	}
	

}
