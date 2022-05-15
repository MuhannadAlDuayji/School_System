package com.system.school.model.user;

import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.School;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dob;
    private Integer schoolId;

    private Integer RoleId;
    private String JobTitle;

    private Integer parentId;
    private String parentFirstName;
    private String parentLastName;
    private String phoneParent;

    private List<ClassRoom> classes;
    private List<School> schools;
}
