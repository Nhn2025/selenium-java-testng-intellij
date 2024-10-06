package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Xpath_Tech {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Text() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");

        // text()
        // Lấy text tuyệt đối
        // Không có khoảng trắng/ xuống dòng/ tab ở đầu hoặc cuối chuỗi
        driver.findElement(By.xpath("//h1[text()='Mobile']"));

        // contains(text(),'')
        // Text nằm trên chính node chứa nó
        // Index đầu tiên
        driver.findElement(By.xpath("//h5[contains(text(),'Jackson')]"));

        // contains(.,'') = contains(string(),'')
        // Text nằm trên chính node đó
        // Text nằm trên child node/ nested text ở bất gì vị trí nào
        driver.findElement(By.xpath("//p[contains(string(),'If you have an account with us')]"));
        driver.findElement(By.xpath("//p[contains(.,'If you have an account with us')]"));

        // concat()
        // Text vừa chứa nháy đơn, nháy đôi
        // Nháy đơn bọc nháy đôi, nháy đôi bọc nháy đơn
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));

        // AND
        // OR
        driver.findElement(By.xpath("//input[@type='email' and @id='email']"));
        driver.findElement(By.xpath("//input[@type='login' or @id='email']"));

        // NOT
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));

        // Inside parent
        // Các element ngang hàng nhau cùng 1 thẻ cha
        driver.findElement(By.xpath("//ol[@id='selectable']/li[20]"));

        // position()
        driver.findElement(By.xpath("//ol[@id='selectable']/li[position()=20]"));

        // Outside parent
        // Các element ngang hàng nhau không cùng 1 thẻ cha
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]"));

        // Last()
        // Element cuối cùng
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));

        // Kế cuối
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)-1]"));

        // Count()
        // Lấy element cuối cùng
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)]"));
    }

    @Test
    public void TC_02_Axes() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");

        // parent, following-sibling
        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button"));
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']"));

        // preceding-sibling
        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/parent::div/preceding-sibling::a"));

        // ancestor
        driver.findElement(By.xpath("//a[@title='IPhone']/ancestor::div[@class='product-info']//span[text()='Add to Cart']"));

        // descendant
        driver.findElement(By.xpath("//a[@title='IPhone']/ancestor::div[@class='product-info']/descendant::*"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
