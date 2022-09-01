/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;

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
//                ResultSet rs = stmt.executeQuery("select * from emp");
//                while (rs.next()) {
//                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        if (ConnectionTest.test()) {
            System.out.println("Connection is successful!");
        } else {
            System.out.println("Connection is not successful!");
        }

    }
}
