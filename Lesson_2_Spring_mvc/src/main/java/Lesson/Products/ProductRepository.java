package Lesson.Products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {

    private final AtomicInteger identity = new AtomicInteger(0);

    private final List<Product> products_array = new ArrayList<>();
    private List<Product> productsId = new ArrayList<>();

    public ProductRepository() {
        insert(new Product("Б.Ю.Александров", 59.6f));
        insert(new Product("Батон", 46.5f));
        insert(new Product("Dragon", 348.37f));
//        productsId.add(new Product("8", 7f));
    }

    public void insert(Product product){
        product.setId(identity.incrementAndGet());
        product.setCost((double) Math.round(product.getCost() * 100) / 100);
        products_array.add(product);
    }

    public void insertFindId(Product product){
        productsId.add(product);
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products_array);
    }

    public List<Product> findProductsById(){

        for (Product a: products_array) {
            if(a.getId() == productsId.get(0).getId()){
                productsId.add(a);
            }
        }
        productsId.remove(0);
        return Collections.unmodifiableList(productsId);
    }
    public List<Product> getProductsById(){
        return Collections.unmodifiableList(productsId);
    }

}
