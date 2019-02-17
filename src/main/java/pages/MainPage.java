package pages;


import drivers.Driver;
import org.openqa.selenium.By;

/**
 * Created by jiaxiong on 2019-01-13 14:58
 */
public class MainPage extends BasePage {

    private By profile = By.id("user_profile_icon");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile() {
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();
    }

    /**
     * 搜索
     */
    public SearchPage gotoSearch() {
        find(By.id("home_search")).click();
        return new SearchPage();
    }

    /**
     * 自选
     */
    public OptionalPage gotoOptional() {
        //find(By.id("tabs")).findElement(text("自选")).click();
        findUAT2("自选").click();
        return new OptionalPage();
    }
}
