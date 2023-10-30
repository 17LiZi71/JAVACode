package org.rental.mysqlutil;

import java.sql.*;

import org.rental.account.Cars;
import org.rental.account.RegularUsers;
import org.rental.account.RootUsers;

public class JDBCUtils {
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldatabase", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean inquireUser(RegularUsers user) throws SQLException {
        String sql = "select * from users where username = ? and userpassword = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inquireUser(RootUsers user) throws SQLException {
        String sql = "select * from Adminis where AdminiName = ? and Adminiword = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean increaseNewVehicles(Cars car) throws SQLException {
        String sql = "insert into cars(carName,price,carType,number)values(?,?,?,?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car.getCarName());
        pstmt.setInt(2, car.getPrice());
        pstmt.setString(3, car.getCarType());
        pstmt.setInt(4, car.getNumber());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static boolean deleteUser(RegularUsers user) throws SQLException {
        String sql = "delete from users where userName=?and userpassword=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static boolean numberRevise(String carName, int number) throws SQLException {
        String sql = "select * from cars where carName = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, carName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            if (rs.getInt(5) + number < 0) {
                return false;
            }
            String sql2 = "update cars set number = ? where carName=?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, rs.getInt(5) + number);
            pstmt.setString(2, carName);
            int result = pstmt.executeUpdate();
            if (result != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean clearOrder(RegularUsers user, int orderNumber) throws SQLException {
        String sql1 = "update users set rentInformation = null where userName=? and userpassword=?;";
        String sql2 = "update users set rentInformation1 = null where userName=? and userpassword=?;";
        switch (orderNumber) {
            case 1:
                pstmt = conn.prepareStatement(sql1);
                break;
            case 2:
                pstmt = conn.prepareStatement(sql2);
                break;
            default:
                break;
        }
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static int priceInquiry(String carName) throws SQLException {
        String sql = "select * from cars where carName = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, carName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(3);
        }
        return -1;
    }

    public static boolean priceRevise(String carName, int price) throws SQLException {
        String sql = "update cars set price = ? where carName=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,price);
        pstmt.setString(2, carName);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static boolean increaseUsers(RegularUsers user) throws SQLException {
        String sql = "insert into users(userName,userpassword,address,phone)values(?,?,?,?);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        pstmt.setString(3, user.getAddress());
        pstmt.setString(4, user.getContactNumber());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static boolean addLease(RegularUsers user, String carName, int time, int serialNumber)
            throws SQLException {
        String sql1 = "update users set rentInformation = ? where userName=? and userpassword=?;";
        String sql2 = "update users set rentInformation1 = ? where userName=? and userpassword=?;";
        String addlease = "租用" + carName + time + "天";
        switch (serialNumber) {
            case 1:
                pstmt = conn.prepareStatement(sql1);
                break;
            case 2:
                pstmt = conn.prepareStatement(sql2);
                break;
            default:
                break;
        }
        pstmt.setString(1, addlease);
        pstmt.setString(2, user.getUserName());
        pstmt.setString(3, user.getUserPassword());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    public static int findOrders(RegularUsers user) throws SQLException {
        String sql = "SELECT * FROM users where userName = ? and userpassword=?;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        rs = pstmt.executeQuery();
        if (rs.next() && rs.getString(6) == null) {
            return 1;
        } else if (rs.getString(7) == null) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void close() throws SQLException {
        pstmt.close();
        rs.close();
        conn.close();
    }
}
