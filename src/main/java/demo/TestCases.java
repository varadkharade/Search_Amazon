package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
       System.out.println("Start Test case: testCase01");
         // Navigate to Google  using www.google.com in driver.get() method
        driver.get("https://www.google.com");
        // Click on search bar and enter text "Amazon" Using Locator "ID" APjFqb and sendKeys("Amazon")
         WebElement searchbar = driver.findElement(By.id("APjFqb"));
        
         Thread.sleep(1000);
        
        searchbar.click();
        searchbar.sendKeys("Amazon");
        
        // Press Enter   Using SearchbarWebelement.sendKeys(Keys.ENTER)
        searchbar.sendKeys(Keys.ENTER);
        
        Thread.sleep(8000);
       
        // Validate if Amazon.in in search results Using Locator "XPath" //span[text()='https://www.amazon.in'] and is displayed method
        WebElement amazonLink = driver.findElement(By.xpath("//span[text()='Amazon.in']"));
        if(amazonLink.isDisplayed()){
            System.out.println("Test Case Pass Link is displayed");
        }else{
            System.out.println("Test Case Fail Link is not displayed");
        }
        System.out.println("End Test case: testCase01");
    }


}
