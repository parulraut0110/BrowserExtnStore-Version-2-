package com.parul.BrowserExtnStore.dto;


import java.util.ArrayList;

import org.bson.types.Binary;

import lombok.Data;
import lombok.NoArgsConstructor;

public class SearchResultDTO {
	//Fields for mysql
	private int serialNo;
    private String extensionName;
    private String description;
    private String browserLink;
    private String versionNo;
    private byte[] extension;

    
    //Fields for mongodb
	private String[] reviews;
	private Binary thumbnail;
	private int raters;
	private float rating;
	private String MINEType;
	
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrowserLink() {
		return browserLink;
	}
	public void setBrowserLink(String browserLink) {
		this.browserLink = browserLink;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public byte[] getExtension() {
		return extension;
	}
	public void setExtension(byte[] extension) {
		this.extension = extension;
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
	public String getMINEType() {
		return MINEType;
	}
	public void setMINEType(String mINEType) {
		MINEType = mINEType;
	}

	
	
}
