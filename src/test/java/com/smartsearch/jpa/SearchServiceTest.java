package com.smartsearch.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smartsearch.dao.hibernate.data.SearchDao;
import com.smartsearch.dao.hibernate.repositories.SearchRepository;

import junit.framework.TestCase;

public class SearchServiceTest extends TestCase {
	public static void main(String args[]){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("search-servlet.xml");
		
		SearchRepository search = ctx.getBean("mySearchServcice", SearchRepository.class);
		List<SearchDao> list = search.findAll();
		
		for(SearchDao dao : list){
			
			System.out.println(dao.getTagName());
		}
	}
	
	public void testMaven() {
		assertTrue(true);
	}
}
