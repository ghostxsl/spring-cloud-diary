package com.example.demo.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class HService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hhistory> getlist(String account) {
        String sql = "SELECT *  FROM history WHERE useraccount = '" + account + "'";
        return (List<Hhistory>) jdbcTemplate.query(sql, new RowMapper<Hhistory>() {
            @Override
            public Hhistory mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hhistory hi = new Hhistory();
                hi.setHistoryid(rs.getInt("historyid"));
                hi.setFilename(rs.getString("filename"));
                hi.setDate(rs.getString("date"));
                hi.setUseraccount(rs.getString("useraccount"));
                hi.setUsertext(rs.getString("usertext"));
                return hi;
            }
        });
    }

    public String getsave(String filename, String date, String account, String usertext) {
        String sql = "INSERT INTO history(filename,date,useraccount,usertext) values('" + filename + "','" + date + "','" + account + "','" + usertext + "')";
        try {
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            return "f";
        }
        return "t";
    }

    public List<Hhistory> lookup(String account, String filename) {
        String sql = "SELECT *  FROM history WHERE useraccount = '" + account + "' AND filename = '"+filename+"'";
        return (List<Hhistory>) jdbcTemplate.query(sql, new RowMapper<Hhistory>() {
            @Override
            public Hhistory mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hhistory hi = new Hhistory();
                hi.setHistoryid(rs.getInt("historyid"));
                hi.setFilename(rs.getString("filename"));
                hi.setDate(rs.getString("date"));
                hi.setUseraccount(rs.getString("useraccount"));
                hi.setUsertext(rs.getString("usertext"));
                return hi;
            }
        });
    }

}

