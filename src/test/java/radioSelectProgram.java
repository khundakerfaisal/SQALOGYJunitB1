import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class radioSelectProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void radioSelected() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(2).click();
        Thread.sleep(1000);
        driver.findElement(By.id("yesRadio")).click();

        String ExpectedText=driver.findElements(By.className("mt-3")).get(0).getText();
        Assertions.assertTrue(ExpectedText.contains("You have selected Yes"));


    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
