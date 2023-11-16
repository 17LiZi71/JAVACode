package com.rentcal.control;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.DefaultCustomer;
import com.rentcal.bean.user.DefaultStoreMgr;
import com.rentcal.bean.user.User;
import com.rentcal.bean.user.VipCustomer;
import com.rentcal.service.AdminService;
import com.rentcal.service.CustomerService;
import com.rentcal.service.Login;
import com.rentcal.util.Constants;

public class View {
    public static Scanner sc = new Scanner(System.in);

    public static void view() throws SQLException {
        System.out.println("*****欢迎光临租赁公司*****");
        System.out.println("*     按1登录,按2注册    *");
        int login = sc.nextInt();
        User user = null;
        if (login == Constants.LOG_ON) {// 进行登录
            user = Login.getLogin().login();
        }
        if (login == Constants.REGISTER) {// 进行注册
            user = CustomerService.getCustomerService().cusRegistered();
        }
        if (user instanceof DefaultCustomer || user instanceof VipCustomer) {
            // 用户对功能进行选择
            int choose = 0;
            System.out.println("*************************");
            System.out.println("*      请选择服务：     *");
            System.out.println("*按1升序排列,按2降序排列*");
            System.out.println("*按3进行租赁,按4进行归还*");
            System.out.println("*按5查看订单,按6充值Vip *");
            System.out.println("*按7退出系统,按8默认排列*");
            // 用户功能选择
            while (choose != Constants.EXIT_SYSTEM) {
                try {
                    choose = sc.nextInt();
                    switch (choose) {
                        case Constants.PRICE_ASCENDING:
                            CustomerService.getCustomerService().cusShowVehicleAsc();// 价格升序查看车辆
                            break;
                        case Constants.PRICE_DESCENDING:
                            CustomerService.getCustomerService().cusShowVehicleDesc();// 价格降序查看车辆
                            break;
                        case Constants.RENT_CAR:
                            CustomerService.getCustomerService().cusLease(user);// 租赁车辆
                            break;
                        case Constants.REPAID_CAR:
                            CustomerService.getCustomerService().cusRepaid(user);// 归还车辆
                            break;
                        case Constants.ORDER_DISPLAY:
                            CustomerService.getCustomerService().cusShowUserOrder(user);// 查看订单
                            break;
                        case Constants.RECHARGE_VIP:
                            user = CustomerService.getCustomerService().cusRecharge(user);// 充值Vip
                            break;
                        case Constants.EXIT_SYSTEM:// 退出系统
                            break;
                        case Constants.DEFAULT_COLLATION:// 车辆按默认编号顺序进行排序
                            CustomerService.getCustomerService().cusShowVehicle();
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {// 异常捕获，提示输入错误
                    System.out.println("输入错误,请重新选择服务");
                    sc.next();
                }
            }
        }
        if (user instanceof DefaultStoreMgr) {// 管理员进行功能选择
            int choose = 0;
            System.out.println("*************************");
            System.out.println("*      请选择操作：     *");
            System.out.println("*按1查看用户,按2删除用户*");
            System.out.println("*按3增加车辆,按4删除车辆*");
            System.out.println("*按5修改租金,按6修改车牌*");
            System.out.println("*按7退出系统,按8默认排列*");
            System.out.println("*按9查看流水            *");
            while (choose != Constants.EXIT_SYSTEM) {
                try {
                    choose = sc.nextInt();
                    switch (choose) {
                        case Constants.SHOW_USER:
                            AdminService.getAdminService().admViewUser();// 查看用户信息
                            break;
                        case Constants.DELETE_USER:// 删除指定用户
                            AdminService.getAdminService().admDeleteUser();
                            break;
                        case Constants.ADD_VEHICLES:// 添加车辆
                            AdminService.getAdminService().admAddnewVehicle();
                            break;
                        case Constants.DELETE_VEHICLES:// 删除指定车辆
                            AdminService.getAdminService().admDeleteVehicle();
                            break;
                        case Constants.MODIFY_PRICE:// 更改车辆价格
                            AdminService.getAdminService().admModifyVehiclePrice();
                            break;
                        case Constants.MODIFY_NUMBER:// 更改车辆车牌号
                            AdminService.getAdminService().admOdifyVehicleNumber();
                            break;
                        case Constants.EXIT_SYSTEM:// 退出系统
                            break;
                        case Constants.DEFAULT_COLLATION:// 按编号默认展示车辆
                            AdminService.getAdminService().admShowVehicle();
                            break;
                        case Constants.VIEW_BILLS:// 查看总流水
                            AdminService.getAdminService().admShowMoney();
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {// try catch语句进行异常捕获
                    System.out.println("输入错误,请重新选择服务");
                    sc.next();
                }
            }
        }
        System.out.println("退出系统成功");
        sc.close();
    }
}
