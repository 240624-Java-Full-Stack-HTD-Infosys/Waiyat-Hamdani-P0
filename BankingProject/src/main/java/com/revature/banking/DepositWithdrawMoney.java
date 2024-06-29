package com.revature.banking;

public class DepositWithdrawMoney {
    private static double currentMoney;
    private static double finalmoney;

    public double DepositMoney(double current ,double insert){
       try {
           if (insert > 0) {
               finalmoney = current + insert;
           }
       }catch(Exception e){
           System.out.println("Error message:" +e);
       }
        return finalmoney;
    }

    public double WithdrawMoney(double current, double take){
        try {
            if (take > 0) {
                finalmoney = current - take;
            }
        }catch(Exception e) {
            System.out.println("Error message:" +e);
        }
        return finalmoney;
    }


    public static double getCurrentMoney() {
        return currentMoney;
    }

    public static void setCurrentMoney(double cm) {
        currentMoney = cm;
    }

    public static double getFinalmoney() {
        return finalmoney;
    }
}
