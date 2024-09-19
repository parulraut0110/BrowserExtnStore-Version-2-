package com.parul.BrowserExtnStore.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parul.BrowserExtnStore.Entity.Thumbnail;
import com.parul.BrowserExtnStore.Repository.ThumbnailRepository;

@Service
public class ThumbnailService {
	@Autowired
	ThumbnailRepository thumbRepo;
	
	public void saveThumbnail() throws IOException {
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setSerialNo("1");
		thumbnail.setRating(0.0F);
		thumbnail.setRaters(0);
		Binary thumbnailData = new Binary(Files.readAllBytes(Paths.get("C:\\Users\\parul\\Downloads\\Dark_Mode_Logo.png")));
		thumbnail.setThumbnail(thumbnailData);
		thumbRepo.save(thumbnail);
		System.out.println("Entered Successfully");
	}
}
