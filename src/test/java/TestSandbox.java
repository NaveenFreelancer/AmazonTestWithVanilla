import amazon.config.BaseFunctions;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestSandbox extends BaseFunctions {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    
  
    
    @BeforeEach
	public void launchURL() throws InterruptedException{
    	driver = DriverFactory.getDriver();
		driver.get(HOME_PAGE_URL);
		 assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
	}
    
    
    @AfterEach
    public void tearDown() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
    }
    
}
