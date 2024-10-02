package com.itwill.user;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.user.mapper.UserMapper;

public class UserDaoImplMyBatisInterface implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImplMyBatisInterface() throws Exception {
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config-interface.xml"));
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : update() 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(UserMapper.class).update(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : findUser() 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user=sqlSession.getMapper(UserMapper.class).findUser(userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : findUserList 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<User> userList=sqlSession.getMapper(UserMapper.class).findUserList();
		sqlSession.close();
		return userList;
	}

	@Override
	public int insert(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : insert() 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(UserMapper.class).insert(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int delete(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : delete() 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(UserMapper.class).delete(userId);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int countByUserId(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisInterface : countByUserId 호출  ");
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(UserMapper.class).countByUserId(userId);
		sqlSession.close();
		return rowCount;
	}

}