package com.bilalov.springeshoprb.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    public String getDatabaseUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
}
