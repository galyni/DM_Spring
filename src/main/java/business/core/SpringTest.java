package business.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringTest {

    @Autowired
    private ProductsService srv;

    public void Test(){
        srv.Test();
    }
}
