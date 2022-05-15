package com.system.school.model.school;

import lombok.*;

import java.util.Date;

@Data
public class ClassRoom {

	private Integer id;
	private String className;
	private Integer schoolId;
	private String addedBy;
	private Date addedAt;

}
