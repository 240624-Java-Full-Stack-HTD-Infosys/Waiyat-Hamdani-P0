package com.revature.Util;

import com.revature.Service.AccountService;
import com.revature.Service.AsciiUtil;
import com.revature.controller.AccountController;
import com.revature.controller.UserController;
import io.javalin.Javalin;

import io.javalin.http.Context;

public class JavalinUtil {
    private static Javalin app;

    public static void startServer() {
        app = Javalin.create().start(8080);
        System.out.println("the app is running");
        AccountService as = new AccountService();
        UserController userController = new UserController(app,as);
        AccountController ac = new AccountController(app,as);
    }

    public static void stopServer() {
        app.stop();
    }

    public static void restartServer() {
        stopServer();
        startServer();
    }

    public static void restartServer(Context ctx) {
        stopServer();
        startServer();

        ctx.result("Welcome  to   \n"+
                AsciiUtil.bankAsci());
    }
}
