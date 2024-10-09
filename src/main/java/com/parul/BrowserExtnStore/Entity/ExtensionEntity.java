package com.parul.BrowserExtnStore.Entity;

import java.io.InputStream;
import java.sql.Date;

import com.parul.BrowserExtnStore.dto.SearchResultDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Extensions")
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
@NoArgsConstructor
public class ExtensionEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int serialNo;

	    @Column(name = "extensionName", nullable = false, length = 50)
	    private String extensionName;

	    @Column(name = "devId", nullable = false)
	    private int devId;

	    @Column(name = "dateUploaded", nullable = true)
	    @Temporal(TemporalType.DATE)
	    private Date dateUploaded;

	    @Column(name = "lastModified", nullable = true)
	    @Temporal(TemporalType.DATE)
	    private Date lastModified;

	    @Column(name = "versionNo", nullable = false, length = 20)
	    private String versionNo;

	    @Column(name = "browserLink", length = 255)
	    private String browserLink;

	    @Lob
	    @Column(name = "extension", columnDefinition = "MEDIUMBLOB")	  
	    private byte[] extension;
	    
	    @Column(name = "description", columnDefinition = "TEXT")
	    private String description;

		public ExtensionEntity(String extensionName, int devId, Date dateUploaded, Date lastModified,
				String versionNo, String browserLink, byte[] extension, String description) {
			this.extensionName = extensionName;
			this.devId = devId;
			this.dateUploaded = dateUploaded;
			this.lastModified = lastModified;
			this.versionNo = versionNo;
			this.browserLink = browserLink;
			this.extension = extension;
			this.description = description;
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

		public int getDevId() {
			return devId;
		}

		public void setDevId(int devId) {
			this.devId = devId;
		}

		public Date getDateUploaded() {
			return dateUploaded;
		}

		public void setDateUploaded(Date dateUploaded) {
			this.dateUploaded = dateUploaded;
		}

		public Date getLastModified() {
			return lastModified;
		}

		public void setLastModified(Date lastModified) {
			this.lastModified = lastModified;
		}

		public String getVersionNo() {
			return versionNo;
		}

		public void setVersionNo(String versionNo) {
			this.versionNo = versionNo;
		}

		public String getBrowserLink() {
			return browserLink;
		}

		public void setBrowserLink(String browserLink) {
			this.browserLink = browserLink;
		}

		public byte[] getExtension() {
			return extension;
		}

		public void setExtension(byte[] extension) {
			this.extension = extension;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}

	    
}
