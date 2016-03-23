package com.zhongshan.ga.logger;

import org.apache.log4j.Logger;

/**
 * 日志输出工具类
 * @author public
 *
 */
public class GenerateLog {
	
	// 实例化日志生成器对象
	private static Logger logger = Logger.getLogger(GenerateLog.class);
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static Logger getInstance() {
		return logger;
	}
	
	/**
	 * 输出Info级别的日志
	 * @param info 日志信息
	 */
	public static void outInfo(Object info) {
		logger.info("*******************" + info + "*******************");
	}
	
	/**
	 * 输出Error级别的日志
	 * @param info 日志信息
	 */
	public static void outError(Object info) {
		logger.error("******************" + info + "*******************");
	}
	
	/**
	 * 输出Warn级别的日志
	 * @param info 日志信息
	 */
	public static void outWarn(Object info) {
		logger.warn("*******************" + info + "*********************");
	}
	
	/**
	 * 输出Debug级别的日志
	 * @param info 日志信息
	 */
	public static void outDebug(Object info) {
		logger.debug("*****************" + info + "***********************");
	}
}
