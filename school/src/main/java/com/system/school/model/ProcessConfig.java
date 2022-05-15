package com.system.school.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessConfig {


    // db
    private @Value("${db.driverClassName}") String driverClassName;
    private @Value("${db.url}") String url;
    private @Value("${db.username}") String username;
    private @Value("${db.password}") String password;
    private @Value("${cfg.minPoolSize}") int minPoolSize;
    private @Value("${cfg.maxPoolSize}") int maxPoolSize;
}
