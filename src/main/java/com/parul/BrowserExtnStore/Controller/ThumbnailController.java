package com.parul.BrowserExtnStore.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parul.BrowserExtnStore.Service.ThumbnailService;

@RestController
public class ThumbnailController {
	@Autowired
	ThumbnailService service;
	
	@GetMapping("/saveThumbnail")
	public void saveThumbnail() throws IOException {
		System.out.println("Reached Controller");
		service.saveThumbnail();
	}
	
}
