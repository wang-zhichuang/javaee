package util;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
public static void writeLog(String info){
	File f=new File("d:/log.txt");
	try {
		FileWriter fw = new FileWriter(f, true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String currentTime = sdf.format(new Date());
		fw.write(currentTime + ":" + info + "\r\n");
		fw.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public static void main(String[] args) throws Exception {
	Log.writeLog("执行添加学生（001,张三，男）操作");
}
}
