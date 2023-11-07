package com.rentcal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rentcal.bean.vehicle.Bus;
import com.rentcal.bean.vehicle.Car;
import com.rentcal.bean.vehicle.Trunk;
import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.util.JDBCUtils;

public class Vehicletb {
    // 车辆数据表管理
    static Connection conn = JDBCUtils.conn;
    static PreparedStatement pstmt = JDBCUtils.pstmt;
    static ResultSet rs = JDBCUtils.rs;

    // 添加车辆
    public static boolean addNewVehicles(Vehicle vehicle) throws SQLException {
        String sql = "insert into vehicle_tb(brand,type,perrent,model,vehicle_number)values(?,?,?,?,?);";
        pstmt = conn.prepareStatement(sql);
        if (vehicle instanceof Car) {
            Car newCar = (Car) vehicle;
            pstmt.setString(4, newCar.getModel());
        }
        if (vehicle instanceof Bus) {
            Bus newBus = (Bus) vehicle;
            pstmt.setString(4, newBus.getPassengerCapacity());
        }
        if (vehicle instanceof Trunk) {
            Trunk newTrunk = (Trunk) vehicle;
            pstmt.setString(4, newTrunk.getCargoCapacity());
        }

        pstmt.setString(1, vehicle.getBrand());
        pstmt.setString(2, vehicle.getType());
        pstmt.setInt(3, vehicle.getPerRent());
        pstmt.setString(5, vehicle.getVehicleId());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 删除车辆
    public static boolean deleteVehicle(int vehicle_id) throws SQLException {
        String sql = "delete from vehicle_tb where  vehicle_id= ? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle_id);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 展示车辆
    public static boolean showVehicle() throws SQLException {
        String sql = "SELECT * FROM vehicle_tb;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("*编号:" + rs.getInt(1) + "  品牌:" + rs.getString(2) + "  种类:" + rs.getString(3) + "  日租金:"
                    + rs.getInt(4) + "  型号:" + rs.getString(5) + "  状态:" + rs.getString(6) + "  车牌号:"
                    + rs.getString(7) + "*");
        }
        return false;
    }

    // 价格升序
    public static void showCarAsc() throws SQLException {
        String sql = "SELECT * FROM vehicle_tb order by perrent asc;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("编号:" + rs.getInt(1) + "  品牌:" + rs.getString(2) + "  种类:" + rs.getString(3) + "  日租金:"
                    + rs.getInt(4) + "  型号:" + rs.getString(5) + "  状态:" + rs.getString(6) + "  车牌号:"
                    + rs.getString(7));
        }
    }

    // 价格降序
    public static void showCarDesc() throws SQLException {
        String sql = "SELECT * FROM vehicle_tb order by perrent desc;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("编号:" + rs.getInt(1) + "  品牌:" + rs.getString(2) + "  种类:" + rs.getString(3) + "  日租金:"
                    + rs.getInt(4) + "  型号:" + rs.getString(5) + "  状态:" + rs.getString(6) + "  车牌号:"
                    + rs.getString(7));
        }
    }

    // 返回车辆日租金
    public static int priceInquiry(int vehicle_id) throws SQLException {
        String sql = "select * from vehicle_tb where vehicle_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle_id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(4);
        }
        return -1;
    }

    // 查看车辆状态
    public static boolean viewStatus(int vehicle_id) throws SQLException {
        String sql = "select * from vehicle_tb where vehicle_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle_id);
        rs = pstmt.executeQuery();
        if (rs.next() && rs.getString(6).equals("default")) {
            return true;
        }
        return false;
    }

    // 修改车辆状态
    public static boolean modifyStatus(int vehicle_id, String state) throws SQLException {
        String sql = "update vehicle_tb set state = ? where vehicle_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, state);
        pstmt.setInt(2, vehicle_id);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 修改车辆日租金
    public static boolean modifyprice(int vehicle_id, int perrent) throws SQLException {
        String sql = "update vehicle_tb set perrent = ? where vehicle_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, perrent);
        pstmt.setInt(2, vehicle_id);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 修改车辆车牌号
    public static boolean modifyNumber(int vehicle_id, String vehicle_number) throws SQLException {
        String sql = "update vehicle_tb set vehicle_number = ? where vehicle_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vehicle_number);
        pstmt.setInt(2, vehicle_id);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            return true;
        }
        return false;
    }

    // 查找车辆编号
    public static int findVehicle(Vehicle v, String model) throws SQLException {
        String sql = "select * from vehicle_tb where brand = ? and type = ? and model = ?;";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, v.getBrand());
        pstmt.setString(2, v.getType());
        pstmt.setString(3, model);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    // 根据编号寻找车辆
    public static boolean vehicleidShow(int vehicle_id) throws SQLException {
        String sql = "select * from vehicle_tb where vehicle_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle_id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.print(rs.getString(2) + rs.getString(5));
            return true;
        }
        return false;
    }

    // 获取车牌号码
    public static String obtainPlate(int vehicle_id) throws SQLException {
        String sql = "select * from vehicle_tb where vehicle_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vehicle_id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString(7);
        }
        return null;
    }

    // 去重
    public static List<String> Deduplication(String str1, String str2, String str3) throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "select distinct " + str1 + " from  vehicle_tb  where " + str2 + " = '" + str3 + "' ;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }
}
