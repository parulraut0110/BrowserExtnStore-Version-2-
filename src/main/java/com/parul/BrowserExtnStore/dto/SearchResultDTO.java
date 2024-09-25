package com.parul.BrowserExtnStore.dto;


import java.util.ArrayList;

import org.bson.types.Binary;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "extensions")
@SqlResultSetMapping(
    name = "SearchResultDTOMapping",
    classes = @ConstructorResult(
        targetClass = SearchResultDTO.class,
        columns = {
            @ColumnResult(name = "serialNo", type = Integer.class),
            @ColumnResult(name = "extensionName", type = String.class),
            @ColumnResult(name = "description", type = String.class),
            @ColumnResult(name = "browserLink", type = String.class),
            @ColumnResult(name = "versionNo", type = String.class),
            @ColumnResult(name = "extension", type = byte[].class)
        }
    )
)
@NamedNativeQuery(
    name = "ExtensionEntity.findSearchResults",
    query = "SELECT serialNo, extensionName, description, browserLink, versionNo, extension " + 
            "FROM extensions " +
            "WHERE MATCH(extensionName, description) " +
            "AGAINST (?1 WITH QUERY EXPANSION)",
    resultSetMapping = "SearchResultDTOMapping"
)

public class SearchResultDTO {
	//Fields for mysql
	@Id
	private int serialNo;
    private String extensionName;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    private String browserLink;
    private String versionNo;
    @Lob
    @Column(name = "extension", columnDefinition = "MEDIUMBLOB")
    private byte[] extension;

    //Fields for mongodb
	private String[] reviews;
	private Binary thumbnail;
	private int raters;
	private float rating;
	private String mimeType;
	
	
	public SearchResultDTO(int serialNo, String extensionName, String description, String browserLink, String versionNo,
			byte[] extension) {
		super();
		this.serialNo = serialNo;
		this.extensionName = extensionName;
		this.description = description;
		this.browserLink = browserLink;
		this.versionNo = versionNo;
		this.extension = extension;
	}
	
	
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
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		mimeType = mimeType;
	}
	
}
