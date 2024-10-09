package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Xpath_Css_Tech {

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
        driver.findElement(By.xpath("//a[contains(text(),'Samsung')]"));

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

    @Test
    public void TC_03_Xpath_Css_01() {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        // 1. Đi từ cha vào con (1 node)
        driver.findElement(By.xpath("//ul/li/div/input[@id='email']"));
        driver.findElement(By.cssSelector("ul>li>div>input[id='email']"));

        // 2. Đi từ cha vào con (nhiều node)
        driver.findElement(By.xpath("//ul//input[@id='email']"));
        driver.findElement(By.cssSelector("ul input[id='email']"));
        driver.findElement(By.cssSelector("div[class='col-2 registered-users'] input[id='email']"));

        // 3. Kết hợp vs ID
        driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("input#email"));

        //4. Kết hợp vs Class
        driver.findElement(By.xpath("//div[@class='col-2 registered-users']"));
        driver.findElement(By.cssSelector("div[class='col-2 registered-users']"));
        driver.findElement(By.cssSelector("div.registered-users"));
        driver.findElement(By.cssSelector(".registered-users"));

        // 5. Attribute
        driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.cssSelector("input[id='email']"));

        // 6. Phép AND
        driver.findElement(By.xpath("//input[@id='email' and @name='login[username]']"));
        driver.findElement(By.cssSelector("input[id='email'][name='login[username]']"));

        //7. Phép OR
        driver.findElement(By.xpath("//input[@id='email' or @id='pass']"));
        driver.findElement(By.cssSelector("input[id='email'],input[id='pass']"));
        driver.findElement(By.cssSelector("input[id='email'],[id='pass']"));

        // 8. Phép NOT
        driver.findElement(By.xpath("//input[not(@id='pass')]"));
        driver.findElement(By.cssSelector("input:not([id='email'])"));

        // 9. Contains attribute
        driver.findElement(By.xpath("//input[contains(@title,'Email Address')]"));
        driver.findElement(By.cssSelector("input[title*='Email Address']"));
        driver.findElement(By.cssSelector("input[title*='Address']"));
        driver.findElement(By.cssSelector("input[title*='Email']"));

        // 10. Start with attribute
        driver.findElement(By.xpath("//input[starts-with(@title,'Email')]"));
        driver.findElement(By.cssSelector("input[title^='Email']"));

        // 11. End with attribute (XPath ko support)
        //driver.findElement(By.xpath("//input[ends-with(@title,'Address')]"));
        driver.findElement(By.cssSelector("input[title$='Address']"));
    }

    @Test
    public void TC_04_Xpath_Css_02() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");

        // 12. Following sibling
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/following-sibling::div/h2/following-sibling::div"));
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>h2+div")); // 1
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>h2~div")); // 3

        // 13. Index
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/following-sibling::div/h2/following-sibling::div[1]"));
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>h2~div:nth-of-type(1)"));
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/following-sibling::div/h2/following-sibling::div[2]"));
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>h2~div:nth-of-type(2)"));
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>h2~div:nth-child(2)"));

        // 14. Last index
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>div:last-of-type"));
        driver.findElement(By.cssSelector("a[title='Samsung Galaxy']+div>div:last-child"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
