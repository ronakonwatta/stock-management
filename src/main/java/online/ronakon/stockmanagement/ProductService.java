package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ProductService() {
    }


    void save(Product product) {
        Product _oldProduct = repository.findByProductCode(product.productCode);
        if (_oldProduct == null)
            repository.save(product);
        if (_oldProduct != null) {
            _oldProduct.productName = product.productName;
            _oldProduct.lastModifiedDate = new Date();
            _oldProduct.price = product.price;
            repository.save(_oldProduct);
        }
    }

    void delete(String productCode) {
        Product _oldProduct = repository.findByProductCode(productCode);
        if (_oldProduct == null)
            return;
        if (_oldProduct != null) {
            _oldProduct.deletedDate = new Date();
            _oldProduct.isDeleted = Boolean.TRUE;
            repository.save(_oldProduct);
        }
    }

    List<Product> findAll() {
        return repository.findAll();
    }

}
