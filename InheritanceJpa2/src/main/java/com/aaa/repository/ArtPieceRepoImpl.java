package com.aaa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.model.ArtPiece;
import com.aaa.model.SearchRequest;


public class ArtPieceRepoImpl  {
	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * @Override public List<ArtPiece> findAll(SearchRequest request) {
	 * CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	 * CriteriaQuery<ArtPiece> criteriaQuery = builder.createQuery(ArtPiece.class);
	 * Root<ArtPiece> artPiece = criteriaQuery.from(ArtPiece.class); Predicate start
	 * = builder.greaterThanOrEqualTo(artPiece.get("createDateTime"),
	 * request.getStart()); Predicate end =
	 * builder.lessThanOrEqualTo(artPiece.get("createDateTime"), request.getEnd());
	 * Predicate finalPredicate = builder.and(start, end);
	 * 
	 * criteriaQuery.where(finalPredicate); List<ArtPiece> retval =
	 * entityManager.createQuery(criteriaQuery).getResultList(); return retval; }
	 * 
	 * @Override
	 * 
	 * @Transactional public void save(ArtPiece s) {
	 * 
	 * entityManager.persist(s); }
	 */
	

}
