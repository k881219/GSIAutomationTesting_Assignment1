package gsi.googlesearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Search {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearchPage() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.clear();
        search.sendKeys("Kahua");
        search.submit();
        Thread.sleep(2000);
        assertEquals("Kahua - Google Search", driver.getTitle());
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='g']"));
        String hrefURL = results.get(1).findElement(By.tagName("a")).getDomProperty("href");
        results.get(1).click();
        Thread.sleep(2000);
        assertEquals(hrefURL, driver.getCurrentUrl());
    }

    @After
    public void closeChrome() {
        driver.quit();
    }
}
