package org.rental.test;

import java.util.Scanner;

import org.rental.account.RegularUsers;
import org.rental.account.RootUsers;
import org.rental.account.Users;
import org.rental.mysqlutil.JDBCUtils;
import org.rental.service.Lease;
import org.rental.service.Login;
import org.rental.service.Manage;
import org.rental.service.Show;

public class Text {
    static final int PRICE_ASCENDING= 1;
    static final int PRICE_DESCENDING = 2;
    static final int RENT_CAR= 3;
    static final int REPAID_CAR= 4;
    static final int NAME_LOOKUP = 5;
    static final int KIND_SEARCH= 6;
    static final int EXIT_SYSTEM= 7 ;
    static final int ORDER_DISPLAY=8  ;
    static final int USERS_DISPLAY=3 ;
    static final int QUANTITY_CHANGES=4 ;
    static final int DELETE_USER=5 ;
    static final int INCREASE_VARIETY=6;
    static final int CHANGE_PRINCE= 8;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Users user = Login.login();
        if (user instanceof RegularUsers) {
            Show.featureShow();
        } else if (user instanceof RootUsers) {
            Show.rootFeatureShow();
        }
        while (user instanceof RegularUsers) {
            try {
                int choose = 0;
                choose = sc.nextInt();
                switch (choose) {
                    case PRICE_ASCENDING:
                        System.out.println("车辆按价格升序排序");
                        Show.showCarAsc();
                        break;
                    case PRICE_DESCENDING:
                        System.out.println("车辆按价格降序排序");
                        Show.showCarDesc();
                        break;
                    case RENT_CAR:
                        System.out.println("车辆租用");
                        Lease.lease((RegularUsers) user);
                        break;
                    case REPAID_CAR:
                        System.out.println("车辆归还");
                        Lease.repaid((RegularUsers) user);
                        break;
                    case NAME_LOOKUP:
                        System.out.println("输入车辆名称,以名称查找");
                        Show.showCarName(sc.next());
                        break;
                    case KIND_SEARCH:
                        System.out.println("输入车辆类型,以类型查找");
                        Show.showCarClass(sc.next());
                        break;
                    case EXIT_SYSTEM:
                        System.out.println("退出系统");
                        user = null;
                        break;
                    case ORDER_DISPLAY:
                        System.out.println("订单展示");
                        Show.showOrders((RegularUsers) user);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("输入错误,请重新选择其他功能");
                sc.next();
            }
        }
        while (user instanceof RootUsers) {
            int choose = 0;
            choose = sc.nextInt();
            switch (choose) {
                case PRICE_ASCENDING:
                    Show.showCarAsc();
                    break;
                case PRICE_DESCENDING:
                    Show.showCarDesc();
                    break;
                case USERS_DISPLAY:
                    Show.userInformation();
                    break;
                case QUANTITY_CHANGES:
                    System.out.println("车辆数量更改");
                    Manage.changeQuantity();
                    break;
                case DELETE_USER:
                    System.out.println("删除用户");
                    Manage.removeUser();
                    break;
                case INCREASE_VARIETY:
                    System.out.println("增加车辆");
                    Manage.increaseCar();
                    break;
                case EXIT_SYSTEM:
                    System.out.println("退出系统");
                    user = null;
                    break;
                case CHANGE_PRINCE:
                    System.out.println("更改车辆价格");
                    Manage.changePrice();
                    break;
                default:
                    break;
            }
        }
        sc.close();
        JDBCUtils.close();
        System.out.println("退出系统成功！");
    }
}
