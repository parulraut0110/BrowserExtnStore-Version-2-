package com.parul.BrowserExtnStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parul.BrowserExtnStore.Entity.ExtensionEntity;
import com.parul.BrowserExtnStore.Repository.ExtensionRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Date;

@Service
public class ExtensionService {

    @Autowired
    private ExtensionRepo extensionRepo;

    public void saveExtension(String extensionName, int devId, Date dateUploaded, Date lastModified, String versionNo, String browserLink, byte[] fileStream, String description) {
        // Ensure that dates are not null
        if (dateUploaded == null || lastModified == null) {
            throw new IllegalArgumentException("dateUploaded and lastModified cannot be null");
        }

        // Create an entity instance
        ExtensionEntity extension = new ExtensionEntity();
        extension.setExtensionName(extensionName);
        extension.setDevId(devId);
        extension.setDateUploaded(new java.sql.Date(dateUploaded.getTime())); // Convert java.util.Date to java.sql.Date
        extension.setLastModified(new java.sql.Date(lastModified.getTime())); // Convert java.util.Date to java.sql.Date
        extension.setVersionNo(versionNo);
        extension.setBrowserLink(browserLink);
        extension.setExtension(fileStream); // Set the InputStream as the blob
        extension.setDescription(description);

        // Save the entity to the database
        try {
            extensionRepo.save(extension);
            System.out.println("Added successfully");
        } catch (Exception e) {
            System.out.println("Error saving extension: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
