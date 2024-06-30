package com.revature.banking;

import com.revature.Database.SqlLiteCRUD;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConsoleATM {
    public static void Displaychooice(){
        System.out.println(" ----Welcome to Revature Banking  version Waiyat----");
        System.out.println("New customer press 1 ");
        System.out.println("Existing customer press 2 ");
        System.out.println(":: ");
    }

    public static void DisplayNewCustomer(){
        /*
        INSERT INTO BankingWaiyatSystem(Id,Name,TypeOfUser,Email,Address,Phone,Balance)
         */
        User registeru =  new User();
        int newUserid = 0;
        List<User> clients = SqlLiteCRUD.readall();
        for(User c : clients) {
            newUserid =c.getUserId();
        }

        newUserid = newUserid+1;
        registeru.setUserId(newUserid);
        System.out.println("Name:  ");
        Scanner n = new Scanner(System.in);
        String name = n.next();
        registeru.setName(name);

        String tUser = AdminOrUser.CLIENT.toString();  //ENUM
        registeru.setTypeUser(tUser);

        System.out.println("Email:  ");
        Scanner es= new Scanner(System.in);
        String email = es.next();
        registeru.setEmail(email);


        System.out.println("Address:  ");
        Scanner ads= new Scanner(System.in);
        String add = ads.next();
        registeru.setAddress(add);

        System.out.println("phone:  ");
        Scanner phs= new Scanner(System.in);
        String phone = phs.next();
        registeru.setPhone(phone);

        System.out.println("How much do you want to store: $  ");
        Scanner bs= new Scanner(System.in);
        double balance = bs.nextDouble();
        registeru.setBalance(balance);

        SqlLiteCRUD enteringdao = new SqlLiteCRUD();
        enteringdao.create(registeru);

    }

    public static void Waitinganswer(){
        Scanner dc = new Scanner(System.in);
        int ans1 = dc.nextInt();
        if (ans1 == 1){
            System.out.println("Welcome new customer");
            DisplayNewCustomer();
        }else if(ans1 == 2 ){
            System.out.println("welcome back");

        }else{
            System.out.println("You choose wrong target");
            Displaychooice();
        }
    }


    private static void display(User u){
        StringBuilder mylistS =  new StringBuilder();
        mylistS.append("id: " +u.getUserId());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("name: " +u.getName());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("Type of User: " +u.getTypeUser());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("Email: " +u.getEmail());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("Address: " +u.getAddress());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("Phone: " +u.getPhone());
        mylistS.append(System.getProperty("line.separator"));
        mylistS.append("Balance: $" +u.getBalance());

        System.out.println(mylistS);

       // return String.format("%-8d%-14s%-13s%,10d", u.getUserId(), u.getName(), u.getAddress(), u.getPhone());
    }

    public static void main(String[] args) {
            //Displaychooice();
            //Waitinganswer();




        List<User> clients = SqlLiteCRUD.readall();
        for(User c : clients){
            display(c);
        }



    }


}