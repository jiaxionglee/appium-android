import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.OptionalPage;

/**
 * Created by jiaxiong on 2019-01-14 20:29
 */
public class OptionalTest {
    private static MainPage mainPage;
    private static OptionalPage optionalPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        optionalPage = mainPage.gotoOptional();
    }

    @ParameterizedTest
    @CsvSource({
            "ali,阿里巴巴"
    })
    void optionalTest(String keyword, String expected) {
        OptionalPage result = optionalPage.searchOptional(keyword);
        OptionalPage addresult = result.addOptional();
        addresult.cancel().removeOptional();
    }
}
