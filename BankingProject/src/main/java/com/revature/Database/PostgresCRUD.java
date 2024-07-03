package com.revature.Database;
import com.revature.Service.ConnectionUtil;
import com.revature.Service.User;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PostgresCRUD {


    private static Properties DB_PROPERTIES;
    private static Connection conn;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    public PostgresCRUD(){
        //---------------------------------local database---------------------------------------------------------------------
        // InputStream inputStream = postgresCRUD.class.getClassLoader().getResourceAsStream("databaseLocale.properties");

        //---------------------------------Group2 database---------------------------------------------------------------------
//        InputStream inputStream = postgresCRUD.class.getClassLoader().getResourceAsStream("database.properties");
//        //System.out.println(System.getProperty("java.class.path"));  // to make sure i have everything
//        DB_PROPERTIES = new Properties();
//        try {
//            DB_PROPERTIES.load(inputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        URL = (String)DB_PROPERTIES.get("url");
//        USERNAME = (String) DB_PROPERTIES.get("uname");
//        PASSWORD = (String) DB_PROPERTIES.get("pwd");
    }


//    public static Connection myConnection() throws SQLException, IOException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
//        Connection conn = DriverManager.getConnection(USERNAME,PASSWORD, URL);
//
//        //conn = DriverManager.getConnection("postgres","wh", "jdbc:postgresql://localhost:5432/waiyatdb");
//        return conn;
//    }



    public void create(User user) {
        try{
            Connection conn = ConnectionUtil.getConneciton();
            String query="INSERT INTO wbank (firstname,lastname,typeofuser,email,address,phone,balance,password) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query);
            cs.setString(1, user.getFirstname());
            cs.setString(2, user.getLastname());
            cs.setString(3, user.getTypeUser());
            cs.setString(4, user.getEmail());
            cs.setString(5, user.getAddress());
            cs.setString(6, user.getPhone());
            cs.setDouble(7, user.getBalance());
            cs.setString(8, user.getPassword());
            cs.executeUpdate();

        }catch(SQLException e){
            System.out.println("debug: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("sql close");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
