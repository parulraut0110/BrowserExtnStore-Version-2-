package com.parul.BrowserExtnStore.Entity;

import java.util.Map;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Document(collection = "ExtensionStore")
public class Thumbnail {
	@Id 
	//@Field(targetType = FieldType.INT32, value = "x")
	private String id;
	private int serialNo;
	private String[] reviews;
	private Binary thumbnail;
	private int raters;
	private int[] ratings;
	private String mimeType;
	private Map<String, Integer> monthlyDownloads;
	private Map<String, Integer> weeklyDownloads;
	private int totalDownloads;	
	
	public String getId() {
		return id;
	}	
	
	public int getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(int  serialNo) {
		this.serialNo = serialNo;
	}
	
	public String[] getReviews() {
		return reviews;
	}
	
	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}
	
	public Binary getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(Binary thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public int getRaters() {
		return raters;
	}
	
	public void setRaters(int raters) {
		this.raters = raters;
	}
	
	public int[] getRatings() {
		return ratings;
	}
	
	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public int getTotalDownloads() {
		return totalDownloads;
	}
	
	public void setTotalDownloads(int totalDownloads) {
		this.totalDownloads = totalDownloads;
	}
	public Map<String, Integer> getMonthlyDownloads() {
		return monthlyDownloads;
	}
	public void setMonthlyDownloads(Map<String, Integer> monthlyDownloads) {
		this.monthlyDownloads = monthlyDownloads;
	}
	public Map<String, Integer> getWeeklyDownloads() {
		return weeklyDownloads;
	}
	public void setWeeklyDownloads(Map<String, Integer> weeklyDownloads) {
		this.weeklyDownloads = weeklyDownloads;
	}

}
