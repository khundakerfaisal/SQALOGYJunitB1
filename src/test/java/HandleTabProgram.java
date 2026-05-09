import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class HandleTabProgram {

    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void tabHandle() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);

        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(1000);


        ArrayList<String> mainWindow=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(mainWindow.get(1));
        Thread.sleep(2000);



        String ExpectedText=driver.findElement(By.id("sampleHeading")).getText();
        Assertions.assertTrue(ExpectedText.contains("This is a sample page"));

        Thread.sleep(2000);

        driver.close();
        Thread.sleep(2000);







    }
    @AfterEach
    public void closeBrowser() {

        driver.quit();
    }
}
