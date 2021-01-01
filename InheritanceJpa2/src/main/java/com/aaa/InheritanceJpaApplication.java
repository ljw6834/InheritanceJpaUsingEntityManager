package com.aaa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import com.aaa.model.ArtPiece;
import com.aaa.model.Material;
import com.aaa.model.Painting;
import com.aaa.model.PaintingTechnique;
import com.aaa.model.Sculpture;
import com.aaa.model.SearchRequest;
import com.aaa.repository.ArtPieceRepoImpl;
import com.aaa.repository.IArtPieceRepo;
import com.aaa.repository.PaintingRepoImpl;

@SpringBootApplication
public class InheritanceJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InheritanceJpaApplication.class, args);
		
		  IArtPieceRepo artRepo = context.getBean(IArtPieceRepo.class);
		  PaintingRepoImpl paintingRepo = context.getBean(PaintingRepoImpl.class);
		 
	    ArtPiece sculpture = new Sculpture("John Doe", Material.WOOD, 220.2);
	    sculpture.setCreateDateTime(LocalDateTime.parse("2018-02-20T06:30:00"));
	    
	    ArtPiece painting1 = new Painting("Tom Smith", PaintingTechnique.ACRYLIC, 25.5, 44.9, "China");
	    painting1.setCreateDateTime(LocalDateTime.now());
        
	    ArtPiece painting2 = new Painting("Mike Bill", PaintingTechnique.ACRYLIC, 25.5, 44.9, "US");
	    painting2.setCreateDateTime(LocalDateTime.parse("2018-02-20T06:30:00"));

	    artRepo.save(sculpture);
	    artRepo.save(painting1);
	    artRepo.save(painting2);
	    
//	    SearchRequest request = new SearchRequest(null, LocalDateTime.parse("2017-02-20T06:30:00"), LocalDateTime.parse("2020-12-28T06:30:00"), "China");
	    SearchRequest request = new SearchRequest(null, null, null, "China");
		/*
		 * List<Painting> paintings =
		 * paintingRepo.findByPaintingTechniqueAndAuthor(PaintingTechnique.ACRYLIC,
		 * "Tom Smith"); System.out.println(paintings.get(0).getHeight());
		 */
	    
		
		  List<ArtPiece> arts = artRepo.findAll(request.getStart(), request.getEnd());
		  
		  System.out.println(arts.size());
		 
	    
	    List<Painting> paintings = paintingRepo.findAllAndCountry(request);
	    System.out.println(paintings.size());
	}
	

}
