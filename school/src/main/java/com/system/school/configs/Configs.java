package com.system.school.configs;


import com.system.school.model.ProcessConfig;
import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@PropertySource({"C:/Application/School_prop/jdbcTest.properties"})
@Configuration
public class Configs {

    @Autowired
    private ProcessConfig config;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();

        System.out.println("Print config here : " + config.toString());
        dataSource.setDriverClassName(this.config.getDriverClassName());
        dataSource.setUrl(this.config.getUrl());
        dataSource.setUsername(this.config.getUsername());
        dataSource.setPassword(this.config.getPassword());
        dataSource.setRemoveAbandoned(false);
        dataSource.setLogAbandoned(false);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(false);
        dataSource.setValidationQuery("select 1 from dual");
        dataSource.setMaxActive(this.config.getMaxPoolSize());
        dataSource.setInitialSize(this.config.getMaxPoolSize());
        dataSource.setMaxIdle(this.config.getMaxPoolSize());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
