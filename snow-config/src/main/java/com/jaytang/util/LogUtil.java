package com.jaytang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * 日志工具
 */
public class LogUtil {

    private static Logger logger ;
    private static final Object[] EMPTY_ARRAY = new Object[]{};
    private static final String FQCN = LogUtil.class.getName();

    private static LocationAwareLogger getLocationAwareLogger(final int depth) {

        return (LocationAwareLogger) LoggerFactory.getLogger(FQCN);
    }
    private static StackTraceElement findCaller(){
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if(callStack==null){
            return null;
        }else{
            StackTraceElement caller = null;
            String className = LogUtil.class.getName();
            boolean isEachLogClass = false;
            StackTraceElement[] var7 = callStack;
            int var6 = callStack.length;
            for(int var5=0;var5<var6;++var5){
                StackTraceElement s = var7[var5];
                if(className.equals(s.getClassName())){
                    isEachLogClass = true;
                }
                if(isEachLogClass && !className.equals(s.getClassName())){
                    isEachLogClass = false;
                    caller = s;
                    break;
                }
            }
        return caller;
        }
    }
    private static Logger logger(){
        StackTraceElement caller = findCaller();
        if(caller==null){
            return LoggerFactory.getLogger(LogUtil.class);
        }else{
            Logger logger = LoggerFactory.getLogger(caller.getClassName()+ "" +caller.getMethodName()+"."+caller.getLineNumber());
            return logger;
        }
    };
    public static void info(String msg) {
        getLocationAwareLogger(3).log(null, FQCN, LocationAwareLogger.INFO_INT,
                msg, EMPTY_ARRAY, null);
    }
//    public static void info(String msg){
//        logger.info(msg);
//    }
    public static void debug(String msg){
        logger().info(msg);
    }
    public static void warn(String msg){
        logger.warn(msg);
    }
    public static void error(String msg){
        logger.error(msg);
    }
}
