package com.aaa.repository;

import java.util.List;

import com.aaa.model.Painting;
import com.aaa.model.SearchRequest;

public interface IPaintingRepo {

	public List<Painting> findAllAndCountry(SearchRequest request);
	
}
