package com.system.school.business.administrator.rm;

import com.system.school.model.school.StudentRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Slf4j
public class TestRM implements RowMapper<StudentRegistration> {
    @Override
    public StudentRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
        int i = 1;
        StudentRegistration temp = new StudentRegistration();
        temp.setId(rs.getInt(i++));
        temp.setFirstName(rs.getString(i++));
        temp.setLastName(rs.getString(i++));
        temp.setDOB(new Date(rs.getDate(i++).getTime()));
        temp.setPhone(rs.getString(i++));
        temp.setIdParent(rs.getInt(i++));
        temp.setCreatedAt(new Date(rs.getDate(i++).getTime()));
        temp.setCreatedBy(rs.getString(i++));
        return temp;
    }
}
