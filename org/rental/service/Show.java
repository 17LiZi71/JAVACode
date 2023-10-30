package org.rental.service;

import java.sql.*;

import org.rental.account.RegularUsers;
import org.rental.mysqlutil.JDBCUtils;

public abstract class Show {
    public static Connection conn = JDBCUtils.conn;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static void featureShow() throws SQLException {
        Show.showCar();
        System.out.println("功能选择");
        System.out.println("按1价格升序查询,按2价格降序查询");
        System.out.println("按3进行车辆租用,按4进行车辆归还");
        System.out.println("按5以车辆名称查询,按6以车辆种类查询");
        System.out.println("按7退出系统,按8查看订单");
        System.out.println("按9查看车辆价格");
    }

    public static void rootFeatureShow() throws SQLException {
        Show.showCar();
        System.out.println("功能选择");
        System.out.println("按1价格升序查询,按2价格降序查询");
        System.out.println("按3查看用户信息,按4更改车辆数量");
        System.out.println("按5删除用户,按6增加车辆");
        System.out.println("按7退出系统,按8更改车辆价格");
    }

    public static void showCar() throws SQLException {
        String sql = "SELECT * FROM cars;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        System.out.println("车辆一览");
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
        }
    }

    public static void showCarAsc() throws SQLException {
        String sql = "SELECT * FROM cars order by price asc;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
        }
    }

    public static void showCarDesc() throws SQLException {
        String sql = "SELECT * FROM cars order by price desc;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
        }
    }

    public static void userInformation() throws SQLException {
        String sql = "SELECT * FROM users;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        System.out.println("账号 密码  住址  电话 订单一         订单二");
        while (rs.next()) {
            System.out.println(rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5)
                    + "  " + rs.getString(6) + "  " + rs.getString(7));
        }
    }

    public static void showCarName(String carName) throws SQLException {
        String sql = "SELECT * FROM cars where carName =?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, carName);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
        }

    }

    public static void showCarClass(String carType) throws SQLException {
        String sql = "SELECT * FROM cars where carType = ?;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, carType);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
        }
    }

    public static void showOrders(RegularUsers user) throws SQLException {

        String sql = "SELECT * FROM users where userName = ? and userpassword=?;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("订单一：" + rs.getString(6));
            System.out.println("订单二：" + rs.getString(7));
        }
    }

    public static void closeAll() throws SQLException {
        rs.close();
        conn.close();
        pstmt.close();
    }
}
