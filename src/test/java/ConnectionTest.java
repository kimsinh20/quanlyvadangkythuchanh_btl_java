/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
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
    private static Connection conn;
    private static Statement stmt;

    public static final String DATABASE_USER = "user";
    public static final String DATABASE_PASSWORD = "password";
    public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public static boolean initConnection() {
        try {
            conn = ConnectionTest.getConnection();
            stmt = conn.createStatement();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbURL = String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName);
        java.util.Properties connProperties = new java.util.Properties();
        connProperties.put(DATABASE_USER, username);
        connProperties.put(DATABASE_PASSWORD, password);
        connProperties.put(MYSQL_AUTO_RECONNECT, "true");
        connProperties.put(MYSQL_MAX_RECONNECTS, "99999");
        return DriverManager.getConnection(dbURL, connProperties);
    }

    public static boolean test() {
        try {
            System.out.println(conn.isClosed());
            System.out.println(stmt.isClosed());
            ResultSet rs = stmt.executeQuery("CALL get_list_mon('20226001');");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

//    public static void test2() {
//
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //here sonoo is database name, root is username and password
//            try ( Connection con = DriverManager.getConnection(
//                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
//                Statement stmt = con.createStatement();
//                for (int i = 0; i < 100; i++) {
//                    ResultSet rs = stmt.executeQuery("CALL get_list_mon('20226001');");
//                }
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static void main(String args[]) {
//        try {
//            ConnectionTest.initConnection();
//        } catch (Exception ex) {
//            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (ConnectionTest.test()) {
//            System.out.println("Connection is successful!");
//        } else {
//            System.out.println("Connection is not successful!");
//        }
//        ConnectionTest.test2();
//        Date date = (Date) Calendar.getInstance().getTime();

        Calendar c = Calendar.getInstance();

        System.out.println(convertDateToString(c.getTime()));
        c.add(Calendar.DATE, 1);
        
        
    }

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
