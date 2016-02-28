package com.smartsearch.service.search.bl;

import java.util.ArrayList;
import java.util.List;

import com.smartsearch.dao.jdbc.SearchDao;
import com.smartsearch.dao.jdbc.impl.SearchDoaService;
import com.smartsearch.service.search.dto.Search;

public class SearchManagerImpl implements SearchManager {

	
	SearchDoaService searchDaoService;
	
	public static ArrayList<Search> keywords = new ArrayList<>();
	static {
		Search s  = new Search();
		s.setTagName("123");
		s.setLocation("Location");
		s.setAddress("123 Address");
		s.setLon(12.34);
		s.setLat(178.9900);
		s.setTags(new ArrayList<String>());
		s.getTags().add("One");
		
		keywords.add(s);
	}
	
	@Override
	public Search get(String query) {
		for(int i = 0; i<keywords.size(); i++){
			if(keywords.get(i).getTagName().contains(query)){
				return keywords.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean update(Search tag) {
		for(int i = 0; i<keywords.size(); i++){
			if(keywords.get(i).getTagName().equals(tag.getTagName())){
				keywords.set(i, tag);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Search tag) {
		keywords.add(tag);
		return true;
	}

	@Override
	public boolean delete(Search tag) {
		for(int i = 0; i<keywords.size(); i++){
			if(keywords.get(i).getTagName().equals(tag.getTagName())){
				keywords.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Search> search(String query) {
		List<SearchDao> list = searchDaoService.get(query);
		List<Search> result = new ArrayList<Search>();
		for(SearchDao dao : list){
			result.add(copyFromDao(dao));
		}
		return result;
	}

	public void setSearchDaoService(SearchDoaService searchDaoService) {
		this.searchDaoService = searchDaoService;
	}
	
	private SearchDao copyToDao(Search dto){
		SearchDao dao = new SearchDao();
		return dao;
	}

	
	private Search copyFromDao(SearchDao dao){
		Search dto  = new Search();
		dto.setTagName(dao.getTagName());
		dto.setLocation(dao.getLocation());
		dto.setAddress(dao.getAddress());
		dto.setLon(dao.getLat());
		dto.setLat(dao.getLon());
		dto.setTags(new ArrayList<String>());
		dto.getTags().add("One");
		
		return dto;
	}
}
