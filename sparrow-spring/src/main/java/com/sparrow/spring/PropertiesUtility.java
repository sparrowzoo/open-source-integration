package com.sparrow.spring;

import com.sparrow.utility.StringUtility;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by harry on 2015/7/13.
 */
public class PropertiesUtility {
    public static void init(String evaPathKey) {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        Resource resource = new FileSystemResource(System.getenv(evaPathKey));
        propertyPlaceholderConfigurer.setLocation(resource);
    }

    public static String getValue(String propertiesFileName, String key) {
        Properties props = new Properties();
        if (StringUtility.isNullOrEmpty(key)) {
            return null;
        }
        String filePath = "/" + propertiesFileName
                + ".properties";
        try {
            props.load(PropertiesUtility.class.getResourceAsStream(filePath));
        } catch (IOException e) {
            return null;
        }
        return props.getProperty(key);
    }
}
