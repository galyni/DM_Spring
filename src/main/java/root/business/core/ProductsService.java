package root.business.core;

import org.apache.tomcat.jni.Local;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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

    public List<Product> getAllProducts(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);
        CriteriaQuery<Product> all = cq.select(rootEntry);
        TypedQuery<Product> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Product getProductById(String id){
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        return product;
    }

    public void deleteProduct(String id){
        Session session = sessionFactory.getCurrentSession();
        Product product = getProductById(id);
        session.delete(product);
    }

    public void updateProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    public void createProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    public static int getRemainingDays(LocalDate datePer){ // indépendant de l'instance
        LocalDate dayDate = LocalDate.now();
        Period period = Period.between(dayDate, datePer);
        return period.getDays();
    }
}
