package Lesson_HW.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCostBetween (BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);

    Page<Product> findByCostGreaterThanEqual (BigDecimal minPrice, Pageable pageable);

    Page<Product> findByCostLessThanEqual (BigDecimal maxPrice, Pageable pageable);



}
