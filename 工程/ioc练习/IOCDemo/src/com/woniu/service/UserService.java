/**  
 * All rights Reserved, Designed By www.woniuxy.com
 * @Title:  Account.java   
 * @Package com.woniu.domain   
 * @Description:    Description  
 * @author: 铚楃墰瀛﹂櫌  
 * @date:   2019骞�10鏈�13鏃� 涓嬪崍9:09:15
 * @user:   Administrator  
 * @version V1.0 
 * @Copyright: 2019 www.woniuxy.com Inc. All rights reserved. 
 * 娉ㄦ剰锛氭湰鍐呭浠呴檺浜庢垚閮借湕鐗涘垱鎯崇鎶�鏈夐檺鍏徃锛岀姝㈠娉勪互鍙婄敤浜庡叾浠栫殑鍟嗕笟鐩�
 */ 
package com.woniu.service;

import com.woniu.dao.UserDao;

/**
 * @author Administrator
 *
 */
public class UserService {
	public UserDao userDao;	
	public void insert() {
		userDao.insert();
	}
	public void delete(){
		userDao.delete();
	}
}
