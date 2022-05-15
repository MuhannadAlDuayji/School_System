package com.system.school.business.Administrator.rm;

import com.system.school.model.school.School;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolRowMapper implements RowMapper<School> {


    @Override
    public School mapRow(ResultSet rs, int rowNum) throws SQLException {
        School temp = new School();
        int i = 1;
        temp.setId(rs.getInt(i++));
        temp.setSchoolName(rs.getString(i++));
        temp.setAddedBy(rs.getInt(i++));
        temp.setAddedAt(rs.getString(i++));
        temp.setModBy(rs.getInt(i++));
        temp.setModAt(rs.getString(i++));
        return temp;
    }
}
