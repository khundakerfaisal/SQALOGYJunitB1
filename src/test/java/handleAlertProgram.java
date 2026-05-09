import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class handleAlertProgram {

    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void handleAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Rashed Khan");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        String textActual=driver.findElement(By.id("promptResult")).getText();
        Assertions.assertTrue(textActual.contains("Rashed Khan"));




    }
    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
