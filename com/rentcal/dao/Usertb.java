package com.rentcal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rentcal.bean.user.DefaultCustomer;
import com.rentcal.bean.user.DefaultStoreMgr;
import com.rentcal.bean.user.User;
import com.rentcal.bean.user.VipCustomer;
import com.rentcal.util.JDBCUtils;

public class Usertb {
    static Connection conn = JDBCUtils.conn;
    static PreparedStatement pstmt = JDBCUtils.pstmt;
    static ResultSet rs = JDBCUtils.rs;

    // 添加用户
    public static boolean addUser(DefaultCustomer newUser) throws SQLException {
        String sql = "insert into user_tb(user_name,user_pwd,user_address,user_phone)values(?,?,?,?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newUser.getUserName());
        pstmt.setString(2, newUser.getUserPwd());
        pstmt.setString(3, newUser.getAddress());
        pstmt.setString(4, newUser.getPhone());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 查找用户
    public static User seekUser(User user) throws SQLException {
        String sql = "select * from user_tb where user_name = ? and user_pwd = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPwd());
        rs = pstmt.executeQuery();
        if (rs.next()) {
            if (rs.getString(6).equals("admin")) {
                return new DefaultStoreMgr(user.getUserName(), user.getUserPwd(), rs.getInt(1));
            }
            if (rs.getString(6).equals("Vip")) {
                return new VipCustomer(user.getUserName(), user.getUserPwd(), rs.getInt(1));
            }
            return new DefaultCustomer(user.getUserName(), user.getUserPwd(), rs.getInt(1));
        }
        return null;
    }

    // 删除用户
    public static boolean deleteUser(int user_id) throws SQLException {
        String sql = "delete from user_tb where user_id = ? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, user_id);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 展示用户信息
    public static void userInformation() throws SQLException {
        String sql = "SELECT * FROM user_tb;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next() && (rs.getString(6).equals("admin") != true)) {
            System.out.println("ID:" + rs.getInt(1) + "  用户名:" + rs.getString(2) + "  密码:" + rs.getString(3) + "  住址:"
                    + rs.getString(4) + "  电话:" + rs.getString(5));
        }
    }

    // 填写订单
    public static boolean addLease(User user, String orders, int number) throws SQLException {
        String sql = "update user_tb set orders" + number + " = '" + orders + "' where user_id = " + user.getUserID()
                + ";";
        pstmt = conn.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 查找订单
    public static int seekLease(User user) throws SQLException {
        String sql = "SELECT * FROM user_tb where user_id = " + user.getUserID() + ";";
        rs = pstmt.executeQuery(sql);
        rs.next();
        if (user instanceof VipCustomer) {
            if (rs.getString(8).equals("default")) {
                return 2;
            }
        }
        if (rs.getString(7).equals("default")) {
            return 1;
        }
        return 0;
    }

    // 查看订单
    public static void showLease(User user) throws SQLException {
        String sql = "SELECT * FROM user_tb where user_id = " + user.getUserID() + ";";
        rs = pstmt.executeQuery(sql);
        rs.next();
        if (!rs.getString(7).equals("default")) {
            int[] order = decodeOrders(rs.getString(7));
            System.out.print("1.租用");
            Vehicletb.vehicleidShow(order[0]);
            System.out.print(" "+order[1] + "天\n");
        }
        if (!rs.getString(8).equals("default")) {
            int[] order = decodeOrders(rs.getString(8));
            System.out.print("2.租用");
            Vehicletb.vehicleidShow(order[0]);
            System.out.print(" "+order[1] + "天\n");
        }
    }

    // 返回订单
    public static String returnOrders1(User user) throws SQLException {
        String sql = "SELECT * FROM user_tb where user_id = " + user.getUserID() + ";";
        rs = pstmt.executeQuery(sql);
        rs.next();
        return rs.getString(7);
    }

    public static String returnOrders2(User user) throws SQLException {
        String sql = "SELECT * FROM user_tb where user_id = " + user.getUserID() + ";";
        rs = pstmt.executeQuery(sql);
        rs.next();
        return rs.getString(8);
    }

    // 翻译订单
    public static int[] decodeOrders(String orders) throws SQLException {
        if (orders.equals("default")) {
            return null;
        }
        String[] orders1 = orders.split(" ");
        int[] result = new int[2];
        result[0] = Integer.parseInt(orders1[0]);
        result[1] = Integer.parseInt(orders1[1]);
        return result;
    }

    // 更改权限
    public static boolean changePermission(User user) throws SQLException {
        String sql = "update user_tb set permissions='Vip' where user_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, user.getUserID());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }
}
