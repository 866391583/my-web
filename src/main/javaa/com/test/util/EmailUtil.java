package com.test.util;

import org.apache.commons.mail.MultiPartEmail;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016Äê4ÔÂ22ÈÕÏÂÎç9:21:12
 */
public class EmailUtil {
	public static void sendEmail(String subject,String msg){
		MultiPartEmail email=new MultiPartEmail();
		email.setHostName("smtp.yeah.net");
		email.setAuthentication("ciscog", "helloworld");
		
		try{
			email.setFrom("ciscog@yeah.net");
			email.addTo("ciscog@yeah.net");
			email.setSubject(subject);
			email.setMsg(msg);
			email.send();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
