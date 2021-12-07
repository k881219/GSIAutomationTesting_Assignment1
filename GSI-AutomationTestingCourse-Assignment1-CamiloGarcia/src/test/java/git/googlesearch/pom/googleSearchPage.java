package git.googlesearch.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class googleSearchPage extends googleSearchBase{

    By searchBoxLocator = By.xpath("//input[@name='q']");
    By listResultLocator = By.xpath("//div[@class='g']");
    String searchParameter = "Kahua";
    String searchTitle = "Kahua - Google Search";
    By tagLocator = By.tagName("a");
    String hrefLocator = "href";

    public googleSearchPage(WebDriver driver) {
        super(driver);
    }

     public void searchAction() throws InterruptedException {
         WebElement searchBox = findElement(searchBoxLocator);
         clean(searchBox);
         input(searchParameter,
                 searchBox);
         submit(searchBox);
         Thread.sleep(2000);
         assertEquals(searchTitle, getTitle());
     }

     public void accessFirstResult() throws InterruptedException {
        List<WebElement> results = findElements(listResultLocator);
        //WebElement element = findTag(tagLocator,results.get(1));
        String hrefURL = getDomProperty(hrefLocator,findTag(tagLocator,results.get(1)));
        click(results.get(1));
        Thread.sleep(2000);
        assertEquals(hrefURL, driver.getCurrentUrl());
     }
}
