package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.User;
import com.rentcal.control.View;
import com.rentcal.dao.Usertb;
import com.rentcal.dao.Vehicletb;
import com.rentcal.service.Interfation.UserRepaid;

public class Repaid implements UserRepaid {
    // 归还类，实现了UserRepaid方法
    static Scanner sc = View.sc;

    @Override
    public void repaid(User user) throws SQLException {
        Usertb.showLease(user);
        String orders1 = Usertb.returnOrders1(user);
        String orders2 = Usertb.returnOrders2(user);
        int[] ordernumber1 = Usertb.decodeOrders(orders1);
        int[] ordernumber2 = Usertb.decodeOrders(orders2);
        // 调用Usertb.decodeOrders方法展示用户订单
        System.out.println("输入归还编号");
        int chose = sc.nextInt();
        if (chose == 2) {
            Usertb.addLease(user, "default", 2);
            Vehicletb.modifyStatus(ordernumber2[0], "default");
            System.out.println("归还成功");
            return;
        }
        Usertb.addLease(user, "default", 1);
        // 调用 Usertb.addLease方法将用户订单修改为默认值
        Vehicletb.modifyStatus(ordernumber1[0], "default");
        // 调用Vehicletb.modifyStatus方法将车辆状态修改为默认值
        System.out.println("归还成功");
        return;
    }

    public static Repaid getRepaid() {
        return new Repaid();
    }
}
