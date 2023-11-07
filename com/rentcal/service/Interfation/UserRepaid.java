package com.rentcal.service.Interfation;

import java.sql.SQLException;

import com.rentcal.bean.user.User;

public interface UserRepaid {
    //用户还车接口
    public void repaid(User user) throws SQLException;
}
