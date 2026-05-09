import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class dateSelectProgramAditional {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void dateSelected() throws InterruptedException {
        driver.get("https://demoqa.com/date-picker");
        Thread.sleep(1000);

        WebElement inputDate=driver.findElement(By.id("datePickerMonthYearInput"));
        Thread.sleep(1000);
        inputDate.sendKeys(Keys.CONTROL+"A");
        Thread.sleep(500);
        inputDate.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);


        LocalDate date=LocalDate.now(); //current date
        inputDate.sendKeys(date.toString());
        Thread.sleep(1000);

        inputDate.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
