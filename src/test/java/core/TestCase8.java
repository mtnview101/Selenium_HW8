package core;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


//Сделайте сценарий, проверяющий наличие стикеров у всех товаров в учебном приложении 
//litecart на главной странице. Стикеры - это полоски в левом верхнем углу изображения 
//товара, на которых написано New или Sale или что-нибудь другое. Сценарий должен проверять, 
//что у каждого товара имеется ровно один стикер.

/**
 * @author Dmitry Nakhabtsev
 */
public class TestCase8 {

public WebDriver driver;
public WebDriverWait wait;

public boolean areElementsPresent(By locator){
    return driver.findElements(locator).size() > 0;}

public boolean isElementPresent(By locator){
    try{
    	driver.findElement(locator);
    	return true;
    }catch(NoSuchElementException ex){
    	return false;
    }
 }
@Test
public void test() throws InterruptedException{

	int i=1;
	String url="http://localhost/litecart/en/";

    WebDriver driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	driver.get(url); 
	
    List<WebElement> elements = driver.findElements(By.cssSelector(".product"));
    System.out.println("elements="+elements.size());

    for (WebElement el :elements){
    	System.out.println("i="+i++);
        Assert.assertTrue(el.findElements(By.cssSelector(".sticker")).size() == 1);}


	
//	Thread.sleep(2000);
	driver.quit();

}
}


