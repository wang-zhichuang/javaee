package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ArticleDao;
import vo.Article;

public class JdbcTemplateTest {
	 ArticleDao articleDao;

	@Before
	public void before() throws Exception {
		 //取得Bean类并且映射为DAO类
		   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");	       
	        articleDao = ctx.getBean(ArticleDao.class);
	}

	

	@Test
	public void testFind() {
		  System.out.println(articleDao.find(3).getContent());
	}

	@Test
	public void testUpdate() {
		Article article=new Article();
		article.setId(2);
        article.setTitle("title2");
        article.setContent("content2");
        articleDao.update(article);  
	}

	@Test
	public void testDelete() {
		  articleDao.delete(2);
	}

	@Test
	public void testAdd() {
		Article article=new Article("title111","content111");
        articleDao.add(article);     
	}

	@Test
	public void testList() {
		List<Article> articleList=articleDao.list(0,5);
		for(Article article:articleList) {
			System.out.println(article.getContent());
		}
		
	}

}
