package com.test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.bean.User;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月20日下午6:18:10
 */
@Component
public class UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<User> getAllUsers(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from user");
		List<User> result=query.list();
		System.out.println(result.size());
		session.close();
		return result;
	}

}
