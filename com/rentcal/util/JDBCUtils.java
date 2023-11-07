package com.rentcal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
    //JDBC工具类，建立与mysql数据库的连接
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdbs", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() throws SQLException {
        conn.close();
        pstmt.close();
        rs.close();
    }
}
