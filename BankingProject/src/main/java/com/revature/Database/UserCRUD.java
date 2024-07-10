package com.revature.Database;
import com.revature.Util.ConnectionUtil;
import com.revature.models.Account;
import com.revature.models.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class UserCRUD implements UpdateUserDAO{
    private static Properties DB_PROPERTIES;
    private static Connection conn;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    public UserCRUD(){}

    public void create(User user) {
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO userwbank (firstname,lastname,phone,address,email,username,password) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            cs.setString(1, user.getFirstname());
            cs.setString(2, user.getLastname());
            cs.setString(3, user.getPhone());
            cs.setString(4, user.getAddress());
            cs.setString(5, user.getEmail());
            cs.setString(6,user.getUsername());
            cs.setString(7,user.getPassword());
            cs.executeUpdate();
            ResultSet keys = cs.getGeneratedKeys();
            if (keys.next()) {
                user.setUserId(keys.getInt(1));
            }
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
    public User read(Integer id){
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from userwbank where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user.setUserId(rs.getInt("userid"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch (SQLException e){
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
        return user;
    }
    public User read(String username){
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from userwbank where username= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user.setUserId(rs.getInt("userid"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch (SQLException e){
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
        return user;
    }
    public Integer readid(String email){
        int myid = 0;
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select userid from userwbank where email= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                myid=rs.getInt("userid");
            }
        }catch (SQLException e){
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
        return myid;
    }
    public boolean updateEmailbyId(String newemail,int id) {
        boolean isupdate =false;
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE userwbank set " +
                    "email = ? " +
                    "where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newemail);
            pstmt.setInt(2,id);
            int affectedrow = pstmt.executeUpdate();
            if(affectedrow ==1){
                isupdate=true;
            }
        }catch(SQLException e){
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
        return isupdate;
    }
    public boolean updateAddressbyId(String newaddress,int id) {
        boolean isupdate =false;
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE userwbank set " +
                    "address = ? " +
                    "where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newaddress);
            pstmt.setInt(2,id);
            int affectedrow = pstmt.executeUpdate();
            if(affectedrow ==1){
                isupdate=true;
            }
        }catch(SQLException e){
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
        return isupdate;
    }
    public boolean updatePhonebyId(String newphone,int id) {
        boolean isupdate =false;
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE userwbank set " +
                    "phone = ? " +
                    "where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newphone);
            pstmt.setInt(2,id);
            int affectedrow = pstmt.executeUpdate();
            if(affectedrow ==1){
                isupdate=true;
            }
        }catch(SQLException e){
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
        return isupdate;
    }
    public boolean updateLastnamebyId(String newLastname,int id) {
        boolean isupdate =false;
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE userwbank set " +
                    "lastname = ? " +
                    "where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newLastname);
            pstmt.setInt(2,id);
            int affectedrow = pstmt.executeUpdate();
            if(affectedrow ==1){
                isupdate=true;
            }
        }catch(SQLException e){
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
        return isupdate;
    }
    public boolean updateFirstnamebyId(String newFirstname,int id) {
        boolean isupdate =false;
        User user = new User();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE userwbank set " +
                    "firstname = ? " +
                    "where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newFirstname);
            pstmt.setInt(2,id);
            int affectedrow = pstmt.executeUpdate();
            if(affectedrow ==1){
                isupdate=true;
            }
        }catch(SQLException e){
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
        return isupdate;
    }
    public boolean delete(Integer id) {
        boolean isDeleted = false;
        try {
            Connection conn = ConnectionUtil.getConnection();
            String query = "DELETE FROM userwbank WHERE userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int affectedRow = pstmt.executeUpdate();
            if (affectedRow == 1) {
                isDeleted = true;
            }
        } catch (SQLException e) {
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
        return isDeleted;
    }
    public ArrayList<User> readAll() {

        User user = new User();
        ArrayList<User> users= new ArrayList<>();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from userwbank ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user.setUserId(rs.getInt("userid"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }catch (SQLException e){
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

        return users;
    }
    public HashMap<String, String> readAllUsernamePass() {
        HashMap<String, String> accounts = new HashMap<>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
            String query = "SELECT username, password FROM userwbank";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                accounts.put(user.getUsername(), user.getPassword());
            }
        } catch (SQLException e) {
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
        return accounts;
    }
}
