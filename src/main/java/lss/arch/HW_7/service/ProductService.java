package lss.arch.HW_7.service;

import lombok.RequiredArgsConstructor;
import lss.arch.HW_7.model.Product;
import lss.arch.HW_7.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Product saveNewProduct(String title, Integer price) {
        Product newProduct = new Product();
        newProduct.setTitle(title);
        newProduct.setPrice(price);
        productRepo.save(newProduct);
        return newProduct;
    }
}
