package git.googlesearch.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;

public class searchPOMTest {

//    private WebDriver driver;
    String url = "https://www.google.com";
    String searchTitle = "Kahua - Google Search";
    googleSearchPage googleSearchPage;
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        googleSearchPage = new googleSearchPage(driver);
        driver = googleSearchPage.getChromeDriver();
        googleSearchPage.vist(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        googleSearchPage.searchAction();
        googleSearchPage.accessFirstResult();

    }


}
