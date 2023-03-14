package first.Bookswagan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
	   // TODO Auto-generated method stub
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get("https://www.bookswagon.com/");
       Actions act = new Actions(driver);
       act.moveToElement(driver.findElement(By.id("ctl00_lblUser"))).build().perform();
       driver.findElement(By.linkText("Log in")).click();
       driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail")).sendKeys("6360610683");
	   driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword")).sendKeys("Manju@1994");
	   driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin")).click();
	   driver.findElement(By.linkText("New Arrivals")).click();
	   
	   List<WebElement> products = driver.findElements(By.cssSelector(".card-img-top.bklazy"));
	   
	   WebElement prod = products.stream().filter(product-> 
	   product.findElement(By.xpath("(//div[@class='col-sm-20'])[7]")).getText().equals("Harry Potter and the Order of the Phoenix")).findFirst().orElse(null);
	   
	   act.moveToElement(prod).build().perform();
	   prod.findElement(By.xpath("//body[1]/form[1]/div[10]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
	   
	   System.out.println("prodct list" +products);
 
	}

}
