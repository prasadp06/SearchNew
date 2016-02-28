package com.smartsearch.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.smartsearch.dao.jdbc.SearchDao;
//com.smartsearch.dao.jdbc.impl.SearchDaoServiceImpl
public class SearchDaoServiceImpl implements SearchDoaService{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate template;
	
	//private final String COLUMNS = 
	
	//id INT, name VARCHAR(50), location VARCHAR(5), address VARCHAR(50), lat FLOAT, lon FLOAT, created DATE, updated DATE
	private static final String INSERT_SEARCH = " INSERT INTO search (id, name, location, address, lat, lon, created , updated) "
			+ "	VALUES (null, ? , ?, ? , ?, ?, ?,?)";
	private static final String INSERT_TAGS = " INSERT INTO tags (id, search_id, tag) "
			+ "	VALUES (?, ? , ?)";
	private static final String UDPATE_SEARCH = " UPDATE search SET name = ?, location = ? , address = ? , lat = ?, lon = ? , updated = ? WHERE id = ? ";
	private static final String DELETE_SEARCH = " DELETE from search WHERE id = ?";
	private static final String DELETE_SEARCH_TAG = " DELETE from tags WHERE search_id = ?";
	private static final String GET_SEARCH = " SELECT id, name, location, address, lat, lon FROM search where name like ? ";
	
	private static final String GET_SEARCH_TAGS = " SELECT s.id, name, location, address, lat, lon, tag FROM search s, tags t "
			+ "	where s.id = t.search_id and name like ? ";
	//private static final String GET_SEARCH = " SELECT name FROM search where name like ? ";
	
	public SearchDaoServiceImpl(){
		
	}
	
	@Override
	public void insert(final SearchDao search) {
		// TODO Auto-generated method stub
		System.out.println("Inside !!");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
//		this.template.update(INSERT_SEARCH, new Object[]{
//				search.getTagName(), 
//				search.getLocation(), 
//				search.getAddress(), 
//				search.getLat(), 
//				search.getLon(), 
//				d, 
//				d
//				});
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pStmt = con.prepareStatement(INSERT_SEARCH, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, search.getTagName());
				pStmt.setString(2, search.getLocation());
				pStmt.setString(3, search.getAddress());
				pStmt.setDouble(4, search.getLat());
				pStmt.setDouble(5, search.getLon());
				pStmt.setDate(6, d);
				pStmt.setDate(7, d);
				return pStmt;
			}
		}, keyHolder);
		
		search.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void update(SearchDao search) {
		System.out.println("Inside Update !!" + search.getTagName() + search.getAddress() + search.getId()) ;
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		this.template.update(UDPATE_SEARCH, new Object[]{
				search.getTagName(),
				search.getLocation(),
				search.getAddress(),
				search.getLat(),
				search.getLon(),
				d,
				search.getId()
		});
		
	}

	@Override
	public void delete(SearchDao search) {
		this.template.update(DELETE_SEARCH_TAG, new Object[]{search.getId()});
		this.template.update(DELETE_SEARCH, new Object[]{search.getId()});
	}

	
	public List<SearchDao> searchTags(String query) {
		return this.template.query(GET_SEARCH_TAGS, new Object[]{"%"+query+"%"}, new SearchResultExtractor());
	}

	@Override
	public List<SearchDao> get(String query) {
		return this.template.query(GET_SEARCH, new Object[]{"%"+query+"%"}, new SearchRawMapper());
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}
	
	private static class SearchRawMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			SearchDao dao = new SearchDao();
			dao.setId(rs.getInt("id"));
			dao.setTagName(rs.getString("name"));
			dao.setLocation(rs.getString("location"));
			dao.setLat(rs.getDouble("lat"));
			dao.setLon(rs.getDouble("lon"));
			return dao;
		}
		
	}
	
	
	private static class SearchResultExtractor implements ResultSetExtractor<List<SearchDao>> {

		@Override
		public List<SearchDao> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, SearchDao> sList = new HashMap<Integer, SearchDao>();
			SearchDao dao; 
			
			if(rs != null){
				while(rs.next()){
					Integer sId = rs.getInt("id");
					dao = sList.get(sId);
					
					if(dao == null){
						dao = new SearchDao();
						dao.setId(rs.getInt("id"));
						dao.setTagName(rs.getString("name"));
						dao.setLocation(rs.getString("location"));
						dao.setLat(rs.getDouble("lat"));
						dao.setLon(rs.getDouble("lon"));
						dao.getTags().add(rs.getString("tag"));
						sList.put(sId, dao);
					}else {
						dao.getTags().add(rs.getString("tag"));
					}
					
				}
			}
			return new ArrayList<>(sList.values());
		}
		
	}

}
