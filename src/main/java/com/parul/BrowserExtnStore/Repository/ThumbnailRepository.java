package com.parul.BrowserExtnStore.Repository;

import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.Thumbnail;

@Repository
public interface ThumbnailRepository extends MongoRepository<Thumbnail, String> { 
	
	@Query("{'serialNo' : ?0}")
	public Thumbnail findAppDetailsInThumbnail(int serialNo);
	
	@Query("{'serialNo' : ?0}")
	@Update("{'$inc' : {'totalDownloads' : 1} }, {'$set' : {'monthlyDownloads' : ?1, 'weeklyDownloads' : ?2, 'lastDownloadedOn' : ?4}}")
	public void updateDownloadStats(int serialNo, Map<String, Integer> monthlyDownloads, Map<String, Integer> weeklyDownloads, int totalDownloads, java.sql.Date lastDownloadedOn);


}