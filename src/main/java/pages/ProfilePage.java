package pages;

import drivers.Driver;
import org.openqa.selenium.By;

import static pages.BasePage.text;

/**
 * Created by jiaxiong on 2019-01-13 15:11
 */
public class ProfilePage {

    private By login = text("点击登录");

    public LoginPage gotoLogin() {
        Driver.getCurrentDriver().findElement(login).click();
        return new LoginPage();
    }
}
