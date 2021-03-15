package business.core;

import business.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
public class ProductsService {

    public ProductsService() {

    }

    public void Test(){
        System.out.println("On est contents");
    }

    public ArrayList<Product> GetAllProducts(){
        return null;
    }

    public Product GetProductById(int id){
        return null;
    }

    public void DeleteProduct(int id){

    }

    public void UpdateProduct(Product product){

    }
    @Transactional
    public void CreateProduct(Product product, Session session){
        session.save(product);

    }
}
