package com.revature;

import com.revature.Database.PostgresCRUD;
import com.revature.Service.User;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args)  {
        PostgresCRUD pgcrud = new PostgresCRUD();
        pgcrud.create(new User("test", "testlast", "type", "5185555555", "2 way st", 100, "test@email.com", 5.55, "password"));








//        Class.forName("org.postgresql.Driver");
//        Connection conn = DriverManager.getConnection(USERNAME,PASSWORD, URL);

//        postgresCRUD testpostgress = new postgresCRUD();

        //String firstname, String lastname, String typeUser, String phone,
        //String address, int userId, String email, double balance, String password

        //testpostgress.create(new User("test", "testlast", "type", "5185555555", "2 way st", 100, "test@email.com", 5.55, "password"));

//        User user = new User();
//        user.setFirstname("sunjae");
//        user.setLastname("Ryu");
//        user.setTypeUser(String.valueOf(AdminOrUser.CLIENT));
//        user.setAddress("14, Hwaseomun-ro 48beon-gil, Paldal-gu, Suwon-si, Gyeonggi-do");
//        user.setEmail("sunjaeimsol@llr.net");
//        user.setPhone("4445556666");
//        user.setBalance(9999);
//        user.setPassword("loveimsol");
//
//        postgresCRUD testpostgress = new postgresCRUD();
//        testpostgress.create(user);
    }
}
