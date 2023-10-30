package com.rentcal.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.rentcal.bean.user.User;
import com.rentcal.bean.vehicle.Vehicle;
import com.rentcal.control.View;
import com.rentcal.dao.Business;
import com.rentcal.dao.Usertb;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.UserLease;

public class Lease implements UserLease{
    static Scanner sc = View.sc;

    @Override
    public boolean lease(User user) throws SQLException {
        int orderNumber = Usertb.seekLease(user);
        if (orderNumber == 0) {
            System.out.println("请先还车");
            return false;
        }
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "轿车", "客车", "货车");
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "type", "brand", "model");
        System.out.println("1.轿车  2.客车  3.货车");
        System.out.println("请选择你要租赁的汽车类型");
        Vehicle vehicle = new Vehicle();
        int chose = -1;
        // 选择车辆
        for (int i = 1; i < 3; i++) {
            chose = sc.nextInt();
            if (i == 1) {
                vehicle.setType(list1.get(chose - 1));
            }
            if (i == 2) {
                vehicle.setBrand(list1.get(chose - 1));
            }
            list1 = Vehicletb.Deduplication(list2.get(i), list2.get(i - 1), list1.get(chose - 1));
            showList(list1);
        }
        String model = list1.get(sc.nextInt() - 1);
        int vehicle_id = Vehicletb.findVehicle(vehicle, model);
        if (!Vehicletb.viewStatus(vehicle_id)) {
            System.out.println("该车辆已被租赁");
            return false;
        }
        System.out.println("可以租赁,请输入租赁时间");
        int days = sc.nextInt();
        int price = Vehicletb.priceInquiry(vehicle_id) * days;
        System.out.println("需支付" + price + "元");
        System.out.println("按y确认支付,按其他键取消支付");
        String payment = sc.next();
        if (payment.equals("y")) {
            Business.income(price+Business.showTurnover());
            Usertb.addLease(user, vehicle_id + " " + days, orderNumber);
            System.out.println("租赁成功,您的车牌号是" + Vehicletb.obtainPlate(vehicle_id));
            Vehicletb.modifyStatus(vehicle_id, "Rented");
        }
        return false;
    }

    public void showList(List<String> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". " + list.get(i - 1) + "  ");
        }
        System.out.println();
    }

    public static Lease getLease() {
        return new Lease();
    }
}
