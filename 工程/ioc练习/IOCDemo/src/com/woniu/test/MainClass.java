/**  
 * All rights Reserved, Designed By www.woniuxy.com
 * @Title:  Account.java   
 * @Package com.woniu.domain   
 * @Description:    Description  
 * @author: 铚楃墰瀛﹂櫌  
 * @date:   2019骞�10鏈�13鏃� 涓嬪崍7:55:40
 * @user:   Administrator  
 * @version V1.0 
 * @Copyright: 2019 www.woniuxy.com Inc. All rights reserved. 
 * 娉ㄦ剰锛氭湰鍐呭浠呴檺浜庢垚閮借湕鐗涘垱鎯崇鎶�鏈夐檺鍏徃锛岀姝㈠娉勪互鍙婄敤浜庡叾浠栫殑鍟嗕笟鐩�
 */ 
package com.woniu.test;

import com.woniu.ioc.MyIoc;
import com.woniu.service.UserService;

/**
 * @author Administrator
 *
 */
public class MainClass {
	public static void main(String[] args) {
		UserService us = (UserService) MyIoc.getBean("userService");
		us.insert();
		us.delete();
	}
}
