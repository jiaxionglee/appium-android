package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxiong on 2019-01-13 16:53
 */
public class SearchPage extends BasePage {

    public SearchPage search(String keyword) {
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    public MainPage cancel() {
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public List<String> getALl() {
        List<String> list = new ArrayList<String>();
        for (WebElement e : finds(By.id("stockName"))) {
            list.add(e.getTagName());
        }
        return list;
    }

    public SearchPage getByStock() {
        return this;
    }

    public ArrayList<String> addSelected() {
        ArrayList<String> list = new ArrayList<String>();
        //find(By.id("followed_btn"))
        MobileElement select =(MobileElement) find(By.xpath("//*[contains(@resource-id,'follow) and contains(@resource-id,'_btn)" +
                "]"));
        list.add(select.getAttribute("resource-id"));
        select.click();
        MobileElement select2 =(MobileElement) find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        list.add(select2.getAttribute("resource-id"));

        return list;

    }

//    public SearchPage addSelected() {
//        find(By.id("follow_btn")).click();
//        return this;
//
//    }

    public SearchPage removeSelected() {
        return this;
    }
}
