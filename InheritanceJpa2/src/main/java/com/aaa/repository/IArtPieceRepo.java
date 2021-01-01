package com.aaa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aaa.model.ArtPiece;

@Repository
public interface IArtPieceRepo extends JpaRepository<ArtPiece, Long> {
	
	@Query("select a from ArtPiece a where a.createDateTime >= ?1 and a.createDateTime <= ?2")
	public List<ArtPiece> findAll(LocalDateTime start, LocalDateTime end);

}
