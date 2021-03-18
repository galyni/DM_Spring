package root.business.core;

import root.business.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ProductsService {


    @Autowired
    private SessionFactory sessionFactory;

    public ProductsService() {
    }

    public void test(){
        System.out.println("On est contents");
    }

    public List<Product> getAllProducts(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);
        CriteriaQuery<Product> all = cq.select(rootEntry);

        TypedQuery<Product> allQuery = session.createQuery(all);
        return allQuery.getResultList();

    }


    public Product getProductById(int id){
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        return product;
    }

    public void deleteProduct(int id){

    }

    public void updateProduct(Product product){

    }

    @Transactional
    public void createProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }
}
