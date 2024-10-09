package com.parul.BrowserExtnStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.parul.BrowserExtnStore.Entity.ExtensionEntity;
import com.parul.BrowserExtnStore.Repository.ExtensionRepo;
import com.parul.BrowserExtnStore.dto.SearchResultDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@Service
public class ExtensionService {

    @Autowired
    private ExtensionRepo extensionRepo;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveExtension(ExtensionEntity extension) {       
        String sql = "INSERT INTO extensions (extensionName, devId, dateUploaded, lastModified, versionNo, browserLink, extension, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"serialNo"});
            ps.setString(1, extension.getExtensionName());
            ps.setInt(2, extension.getDevId());
            ps.setDate(3, extension.getDateUploaded());
            ps.setDate(4, extension.getLastModified());
            ps.setString(5, extension.getVersionNo());
            ps.setString(6, extension.getBrowserLink());
            ps.setBytes(7, extension.getExtension());
            ps.setString(8, extension.getDescription());
            return ps;
        }, keyHolder);
        		
		return keyHolder.getKey().intValue();
    }
      
    
}


