package com.revature.controller;

import com.revature.Database.*;
import com.revature.Service.AccountService;
import com.revature.Service.AsciiUtil;
import com.revature.controller.dto.AccountIdDTO;
import com.revature.models.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Date;
import java.util.HashMap;


public class AccountController {
    Javalin api;
    AccountService accountService;


    private static  User user ;
    private static Account account ;
    private static HashMap<String ,String> mapping ;


    public AccountController() {}
    public AccountController(Javalin api, AccountService accountService) {
        this.api = api;
        this.accountService = accountService;
        api.get("/auth",this::welcome);
        api.get("/auth/deposit",this::deposit);
        api.get("/auth/withdraw",this::withdraw);
        api.get("/auth/transfer",this::transfer);
        api.get("/auth/createExtraAccount",this::create);
        api.get("/auth/deleteAccount",this::delete);
    }

    private void create(Context ctx) {
        UserCRUD udao = new UserCRUD();
        AccountCRUD adao = new AccountCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            Account auth = ctx.bodyAsClass(Account.class);
            adao.create(auth,user);
            auth.setUserId(user.getUserId());
            ctx.json(auth);
            ctx.status(200);


        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void delete(Context ctx) {
        UserCRUD udao = new UserCRUD();
        AccountCRUD adao = new AccountCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            account =adao.read(user.getUserId());
            AccountIdDTO auth = ctx.bodyAsClass(AccountIdDTO.class);
            if(account.getBalance() > 0){
                ctx.status(400);
                ctx.result("you still have money , cannot delete your account ");
                return;
            }
            adao.delete(auth.getAccountId());
            ctx.result("We are sorry to see you go ....  Don't Go  don't go...   T.T");
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void transfer(Context ctx) {
        UserCRUD udao = new UserCRUD();
        AccountCRUD adao = new AccountCRUD();
        TransferCrud tdao = new TransferCrud();
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));  // decided to use cookies
            account =adao.read(user.getUserId());
            Transfer auth = ctx.bodyAsClass(Transfer.class);
            if (account.getBalance() ==0){
                ctx.status(400);
                ctx.result("You poor , you don't have enough money ");
                return;
            }
            if(auth.getAmount() <=0){
                ctx.status(400);
                ctx.result("Invalid transfer amount. Amount cannot be Zero or negative.");
                return;
            }
            auth.setFromAccountId(account.getAccountId());
            auth.setDate(sqlDate);
            tdao.transferMoney(auth);
            HashMap<String, Object> response = new HashMap<>();
            response.put("Account",account);
            response.put("Transfer",auth);
            ctx.json(response);
            ctx.status(200);

        }catch(Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void deposit(Context ctx) {
        Date utilDate = new Date();
        Date sqlDate = new java.sql.Date(utilDate.getTime());
        UserCRUD udao = new UserCRUD();
        AccountCRUD adao = new AccountCRUD();
        DepositCrud ddao = new DepositCrud();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));  // decided not to use cookies
            account =adao.read(user.getUserId());
            Deposit auth = ctx.bodyAsClass(Deposit.class);
            if (auth.getAmountDeposit() <= 0) {      // if this 0 or negative return false
                ctx.status(400);
                ctx.result("Invalid deposit amount. Amount cannot be Zero or negative.");
                return;
            }
            auth.setAccountId(account.getAccountId());
            auth.setDate(sqlDate);
            ddao.depositmoney(auth,account);

            HashMap<String, Object> response = new HashMap<>();
            response.put("Account",account);
            response.put("deposit",auth);
            ctx.json(response);
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void withdraw(Context ctx) {
        try{
            UserCRUD udao = new UserCRUD();
            AccountCRUD adao = new AccountCRUD();
            WithdrawCrud wdao = new WithdrawCrud();
            Date utilDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId)); //  to used cookies
            account =adao.read(user.getUserId());
            Withdrawal auth = ctx.bodyAsClass(Withdrawal.class);

            if (auth.getAmountWithdrawal() <= 0) {      // if this 0 or negative return false
                ctx.status(400);
                ctx.result("Invalid withdraw amount. Amount cannot be Zero or negative.");
                return;
            }
            auth.setAccountId(account.getAccountId());
            auth.setDate(sqlDate);
            wdao.withdrawMoney(auth,account);

            HashMap<String, Object> response = new HashMap<>();
            response.put("Account",account);
            response.put("Withdrawal",auth);
            ctx.json(response);
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(400);
            e.printStackTrace();
        }

        //ctx.json(auth);
    }

    private void welcome(Context ctx) {
        UserCRUD udao = new UserCRUD();
        AccountCRUD adao = new AccountCRUD();
        String authStringUserId = ctx.cookie("AuthStringId");
        user = udao.read(Integer.parseInt(authStringUserId));
        ctx.status(200);


        ctx.result("Welcome " + user.getFirstname() + " your user id is : "+ user.getUserId()+
                "\n to deposit: add /deposit  " +
                "\n to withdraw: add /withdraw  " +
                "\n to transfer: add /transfer" +
                "\n to create extra account :  add /extraaccount" +
                "\n to create delete an account: add/minusaccount" +
                "\n"
                + AsciiUtil.bankAsci());

        System.out.println("the user :" +user.getFirstname() + "succesfully welcome");
        System.out.println(AsciiUtil.bankAsci());
    }




//    public static User getUser() {return user;}
//    public static void setUser(User user) {AccountController.user = user;}
//    public static Account getAccount() {return account;}
//    public static void setAccount(Account account) {AccountController.account = account;}



}
