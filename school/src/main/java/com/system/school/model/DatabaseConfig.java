package com.system.school.model;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int maxPoolSize;
    private int initialSize;
    private int activeSize;
}
