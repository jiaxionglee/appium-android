import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.SearchPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jiaxiong on 2019-01-13 17:11
 */
public class SearchTest {

    private static MainPage mainPage;
    private static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd", "拼多多",
            "alibaba", "阿里巴巴",
            "sogo", "搜狗"
    })
    void searchTest(String keyword, String expected) {
        String name = searchPage.search(keyword).getALl().get(0);
        assertThat(name, equalTo(expected));
    }

    @Test
    void choice() {
        SearchPage result=searchPage.search("mi").addSelected();
//        assertThat(result.getALl().get(0), hasItems("followed_bt", "follow_btn"));
//        assertThat(result.getALl().get(0), equalTo("followed_bt"));
    }
}
