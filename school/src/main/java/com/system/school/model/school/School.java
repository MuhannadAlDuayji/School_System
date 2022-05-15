package com.system.school.model.school;

import com.system.school.model.user.User;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class School {

	private int id;
	private String schoolName;
	private int addedBy;
	private String addedAt;
	private int modBy;
	private String modAt;
	private List<ClassRoom> classes;
	private User manger;

}
