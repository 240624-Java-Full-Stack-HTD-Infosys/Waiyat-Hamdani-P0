package BankingSystem;

public class User {
    enum TypeUser{
        GUESS,
        CLIENT,
        ADMIN
    }

    private String Firstname;
    private String Lastname;
    private String Address;
    private int userId;
    private String Email;
    private double Balance;

    public User(String firstname, String lastname , String email, String add){
        super();
        Firstname = firstname;
        Lastname = lastname;
        Email =  email;
        Address = add;

    }



}
