package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.dao.UserJpa;
@Service
public class UserService {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	UserJpa userJpa;
	public void printInfo(){
		System.out.println(user.getEmail()+"and "+user.getName());
		userDao.getAllUsers();
		
		User tmp=new User();
		tmp.setEmail("test@jpa.org");
		tmp.setName("jpa test");
		userJpa.save(tmp);
		List<User> userList=(List<User>) userJpa.findAll();
		System.out.println(userList.size());
		for(User u:userList)
		{
			System.out.println(u.getId()+" "+u.getName()+" "+u.getEmail());
		}
	}
	

}
