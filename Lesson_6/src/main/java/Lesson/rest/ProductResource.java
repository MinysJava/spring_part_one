package Lesson.rest;

import Lesson.product.Product;
import Lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(path = "/{id}/id", produces = "application/json")
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id).get();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product){
        productService.save(product);
    }

    @DeleteMapping(path = "/{id}/id", produces = "application/json")
    public void deleteProduct(Long id){
        productService.deleteById(id);
    }
}
