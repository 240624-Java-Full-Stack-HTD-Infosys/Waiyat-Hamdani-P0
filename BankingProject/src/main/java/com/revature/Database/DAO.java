package com.revature.Database;

import java.util.List;

public interface DAO <T, U>{
    boolean create(T t);
    T read(U u);
    boolean update(T t);
    boolean delete(U u);
    List<T> readall();

}
