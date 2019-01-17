package pages;

import org.openqa.selenium.By;

import static pages.BasePage.find;
import static pages.BasePage.text;

/**
 * Created by jiaxiong on 2019-01-13 15:22
 */
public class LoginPage {

    private By others = text("手机及其他登录");
    private By pwdLogin = text("邮箱手机号密码登录");
    private By username = By.id("login_account");
    private By pwd = By.xpath("//*[@password='true']");
    private By login = By.id("button_next");
    private By msg = By.id("md_content");

    private String message;

    public LoginPage pwdFail(String username, String pwd) {
        find(others).click();
        find(pwdLogin).click();
        find(this.username).sendKeys(username);
        find(this.pwd).sendKeys(pwd);
        find(login).click();
        message = find(msg).getText();
        find(By.id("md_buttonDefaultPosition")).click();

        return this;
    }

    public MainPage pwdSuccess(String username, String pwd) {
        find(others).click();
        find(pwdLogin).click();
        find(this.username).sendKeys(username);
        find(this.pwd).sendKeys(pwd);
        find(login).click();

        return new MainPage();
    }

    public String getMassage() {
        return message;
    }

    public ProfilePage gotoProfile() {
//        Byfind(By.id("iv_close")).click();
//        find(By.id("iv_action_back")).click();
        find(By.xpath("//*contains(@resource-id,'iv_close') or contains(@resource-id,'iv_close')"));
        return new ProfilePage();
    }



    public void gotoWeixinLogin() {

    }

    public void gotoVerify() {

    }

    public void gotoPwdLogin() {

    }
}
