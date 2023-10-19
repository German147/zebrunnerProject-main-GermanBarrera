package functionality;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JS{
    public static void click(WebDriver driver, ExtendedWebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element.getElement());
    }

    public static void scrollToTheBottom(WebDriver driver, ExtendedWebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToTheTop(WebDriver driver, ExtendedWebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollToElement(WebDriver driver, ExtendedWebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element.getElement());
    }

    public static void scrollByPixels(WebDriver driver, int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = String.format("window.scrollBy(0, %d);", pixels);
        jsExecutor.executeScript(script);
    }

}
