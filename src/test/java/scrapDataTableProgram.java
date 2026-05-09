import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class scrapDataTableProgram {
    WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void scrapTableData() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        WebElement tableData = driver.findElements(By.className("table-striped")).get(0);
        List<WebElement> tableRowAllData = tableData.findElements(By.tagName("tr"));
        for (WebElement rows : tableRowAllData) {
            List<WebElement> tableAllCell = rows.findElements(By.tagName("td"));
            for (WebElement cell : tableAllCell) {
                System.out.println(cell.getText());
            }
        }
    }

    @AfterEach
    public void closeBrowser() {

        driver.quit();
    }
}
