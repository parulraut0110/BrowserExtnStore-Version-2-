package com.parul.BrowserExtnStore.Controller;

import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parul.BrowserExtnStore.Entity.ExtensionEntity;
import com.parul.BrowserExtnStore.Service.ExtensionService;

@RestController
public class ExtensionController {

    @Autowired
    ExtensionService extensionService;

    @GetMapping("/mainController")
    public void mainController() throws IOException, ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();  
        String formattedDate = sdf.format(date);  
        Date dateUploaded = sdf.parse(formattedDate);  // Create a 'Date' object corresponding to the string input provided
        String[] months = {
        	    "January", "February", "March", "April", "May", 
        	    "June", "July", "August", "September", "October", 
        	    "November", "December"
        	};
        
        String[] daysOfWeek = {
        	    "Sunday", "Monday", "Tuesday", "Wednesday", 
        	    "Thursday", "Friday", "Saturday"
        	};

        // Read the file as byte[]
        Path path = Paths.get("C:\\BrowserExtension\\DarkModeExtension.zip");
        byte[] fileData = Files.readAllBytes(path);  // Convert file to byte[]

        System.out.println("Saving extension entry...");
        // Call the service with the byte[] data
        ExtensionEntity extension = new ExtensionEntity();
        extension.setExtensionName("Dark Mode Extension");
        extension.setDevId(10);
        extension.setDateUploaded(new java.sql.Date(dateUploaded.getTime())); 
        extension.setLastModified(new java.sql.Date(dateUploaded.getTime())); 
        extension.setVersionNo("1.0.0");
        extension.setBrowserLink("https://chromewebstore.google.com/detail/darkmodeextension/jcgmljkndiijbonfbbhibbfidmbdojfl?authuser=2");
        extension.setExtension(fileData); // Set the InputStream as the blob
        String description = "Improve your web browsing with our Chrome extension. It allows you to easily switch between light and dark modes, making it easier on your eyes. You can also adjust contrast, saturation, and grayscale to suit your needs. The Night Light feature adds a warm sepia tone to reduce blue light at night. With a simple reset option to return settings to their defaults, this extension offers a customizable and comfortable browsing experience.";
        extension.setDescription(description);
        System.out.println("Saved extension entry");
        
    }
    
    
}
