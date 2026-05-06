import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScreenShotProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void screenShot() throws InterruptedException, IOException {
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(1000);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        Random rand=new Random();
        int autoNumber=rand.nextInt(500);

        String filePath = "C:/Users/akm.faisal/Downloads/"+autoNumber + ".png";

        File destFile=new File(filePath);

        FileUtils.copyFile(srcFile,destFile);
        Thread.sleep(2000);


    }


    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
