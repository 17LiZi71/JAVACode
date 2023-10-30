package com.rentcal.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.User;
import com.rentcal.bean.user.VipCustomer;
import com.rentcal.control.View;
import com.rentcal.dao.Business;
import com.rentcal.dao.Usertb;
import com.rentcal.service.Interfation.UserRecharge;

public class Recharge implements UserRecharge {
    static Scanner sc = View.sc;

    @Override
    public User recharge(User user) throws SQLException {
        System.out.println("Vip用户可以同时租赁两辆车");
        if (user instanceof VipCustomer) {
            System.out.println("您已经是Vip用户了");
            return user;
        }
        System.out.println("请支付100元成为Vip用户,按y支付");
        String rech = sc.next();
        if (rech.equals("y")) {
            Business.income(Business.showTurnover() + 100);
            System.out.println("支付成功,您已成为Vip用户");
            Usertb.changePermission(user);
            return Usertb.seekUser(user);
        }
        return user;
    }

    public static Recharge getRecharge() {
        return new Recharge();
    }
}
