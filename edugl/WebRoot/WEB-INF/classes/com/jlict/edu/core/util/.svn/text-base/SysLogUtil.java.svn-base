/**
 * 
 */
package com.jlict.edu.core.util;

import org.apache.log4j.Logger;

/**
 * <p>Title: com.jlict.hrgl.core.util.SysLogUtil.java</p>
 * <p>Description: 系统日志工具类</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class SysLogUtil {
	private static Logger logger = Logger.getLogger("hrgl");
	public static void debug(Object message) {
        //   if (inited)
        {
            logger.debug(message);
        }
    }

    public static void debug(Object message, Throwable t) {
        //   if (inited)
        {
            logger.debug(message, t);
        }
    }

    public static void error(Object message) {

        {
            logger.error(message);
        }
    }
    public static void error(Throwable t) {

        {
            logger.error(t.getMessage(), t);
        }
    }

    public static void error(Object message, Throwable t) {

        {
            logger.error(message, t);
        }
    }

    public static void fatal(Object message) {
        {
            logger.fatal(message);
        }
    }

    public static void fatal(Throwable t) {
        {
            logger.fatal(t.getMessage(), t);
        }
    }
    
    public static void fatal(Object message, Throwable t) {
        {
            logger.fatal(message, t);
        }
    }

    public static void info(Object message) {
        {
            logger.info(message);
        }
    }

    public static void info(Object message, Throwable t) {
        {
            logger.info(message, t);
        }
    }
    public static void warn(Object message) {
        {
            logger.warn(message);
        }
    }
    public static void warn(Throwable t) {
        {
            logger.warn(t.getMessage(), t);
        }
    }

    public static void warn(Object message, Throwable t) {
        {
            logger.warn(message, t);
        }
    }

    public static boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public static boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }
}
