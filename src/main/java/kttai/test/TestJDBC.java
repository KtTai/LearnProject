package kttai.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }

        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://114.115.207.207/tzzBD?" +
                            "user=root&password=1239870_1");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rate_plan limit 1");
            rs1 = conn.prepareStatement("select * from `user` limit 1").executeQuery();

            System.out.println(rs.findColumn("code"));
            System.out.println(rs1.findColumn("uname"));
            /*while (rs.next()){
                System.out.print(rs.getObject("id")+"   "+rs.getObject("code"));
            }
            System.out.println("");
            while (rs1.next()){
                System.out.print(rs1.getObject("id")+"   "+rs1.getObject("uname"));
            }*/
            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException1: " + ex.getMessage());
            System.out.println("SQLState1: " + ex.getSQLState());
            System.out.println("VendorError1: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }
}
