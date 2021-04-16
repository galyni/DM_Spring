package root.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.ProductsService;
import root.business.models.Product;

import java.time.LocalDate;
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

    @GetMapping(path="/DeleteProduct")
    public ModelAndView deleteProduct(String id)
    {
        srv.deleteProduct(id);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @RequestMapping(path="/CreateProduct")
    public ModelAndView createProduct(){
//    public ModelAndView createProduct(@ModelAttribute Product product){
        //Mock
        Product product = new Product("SpringPueDuCul", "ABCDEFGHI", 15.5, 12000, LocalDate.now());

        // For realsies
        srv.createProduct(product);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @RequestMapping(path="/UpdateProduct")
    public ModelAndView updateProduct(){
//    public ModelAndView createProduct(@ModelAttribute Product product){
        //Mock
        Product product = srv.getProductById("978020137962");
        product.setNom("BananeModifiee");

        // For realsies
        srv.updateProduct(product);
        return new ModelAndView("redirect:/GetProductsList");
    }
}
