package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.config.BaseFunctions;

public class Landing extends BaseFunctions{

	@FindBy(id="nav-hamburger-menu")
	WebElement hamBurgerMenu;
	
	@FindBy(id="hmenu-canvas")
	WebElement leftMenu;
		
	
	
	public Landing() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean navigateToHamburgerMenu() throws Exception {
		verifyPageLoadCompleted(5);
		click(hamBurgerMenu);
		return isElementPresent(leftMenu);
	}

}
