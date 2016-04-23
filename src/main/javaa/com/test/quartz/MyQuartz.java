package com.test.quartz;

import com.test.util.EmailUtil;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月22日下午10:36:36
 */
public class MyQuartz {
	public void work(){
		EmailUtil.sendEmail("Quartz", "Quartz Message");
	}

}
