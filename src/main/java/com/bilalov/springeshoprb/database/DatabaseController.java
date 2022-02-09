package com.bilalov.springeshoprb.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/database_url")
    public String getUrl() {
        return databaseService.getDatabaseUrl();
    }

    @GetMapping("/username")
    public String getUsername() {
        return databaseService.getUsername();
    }

}
