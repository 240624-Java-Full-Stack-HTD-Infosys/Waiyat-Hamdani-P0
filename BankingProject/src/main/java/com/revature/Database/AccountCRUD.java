package com.revature.Database;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Account;
import com.revature.models.User;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class AccountCRUD {
    private static Properties DB_PROPERTIES;
    private static Connection conn;

    public void create(Account account) {
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO accountwbank (balance,accounttype,userid) VALUES(?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            cs.setDouble(1, account.getBalance());
            cs.setString(2, account.getAccountType());
            cs.setInt(3, account.getUserId());
            cs.executeUpdate();
            ResultSet keys = cs.getGeneratedKeys();
            if (keys.next()) {
                account.setAccountId(keys.getInt(1));
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
    public boolean delete(Integer id) {
        boolean isDeleted = false;
        try {
            Connection conn = ConnectionUtil.getConnection();
            String query = "DELETE FROM accountwbank WHERE accountid = ?";
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
    public Double getBalance(int accountid){
        Double balanceacc = null;
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select balance from accountwbank where accountid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,accountid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                balanceacc=rs.getDouble("balance");
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

        return balanceacc;
    }
    public Boolean UpdateBalance(double newbalance , int accountid){
        Boolean isupdate = false;
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "UPDATE accountwbank SET balance = ? WHERE accountid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, newbalance);
            pstmt.setInt(2, accountid);
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
    public void create(Account account,User user) {
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO accountwbank (balance,accounttype,userid) VALUES(?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            cs.setDouble(1, account.getBalance());
            cs.setString(2, account.getAccountType());
            cs.setInt(3, user.getUserId());
            cs.executeUpdate();
            ResultSet keys = cs.getGeneratedKeys();
            if (keys.next()) {
                account.setAccountId(keys.getInt(1));
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
}
