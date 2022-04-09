package com.pseudo.queue.internal.processing.module.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MySQLConfiguration {
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, dbUserName,dbPassword);
    }
}