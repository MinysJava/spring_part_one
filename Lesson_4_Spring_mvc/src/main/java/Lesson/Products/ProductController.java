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
    private int id;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public String allProducts(Model model){
        model.addAttribute("products_array", productRepository.getAllProducts());
        model.addAttribute("productsId", productRepository.getProductsById());
        return "products";
    }

    @GetMapping("/form2")
    public String formProduct(Model model){
        model.addAttribute("product", new Product());
        return "prod_form";
    }

    @PostMapping("/form2")
    public String newProduct(Product product){
        productRepository.insert(product);
        return "redirect:/product";
    }

    @GetMapping("/form3")
    public String productId(Model model){
        model.addAttribute("product", new Product());
        return "prod_find";
    }

    @PostMapping("/form3")
    public String findProduct(Product product){

        productRepository.insertFindId(product);
        productRepository.findProductsById();
        return "redirect:/product";
    }




}
