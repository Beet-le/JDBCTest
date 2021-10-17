package com.COnstrater;

import com.Dao.Mydb;

import java.sql.SQLException;

public class Maintext {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Mydb mydb=new Mydb();
        mydb.opendb();
    }
}
