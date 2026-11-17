package com.klu.appservice.controller;

import com.klu.appservice.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/api/data")
    public Map<String, Object> getData() {
        return dataService.getDatabaseDetails();
    }
}
