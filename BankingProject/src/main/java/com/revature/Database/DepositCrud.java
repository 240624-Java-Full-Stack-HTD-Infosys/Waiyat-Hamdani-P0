package com.revature.Database;

import com.revature.Service.ConnectionUtil;
import com.revature.models.Account;
import com.revature.models.Deposit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DepositCrud {
    private static Connection conn;

    public void create(Deposit deposit) {

        AccountCRUD accountdao = new AccountCRUD();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO depositwbank (accountid,date,amountdeposit) VALUES(?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query);
            cs.setInt(1, deposit.getAccountId());
            cs.setDate(2, deposit.getDate());
            cs.setDouble(3, deposit.getAmountDeposit());
            Double amtD = deposit.getAmountDeposit();
            Double newbalance = accountdao.getBalance(deposit.getAccountId())+amtD;
            System.out.println(deposit.getAccountId());
            System.out.println("this is a new balance: " +newbalance);
            accountdao.UpdateBalance(newbalance,deposit.getAccountId());
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


    public Deposit read(Integer id){
        Deposit deposit = new Deposit();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from depositwbank where accountid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                deposit.setDepositId(rs.getInt("depositid"));
                deposit.setAccountId(rs.getInt("accountid"));
                deposit.setDate(rs.getDate("date"));
                deposit.setAmountDeposit(rs.getDouble("amountdeposit"));
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
        return deposit;
    }


}
