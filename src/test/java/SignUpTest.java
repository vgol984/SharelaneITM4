import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Test");
        driver.findElement(By.name("last_name")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("test123@test.test");
        driver.findElement(By.name("password1")).sendKeys("qwerty123456");
        driver.findElement(By.name("password2")).sendKeys("qwerty123456");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String confirmationMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(confirmationMessage, "Account is created!");
        driver.quit();
    }
}
