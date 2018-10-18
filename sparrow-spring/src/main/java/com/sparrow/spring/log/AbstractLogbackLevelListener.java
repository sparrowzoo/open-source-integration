package com.sparrow.spring.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by harry on 2017/4/19.
 */
public abstract class AbstractLogbackLevelListener implements InitializingBean {
    public abstract String getLevel();

    private final void scan() {
        String level = this.getLevel();
        if (level==null||level.trim().equalsIgnoreCase("")) {
            return;
        }

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        List<Logger> loggerList = loggerContext.getLoggerList();
        Logger rootLogger= loggerContext.getLogger("ROOT");

        if(rootLogger==null||rootLogger.getLevel()==null){
            return;
        }

        if(rootLogger.getLevel().levelStr.equalsIgnoreCase(level)){
           return;
        }

        for (Logger logger : loggerList) {
            logger.setLevel(Level.toLevel(level, logger.getLevel()));
        }
    }

    public void afterPropertiesSet() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                scan();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
