package com.revature.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        //---------------------------------local database---------------------------------------------------------------------
         InputStream inputStream = ConnectionUtil.class.getClassLoader().getResourceAsStream("databaseLocale.properties");
        //---------------------------------group2 database---------------------------------------------------------------------
        //InputStream inputStream = ConnectionUtil.class.getClassLoader().getResourceAsStream("databaseg2.properties");
        Properties props = new Properties();
        props.load(inputStream);
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(props.getProperty("url"), props.getProperty("uname"), props.getProperty("pwd"));
    }



}
