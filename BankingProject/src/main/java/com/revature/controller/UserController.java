package com.revature.controller;

import com.google.gson.Gson;
import com.revature.Database.AccountCRUD;
import com.revature.Database.UserCRUD;
import com.revature.Service.AccountService;
import com.revature.Service.AsciiUtil;
import com.revature.Util.JavalinUtil;
import com.revature.controller.dto.AuthLoginDto;
import com.revature.controller.dto.AuthRegistrationDto;
import com.revature.models.Account;
import com.revature.models.User;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Cookie;

import java.util.HashMap;
import java.util.Map;


public class UserController {
    Javalin api;
    AccountService accountService;
    private static AccountCRUD adao = new AccountCRUD();
    private static UserCRUD udao = new UserCRUD();
    private static  User user ;
    private static Account account ;
    private static HashMap<String ,String> userpass;
    private AccountController ac;

    public UserController(Javalin api, AccountService accountService) {
        this.api = api;
        this.accountService = accountService;
        userpass = udao.readAllUsernamePass();
        api.post("/",this::reseting);
        api.get("/login",this::login);
        api.get("/register",this::register);
    }



    public User login(Context ctx)  {
        //to expire the cookies
        Cookie expiredCookie = new Cookie("AuthStringId", "");
        expiredCookie.setMaxAge(0); // Set the cookie to expire immediately
        ctx.cookie(expiredCookie);
        // to expire the cookies
        ctx.status(200);
        AuthLoginDto auth = ctx.bodyAsClass(AuthLoginDto.class);
        if(AccountService.isUsernameandPasswordExist(userpass,auth.getUsername(),auth.getPassword())){
            user = udao.read(auth.getUsername());
            System.out.println(user);
            // AccountController.setUser(user);
            // ctx.redirect("/auth");
            // Try use cookie instead ============
            // String userJson = new Gson().toJson(user);
            Cookie cookie = new Cookie("AuthStringId", Integer.toString(user.getUserId()));
            ctx.cookie(cookie);
            //Try use cookie instead ============

            ctx.json(user);
            ctx.status(200);

        }else{
            ctx.status(401); // Unauthorized
            ctx.result("Invalid username or password");
            System.out.println("Invalid username or password");
        }
        return user;
    }

    public void register(Context ctx){
        //to expire the cookies
        Cookie expiredCookie = new Cookie("AuthStringId", "");
        expiredCookie.setMaxAge(0); // Set the cookie to expire immediately
        ctx.cookie(expiredCookie);
        // to expire the cookies
        try {
            Gson gson = new Gson();
            AuthRegistrationDto auth= ctx.bodyAsClass(AuthRegistrationDto.class);
            Map<String, Object> response = new HashMap<>();
            account = auth.getAccount();
            udao.create(auth.getUser());
            adao.create(account,auth.getUser());
            response.put("user", auth.getUser());
            account.setUserId(auth.getUser().getUserId());
            response.put("account", account);
            ctx.json(response);
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(400);
            e.printStackTrace();
            ctx.result("Invalid input, please check your json ");
        }

    }
    private void reseting(Context ctx) {
        JavalinUtil.restartServer();
        ctx.redirect("/hello");
        api.post("/hello",this::welcometobank);
    }
    private void welcometobank(Context context) {
        context.result(AsciiUtil.bankAsci());
        context.status(200);
    }

}
