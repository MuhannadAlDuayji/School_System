package com.system.school.business.student;

import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.Record;
import com.system.school.model.school.RecordComponent;
import com.system.school.model.school.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
public class StudentImpl implements IStudent {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<School> getSchool(int id) {

        return jdbcTemplate.query("SELECT ID,SCHOOL_NAME FROM SCHOOL ORDER BY ID ASC ", new RowMapper<School>() {
            @Override
            public School mapRow(ResultSet rs, int rowNum) throws SQLException {
                School temp = new School();
                temp.setId(rs.getInt("ID"));
                temp.setSchoolName(rs.getString("SCHOOL_NAME"));
                return temp;
            }

        });
    }

    @Override
    public List<ClassRoom> getClassRoom(int id, int school_id) {
        return jdbcTemplate.query("SELECT ID,CLASS_NAME FROM CLASSROOM ORDER BY ID ASC ", new RowMapper<ClassRoom>() {
            @Override
            public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
                ClassRoom temp = new ClassRoom();
                temp.setId(rs.getInt("ID"));
                temp.setClassName(rs.getString("CLASS_NAME"));
                return temp;
            }

        });
    }

    @Override
    public List<Record> getRecord(int id, int classRoom_id) {
        return jdbcTemplate.query("SELECT ID, RECORDER_ID FROM RECORD ORDER BY ID ASC ", new RowMapper<Record>() {
            @Override
            public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
                Record temp = new Record();
                temp.setId(rs.getInt("ID"));
                temp.setRecorderId(rs.getInt("RECORDER_ID"));
                return temp;
            }

        });
    }

    @Override
    public List<RecordComponent> getRecordComponent(int id, int classRoom, int school) {

        return jdbcTemplate.query("SELECT ID, RECORDER_ID FROM RECORD ORDER BY ID ASC ", new RowMapper<RecordComponent>() {
            @Override
            public RecordComponent mapRow(ResultSet rs, int rowNum) throws SQLException {
                RecordComponent temp = new RecordComponent();
                temp.setId(rs.getInt("ID"));
                temp.setRecordId(rs.getInt("RECORDER_ID"));
                return temp;
            }

        });
    }
}
