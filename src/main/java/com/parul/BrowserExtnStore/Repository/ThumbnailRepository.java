package com.parul.BrowserExtnStore.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.Thumbnail;

@Repository
public interface ThumbnailRepository extends MongoRepository<Thumbnail, String> { 
	
	@Query("{'serialNo' : ?0}")
	public Thumbnail findAppDetailsInThumbnail(int serialNo);
}
