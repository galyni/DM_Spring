package root.business.controllers;

import org.apache.tomcat.jni.Local;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.ProductsService;
import root.business.models.Product;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private ProductsService srv;


    public ProductController(ProductsService srv) {
        this.srv = srv;
    }

    // TODO : refactor
    @GetMapping(path="/GetProductsList")
    public ModelAndView getProductsList(HttpServletRequest request, HttpServletResponse response){
        LocalDate dayDate = LocalDate.now();
        List<Product> productList = srv.getAllProducts();
        HashMap<String, Integer> hashDatePer = new HashMap<String, Integer>();
        for(Product product : productList){
            int joursRestants = srv.getRemainingDays(product.getDatePeremption());
            hashDatePer.put(product.getCode(), joursRestants);
        }
        ModelAndView result = new ModelAndView("productListView");
        result.addObject("hashDatePer", hashDatePer);
        result.addObject("productList", productList);
        result.addObject("dayDate", dayDate);
        return result;
    }

    @GetMapping(path="/")
    public ModelAndView homePage(){
        List<Product> productList = srv.getAllProducts();
        ModelAndView result = new ModelAndView("homeView");
        result.addObject("productList", productList);
        return result;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path="/DeleteProduct")
    public ModelAndView deleteProduct(String id, HttpServletRequest request)
    {
        srv.deleteProduct(id);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/CreateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductForm(HttpServletRequest request){

        return new ModelAndView("productCreate", "product", new Product());
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/CreateProduct", method=RequestMethod.POST)
    public ModelAndView createProduct(@ModelAttribute("product") Product product, HttpServletRequest request){

        if (product != null) {
            try {
                //product.setDatePeremption(LocalDate.now());
                srv.createProduct(product);
            } catch (Exception e) {
                if(e instanceof DataIntegrityViolationException) {
                    request.setAttribute("error", "Cette référence produit est déjà utilisée.");
                } else {
                    request.setAttribute("error", "Une erreur est survenue, veuillez réessayer");
                }
                return new ModelAndView("productCreate", "product", product);
            }
        }
        return new ModelAndView("redirect:/GetProductsList");
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/UpdateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductUpdateForm(String id, HttpServletRequest request){

        return new ModelAndView("productUpdate", "product", srv.getProductById(id));
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/UpdateProduct", method=RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("product") Product product, HttpServletRequest request){

        if (product != null) {
            srv.updateProduct(product);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }


}
