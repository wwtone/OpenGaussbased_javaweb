package com.Dao;


import java.sql.Connection;
import java.sql.DriverManager;

public interface BaseDao {
    default Connection getConnection() {
        String dbUrl = "jdbc:postgresql://192.168.232.135:26000/wwt_db_uni?useUnicode=true&characterEncoding=UTF-8&currentSchema=wuwt";
        String dbUserName = "zjutwwt";
        String dbPassword = "Wwt@12345678";
        String jdbcName = "org.postgresql.Driver";
        Connection dbconn = null;
        try {
            Class.forName(jdbcName);
            dbconn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbconn;
    }
}

