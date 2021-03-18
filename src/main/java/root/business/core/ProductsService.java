package root.business.core;

import root.business.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class ProductsService {


    @Autowired
    private SessionFactory sessionFactory;

    public ProductsService() {
    }

    public void test(){
        System.out.println("On est contents");
    }

    public ArrayList<Product> getAllProducts(){
        return null;
    }

    public Product getProductById(int id){
        return null;
    }

    public void deleteProduct(int id){

    }

    public void updateProduct(Product product){

    }

    public void createProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.save(product);

    }
}
