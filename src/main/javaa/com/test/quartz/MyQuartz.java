package com.test.quartz;

import com.test.util.EmailUtil;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016��4��22������10:36:36
 */
public class MyQuartz {
	public void work(){
		EmailUtil.sendEmail("Quartz", "Quartz Message");
	}

}
