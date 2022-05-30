package com.system.school.model.school;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.system.school.business.Administrator.rm.StudentRowMapper;
import com.system.school.model.user.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassRoom {

	private Integer id;
	private String className;
	private Integer schoolId;
	private String addedBy;
	private String addedAt;
	private int modBy;
	private String modAt;
	private List<User> students;

}
