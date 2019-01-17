
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jiaxiong on 2019-01-13 14:51
 */
public class LoginTest {

    private static MainPage mainPage;
    private static ProfilePage profilePage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfile();
    }

    @ParameterizedTest
    @CsvSource({
            "17010281698,xxxxxx,手机号码填写错误"
    })
    void pwdLogin(String username, String pwd, String expected) {
        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.pwdFail(username, pwd);
        //loginPage.gotoProfile();
        assertThat(loginPage.getMassage(), equalTo(expected));
    }
}
