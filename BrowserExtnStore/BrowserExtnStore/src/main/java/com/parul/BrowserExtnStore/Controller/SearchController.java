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
import com.parul.BrowserExtnStore.dto.SearchResultDTO;

@Controller
public class SearchController {
	@Autowired
	ExtensionRepo extensionRepo;
	
	@GetMapping("/search")
	public String handleSearch(@RequestParam("search") String searchQuery, @ModelAttribute("searchData") SearchData searchDataObj, Model model) {        //The form data submitted is use to populate the searchDataObj by spring
		System.out.println("searchQuery: " + searchQuery);
		List<Object []> searchResults = extensionRepo.findInExtensionsStore(searchDataObj.getSearch());
		System.out.println("Results: " + searchResults.get(0)[0] + " " + searchResults.get(0)[1]);
		model.addAttribute("searchResults", searchResults);
		return "index";
	}
}
