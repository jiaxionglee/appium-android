package config;

import java.util.HashMap;

/**
 * Created by jiaxiong on 2019-01-21 21:31
 */
public class XueqiuDataConfig {

    public String username = "17010281698";
    public String password = "123456";
    public String input;
    public String expected;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }


    public HashMap<String, Object> optional = new HashMap<String, Object>();
}
