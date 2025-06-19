import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DiscountTest {
    @Test
    public void checkout2() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py?page=2&zip_code=11111&first_name=Qwe&last_name=Rty&email=test%40test.test&password1=123456&password2=123456");
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value=Update]"));
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[5]/p/b")).getText(), "2");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[6]")).getText(), "4.0");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[7]")).getText(), "196.00");
        driver.quit();
        softAssert.assertAll();
    }
}
