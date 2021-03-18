package root;

import root.business.core.ProductsService;
import root.business.core.SpringTest;
import root.business.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;

@ComponentScan("business.core")
public class Main {

    public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(root.Main.class);
//
//        //Byname Autowiring
//        SpringTest test = context.getBean(SpringTest.class);
//        test.Test();
        System.out.println("Main numero 1");
        SessionFactory testBDD = new Configuration().configure().buildSessionFactory();
        Session oSession = testBDD.openSession();
        Transaction oTransaction = null;

        try {
           oTransaction  = oSession.beginTransaction();
           Product produit1 = new Product();
           produit1.setCode("17885541");
           produit1.setNom("Framboise");
           produit1.setQuantite(8966665);
           produit1.setDatePeremption(LocalDate.now());

           oSession.save(produit1);

            Product produit2 = (Product) oSession.find(Product.class, "123020137962");
           oSession.flush();
           oTransaction.commit();
            System.out.println(produit2.getNom());

        }catch (Exception e){
            System.out.println("lalala");
            if (oTransaction != null){
                oTransaction.rollback();
            }

        }
        finally {
            oSession.close();
            testBDD.close();
        }



    }
}
