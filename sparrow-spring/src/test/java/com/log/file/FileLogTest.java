package com.log.file;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * created by harry on 2016/3/16.
 */
public class FileLogTest {

    public static void main(String[] args) {
        LoggerContext loggerContext=(LoggerContext) LoggerFactory.getILoggerFactory();

        List<ch.qos.logback.classic.Logger> loggerList= loggerContext.getLoggerList();
        for(ch.qos.logback.classic.Logger logger:loggerList){
            logger.setLevel(Level.ERROR);
            System.out.println(logger);
            System.out.println(logger.getLevel());
        }

        ch.qos.logback.classic.Logger l=(ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.log.file.ok.o.dd");
        l.debug("test test");
    }
}
