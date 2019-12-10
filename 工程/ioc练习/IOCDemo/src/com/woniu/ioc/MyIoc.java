/**  
 * All rights Reserved, Designed By www.woniuxy.com
 * @Title:  Account.java   
 * @Package com.woniu.domain   
 * @Description:    Description  
 * @author: 蜗牛学院  
 * @date:   2019年10月13日 下午7:11:22
 * @user:   Administrator  
 * @version V1.0 
 * @Copyright: 2019 www.woniuxy.com Inc. All rights reserved. 
 * 注意：本内容仅限于成都蜗牛创想科技有限公司，禁止外泄以及用于其他的商业目
 */ 
package com.woniu.ioc;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Administrator
 *
 */
public class MyIoc {
	private static ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<String,Object>();
	/**
	 * 
	 */
	public static void init() {
		
		try {
			InputStream in = MyIoc.class.getClassLoader().getResourceAsStream("ioc.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for(Element e : list) {
				String beanClass = e.attribute("class").getValue();
				String className = e.attribute("id").getValue();
				Object obj = Class.forName(beanClass).newInstance();
				map.put(className, obj);		
				List<Element> pro = e.elements();
				if(!(pro.isEmpty())) {
					for(Element p : pro) {																		
						String beanName = p.attribute("name").getValue();
						String ref = p.attribute("ref").getValue();
						Field f = obj.getClass().getDeclaredField(beanName);
						f.setAccessible(true);
						f.set(obj, map.get(ref));
					}
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Object getBean(String beanName) {
		init();
		return map.get(beanName);
	}
}
