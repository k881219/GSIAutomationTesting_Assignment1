package git.googlesearch.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.xml.bind.Element;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class googleSearchBase {
    WebDriver driver;

    public googleSearchBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-ca");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFirefoxDriver(){
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void input(String inputText, WebElement element) {
        element.sendKeys(inputText);
    }

    public WebElement findTag(By tag, WebElement element) {
        return element.findElement(tag);
    }

    public String getDomProperty(String tag, WebElement element) {
        return element.getDomProperty(tag);
    }

    public void clean(WebElement element){
        element.clear();
    }

    public void click(WebElement element){
        element.click();
    }

    public void submit(WebElement element) {
        element.submit();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            throw e;
        }
    }

    public void vist(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
