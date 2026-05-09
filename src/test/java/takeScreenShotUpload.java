import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class takeScreenShotUpload {

    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Disabled
    public void takeScreenshot() throws IOException, InterruptedException {

        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String fileName = "screenShot"; //File name Rearrange
        Random random = new Random();
        int generateNumber = random.nextInt(9999);
        String getFileName = fileName + generateNumber;
        System.out.println(getFileName);


        String filePath = "C:/Users/akm.faisal/Downloads/" + getFileName + ".png";

        File destFile = new File(filePath);

        FileUtils.copyFile(srcFile, destFile);
        Thread.sleep(2000);


    }

    @DisplayName("UPLOAD FILE")
    @Order(1)
    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);

        WebElement srcFileUpload=driver.findElement(By.id("uploadFile"));
        Thread.sleep(1000);
        srcFileUpload.sendKeys("C:\\Users\\akm.faisal\\Downloads\\screenShot1967.png");

        Thread.sleep(5000);

    }

    @DisplayName("DOWNLOAD FILE")
    @Order(2)

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);
        WebElement clickDownloadButton=driver.findElement(By.id("downloadButton"));

        clickDownloadButton.click();
        Thread.sleep(2000);

    }


    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
