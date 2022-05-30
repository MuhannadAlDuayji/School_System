package com.system.school.model.school;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecordComponent {

	private Integer recordId;
	private StringBuilder subject;
	private StringBuilder from;
	private StringBuilder to;
	private Integer mark;
	private Integer stage;

    public void setId(int id) {
    }
}
