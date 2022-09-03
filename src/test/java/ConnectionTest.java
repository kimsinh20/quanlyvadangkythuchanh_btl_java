/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ConnectionTest {

    private static final String databaseHost = "sql6.freesqldatabase.com";
    private static final String databaseName = "sql6516524";
    private static final String username = "sql6516524";
    private static final String password = "cfC9FxDEIG";
    private static final String port = "3306";

    public ConnectionTest() {
    }

    public static boolean test() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("CALL get_list_mon('20226001');");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void test2() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                Statement stmt = con.createStatement();
                for (int i = 0; i < 100; i++) {
                    ResultSet rs = stmt.executeQuery("CALL get_list_mon('20226001');");
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
//        if (ConnectionTest.test()) {
//            System.out.println("Connection is successful!");
//        } else {
//            System.out.println("Connection is not successful!");
//        }
        ConnectionTest.test2();
    }
}
