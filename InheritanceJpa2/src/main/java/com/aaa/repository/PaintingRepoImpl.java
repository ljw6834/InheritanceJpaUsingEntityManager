package com.aaa.repository;

import java.util.ArrayList;
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
import com.aaa.model.Painting;
import com.aaa.model.SearchRequest;

@Repository
public class PaintingRepoImpl implements IPaintingRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Painting> findAllAndCountry(SearchRequest request) {
		List<Painting> retval = null; 
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Painting> criteriaQuery = builder.createQuery(Painting.class);
		Root<Painting> painting = criteriaQuery.from(Painting.class);

		List<Predicate> predicates = new ArrayList<>();
		if (request.getStart() != null) {
			predicates.add(builder.greaterThanOrEqualTo(painting.get("createDateTime"), request.getStart()));
		}
		if (request.getEnd() != null) {
			predicates.add(builder.lessThanOrEqualTo(painting.get("createDateTime"), request.getEnd()));
		}
		if (request.getCountry() != null) {
			predicates.add(builder.equal(painting.get("country"), request.getCountry()));
		}

		if (!predicates.isEmpty()) {
			criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			retval = entityManager.createQuery(criteriaQuery).getResultList();
		}
		 
		return retval;
	}

}
