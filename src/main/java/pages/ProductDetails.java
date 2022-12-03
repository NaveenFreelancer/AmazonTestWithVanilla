package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.config.BaseFunctions;

public class ProductDetails extends BaseFunctions{
	@FindBy(id="titleSection")
	WebElement textTitleSection;
	
	@FindBy(xpath="//h1[contains(text(),'About this item')]/following-sibling::ul/li/span")
	List<WebElement> textAboutThisItem;
	
	public ProductDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify(String productName) throws InterruptedException {
		verifyPageLoadCompleted(10);
			return isElementPresent(driver.findElement(By.xpath("//div[@id='titleSection']//span[contains(text(),'"+productName+"')]")));
	}
	
	public String getAboutThisItem() throws InterruptedException, IOException {
		String text = null;
		if(textAboutThisItem.size()==0) {
			if(scrollToElement(driver.findElement(By.xpath("//h1[contains(text(),'About this item')]"))))
				text = "";
		}
		else {
			text = "";
			for(WebElement element : textAboutThisItem) {
				scrollToElement(element);
				text+=String.format("%s\n", element.getText());
			}
		}
		
		return text;
	}

}
