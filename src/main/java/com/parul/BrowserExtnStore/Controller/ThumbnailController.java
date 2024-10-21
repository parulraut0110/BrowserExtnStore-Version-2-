package com.parul.BrowserExtnStore.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parul.BrowserExtnStore.Service.ThumbnailService;

@RestController
public class ThumbnailController {
	@Autowired
	ThumbnailService service;
	
	@GetMapping("/saveThumbnail/{serialNo}")
	public void saveThumbnail(@PathVariable int serNo) throws IOException, ParseException {
		System.out.println("Reached Controller");
		service.saveThumbnail(serNo);
	}
	
}
