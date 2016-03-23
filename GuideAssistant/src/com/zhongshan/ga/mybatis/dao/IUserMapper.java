package com.zhongshan.ga.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhongshan.ga.mybatis.bean.User;


/**
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 * @author public
 *
 */
public interface IUserMapper {
	
	// 使用@Insert注解指明add方法要执行的SQL
	@Insert("INSERT INTO USER (userName, userAge, userAddress) VALUES(#{userName}, #{userAge}, #{userAddress})")
	public int add(User user);
	
	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete("DELETE FROM USER WHERE id = #{id}")
	public int deleteById(int id);
	
	// 使用@Update注解指明update方法要执行的SQL
	@Update("UPDATE USER SET userName=#{userName}, userAge=#{userAge}, userAddress=#{userAddress}  where id=#{id}")
	public int update(User user);
	
	// 使用@Select注解指明getAll方法要执行的SQL
	@Select("select * from user")
	public List<User> getAll();
	
	// 使用@Select注解指明getById要执行的语句
	@Select("select * from user where id=#{id}")
	public User getById(int id);
}
