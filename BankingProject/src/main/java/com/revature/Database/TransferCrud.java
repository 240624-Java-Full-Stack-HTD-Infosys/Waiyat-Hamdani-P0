package com.revature.Database;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Transfer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransferCrud {
    private static Connection conn;
    public void transferMoney(Transfer transfer) {
        AccountCRUD accountdao = new AccountCRUD();
        try{
            Connection conn = ConnectionUtil.getConnection();
            String query="INSERT INTO transferwbank (from_accountid,to_accountid,amount,date) VALUES(?,?,?,?)";
            PreparedStatement cs = conn.prepareStatement(query);
            cs.setInt(1,transfer.getFromAccountId());
            cs.setInt(2,transfer.getToAccountId());
            cs.setDouble(3,transfer.getAmount());
            cs.setDate(4,transfer.getDate());
            double fromAcctBal = accountdao.getBalance(transfer.getFromAccountId());
            if (fromAcctBal < transfer.getAmount()) {
                System.out.println("Insufficient balance in the account to transfer.");
            }
            System.out.println("account id: "+ transfer.getFromAccountId() + " transfer you money : "+ transfer.getAmount());
            double newFromAcctBal = fromAcctBal - transfer.getAmount();
            accountdao.UpdateBalance(newFromAcctBal, transfer.getFromAccountId());
            System.out.println("account id: "+ transfer.getToAccountId()+" recive transfer amount : $"+transfer.getAmount() );
            double toAcctBal = accountdao.getBalance(transfer.getToAccountId());
            double newToAcctBal = toAcctBal + transfer.getAmount();
            accountdao.UpdateBalance(newToAcctBal, transfer.getToAccountId());

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
