package com.zhongshan.ga.test.junittest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zhongshan.ga.mybatis.bean.User;
import com.zhongshan.ga.mybatis.dao.IUserMapper;
import com.zhongshan.ga.utils.MyBatisUtil;



public class TestCRUDByAnnotationMapper {

	@Test
	public void testAdd() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = session.getMapper(IUserMapper.class);
		
		User user = new User();
		user.setUserAddress("广西");
		user.setUserAge(25);
		user.setUserName("会员12");
		// 调用接口方法
		int add = mapper.add(user);
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		session.close();
		System.out.println(add);
		
	}
	
	@Test
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		
		User user = new User();
		user.setUserName("Andrew");
		user.setUserAge(22);
		user.setUserAddress("广东");
		
		// 执行更新操作
		int retResult = mapper.update(user);
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testDelete() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = session.getMapper(IUserMapper.class);
		// 执行删除操作
		int retResult = mapper.deleteById(2);
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		session.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testGetUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		// 执行查询操作
		User user = mapper.getById(4);
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(user);
	}
	
	@Test
	public void testGetAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		// 执行查询操作
		List<User> users = mapper.getAll();
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(users.get(0).getUserName());
	}
}
