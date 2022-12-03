import org.junit.jupiter.api.Test;

import pages.Landing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

public class AmazonTest extends TestSandbox {
	
	
  @Tag("smokeTest")
  @DisplayName("This test is assignment test")

	
	@Test
	void test() throws Exception {
		Landing landingPage = new Landing();
		assertTrue(landingPage.navigateToHamburgerMenu(),"Humburger menu is not displayed");
		Thread.sleep(5000);
	}

}
