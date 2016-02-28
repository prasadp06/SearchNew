package com.smartsearch.dao.jdbc.impl;

import java.util.List;

import com.smartsearch.dao.jdbc.SearchDao;

public interface SearchDoaService {
	
	public void insert(SearchDao search);
	public void update(SearchDao search);
	public void delete(SearchDao search);
	public List<SearchDao> get(String query);
}
