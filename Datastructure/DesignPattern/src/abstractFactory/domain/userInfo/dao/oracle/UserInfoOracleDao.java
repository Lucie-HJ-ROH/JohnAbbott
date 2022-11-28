package abstractFactory.domain.userInfo.dao.oracle;

import abstractFactory.domain.userInfo.UserInfo;
import abstractFactory.domain.userInfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {


    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into MySQL DB UserId = " + userInfo.getUserId());

    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update into MySQL DB UserId = " + userInfo.getUserId());

    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete into MySQL DB UserId = " + userInfo.getUserId());

    }
}
