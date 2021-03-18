package root;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import root.business.core.ProductsService;
import root.business.models.Product;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Main2 {

    public static void main(String[] args) {
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);

//        SpringHibernateConfig config = context.getBean(SpringHibernateConfig.class);
//        SessionFactory testBDD = config.sessionFactory().getObject();
//        Session oSession = testBDD.openSession();

//        try {
//            Product produit1 = new Product();
//            produit1.setCode("25101999");
//            produit1.setNom("Litchi");
//            produit1.setQuantite(493);
//          sta produit1.setDatePeremption(LocalDate.now());
//
//            ProductsService service = context.getBean(ProductsService.class);
//            SessionFactory sessionFactory = context.getBean(SessionFactory.class);
//            Session session = sessionFactory.getCurrentSession();
//            service.CreateProduct(produit1, session);
//
////            oSession.flush();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
////            oSession.close();
////            testBDD.close();
//        }

        ApplicationContext ctx = SpringApplication.run(Main2.class, args);
        ProductsService srv = ctx.getBean(ProductsService.class);
        Product produit1 = new Product();
        produit1.setCode("4321");
        produit1.setNom("Litchi");
        produit1.setQuantite(15);
        produit1.setDatePeremption(LocalDate.now());

       new Thread(() -> {
           srv.createProduct(produit1);
       }).start();



    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//
//        return args -> {
//
//            System.out.println("Liste des Beans enregistrés par Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
}
