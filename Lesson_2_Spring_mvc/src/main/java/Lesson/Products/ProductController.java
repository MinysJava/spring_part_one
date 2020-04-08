package Lesson.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public String allProducts(Model model){
        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }

    @GetMapping("/product")
    public String formProduct(Model model){
        model.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping("/product")
    public String newProduct(Product product){
        productRepository.insert(product);
        return "product";
    }


}
