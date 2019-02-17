package pages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jiaxiong on 2019-01-13 15:38
 */
public class BasePage {

    static WebElement find(By locator) {
        //todo 根据弹窗列表批量检索
        try {
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    static List<WebElement> finds(By locator) {
        return Driver.getCurrentDriver().findElements(locator);
    }

    static By locate(String locator) {
        if (locator.matches("/.*")) {
            return By.xpath(locator);
        } else {
            return By.id(locator);
        }
    }

    static By text(String content) {
        return By.xpath("//*[@text='" + content + "']");
    }

    static WebElement findUAT2(String content){
        return Driver.getCurrentDriver().findElementByXPath("//*[@text='" + content + "']");
    }
}
