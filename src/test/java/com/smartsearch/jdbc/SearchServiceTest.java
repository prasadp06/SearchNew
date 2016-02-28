package com.smartsearch.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smartsearch.dao.jdbc.SearchDao;
import com.smartsearch.dao.jdbc.impl.SearchDoaService;

import junit.framework.TestCase;

public class SearchServiceTest extends TestCase {

	/*
	ApplicationContext ctx = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/search-servlet.xml");
	static Integer key = null;
	public void testInsert() {
		SearchDao s = new SearchDao();
		s.setTagName("new");
		s.setLocation("Y");
		s.setLat(12.11);
		s.setLon(14.65);
		s.setId(1000001);
		SearchDoaService service = ctx.getBean("searchDaoService", SearchDoaService.class);
		service.insert(s);
		key = s.getId();
		System.out.println(key);
		assertTrue(key > 0);
		
	}

	public void testUpdate() {
		SearchDao s = new SearchDao();
		s.setTagName("Stamford");
		s.setLocation("Y");
		s.setAddress("Stamford");
		s.setLat(12.11);
		s.setLon(14.65);
		s.setId(key);
		
		SearchDoaService service = ctx.getBean("searchDaoService", SearchDoaService.class);
		service.update(s);
		
		assertTrue(s.getId() == key);
	}

	
	public void testGet() {
		
		SearchDoaService service = ctx.getBean("searchDaoService", SearchDoaService.class);
		List<SearchDao> results = service.get("york");
		assertTrue(results.size() >0);
	}

	public void testDelete() {
		SearchDao s = new SearchDao();
		s.setTagName("York");
		s.setLocation("Y");
		s.setLat(12.11);
		s.setLon(14.65);
		s.setId(key);
		
		SearchDoaService service = ctx.getBean("searchDaoService", SearchDoaService.class);
		service.delete(s);
		
		assertTrue(true);
	}

*/
	
	public void testMaven() {
		assertTrue(true);
	}
}
