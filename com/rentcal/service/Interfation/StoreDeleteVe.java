package com.rentcal.service.Interfation;

import java.sql.SQLException;

public interface StoreDeleteVe {
    //删除车辆及用户接口
    public boolean deleteVehicle() throws SQLException;

    public boolean deleteUser() throws SQLException;
}
