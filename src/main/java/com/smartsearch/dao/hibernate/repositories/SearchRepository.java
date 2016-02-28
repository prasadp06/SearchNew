package com.smartsearch.dao.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartsearch.dao.hibernate.data.SearchDao;

@Repository
public interface SearchRepository  extends JpaRepository<SearchDao, Integer>{

}
