package abstractFactory.domain.product.dao.oracle;

import abstractFactory.domain.product.Product;
import abstractFactory.domain.product.dao.ProductDao;

public class ProductOracleDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("Insert into Oracle DB productId = " + product.getProductId());
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("Update into Oracle DB productId = " + product.getProductId());
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("Delete into Oracle DB productId = " + product.getProductId());

    }
}
