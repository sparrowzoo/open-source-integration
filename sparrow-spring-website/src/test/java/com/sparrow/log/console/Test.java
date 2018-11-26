package com.sparrow.log.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by harry on 2015/7/9.
 */
public class Test {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.debug("console{},{}{}", 1, 2,3,5,5);

        String format = "test {}{}";
        Object[] as = new Object[]{"1", 2};
        int i = 0;
        while (format.indexOf("{}") > 0) {
            format = format.replaceFirst("\\{\\}", String.valueOf(as[i]));
            i++;
        }
        System.out.println(format);
    }
}
