package com.revature.Database;

public interface UpdateUserDAO{
    boolean updateEmailbyId(String newemail, int id);
    boolean updateAddressbyId(String newaddress, int id);
    boolean updatePhonebyId(String newphone, int id);
    boolean updateLastnamebyId(String newLastname, int id);
    boolean updateFirstnamebyId(String newFirstname, int id);
}
