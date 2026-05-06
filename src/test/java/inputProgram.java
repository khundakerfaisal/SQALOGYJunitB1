import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class inputProgram {
    @Test
    public void inputEntry() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(1000);
        driver.findElements(By.className("card")).get(0).click();
        Thread.sleep(1000);
        driver.findElements(By.className("btn-light")).get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.id("userName")).sendKeys("Emon Mahmud");
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("emon@yopmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Dhaka");
        driver.findElement(By.id("permanentAddress")).sendKeys("Dhaka");
        driver.findElements(By.className("btn-primary")).get(0).click();
        Thread.sleep(1000);
        String ExpectedNameText=driver.findElement(By.id("name")).getText();
        String ExpectedEmailText=driver.findElement(By.id("email")).getText();
        String ActualText="Name:Emon Mahmud";
        String ActualEmailText="Email:emon@yopmail.com";

        Assertions.assertEquals(ExpectedNameText,ActualText);
        Assertions.assertEquals(ExpectedEmailText,ActualEmailText);



    }
}
