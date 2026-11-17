package com.klu.appservice.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DataService {

    private final JdbcTemplate jdbcTemplate;

    public DataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> getDatabaseDetails() {
        return jdbcTemplate.queryForMap(
            "SELECT current_database() AS database_name, " +
            "current_timestamp AS server_time, " +
            "'Application connected successfully to database container' AS message"
        );
    }
}
