package amazon.config;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseFunctions {
	
	protected static WebDriver driver;
	
	
	public boolean waitUntilElementFound(By locator, Integer seconds) {
		Boolean found = false;
		try {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(seconds));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		found = true;
	} catch (Exception e) {
		e.getStackTrace();
	}
		return found;
	}
	
	public boolean switchToNewTaborWindow(Set<String> windows) throws InterruptedException {
		boolean newWindow = false;
		int time = 0;
		while(!newWindow && time<5) {
			Set<String> currentWindows = driver.getWindowHandles();
			if(currentWindows.size()==windows.size()+1) {
				String window = (String) currentWindows.stream().filter(e->!windows.contains(e)).collect(Collectors.toSet()).toArray()[0];
				driver.switchTo().window(window);
				newWindow = true;
			}
				
			else {
				Thread.sleep(1000);
				time++;
				}
		};
		return newWindow;
	}
	
	
	public  void click(WebElement element) throws Exception {
		try {
			if(element.isEnabled())
			{
				element.click();
				
					}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
	public  void sendKeys(WebElement element, String text) throws InterruptedException, IOException {
		try {
			if(element.isEnabled())
			{
				element.clear();
				element.sendKeys(text);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void mouseOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click();
		action.build().perform();
	}
	
	public boolean verifyPageLoadCompleted(Integer seconds) {
		boolean pageLoadedCompletely = false;
		JavascriptExecutor j = (JavascriptExecutor)driver;
		for (int i=0; i<seconds; i++){
	         try {
	            Thread.sleep(1000);
	         }catch (InterruptedException ex) {
	            System.out.println("Page has not loaded yet ");
	         }
	         //again check page state
	         if (j.executeScript("return document.readyState").toString().equals("complete")){
	            pageLoadedCompletely = true;
	            break;
	         }
	      }
		return pageLoadedCompletely;
	}
	

	
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean scrollToElement(WebElement ele) throws InterruptedException, IOException{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);	
		Boolean success = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(ele));
			success = true;
		}catch (Exception e){
		}
		return success;
	}
	

}
