package org.rental.service;

import java.sql.SQLException;
import java.util.Scanner;

import org.rental.account.Cars;
import org.rental.account.RegularUsers;
import org.rental.mysqlutil.JDBCUtils;
import org.rental.test.Text;

public class Manage {
    public static Scanner sc = Text.sc;

    public static boolean changeQuantity() throws SQLException {
        System.out.println("输入车辆名称");
        String carName = sc.next();
        System.out.println("输入增加数量");
        int number = sc.nextInt();
        if (JDBCUtils.numberRevise(carName, number))
        {
            System.out.println("增加成功");
            return true;
        }
        return false;
    }

    public static boolean removeUser() throws SQLException {
        RegularUsers user = new RegularUsers();
        System.out.println("输入删除用户用户名");
        user.setUserName(sc.next());
        System.out.println("输入删除用户密码");
        user.setUserPassword(sc.next());
        if (JDBCUtils.deleteUser(user))
        {
            System.out.println("删除成功");
            return true;
        }
        return false;
    }

    public static boolean increaseCar() throws SQLException {
        Cars car = new Cars();
        System.out.println("输入车辆名称");
        car.setCarName(sc.next());
        System.out.println("输入车辆种类");
        car.setCarType(sc.next());
        System.out.println("输入车辆价格");
        car.setPrice(sc.nextInt());
        System.out.println("输入车辆数量");
        car.setNumber(sc.nextInt());
        if (JDBCUtils.increaseNewVehicles(car)) {
            System.out.println("添加成功");
            return true;
        }
        return false;
    }

    public static boolean changePrice() throws SQLException {
        System.out.println("输入更改价格车辆名称");
        String carName = sc.next();
        System.out.println("输入新价格");
        int price = sc.nextInt();
        if (JDBCUtils.priceRevise(carName, price)) {
            System.out.println("更改成功");
            return true;
        }
        return false;
    }
    
}
