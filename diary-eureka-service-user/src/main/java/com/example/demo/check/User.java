package com.example.demo.check;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/19.
 */
public class User implements Serializable{
    private int userid;
    private String useraccount;
    private String userpassword;
    private int usersex;


    public int getUserid() {
        return userid;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public int getUsersex() {
        return usersex;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setUsersex(int usersex) {
        this.usersex = usersex;
    }
}
