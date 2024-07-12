package com.revature.controller;

import com.revature.Database.*;
import com.revature.Service.AccountService;
import com.revature.Service.AsciiUtil;
import com.revature.controller.dto.*;
import com.revature.models.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
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
        api.get("/auth/changeEmail", this::changeemail);
        api.get("/auth/changePhone",this::changephone);
        api.get("/auth/changeAddress",this::changeAddress);
        api.get("/auth/changeFirstname",this::changeFirstname);
        api.get("/auth/changeLastname",this::changeLastname);
        api.post("/auth/history",this::history);
    }

    private void history(Context ctx) {
        JoinCrud jdao = new JoinCrud();
        UserCRUD udao = new UserCRUD();

        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            ArrayList<BankAccountDetails> details = jdao.readAlldetails(user.getUserId());
            System.out.println(details);
            ctx.json(details);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void changeLastname(Context ctx) {
        UserCRUD udao = new UserCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            LastnameChangeDto lastnamecd = ctx.bodyAsClass(LastnameChangeDto.class);
            udao.updateFirstnamebyId(lastnamecd.getNewLastname(), user.getUserId());
            user.setLastname(lastnamecd.getNewLastname());
            ctx.json(user);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void changeFirstname(Context ctx) {
        UserCRUD udao = new UserCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            FirstnameChangeDto firstnamecd = ctx.bodyAsClass(FirstnameChangeDto.class);
            udao.updateFirstnamebyId(firstnamecd.getNewFirstname(), user.getUserId());
            user.setFirstname(firstnamecd.getNewFirstname());
            ctx.json(user);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void changeAddress(Context ctx) {
        UserCRUD udao = new UserCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            AddressChangeDto addcd = ctx.bodyAsClass(AddressChangeDto.class);
            udao.updateAddressbyId(addcd.getNewAddress(), user.getUserId());
            user.setAddress(addcd.getNewAddress());
            ctx.json(user);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void changephone(Context ctx) {
        UserCRUD udao = new UserCRUD();
        try{
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            PhoneChangeDto phonecd = ctx.bodyAsClass(PhoneChangeDto.class);
            udao.updatePhonebyId(phonecd.getNewPhone(), user.getUserId());
            user.setPhone(phonecd.getNewPhone());
            ctx.json(user);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
    }

    private void changeemail(Context ctx) {
        UserCRUD udao = new UserCRUD();
        try {
            String authStringUserId= ctx.cookie("AuthStringId");
            user = udao.read(Integer.parseInt(authStringUserId));
            EmailChangeDto emailcd = ctx.bodyAsClass(EmailChangeDto.class);
            udao.updateEmailbyId(emailcd.getNewEmail(),user.getUserId());
            user.setEmail(emailcd.getNewEmail());
            ctx.json(user);
            ctx.status(200);
        }catch (Exception e){
            ctx.status(400);
            e.printStackTrace();
        }
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
                "\n to create extra account :  add /createExtraAccount" +
                "\n to create delete an account: add /deleteAccount" +
                "\n"
                + AsciiUtil.bankAsci());

        System.out.println("the user :" +user.getFirstname() + "succesfully welcome");
        System.out.println(AsciiUtil.bankAsci());
    }


}
