package com.test.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月22日下午4:08:32
 */
public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInfo");
		String currentUsername=(String)super.getAvailablePrincipal(arg0);
		if(currentUsername!=null && "mike".equals(currentUsername)){
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			info.addRole("admin");
			info.addStringPermission("admin:manager");
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("AuthenticationInfo");
		UsernamePasswordToken token=(UsernamePasswordToken)arg0;
		if(token!=null && token.getUsername().equals("mike")){
			AuthenticationInfo info=new SimpleAuthenticationInfo("mike","mike",this.getName());
			return info;
		}
		return null;
	}

}
