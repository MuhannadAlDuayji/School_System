package com.system.school.business.student;

import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.Record;
import com.system.school.model.school.RecordComponent;
import com.system.school.model.school.School;

import java.util.List;

public interface IStudent {

    public List<School> getSchool(int id); // from table Student-School
    public List<ClassRoom> getClassRoom(int id, int school_id); // from table Student-ClassRoom
    public List<Record> getRecord(int id, int classRoom_id); // from table Student-School
    public List<RecordComponent> getRecordComponent(int id, int classRoom, int school);
}
