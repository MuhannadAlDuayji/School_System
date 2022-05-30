package com.system.school.business.Administrator.rm;

import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.School;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRoomRowMapper implements RowMapper<ClassRoom> {


    @Override
    public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClassRoom temp = new ClassRoom();
        int i = 1;
        temp.setId(rs.getInt(i++));
        temp.setClassName(rs.getString(i++));
        temp.setAddedBy(rs.getString(i++));
        temp.setAddedAt(rs.getString(i++));
        temp.setModBy(rs.getInt(i++));
        temp.setModAt(rs.getString(i++));
        return temp;
    }
}