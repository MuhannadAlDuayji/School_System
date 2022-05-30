package com.system.school.model.school;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Record {
	
	private Integer id;
	private Integer recorderId;
	private Date recordHistory;
	private List<RecordComponent> records;
	private Boolean behavior;
	private Integer studentId;
}
