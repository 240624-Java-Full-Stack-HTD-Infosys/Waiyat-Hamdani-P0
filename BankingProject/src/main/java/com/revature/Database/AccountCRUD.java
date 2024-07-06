package com.revature.Database;

import com.revature.Service.ConnectionUtil;
import com.revature.models.Account;
import com.revature.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AccountCRUD {
    private static Properties DB_PROPERTIES;
    private static Connection conn;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    public void create(Account account) {
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO accountwbank (username,password,balance,accounttype,userid) VALUES(?,?,?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query);
            cs.setString(1, account.getUsername());
            cs.setString(2, account.getPassword());
            cs.setDouble(3, account.getBalance());
            cs.setString(4, account.getAccountType());
            cs.setInt(5, account.getUserId());
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

    public Account read(Integer id){
        Account account = new Account();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from accountwbank where userid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                account.setAccountId(rs.getInt("accountid"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setBalance(rs.getDouble("balance"));
                account.setAccountType(rs.getString("accounttype"));
                account.setUserId(rs.getInt("userid"));
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
        return account;
    }


}
