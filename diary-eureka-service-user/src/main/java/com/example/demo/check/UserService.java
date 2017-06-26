package com.example.demo.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getList(){
        String sql = "SELECT *  FROM user";
         return (List<User>) jdbcTemplate.query(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setUseraccount(rs.getString("useraccount"));
                user.setUserpassword(rs.getString("userpassword"));
                user.setUsersex(rs.getInt("usersex"));
                return user;
            }
        });
    }
}

