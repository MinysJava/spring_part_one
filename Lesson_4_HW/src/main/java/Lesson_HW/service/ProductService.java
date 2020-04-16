package Lesson_HW.service;

import Lesson_HW.product.Product;
import Lesson_HW.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void insert(Product product){
        productRepository.save(product);
    }

    @Transactional
    public void update(Product product){
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getMinMaxProducts(BigDecimal minPrice, BigDecimal maxPrice){
        return productRepository.findByCostBetween(minPrice, maxPrice);
    }

    @Transactional(readOnly = true)
    public List<Product> getMinProducts(BigDecimal minPrice){
        return productRepository.findByCostAfter(minPrice);
    }

    @Transactional(readOnly = true)
    public List<Product> getMaxProducts(BigDecimal maxPrice){
        return productRepository.findByCostBefore(maxPrice);
    }
}
