package com.parul.BrowserExtnStore.Entity;

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
	private String imgName;    
	private String serialNo;
	private String[] reviews;
	private Binary thumbnail;
	private int raters;
	private float rating;
	private String mimeType;
	
	public String getId() {
		return id;
	}	
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		mimeType = mimeType;
	}
	
}
