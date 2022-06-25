package com.system.school.business.administrator.rm;

import com.system.school.model.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getInt(1));
        user.setFirstName(rs.getString(2));
        user.setLastName(rs.getString(3));
        user.setPhoneNumber(rs.getString(4));

        return user;
    }
}
