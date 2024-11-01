package com.parul.BrowserExtnStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parul.BrowserExtnStore.Entity.ReviewerDoc;
import com.parul.BrowserExtnStore.Repository.ReviewersRepository;

@Service
public class ReviewersService {
	
	@Autowired
	ReviewersRepository reviewersRepo;
	
	public void saveReviewer(ReviewerDoc reviewer) {
		reviewersRepo.save(reviewer);
	}
	
	public ReviewerDoc getReviewer(String id) {
		return reviewersRepo.findById(id).orElse(null);	
	}
	
	public List<ReviewerDoc> getAllReviewers() {
		return reviewersRepo.findAll();
	}
	
	public void deleteReviewer(String id) {
		reviewersRepo.deleteById(id);
	}
}
