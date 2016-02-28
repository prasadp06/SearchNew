package com.smartsearch.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartsearch.dao.hibernate.data.SearchDao;
import com.smartsearch.dao.hibernate.repositories.SearchRepository;

@Repository
public class SearchServiceDaoImpl implements SearchRepository {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<SearchDao> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<SearchDao> findAll() {
		
		return this.sessionFactory.openSession().createCriteria(SearchDao.class).list();
				
				//.getO.createCriteria(SearchDao.class).list();
	}

	@Override
	public List<SearchDao> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends SearchDao> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchDao saveAndFlush(SearchDao arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SearchDao> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SearchDao arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends SearchDao> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<SearchDao> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchDao findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SearchDao> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
