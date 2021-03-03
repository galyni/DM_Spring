import business.core.ProductsService;
import business.core.SpringTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@ComponentScan("business.core")
public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        //Byname Autowiring
        SpringTest test = context.getBean(SpringTest.class);
        test.Test();
    }
}
