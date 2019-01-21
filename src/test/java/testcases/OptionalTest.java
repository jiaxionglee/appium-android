package testcases;

import config.XueqiuDataConfig;
import config.XueqiuConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.OptionalPage;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    @DisplayName("CsvParam")
    void optionalTestParam(String keyword, String expected) {
        OptionalPage result = optionalPage.searchOptional(keyword);
        assertThat(result.getAll().get(0), equalTo(expected));
        OptionalPage add_result = result.addOptional();
        add_result.cancel().removeOptional();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/optional.csv")
    @DisplayName("CsvFileParam")
    void optionalTest(String keyword, String expected) {
        OptionalPage result = optionalPage.searchOptional(keyword);
        assertThat(result.getAll().get(0), equalTo(expected));
        OptionalPage add_result = result.addOptional();
        add_result.cancel().removeOptional();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("CsvFileYamlParam")
    void optionalTestYaml(String keyword, String expected) {
        OptionalPage result = optionalPage.searchOptional(keyword);
        assertThat(result.getAll().get(0), equalTo(expected));
        OptionalPage add_result = result.addOptional();
        add_result.cancel().removeOptional();
    }

    static Stream<Arguments> dataProvider() {
        XueqiuDataConfig dataConfig = new XueqiuDataConfig();
        XueqiuConfig config = XueqiuConfig.load("/data/XueqiuData.yaml");
        config.xueqiuDataConfig.optional.keySet().forEach(key -> {
            String value = config.xueqiuDataConfig.optional.get(key).toString();
            dataConfig.setInput(key);
            dataConfig.setExpected(value);
        });
        return Stream.of(arguments(dataConfig.getInput(),dataConfig.getExpected()));
    }
}
