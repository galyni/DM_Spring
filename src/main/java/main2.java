import business.core.ProductsService;
import business.models.Product;
import conf.SpringHibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.time.LocalDate;

public class main2 {

    public static void main(String[] args) {
        SpringHibernateConfig config = new SpringHibernateConfig();
        SessionFactory testBDD = (SessionFactory) config.sessionFactory();
        Session oSession = testBDD.openSession();

        try {
            Product produit1 = new Product();
            produit1.setCode("25101999");
            produit1.setNom("Litchi");
            produit1.setQuantite(493);
            produit1.setDatePeremption(LocalDate.now());

            ProductsService service = new ProductsService();
            service.CreateProduct(produit1, oSession);

            oSession.flush();

        } catch (Exception e) {
            System.out.println("lalala");

        } finally {
            oSession.close();
            testBDD.close();
        }
    }
}
