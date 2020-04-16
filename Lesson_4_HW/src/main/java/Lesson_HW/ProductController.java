package Lesson_HW;

import Lesson_HW.product.Product;
import Lesson_HW.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String allProducts(Model model){
        model.addAttribute("products_array", productService.getAllProducts());
        return "products";
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public String getMinMaxProducts(@RequestParam("minPrice") BigDecimal minPrice,
                              @RequestParam("maxPrice") BigDecimal maxPrice,
                              Model model){
        model.addAttribute("products_array", productService.getMinMaxProducts(minPrice, maxPrice));
        return "products";
    }

    @GetMapping("/form")
    public String formProduct(Model model){
        model.addAttribute("product", new Product());
        return "prod_form";
    }

    @PostMapping("/form")
    public String newProduct(Product product){
        productService.insert(product);
        return "redirect:/product";
    }
}

