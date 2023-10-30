package com.rentcal.control;

import java.sql.SQLException;
import java.util.Scanner;

import com.rentcal.bean.user.DefaultCustomer;
import com.rentcal.bean.user.DefaultStoreMgr;
import com.rentcal.bean.user.User;
import com.rentcal.bean.user.VipCustomer;
import com.rentcal.service.AddVehicle;
import com.rentcal.service.DeleteVehicle;
import com.rentcal.service.Lease;
import com.rentcal.service.Login;
import com.rentcal.service.ModifyVehicle;
import com.rentcal.service.Recharge;
import com.rentcal.service.Registered;
import com.rentcal.service.Repaid;
import com.rentcal.service.ShowVehicles;
import com.rentcal.service.ViewMiscellaneous;
import com.rentcal.util.Constants;

public class View {
    public static Scanner sc = new Scanner(System.in);

    public static void view() throws SQLException {
        System.out.println("**********欢迎光临租赁公司**********");
        System.out.println("*按1登录,按2注册,按其他键退出      *");
        int login = sc.nextInt();
        User user = null;
        if (login == Constants.LOG_ON) {
            user = Login.getLogin().login();
        }
        if (login == Constants.REGISTER) {
            user = Registered.getRegistered().registered();
        }
        if (user instanceof DefaultCustomer || user instanceof VipCustomer) {
            int choose = 0;
            ShowVehicles.getShowVehicles().showVehicle();
            System.out.println("*********************************");
            System.out.println("*请选择服务：                   *");
            System.out.println("*按1价格升序排列,按2价格降序排列*");
            System.out.println("*按3进行租赁,按4进行归还        *");
            System.out.println("*按5查看订单,按6充值Vip         *");
            System.out.println("*按7退出系统                    *");
            try {
                while (choose != Constants.EXIT_SYSTEM) {
                    choose = sc.nextInt();
                    switch (choose) {
                        case Constants.PRICE_ASCENDING:
                            ShowVehicles.getShowVehicles().showVehicleAsc();
                            break;
                        case Constants.PRICE_DESCENDING:
                            ShowVehicles.getShowVehicles().showVehicleDesc();
                            break;
                        case Constants.RENT_CAR:
                            Lease.getLease().lease(user);
                            break;
                        case Constants.REPAID_CAR:
                            Repaid.getRepaid().repaid(user);
                            break;
                        case Constants.ORDER_DISPLAY:
                            ViewMiscellaneous.getMiscellaneous().showUserOrder(user);
                            break;
                        case Constants.RECHARGE_VIP:
                            user = Recharge.getRecharge().recharge(user);
                            break;
                        case Constants.EXIT_SYSTEM:
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("输入错误,请重新选择服务");
            }
        }
        if (user instanceof DefaultStoreMgr) {
            int choose = 0;
            ShowVehicles.getShowVehicles().showVehicle();
            System.out.println("请选择操作：");
            System.out.println("按1价格升序排列,按2价格降序排列");
            System.out.println("按3增加车辆,按4删除车辆");
            System.out.println("按5修改车辆日租金,按6修改车辆车牌号");
            System.out.println("按7退出系统,按8查看账单");
            try {
                while (choose != Constants.EXIT_SYSTEM) {
                    choose = sc.nextInt();
                    switch (choose) {
                        case Constants.PRICE_ASCENDING:
                            ShowVehicles.getShowVehicles().showVehicleAsc();
                            break;
                        case Constants.PRICE_DESCENDING:
                            ShowVehicles.getShowVehicles().showVehicleDesc();
                            break;
                        case Constants.ADD_VEHICLES:
                            AddVehicle.getAddVehicle().AddnewVehicle();
                            break;
                        case Constants.DELETE_VEHICLES:
                            DeleteVehicle.getDeleteVehicle().deleteVehicle();
                            break;
                        case Constants.MODIFY_PRICE:
                            ModifyVehicle.getModifyVehicle().modifyVehiclePrice();
                            break;
                        case Constants.MODIFY_NUMBER:
                            ModifyVehicle.getModifyVehicle().modifyVehicleNumber();
                            break;
                        case Constants.EXIT_SYSTEM:
                            break;
                        case Constants.VIEW_BILLS:
                            ViewMiscellaneous.getMiscellaneous().showMoney();
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("输入错误,请重新选择服务");
            }
        }
        System.out.println("退出系统成功");
        sc.close();
    }
}
