package pro.yoric.it.dao;

import pro.yoric.it.parking.pojo.AppParkingUser;

import java.util.List;

public interface IAppParkingUserDao
{
    // CREATE
    void saveUser(AppParkingUser user);

    // READ
    String               findUserByPersonId         (Long id);
    List<AppParkingUser> searchByAppParkingUserLogin(String login);
}
