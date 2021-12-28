package pro.yoric.it.dao;

import pro.yoric.it.pojo.AppParkingUser;

import java.util.List;

public interface IAppParkingUserDao
{
    List<AppParkingUser> searchByAppParkingUserLogin(String login);

    String findUserByPersonId(Long id);

    void saveUser(AppParkingUser user);
}
