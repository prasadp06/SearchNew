package com.smartsearch.service.search.bl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smartsearch.service.search.dto.Search;

@Component
public interface SearchManager {
	
	public Search get(String query);
	public boolean update(Search tag);
	public boolean add(Search tag);
	public boolean delete(Search tag);
	public List<Search> search(String query);
	
}
