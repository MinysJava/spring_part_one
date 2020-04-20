package Lesson_HW.service;

import Lesson_HW.product.Product;
import Lesson_HW.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    public Page<Product> getMinMaxProducts(Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Pageable pageable){
        if (minPrice.isPresent() && maxPrice.isPresent()) {
            return productRepository.findByCostBetween(minPrice.get(), maxPrice.get(), pageable);
        }
        if (minPrice.isPresent()) {
            return productRepository.findByCostGreaterThanEqual(minPrice.get(), pageable);
        }
        if (maxPrice.isPresent()) {
            return productRepository.findByCostLessThanEqual(maxPrice.get(), pageable);
        }
        return productRepository.findAll(pageable);
    }

//    @Transactional(readOnly = true)
//    public List<Product> getMinProducts(BigDecimal minPrice){
//        return productRepository.findByCostAfter(minPrice);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Product> getMaxProducts(BigDecimal maxPrice){
//        return productRepository.findByCostBefore(maxPrice);
//    }

    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }
}
