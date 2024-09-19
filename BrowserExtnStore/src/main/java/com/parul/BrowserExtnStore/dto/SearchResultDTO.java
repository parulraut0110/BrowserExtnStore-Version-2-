package com.parul.BrowserExtnStore.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

public class SearchResultDTO {
	private byte[] thumbnail;
    private String extensionName;
    private String description;
    private String browserLink;
    private float rating;
    private int rated;
    private String[] feedbacks;
    
    
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getRated() {
		return rated;
	}
	public void setRated(int rated) {
		this.rated = rated;
	}
	public String[] getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(String[] feedbacks) {
		this.feedbacks = feedbacks;
	}
 
	
}
