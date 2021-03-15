package root;

import root.business.core.ProductsService;
import business.models.Product;
import root.conf.SpringHibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;


public class main2 {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);

//        SpringHibernateConfig config = context.getBean(SpringHibernateConfig.class);
//        SessionFactory testBDD = config.sessionFactory().getObject();
//        Session oSession = testBDD.openSession();

        try {
            Product produit1 = new Product();
            produit1.setCode("25101999");
            produit1.setNom("Litchi");
            produit1.setQuantite(493);
            produit1.setDatePeremption(LocalDate.now());

            ProductsService service = context.getBean(ProductsService.class);
            service.CreateProduct(produit1);

//            oSession.flush();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
//            oSession.close();
//            testBDD.close();
        }
    }
}
