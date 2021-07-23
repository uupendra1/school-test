/*
package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class Test {
    public Map<String, String> getFromDB1() {
        */
/*Class.forName("com.x.y.x");
        Connection connection = DriverManager.getConnection("xyz");*//*


        Statement statement = DbConnection.getConnection().createStatement();
        ResultSet rs = statement.execute("select * from abc");

        //

    }

    public Map<String, String> getFromDB2() {

        Statement statement = DbConnection.getConnection().createStatement();
        ResultSet rs = statement.execute("select * from def");

        //

    }
}
*/
