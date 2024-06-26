public class DepositWithdrawMoney {
    private static double currentMoney;
    private static double finalmoney;

    public double DepositMoney(double current ,double insert){
        if(insert > 0) {
            finalmoney = current + insert;
        }
        return finalmoney;
    }

    public double WithdrawMoney(double current, double take){
        if(insert >0){
            finalmoney = current - insert;
        }
        return finalmoney;
    }


    public static double getCurrentMoney() {
        return currentMoney;
    }

    public static void setCurrentMoney(double currentMoney) {
        DepositWithdrawMoney.currentMoney = currentMoney;
    }
    
}
