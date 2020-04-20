package Lesson_HW;

import Lesson_HW.product.Product;
import Lesson_HW.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

//    @GetMapping
//    public String allProducts(Model model){
//        model.addAttribute("products_array", productService.getAllProducts());
//        return "products";
//    }

    @GetMapping
    public String getMinMaxProducts(@RequestParam(value = "minPrice") Optional<BigDecimal> minPrice,
                                    @RequestParam(value = "maxPrice") Optional<BigDecimal> maxPrice,
                                    @RequestParam(value = "page") Optional<Integer> page,
                                    @RequestParam(value = "size") Optional<Integer> size,
                                    Model model){
        model.addAttribute("products_array", productService.getMinMaxProducts(
                minPrice, maxPrice,
                PageRequest.of(page.orElse(1) -1, size.orElse(5))));
        model.addAttribute("minAge", minPrice.orElse(null));
        model.addAttribute("maxAge", maxPrice.orElse(null));
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

