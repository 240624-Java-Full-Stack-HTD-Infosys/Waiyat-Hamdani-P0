package com.revature.Database;

import com.revature.banking.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SqlLiteCRUD implements DAO<User,Integer>{
    //D:\RevatureTraining\Waiyat-Hamdani-P0\BankingProject\data\BankingWaiyatSystem.db
    public static String url = "jdbc:sqlite:BankingProject/data/BankingWaiyatSystem.db";
    //public static String url = "jdbc:sqlite:D/RevatureTraining/Waiyat-Hamdani-P0/BankingProject/data/BankingWaiyatSystem.db";
    public static Connection conn ;



    /* establish connection to SQL lite */

    public static void connect() {
        try {
            //Class.forName("org.sqlite.JDBC"); // find out what is this ->do later
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
        //catch(Exception e){
        //    System.out.println("what is this" + e.getMessage());
       // }
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





    @Override
    public boolean create(User user) {
        boolean isCreated =false;
        try{
            conn = DriverManager.getConnection(url);
//INSERT INTO BankingWaiyatSystem(Id,TypeOfUser,Email,Address,Phone,Balance) VALUES(0,'ADMIN','waiyat@imsol.com','1 lovelyrunner st' ,'203-111-2222', 999999);
            String query="INSERT INTO BankingWaiyatSystem(Id,Name,TypeOfUser,Email,Address,Phone,Balance) VALUES(?,'?','?','?','?' ,'?', ?);";
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1,user.getUserId());
            cs.setString(2, user.getName());
            cs.setString(3, user.getTypeUser());
            cs.setString(4, user.getEmail());
            cs.setString(5, user.getAddress());
            cs.setString(6, user.getPhone());
            cs.executeUpdate();
            int affectedRows=cs.executeUpdate();
            if(affectedRows ==1) {
                isCreated = true;
            }
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
        return isCreated;
    }

    @Override
    public User read(Integer id) {
        User client =  null;        // just setup my client as null for now

        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query="Select Id,Name,TypeOfUser,Email,Address,Phone,Balance from BankingWaiyatSystem WHERE Id ="+id;
            ResultSet rs =stmt.executeQuery(query);			// result set and execute query
            //System.out.println(rs);
            while (rs.next()) {
                client = new User();
                client.setUserId(rs.getInt(1));
                //System.out.println("Routing number : "+rs.getInt(1));
                client.setName(rs.getString("Name"));
                //System.out.println("Name: " +rs.getString("Name"));
                client.setTypeUser(rs.getString("TypeOfUser"));
                //System.out.println("type of user: " +rs.getString("TypeOfUser"));
                client.setEmail(rs.getString("Email"));
                // System.out.println("Email: " +rs.getString("Email"));
                client.setAddress(rs.getString("Address"));
                //System.out.println("Address: " +rs.getString("Address"));
                client.setPhone(rs.getString("Phone"));
                //System.out.println("Address: " +rs.getString("Phone"));
                client.setBalance(rs.getDouble("Balance"));
                //System.out.println("balance: $" +rs.getInt("Balance"));



            }
        }catch(Exception e){
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

        return client;
    }

    @Override
    public boolean update(User user) {
        boolean isCreated=false;
        try{
            conn = DriverManager.getConnection(url);
            String query="UPDATE BankingWaiyatSystem set Name = ?  "
                    + ", Email = ? "
                    + ", Address = ? "
                    + ", Phone = ? "
                    + ", Balance = ? " + user.getBalance()
                    + "WHERE Id = ? " ;
            CallableStatement cs = conn.prepareCall( query );
            cs.setString(1, user.getName());
            cs.setString(2, user.getEmail());
            cs.setString(3, user.getAddress());
            cs.setString(4, user.getPhone());
            cs.setDouble(5,user.getBalance());
            cs.setInt(6,user.getUserId());
            int affectedRows=cs.executeUpdate();
            if(affectedRows ==1) {
                isCreated = true;
            }

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

        return isCreated;
    }

    @Override
    public boolean delete(Integer integer) {
        boolean deleted= false;
        try{
            conn = DriverManager.getConnection(url);
            String query= "DELETE FROM BankingWaiyatSystem Where Id = ? ";   //query
            PreparedStatement pstmt = conn.prepareCall(query);
            pstmt.setInt(1, integer);
            int affectedrow =pstmt.executeUpdate();
            if (affectedrow == 1) {
                deleted = true;
            }
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
        return false;
    }

    public static List<User> readall() {
        List<User> userList = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query="SELECT * from BankingWaiyatSystem";
            ResultSet rs =stmt.executeQuery(query);
            while (rs.next()) {
                User client = new User();
                client.setUserId(rs.getInt("Id"));
                client.setName(rs.getString("Name"));
                client.setTypeUser(rs.getString("TypeOfUser"));
                client.setEmail(rs.getString("Email"));
                client.setAddress(rs.getString("Address"));
                client.setPhone(rs.getString("Phone"));
                client.setBalance(rs.getDouble("Balance"));
                userList.add(client);
            }

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
        return userList;
    }


}
