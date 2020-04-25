package Lesson.rest;

import Lesson.product.Product;
import Lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return productService.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        if (product.getId() != null){
            throw new IllegalArgumentException("что-нибудь!");
        }
        productService.save(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product){
        productService.save(product);
    }

    @DeleteMapping(path = "/{id}/id", produces = "application/json")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundException exception){
        return new ResponseEntity<>("NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException exception){
        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
