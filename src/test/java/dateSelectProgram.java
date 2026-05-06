import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class dateSelectProgram {
    WebDriver driver;


    @BeforeEach
    public void StartBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void dateSelected() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(1000);

        WebElement inputDate=driver.findElement(By.id("dateOfBirthInput"));
        Thread.sleep(2000);
        inputDate.sendKeys(Keys.CONTROL + "A");
        Thread.sleep(5000);


        LocalDate date=LocalDate.now(); //current date
        inputDate.sendKeys(date.toString());
        Thread.sleep(2000);

        inputDate.sendKeys(Keys.ENTER);
        Thread.sleep(2000);


        inputDate.clear();
        Thread.sleep(5000);




//        driver.findElement(By.id("yesRadio")).click();




    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

}
