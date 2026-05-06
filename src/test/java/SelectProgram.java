import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SelectProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void selectDropdownData() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(1000);

        WebElement selectData=driver.findElement(By.id("oldSelectMenu"));
        Thread.sleep(2000);
        Select select=new Select(selectData);
        select.selectByVisibleText("Green");
        Thread.sleep(4000);



    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
