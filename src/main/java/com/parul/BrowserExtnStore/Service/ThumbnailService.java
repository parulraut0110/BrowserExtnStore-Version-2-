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

	
	public void saveThumbnail(int serialNo) throws IOException {
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setSerialNo(serialNo);
		thumbnail.setRatings(new int[] {10, 20, 30, 40, 50});
		thumbnail.setTotalDownloads(0);
		thumbnail.setRaters(0);
		Binary thumbnailData = new Binary(Files.readAllBytes(Paths.get("C:\\Users\\parul\\Downloads\\Dark_Mode_Logo.png")));
		thumbnail.setThumbnail(thumbnailData);
		thumbnail.setMimeType("image/png");
		//thumbnail.setMonthlyDownloads(new int[] {30, 40, 100, 50});
		thumbRepo.save(thumbnail);
		System.out.println("Entered Successfully");
	}
	
	public List<SearchResultDTO> findInThumnailRepo(List<SearchResultDTO> dtos) {
		for(SearchResultDTO dto : dtos) {
			Query query = new Query();
			query.addCriteria(Criteria.where("serialNo").is(dto.getSerialNo()));
			Thumbnail thumbnail = mongoTemplate.findOne(query, Thumbnail.class);
			dto.setReviews(thumbnail.getReviews());
			dto.setThumbnailBase64(Base64.getEncoder().encodeToString(thumbnail.getThumbnail().getData()));
			dto.setRaters(thumbnail.getRaters());
			int[] ratings = thumbnail.getRatings();	
			float rating = ((float)ratings[0] + 2*ratings[1] + 3*ratings[2] + 4*ratings[3] + 5*ratings[4])/thumbnail.getRaters();
			dto.setRating(rating);
			dto.setMimeType(thumbnail.getMimeType());
			System.out.println("thumbnail: " + thumbnail.getThumbnail().getData().length);
			System.out.println("thumbnail: " + thumbnail.getThumbnail().getData().length);
			System.out.println("rating : " + dto.getRating());
			System.out.println("review1 : " + thumbnail.getReviews()[1]);
			System.out.println("raters : " + thumbnail.getRaters());
			System.out.println("2nd month Downloads : " + (thumbnail.getMonthlyDownloads())[1]);
			System.out.println("mimeType : " + thumbnail.getMimeType());
			
		}
		return dtos;
	}

}
