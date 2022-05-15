package com.system.school.model.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistration {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String phone;
    private Integer idParent;
    private Date createdAt;
    private String createdBy;
}
