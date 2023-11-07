package com.rentcal.service.Interfation;

import java.sql.SQLException;

public interface ModifyVeInmtion {
    //修改车辆信息接口
    public boolean modifyVehiclePrice() throws SQLException;

    public boolean modifyVehicleNumber() throws SQLException;
}
