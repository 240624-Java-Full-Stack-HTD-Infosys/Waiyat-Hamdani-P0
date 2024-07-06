package com.revature.Database;

import com.revature.Service.ConnectionUtil;
import com.revature.models.Deposit;
import com.revature.models.Withdrawal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawCrud {
    private static Connection conn;
    public void create(Withdrawal withdrawal) {

        AccountCRUD accountdao = new AccountCRUD();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO withdrawalwbank (accountid,date,amountwithdrawal) VALUES(?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query);
            cs.setInt(1, withdrawal.getAccountId());
            cs.setDate(2, withdrawal.getDate());
            cs.setDouble(3, withdrawal.getAmountWithdrawal());
            Double amtw = withdrawal.getAmountWithdrawal();
            Double newbalance = accountdao.getBalance(withdrawal.getAccountId())-amtw;
            System.out.println(withdrawal.getAccountId());
            System.out.println("this is a new balance: " +newbalance);
            accountdao.UpdateBalance(newbalance,withdrawal.getAccountId());
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

    public Withdrawal read(Integer id){
        Withdrawal withdrawal = new Withdrawal();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "select * from withdrawalwbank where accountid= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                withdrawal.setWithdrawId(rs.getInt("withdrawid"));
                withdrawal.setAccountId(rs.getInt("accountid"));
                withdrawal.setDate(rs.getDate("date"));
                withdrawal.setAmountWithdrawal(rs.getDouble("amountwithdrawal"));
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
        return withdrawal;
    }

}
