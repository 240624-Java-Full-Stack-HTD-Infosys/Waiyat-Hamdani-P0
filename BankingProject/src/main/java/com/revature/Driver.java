package com.revature;

import com.revature.Database.AccountCRUD;
import com.revature.Database.UserCRUD;
import com.revature.models.Account;
import com.revature.models.CheckingSavingCredit;
import com.revature.models.User;

public class Driver {
    public static void main(String[] args)  {

        Account waiyatacc = new Account();
        waiyatacc.setUsername("waiyatoppa");
        waiyatacc.setPassword("admin");
        waiyatacc.setBalance(999999.89);
        waiyatacc.setAccountType(CheckingSavingCredit.CHECKING.toString());
        waiyatacc.setUserId(1);

        AccountCRUD wacc = new AccountCRUD();
        //wacc.create(waiyatacc);
        System.out.println(wacc.read(1));
















      //  User waiyat = new User();
      //  waiyat.setFirstname("waiyat");
      //  waiyat.setLastname("hamdani");
       // waiyat.setPhone("2033334444");
       // waiyat.setAddress("1 way st , I wish ,south korea");
       // waiyat.setEmail("wyth@lovelyrunner.com");

       // UserCRUD userdao = new UserCRUD();
        //userdao.create(waiyat);
        //userdao.delete(1);
        //userdao.updateEmailbyId("everyguyissomeonesunjae@gmail.com",1);
        //userdao.updateAddressbyId("1 lovely runner st , timetravel ,south korea", 1);
        //userdao.updatePhonebyId("222-333-4444",1);
        //userdao.updateLastnamebyId("HAMDANI",1);
        //userdao.updateFirstnamebyId("WAIYAT",1);
        //System.out.println(userdao.read(1));





    }
}
