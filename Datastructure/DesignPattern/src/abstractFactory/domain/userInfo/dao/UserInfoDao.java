package abstractFactory.domain.userInfo.dao;
import abstractFactory.domain.userInfo.UserInfo;

public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void deleteUserInfo(UserInfo userInfo);


}
