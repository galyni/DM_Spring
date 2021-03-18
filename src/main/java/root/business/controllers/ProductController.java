package root.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.ProductsService;
import root.business.models.Product;

import java.util.List;

@Controller
public class ProductController {

    private ProductsService srv;

    public ProductController(ProductsService srv) {
        this.srv = srv;
    }

    @GetMapping(path="/GetProductsList")
    public ModelAndView getProductsList(){
        System.out.println("Bonjour");
        List<Product> productList = srv.getAllProducts();
        ModelAndView result = new ModelAndView("productListView");
        result.addObject("productList", productList);
        return result;
    }

}
