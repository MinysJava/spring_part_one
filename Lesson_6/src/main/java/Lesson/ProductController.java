package Lesson;


import Lesson.product.Product;
import Lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String getMinMaxProducts(@RequestParam(value = "minPrice") Optional<BigDecimal> minPrice,
                                    @RequestParam(value = "maxPrice") Optional<BigDecimal> maxPrice,
                                    @RequestParam(value = "page") Optional<Integer> page,
                                    @RequestParam(value = "size") Optional<Integer> size,
                                    Model model){
        model.addAttribute("activePage", "Products");
        model.addAttribute("products_array", productService.getMinMaxProducts(
                minPrice, maxPrice,
                PageRequest.of(page.orElse(1) -1, size.orElse(5))));
        model.addAttribute("minPrice", minPrice.orElse(null));
        model.addAttribute("maxPrice", maxPrice.orElse(null));
        return "products";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "prod_form";
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

    @GetMapping("/order")
    public String orders(Model model){
        model.addAttribute("activePage", "Orders");
        return "orders";
    }
}

