package com.revature.Service;

import java.util.HashMap;

public class AccountService {
    public static boolean login(String U , String P){return false;}
    public static boolean isUsernameandPasswordExist(HashMap<String, String> user, String key, String value) {
        if (user.containsKey(key)) {
            String account = user.get(key);
            if (account.equals(value)) {
                return true;
            }
        }
        return false;
    }
}

