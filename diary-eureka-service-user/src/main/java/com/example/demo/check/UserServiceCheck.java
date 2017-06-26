package com.example.demo.check;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceCheck {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getcheck(String account,String pass){
        String sql = "SELECT *  FROM user WHERE useraccount = '"+account+"' AND userpassword ='"+pass+"'";
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

    public String getadd(String userAccount,String userPassword,String userSex){
        String sql = "INSERT INTO user(useraccount,userpassword,usersex) values('"+userAccount+"','"+userPassword+"',"+userSex+")";
        try {
            jdbcTemplate.update(sql);
        }catch (Exception e){
            return "f";
        }
        return "t";
    }

}
