package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

/**
 * Created by jiaxiong on 2019-01-20 11:38
 */
public class XueqiuConfig {

    public XueqiuDataConfig xueqiuDataConfig;


    public static XueqiuConfig load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            XueqiuConfig config = mapper.readValue(XueqiuConfig.class.getResource(path), XueqiuConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
