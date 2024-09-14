package com.parul.BrowserExtnStore.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResultDTO {
    private String extensionName;
    private String description;
    private String versionNo;
    private String browserLink;

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

    
}
