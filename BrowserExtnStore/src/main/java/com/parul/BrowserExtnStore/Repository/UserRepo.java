package com.parul.BrowserExtnStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
}
