package abstractFactory.factory;

import abstractFactory.domain.product.dao.ProductDao;
import abstractFactory.domain.product.dao.mysql.ProductMySqlDao;
import abstractFactory.domain.userInfo.dao.UserInfoDao;
import abstractFactory.domain.userInfo.dao.mysql.UserInfoMySqlDao;


public class SqlDaoFactory implements DaoFactory {
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMySqlDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductMySqlDao();
    }
}
