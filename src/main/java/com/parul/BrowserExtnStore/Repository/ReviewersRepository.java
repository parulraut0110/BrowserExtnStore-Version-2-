package com.parul.BrowserExtnStore.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.ReviewerDoc;

@Repository
public interface ReviewersRepository extends MongoRepository<ReviewerDoc, String> {
	
}
