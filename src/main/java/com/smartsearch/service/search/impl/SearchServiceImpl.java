package com.smartsearch.service.search.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartsearch.service.search.SearchService;
import com.smartsearch.service.search.bl.SearchManager;
import com.smartsearch.service.search.dto.Search;

public class SearchServiceImpl implements SearchService{

	public void setSearchManager(SearchManager searchManager) {
		this.searchManager = searchManager;
	}

	@Autowired
	SearchManager searchManager;
	
	@Override
	public  List<Search> search(String keys) {
		System.out.println("Inside Search " + keys);
		return searchManager.search(keys);
	}

	@Override
	public Response updateTag(Search tag) {
		return Response.ok(searchManager.update(tag)).build();
	}

	@Override
	public Response addTag(Search tag) {
		return Response.ok(searchManager.add(tag)).build();
	}

	@Override
	public Response delete(Search tag) {
		return Response.ok(searchManager.delete(tag)).build();
	}

	@Override
	public Search get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
