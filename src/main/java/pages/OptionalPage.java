package pages;

import drivers.Driver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * Created by jiaxiong on 2019-01-14 20:30
 */
public class OptionalPage extends BasePage {

    public OptionalPage searchOptional(String keyword) {
        find(By.id("action_create_cube")).click();
        find(By.id("search_input_text")).sendKeys(keyword);
        return this;
    }

    public OptionalPage addOptional() {
        find(By.id("follow_btn")).click();
        return this;
    }

    public OptionalPage removeOptional() {
        TouchAction touchAction = new TouchAction(Driver.getCurrentDriver());
        WebElement element1 = find(By.id("portfolio_whole_item"));
        // 长按
        touchAction.longPress(longPressOptions().withElement(element(element1))
                .withDuration(Duration.ofMillis(1000))).release().perform();

        find(By.id("md_contentRecyclerView")).findElement(text("删除")).click();
        return this;
    }

    public OptionalPage cancel() {
        find(By.id("action_close")).click();
        return this;
    }
}
