import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class windowHandleProgram {

    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);

        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(1000);

        String mainWindow=driver.getWindowHandle();

        Set<String> allWindow=driver.getWindowHandles();

        for (String getAllWindow:allWindow){
            if (!getAllWindow.equals(mainWindow)){
                driver.switchTo().window(getAllWindow);

                String ExpectedText=driver.findElement(By.id("sampleHeading")).getText();
                Assertions.assertTrue(ExpectedText.contains("This is a sample page"));

                Thread.sleep(2000);
            }
        }

        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(mainWindow);

        Thread.sleep(2000);

    }
    @AfterEach
    public void closeBrowser() {

        driver.quit();
    }
}
