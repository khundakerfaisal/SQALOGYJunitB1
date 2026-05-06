import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class checkBoxProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void checkBoxSelected() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(1).click();
        Thread.sleep(1000);
        driver.findElements(By.className("rc-tree-checkbox")).get(0).click();

        String ExpectedText=driver.findElement(By.id("result")).getText();
        String ActualText="You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "documents\n" +
                "downloads\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "office\n" +
                "wordFile\n" +
                "excelFile\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general";

        Assertions.assertEquals(ExpectedText,ActualText);


    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
