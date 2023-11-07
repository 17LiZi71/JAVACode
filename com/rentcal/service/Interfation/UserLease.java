package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserLease {
    //用户租赁车辆接口
    public boolean lease(User user) throws SQLException;
}
