package root.business.core;

import business.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
@Transactional
public class ProductsService {

    @Autowired
    private SessionFactory sessionFactory;

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

    public void CreateProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }
}
