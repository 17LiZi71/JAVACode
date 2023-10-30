package com.rentcal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rentcal.util.JDBCUtils;

public class Business {
    static Connection conn = JDBCUtils.conn;
    static PreparedStatement pstmt = JDBCUtils.pstmt;
    static ResultSet rs = JDBCUtils.rs;

    public static boolean income(int money) throws SQLException {
        String sql = "update business set turnover = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, money);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static int showTurnover() throws SQLException {
        String sql = "select * from business;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
}
