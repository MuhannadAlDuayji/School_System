package com.system.school.business.student;

import com.system.school.model.school.RecordComponent;

import java.util.List;

public interface IStudent {

    public List<RecordComponent> getData(int id, int classRoom, int school);
}
