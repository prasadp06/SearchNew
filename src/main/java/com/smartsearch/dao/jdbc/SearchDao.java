package com.smartsearch.dao.jdbc;

import java.util.ArrayList;

public class SearchDao {
	Integer id;
	String tagName; 
	String location; 
	String address; 
	Double lat; 
	Double lon;
	
	ArrayList<String> tags;
	
	public ArrayList<String> getTags() {
		if(tags == null){
			tags = new ArrayList<String>();
		}
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
