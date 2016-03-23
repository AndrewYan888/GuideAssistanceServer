package com.zhongshan.ga.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhongshan.ga.logger.GenerateLog;

public class MyBatisUtil {
	
	
	/**
      * 获取SqlSessionFactory
      * @return SqlSessionFactory
     */
     public static SqlSessionFactory getSqlSessionFactory() {
	         String resource = "SqlMapConfig.xml";
	         GenerateLog.outDebug("读取MyBatis配置文件--SqlMapConfig.xml");
         InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
         GenerateLog.outDebug("创建SqlSessionFactory");
         return factory;
     }
     
     /**
      * 获取SqlSession
      * @return SqlSession
      */
     public static SqlSession getSqlSession() {
         SqlSession sqlSession =  getSqlSessionFactory().openSession();
         GenerateLog.outDebug("打开SqlSession非自动提交");
         return sqlSession;
     }
     
     /**
      * 获取SqlSession
      * @param isAutoCommit 
      *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
      *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
      * @return SqlSession
      */
     public static SqlSession getSqlSession(boolean isAutoCommit) {
    	 SqlSession sqlSession = getSqlSessionFactory().openSession(isAutoCommit);
    	 GenerateLog.outDebug("打开SqlSession非自动提交");
    	 return sqlSession;
     }
}
