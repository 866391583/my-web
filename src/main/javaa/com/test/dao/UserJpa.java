package com.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.bean.User;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月21日上午10:43:06
 */
@Repository
public interface UserJpa extends CrudRepository<User, Integer> {

}
