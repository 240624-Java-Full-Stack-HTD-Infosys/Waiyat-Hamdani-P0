package com.revature;

import com.revature.Database.AccountCRUD;
import com.revature.Database.DepositCrud;
import com.revature.Database.UserCRUD;
import com.revature.Database.WithdrawCrud;
import com.revature.models.*;

import java.util.Date;
import java.util.Date;

public class Driver {
    public static void main(String[] args)  {
        Date utilDate = new Date();
        java.sql.Date todayis = new java.sql.Date(utilDate.getTime());

        Withdrawal wm = new Withdrawal();
        wm.setAccountId(1);
        wm.setDate(todayis);
        wm.setAmountWithdrawal(5.59);

        WithdrawCrud wdao = new WithdrawCrud();
        wdao.create(wm);
        wdao.read(1);


//        Deposit dm = new Deposit();
//        dm.setAccountId(1);
//        dm.setDate(todayis);
//        dm.setAmountDeposit(500.59);
//
//        DepositCrud ddao = new DepositCrud();
//        ddao.create(dm);
//        ddao.read(1);


//        Account waiyatacc = new Account();
//        waiyatacc.setUsername("waiyatoppa");
//       waiyatacc.setPassword("admin");
//       waiyatacc.setBalance(999.89);
//        waiyatacc.setAccountType(CheckingSavingCredit.CHECKING.toString());
//        waiyatacc.setUserId(1);
//
        AccountCRUD wacc = new AccountCRUD();
//        wacc.create(waiyatacc);
//        //wacc.delete(1);
//        wacc.updatePasswordbyEmail("lesserafim","everyguyissomeonesunjae@gmail.com");
//
        System.out.println(wacc.read(1));
//        System.out.println(wacc.getBalance(1));




//        User waiyat = new User();
//       waiyat.setFirstname("waiyat");
//        waiyat.setLastname("hamdani");
//        waiyat.setPhone("2033334444");
//        waiyat.setAddress("1 way st , I wish ,south korea");
//        waiyat.setEmail("wyth@lovelyrunner.com");
//
//        UserCRUD userdao = new UserCRUD();
//        userdao.create(waiyat);
//        //userdao.delete(1);
//        userdao.updateEmailbyId("everyguyissomeonesunjae@gmail.com",1);
//        userdao.updateAddressbyId("1 lovely runner st , timetravel ,south korea", 1);
//        userdao.updatePhonebyId("222-333-4444",1);
//        userdao.updateLastnamebyId("HAMDANI",1);
//        userdao.updateFirstnamebyId("WAIYAT",1);
//        System.out.println(userdao.read(1));





    }
}
