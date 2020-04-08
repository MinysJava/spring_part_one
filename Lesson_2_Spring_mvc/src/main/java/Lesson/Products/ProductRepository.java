package Lesson.Products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {

    private final AtomicInteger identity = new AtomicInteger(0);

    private final List<Product> products = new ArrayList<>();
    private List<Product> productsId = new ArrayList<>();

    public ProductRepository() {
        insert(new Product("Б.Ю.Александров", 59.6f));
        insert(new Product("Батон", 46.5f));
        insert(new Product("Dragon", 348.37f));
    }

    public void insert(Product product){
        product.setId(identity.incrementAndGet());
        product.setCost((double) Math.round(product.getCost() * 100) / 100);
        products.add(product);
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }

    public List<Product> getProductsById(int id){

        for (Product a: products) {
            if(a.getId() == id){
                productsId.add(a);
            }
        }
        return Collections.unmodifiableList(productsId);
    }
}
