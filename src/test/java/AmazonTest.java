import org.junit.jupiter.api.Test;

import amazon.choices.Category;
import amazon.choices.LeftNavigationSection;
import amazon.choices.SortBy;
import amazon.choices.SubCategory;
import amazon.factories.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import pages.Landing;
import pages.LeftNavigationPanel;
import pages.ProductDetails;
import pages.SearchResults;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

@Slf4j
public class AmazonTest extends TestBase {
	
	
  @Tag("smokeTest")
  @DisplayName("This test is assignment test")

	
	@Test
	void test() throws Exception {
		Landing landingPage = new Landing();
		LeftNavigationPanel leftPanel = new LeftNavigationPanel();
		SearchResults resultPage = new SearchResults();
		ProductDetails pdPage = new ProductDetails();
		assertTrue(landingPage.navigateToHamburgerMenu(),"Humburger menu is not displayed");
		leftPanel.navigateToCategory(LeftNavigationSection.SHOP_BY_CATEGORY.toString(), Category.TV_APPLIANCES_ELECTRONICS.toString(), SubCategory.TELEVVISIONS.toString());
		resultPage.applyFilter("Brands", "Samsung");
		resultPage.applySorting(SortBy.HIGH_TO_LOW.toString());
		Set<String> windows = driver.getWindowHandles();
		//Selecting 2nd result
		String productName = resultPage.selectNthResult(2);
		switchToNewTaborWindow(windows);
		assertTrue(pdPage.verify(productName), String.format("Driver is not switched to product '%s' details page", productName));
		String textAboutProduct = pdPage.getAboutThisItem();
		assertNotNull(textAboutProduct, "About this item” section is not present for product : "+productName);
		log.info("{} details : \n {}", productName, textAboutProduct);
		Thread.sleep(5000);
	}

}
