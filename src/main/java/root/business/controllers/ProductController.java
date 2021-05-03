package root.business.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.ProductsService;
import root.business.models.Product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ProductController {

    private ProductsService srv;


    public ProductController(ProductsService srv) {
        this.srv = srv;
    }

    @GetMapping(path="/GetProductsList")
    public ModelAndView getProductsList(HttpServletRequest request){
        List<Product> productList = srv.getAllProducts();
        ModelAndView result = new ModelAndView("productListView");
        result.addObject("productList", productList);
        request.setAttribute("connected", request.getSession().getAttribute("connected") != null && (boolean)request.getSession().getAttribute("connected"));
        return result;
    }

    @GetMapping(path="/")
    public ModelAndView homePage(){
        List<Product> productList = srv.getAllProducts();
        ModelAndView result = new ModelAndView("productListView");
        result.addObject("productList", productList);
        return result;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path="/DeleteProduct")
    public ModelAndView deleteProduct(String id, HttpServletRequest request)
    {
        if (redirection(request)) {
        return new ModelAndView("redirect:/GetProductsList");
        }
        srv.deleteProduct(id);
        return new ModelAndView("redirect:/GetProductsList");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/CreateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductForm(HttpServletRequest request){
       // if (redirection(request)) {
        //    return new ModelAndView("redirect:/GetProductsList");
        //}
        return new ModelAndView("productCreate", "product", new Product());
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/CreateProduct", method=RequestMethod.POST)
    public ModelAndView createProduct(@ModelAttribute("product") Product product, HttpServletRequest request){
        if (redirection(request)) {
            return new ModelAndView("redirect:/GetProductsList");
        }
        if (product != null) {
            product.setDatePeremption(LocalDate.now());
            srv.createProduct(product);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/UpdateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductUpdateForm(String id, HttpServletRequest request){
        if (redirection(request)) {
            return new ModelAndView("redirect:/GetProductsList");
        }
        return new ModelAndView("productUpdate", "product", srv.getProductById(id));
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/UpdateProduct", method=RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("product") Product product, HttpServletRequest request){
        if (redirection(request)) {
            return new ModelAndView("redirect:/GetProductsList");
        }
        if (product != null) {
            product.setDatePeremption(LocalDate.now());
            srv.updateProduct(product);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }

    private void checkConnection(HttpServletRequest request)
    {
        if((boolean)request.getSession().getAttribute("connected"))
        {
            request.setAttribute("connected", true);
        }
    }

    private boolean redirection(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("connected") == null) {
            return true;
        } else if (!(boolean)request.getSession().getAttribute("connected")){
            return true;
        };
        return false;
    }
}
