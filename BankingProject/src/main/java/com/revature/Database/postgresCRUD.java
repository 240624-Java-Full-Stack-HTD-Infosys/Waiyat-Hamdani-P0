package com.revature.Database;
import com.revature.Service.AdminOrUser;
import com.revature.Service.User;

import javax.imageio.stream.ImageInputStreamImpl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;

public class postgresCRUD {

    public static Connection conn ;
    private static Properties DB_PROPERTIES;

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    public postgresCRUD(){
        //---------------------------------local database---------------------------------------------------------------------
        // InputStream inputStream = postgresCRUD.class.getClassLoader().getResourceAsStream("databaseLocale.properties");

        //---------------------------------Group2 database---------------------------------------------------------------------
        InputStream inputStream = postgresCRUD.class.getClassLoader().getResourceAsStream("database.properties");
        //System.out.println(System.getProperty("java.class.path"));  // to make sure i have everything
        DB_PROPERTIES = new Properties();
        try {
            DB_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection myConnection() throws SQLException{
        URL = (String)DB_PROPERTIES.get("url");
        USERNAME = (String) DB_PROPERTIES.get("uname");
        PASSWORD = (String) DB_PROPERTIES.get("pwd");
        conn = DriverManager.getConnection(USERNAME,PASSWORD, URL);
       // conn = DriverManager.getConnection("postgres","wh", "jdbc:postgresql://localhost:5432/waiyatdb");
        return conn;
    }

    public static void connect() {
        try {
            myConnection();
            System.out.println("Connection to Postgres has been established.");

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
        finally {
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

    public void create(User user) {
        try{
            myConnection();
            String query="INSERT INTO wbank (firstname,lastname,typeofuser,email,address,phone,balance,password) VALUES(?,'?','?','?','?','?' ,'?', ?)";
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
            System.out.println(e.getMessage());
        }finally {
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

    public static void main(String[] args){
        User user = new User();
        user.setFirstname("sunjae");
        user.setLastname("Ryu");
        user.setTypeUser(String.valueOf(AdminOrUser.CLIENT));
        user.setAddress("14, Hwaseomun-ro 48beon-gil, Paldal-gu, Suwon-si, Gyeonggi-do");
        user.setEmail("sunjaeimsol@llr.net");
        user.setPhone("4445556666");
        user.setBalance(9999);
        user.setPassword("loveimsol");

        postgresCRUD testpostgress = new postgresCRUD();
        testpostgress.create(user);
    }

}
