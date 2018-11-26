package com.sparrow.log.file;

import com.sparrow.log.root.RootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by harry on 2016/3/16.
 */
public class FileLogTest {

    private static Logger logger = LoggerFactory.getLogger(RootTest.class);

    public static void main(String[] args) {
        logger.info("root info");
    }
}
