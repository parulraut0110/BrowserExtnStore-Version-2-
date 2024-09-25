package com.parul.BrowserExtnStore.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.parul.BrowserExtnStore.Model.SearchData;
import com.parul.BrowserExtnStore.Repository.ExtensionRepo;
import com.parul.BrowserExtnStore.Service.ThumbnailService;
import com.parul.BrowserExtnStore.dto.SearchResultDTO;

@Controller
public class SearchController {
	@Autowired
	ExtensionRepo extensionRepo;
	
	@Autowired
	ThumbnailService service;
	
	@GetMapping("/search")
	public String handleSearch(@RequestParam("search") String searchQuery, @ModelAttribute("searchData") SearchData searchDataObj, Model model) {        //The form data submitted is use to populate the searchDataObj by spring
		System.out.println("searchQuery: " + searchQuery);
		List<SearchResultDTO> searchResults = extensionRepo.findInExtensionsStore(searchDataObj.getSearch());
		System.out.println("Results: " + searchResults.get(0).getExtensionName() + " " + searchResults.get(0).getDescription());
		System.out.println("serialNo : " + searchResults.get(0).getSerialNo());
		searchResults = service.findInThumnailRepo(searchResults);
		System.out.println("thumbnail size : " + searchResults.get(0).getThumbnail().length());
		model.addAttribute("searchResults", searchResults);
		return "index";
	}
}
  