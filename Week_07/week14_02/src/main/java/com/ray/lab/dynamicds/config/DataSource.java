package com.ray.lab.dynamicds.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSource {

    @Bean("MasterDataSource")
    @ConfigurationProperties("spring.datasource.master")
    public HikariDataSource masterDatasource() {
        return new HikariDataSource();
    }

    @Bean("MasterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate() {
        return new JdbcTemplate(masterDatasource());
    }

    @Bean("SlaveDatasource")
    @ConfigurationProperties("spring.datasource.slave")
    public HikariDataSource slaveDatasource() {
        return new HikariDataSource();
    }

    @Bean("SlaveJdbcTemplate")
    public JdbcTemplate slaveJdbcTemplate() {
        return new JdbcTemplate(slaveDatasource());
    }
}
