package com.jaytang.model.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具
 */
public class LogUtil {

    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String msg){
        logger.info(msg);
    }
    public static void debug(String msg){
        logger.debug(msg);
    }
    public static void warn(String msg){
        logger.warn(msg);
    }
    public static void error(String msg){
        logger.error(msg);
    }
}
