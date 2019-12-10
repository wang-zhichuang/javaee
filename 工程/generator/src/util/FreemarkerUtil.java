package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil
{
	private static FreemarkerUtil util;
	private static Configuration cfg;
	
	private FreemarkerUtil(){
		
	}
	
	public static FreemarkerUtil getInstance(String pname){
		if(util==null){
			 cfg=new Configuration();
			 cfg.setDefaultEncoding("UTF-8");
			 cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);//设置模板文件所在路径，不包括文件名（基于类相对路径）
			 util=new FreemarkerUtil();
		}
		return util;
	}
	
	public static FreemarkerUtil getInstance(File pname) throws Exception{
		if(util==null){
			 cfg=new Configuration();
			 cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(pname);//设置模板文件所在路径，不包括文件名（绝对路径）
			 util=new FreemarkerUtil();
		}
		return util;
	}
	/**
	 * 获取模板对象
	 * @param fname 模板文件名称
	 * @return
	 */
	private Template getTemplate(String fname){//fname为模板文件名称
		try
		{
			return cfg.getTemplate(fname);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过标准输出流输出模板的结果
	 * @param root 数据对象
	 * @param fname 模板文件名
	 */
	public void sprint(Map<String,Object>root,String fname){
		try
		{
			
			  Writer out = null; 
		      out = new BufferedWriter(new OutputStreamWriter(System.out));  
		      getTemplate(fname).process(root, out);
		         
		}
		catch (TemplateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 基于文件输出
	 * @param root 数据对象
	 * @param fname 模板文件名
	 * @param outpath 输出文件路径
	 */
	public void fprint(Map<String,Object> root, String fname, String outpath){
		try
		{
			
			 Writer out =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outpath),"UTF-8")); 
		      getTemplate(fname).process(root,out);
		      out.close();
		      
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (TemplateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
}
