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
import com.rentcal.util.VehicleFactory;

public class Lease implements UserLease {
    // 租赁方法，实现UserLease接口
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
        Vehicle vehicle = null;
        int chose = -1;
        // 选择车辆
        for (int i = 1; i < 3; i++) {
            chose = sc.nextInt();
            if (i == 1) {
                vehicle = VehicleFactory.factory(list1.get(chose - 1));
                vehicle.setType(list1.get(chose - 1));
                System.out.println("请选择你要租赁的汽车品牌");
            }
            if (i == 2) {
                System.out.println("请选择你要租赁的具体型号");
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
        // 调用Vehicletb.priceInquiry方法获取车辆日租金，然后计算总租金
        System.out.println("需支付" + price + "元");
        System.out.println("按y确认支付,按其他键取消支付");
        String payment = sc.next();
        if (payment.equals("y")) {
            Business.income(price + Business.showTurnover());
            // 调用Business.showTurnover()方法将用户支付的租金写入营业额表
            Usertb.addLease(user, vehicle_id + " " + days, orderNumber);
            // 调用Usertb.addLease()方法将租车订单写入用户订单数据列
            System.out.println("租赁成功,您的车牌号是" + Vehicletb.obtainPlate(vehicle_id));
            //调用Vehicletb.modifyStatus方法将车辆状态改为rented
            Vehicletb.modifyStatus(vehicle_id, "Rented");
        }
        return false;
    }

    // 根据用户选择展示车辆
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
