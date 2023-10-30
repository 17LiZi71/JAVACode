package org.rental.service;

import java.sql.*;
import java.util.Scanner;

import org.rental.account.RegularUsers;
import org.rental.mysqlutil.JDBCUtils;
import org.rental.test.Text;

public class Lease {
    static Scanner sc = Text.sc;

    public static boolean lease(RegularUsers user) throws SQLException {
        if (JDBCUtils.findOrders(user) == 0) {
            System.out.println("已经租用两辆车,请归还后再进行租赁");
            return false;
        }
        System.out.println("输入租车名称");
        String carName = sc.next();
        System.out.println("输入租车时间");
        int time = sc.nextInt();
        System.out.println("需要支付" + time * JDBCUtils.priceInquiry(carName));
        JDBCUtils.numberRevise(carName, -1);
        JDBCUtils.addLease(user, carName, time, JDBCUtils.findOrders(user));
        System.out.println("租车成功");
        return true;
    }

    public static void repaid(RegularUsers user) throws SQLException {
        Show.showOrders(user);
        System.out.println("请输入订单编号");
        int orderNumber = sc.nextInt();
        System.out.println("请输入订单车辆名称");
        String carName = sc.next();
        JDBCUtils.clearOrder(user, orderNumber);
        if (JDBCUtils.numberRevise(carName, 1)) {
            System.out.println("归还成功");
            return;
        }
        System.out.println("归还失败");
        return;
    }
}
