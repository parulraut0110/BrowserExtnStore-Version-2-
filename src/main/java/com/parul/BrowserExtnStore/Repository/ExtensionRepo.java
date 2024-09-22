package com.parul.BrowserExtnStore.Repository;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parul.BrowserExtnStore.Entity.ExtensionEntity;
import com.parul.BrowserExtnStore.dto.SearchResultDTO;

@Repository
public interface ExtensionRepo extends JpaRepository<ExtensionEntity, Integer> {


	@Query(name = "ExtensionEntity.findSearchResults",
			nativeQuery = true)
	List<SearchResultDTO> findInExtensionsStore(String searchQuery);



}
