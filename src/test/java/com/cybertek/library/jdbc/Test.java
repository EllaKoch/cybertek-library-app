package com.cybertek.library.jdbc;

import com.cybertek.library.utilities.ConfigurationReader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {


        String url = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);

       ResultSet rs  =  DB_Utility.runQuery("select * from book_categories");

        //DB_Utility.displayAllData();

        while(rs.next()){
            System.out.println(rs.getString("name"));

        }


        System.out.println(DB_Utility.getAllColumnNamesAsList());

        DB_Utility.destroy();




    }
}
