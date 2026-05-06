import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class buttonSelectProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void buttonSelected() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(4).click();
        Thread.sleep(1000);

        Actions action=new Actions(driver);

        WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClickButton);
        Thread.sleep(5000);

        WebElement rightClick=driver.findElements(By.className("btn-primary")).get(1);
        action.contextClick(rightClick);
        Thread.sleep(5000);

        List<WebElement> clickButton=driver.findElements(By.cssSelector("button"));
        action.click(clickButton.get(3)).perform();


//        driver.findElement(By.id("yesRadio")).click();




    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
