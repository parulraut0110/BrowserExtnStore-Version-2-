package com.parul.BrowserExtnStore.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.Thumbnail;

@Repository
public interface ThumbnailRepository extends MongoRepository<Thumbnail, String> { 
	
}
