package com.revature.Database;

import com.revature.Util.ConnectionUtil;
import com.revature.models.BankAccountDetails;
import com.revature.models.Deposit;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class JoinCrud {
    private static Properties DB_PROPERTIES;
    private static Connection conn;


    public ArrayList<BankAccountDetails> readAlldetails(Integer id) {

        BankAccountDetails bad = new BankAccountDetails();
        ArrayList<BankAccountDetails> details= new ArrayList<>();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query = "SELECT a.accountid, w.amountwithdrawal, d.amountdeposit, w.date AS withdrawdate, d.date AS depositdate " +
                    "FROM accountwbank a " +
                    "LEFT JOIN (SELECT accountid, amountdeposit, date FROM depositwbank) d ON a.accountid = d.accountid " +
                    "LEFT JOIN (SELECT accountid, amountwithdrawal, date FROM withdrawalwbank) w ON a.accountid = w.accountid " +
                    "WHERE a.userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                bad.setAccountId(rs.getInt("accountid"));
                bad.setAmountWithdrawal(rs.getDouble("amountwithdrawal"));
                bad.setAmountDeposit(rs.getDouble("amountdeposit"));
                bad.setDepositDate(rs.getDate("withdrawdate"));
                bad.setDepositDate(rs.getDate("depositdate"));
                details.add(bad);
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
        return details;
    }
}
