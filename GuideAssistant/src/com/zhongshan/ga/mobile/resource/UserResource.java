package com.zhongshan.ga.mobile.resource;

import org.apache.ibatis.session.SqlSession;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.zhongshan.ga.mybatis.bean.User;
import com.zhongshan.ga.mybatis.dao.IUserMapper;
import com.zhongshan.ga.utils.MyBatisUtil;

public class UserResource extends ServerResource {
	private int id; // 主键

	/**
	 * 获取请求的用户Id
	 */
	@Override
	protected void doInit() throws ResourceException {
		// TODO Auto-generated method stub
		id = Integer.valueOf((String) getRequestAttributes().get("id"));
	}
	
	@Get
	public Representation get(Representation entity) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 *  得到IUserMapper 接口对象的实现类对象，
		 *  IUserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		 */
		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		User user = mapper.getById(id);
		Gson gson = new Gson();
		return new StringRepresentation(gson.toJson(user));
	}
	
}
