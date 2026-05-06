import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class scrollUpAndDown {

    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @DisplayName("Scroll Down")
    @Order(1)
    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(0).click();
        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(4000);

    }
    @DisplayName("Scroll Up")
    @Order(2)
    @Test
    public void scrollUp() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(0).click();
        Thread.sleep(1000);

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)"); //Scroll Down
        Thread.sleep(4000);
        js.executeScript("window.scrollTo(0,0)"); //Scroll Up
        Thread.sleep(6000);
    }
    @DisplayName("Element wise Scroll")
    @Order(3)
    @Test
    public void elementWiseScroll() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(0).click();
        Thread.sleep(1000);

        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",currentAddress);
        Thread.sleep(4000);

    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }


}
