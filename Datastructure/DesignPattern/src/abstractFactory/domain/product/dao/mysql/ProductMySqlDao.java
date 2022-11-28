package abstractFactory.domain.product.dao.mysql;

import abstractFactory.domain.product.Product;
import abstractFactory.domain.product.dao.ProductDao;

public class ProductMySqlDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("Insert into MySQL DB productId = " + product.getProductId());
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("Update into MySQL DB productId = " + product.getProductId());
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("Delete into MySQL DB productId = " + product.getProductId());

    }
}
