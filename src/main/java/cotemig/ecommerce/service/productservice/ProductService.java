package cotemig.ecommerce.service.productservice;

import cotemig.ecommerce.model.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Integer id);

    List<Product> getAllProducts();

    void deleteAllProducts();

    void deleteProductById(Integer id);

    void insertProduct(Product product);
}
