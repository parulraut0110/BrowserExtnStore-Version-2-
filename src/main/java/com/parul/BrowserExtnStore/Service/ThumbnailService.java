package com.parul.BrowserExtnStore.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.parul.BrowserExtnStore.Entity.Thumbnail;
import com.parul.BrowserExtnStore.Repository.ThumbnailRepository;
import com.parul.BrowserExtnStore.dto.SearchResultDTO;

@Service
public class ThumbnailService {
	@Autowired
	ThumbnailRepository thumbRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	public void saveThumbnail() throws IOException {
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setSerialNo(1);
		thumbnail.setRating(0.0F);
		thumbnail.setRaters(0);
		Binary thumbnailData = new Binary(Files.readAllBytes(Paths.get("C:\\Users\\parul\\Downloads\\Dark_Mode_Logo.png")));
		thumbnail.setThumbnail(thumbnailData);
		thumbnail.setMimeType("image/png");
		thumbRepo.save(thumbnail);
		System.out.println("Entered Successfully");
	}
	
	public List<SearchResultDTO> findInThumnailRepo(List<SearchResultDTO> dtos) {
		for(SearchResultDTO dto : dtos) {
			Query query = new Query();
			query.addCriteria(Criteria.where("serialNo").is(dto.getSerialNo()));
			//Thumbnail thumbnail = mongoTemplate.findOne(query, Thumbnail.class);
			dto = mongoTemplate.findOne(query, SearchResultDTO.class);
			/*
			dto.setReviews(thumbnail.getReviews());
			dto.setThumbnailBase64(Base64.getEncoder().encodeToString(thumbnail.getThumbnail().getData()));
			dto.setRaters(thumbnail.getRaters());
			dto.setRating(thumbnail.getRating());
			dto.setMimeType(thumbnail.getMimeType());
			System.out.println("thumbnail: " + thumbnail.getThumbnail().getData().length);
			System.out.println("thumbnail: " + thumbnail.getThumbnail().getData().length);
			System.out.println("rating : " + thumbnail.getRating());
			System.out.println("review1 : " + thumbnail.getReviews()[1]);
			System.out.println("raters : " + thumbnail.getRaters());
			System.out.println("mimeType : " + thumbnail.getMimeType());
			 */
		}
		return dtos;
	}

}
