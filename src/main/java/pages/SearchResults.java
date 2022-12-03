package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.config.BaseFunctions;

public class SearchResults extends BaseFunctions{

	@FindBy(xpath="//span[text()='Sort by:']/ancestor::span[@class='a-button-inner']")
	WebElement btnSortBy;

	public SearchResults() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean applyFilter(String filterName, String filterValues) throws Exception {
		for(String value : filterValues.split(", ")) {
			WebElement filterElement = driver.findElement(By.xpath(String.format("//span[text()='%s']/../following::ul//span[text()='%s']/ancestor::a", filterName, value)));	
			scrollToElement(filterElement);
			click(filterElement);
			if(!waitUntilElementFound(By.xpath("//input[@checked='']/ancestor::div[contains(@class,'checkbox')]/following-sibling::span[text()='"+value+"']"),2))
				return false;
			}
		return true;
		
	}
	
	public boolean applySorting(String sortingValue) throws Exception {
		click(btnSortBy);
		waitUntilElementFound(By.xpath("//a[text()='Featured']/ancestor::div[@aria-hidden='false']"),2);
		click(driver.findElement(By.xpath("//a[text()='"+sortingValue+"']/..")));
		return waitUntilElementFound(By.xpath("//span[text()='"+sortingValue+"']"),2);
	}
	
	
	public String selectNthResult(int number) throws Exception {
		String productName = driver.findElement(By.xpath("//div[@data-index="+number+"]//a/span[contains(@class,'a-text-normal')]")).getText();
		click(driver.findElement(By.xpath("//div[@data-index="+number+"]")));
		return productName;
	}
}
