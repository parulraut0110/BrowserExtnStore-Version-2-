package com.parul.BrowserExtnStore.Controller;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.parul.BrowserExtnStore.Entity.ExtensionEntity;
import com.parul.BrowserExtnStore.Entity.Thumbnail;
import com.parul.BrowserExtnStore.Model.SearchData;
import com.parul.BrowserExtnStore.Repository.ExtensionRepo;
import com.parul.BrowserExtnStore.Repository.ThumbnailRepository;
import com.parul.BrowserExtnStore.Service.ThumbnailService;
import com.parul.BrowserExtnStore.dto.SearchResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SearchController {
	@Autowired
	ExtensionRepo extensionRepo;
	
	@Autowired
	ThumbnailRepository thumbnailRepo;
	
	@Autowired
	ThumbnailService service;
	
	@GetMapping("/search")
	public String handleSearch(@RequestParam("search") String searchQuery, @ModelAttribute("searchData") SearchData searchDataObj, Model model) {        //The form data submitted is use to populate the searchDataObj by spring
		System.out.println("searchQuery: " + searchQuery);
		List<SearchResultDTO> searchResults = extensionRepo.findInExtensionsStore(searchDataObj.getSearch());
		System.out.println("Results: " + searchResults.get(0).getExtensionName() + " " + searchResults.get(0).getDescription());
		System.out.println("serialNo : " + searchResults.get(0).getSerialNo());
		searchResults = service.findInThumnailRepo(searchResults);
		System.out.println("thumbnail size : " + searchResults.get(0).getThumbnailBase64().length());
		model.addAttribute("searchResults", searchResults);
		return "index";
	}
	
	@GetMapping("/details/{id}")
	public String appDetails(@PathVariable int id, Model model) throws JsonProcessingException {
		ExtensionEntity extensionResult = extensionRepo.findAppDetailsInExtension(id);
		Thumbnail thumbnailResult = thumbnailRepo.findAppDetailsInThumbnail(id);
		System.out.println("BrowserLink : " + extensionResult.getBrowserLink());
		System.out.println("Description : " + extensionResult.getDescription());
		System.out.println("MimeType : " + thumbnailResult.getMimeType());
		System.out.println("reviews : " + thumbnailResult.getReviews()[1]);
		System.out.println("monthly Downloads : " + thumbnailResult.getMonthlyDownloads().get("September"));
		
		model.addAttribute("appDetailsInStore", extensionResult);
		model.addAttribute("appDetailsInThumbnail", thumbnailResult);
		model.addAttribute("thumbnailBase64", Base64.getEncoder().encodeToString(thumbnailResult.getThumbnail().getData()));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String monthlyDownloadsJson = "{}";  
		monthlyDownloadsJson = objectMapper.writeValueAsString(thumbnailResult.getMonthlyDownloads());
		System.out.println(monthlyDownloadsJson);
		model.addAttribute("monthlyDownloadsJson", monthlyDownloadsJson);
		
		String weeklyDownloadsJson = "{}"; 
		weeklyDownloadsJson = objectMapper.writeValueAsString(thumbnailResult.getWeeklyDownloads());
		model.addAttribute("weeklyDownloadsJson", weeklyDownloadsJson);
		
		System.out.println("thumb : " + model.getAttribute("thumbnailBase64"));
		System.out.println("description : " + ((ExtensionEntity)model.getAttribute("appDetailsInStore")).getDescription());
		System.out.println("october Download : " + ((Thumbnail)model.getAttribute("appDetailsInThumbnail")).getMonthlyDownloads().get("October"));
		return "index";
	}
}
  