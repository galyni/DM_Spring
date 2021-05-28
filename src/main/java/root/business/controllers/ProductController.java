package root.business.controllers;

import org.apache.tomcat.jni.Local;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Secured("ROLE_ADMIN") // ROLE_ADMIN pourrait être un enum des rôles, ou une constante
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

                // JAMAIS d'instanceof sur une Exception ! Utiliser plutôt le pattern matching du catch.
                // On pourrait par exemple utiliser :
            } catch (DataIntegrityViolationException e) {
                LOG.log(Level.FINE, "Cannot create product - reference already set " + product, e);
                request.setAttribute("error", "Cette référence produit est déjà utilisée: " + product.getCode());
                ModelAndView result = new ModelAndView("productCreate", "product", product);
                result.setStatus(HttpStatus.CONFLICT);
                return result;
            } catch (Exception e) {
                LOG.log(Level.WARNING, "Unable to create product " + product, e);
                request.setAttribute("error", "Une erreur est survenue, veuillez réessayer");
                ModelAndView result = new ModelAndView("productCreate", "product", product);
                result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                return result;
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

        // est-il vraiment normal de ne pas avoir de product ?
        if (product == null) {
            LOG.warning("No product provided !"); // likely a bug
            ModelAndView result = new ModelAndView("productUpdate");
            result.setStatus(HttpStatus.BAD_REQUEST);
            return result;
        }
        //if (product != null) {
            srv.updateProduct(product);
        //}
        return new ModelAndView("redirect:/GetProductsList");
    }

    private static Logger LOG = Logger.getLogger(ProductController.class.getName());

}
