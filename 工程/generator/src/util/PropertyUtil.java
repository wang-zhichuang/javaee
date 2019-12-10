package util;

import java.util.Properties;

public class PropertyUtil {
	private static Properties pr = new Properties();
	static {
		try {
			pr.load(PropertyUtil.class.getClassLoader().getResourceAsStream("generator.properties"));			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static String get(String key) {
        return pr.getProperty(key);
	}
}
