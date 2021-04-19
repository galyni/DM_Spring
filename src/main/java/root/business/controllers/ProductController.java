package root.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import root.business.core.ProductsService;
import root.business.models.Product;
import root.business.models.Utilisateur;


import javax.servlet.http.HttpServletRequest;
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
        List<Product> productList = srv.getAllProducts();
        ModelAndView result = new ModelAndView("productListView");
        result.addObject("productList", productList);
        return result;
    }

    @GetMapping(path="/")
    public ModelAndView homePage(){
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

    @RequestMapping(path="/CreateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductForm(){

        //Product product = new Product();
//        ModelAndView result = new ModelAndView("productCreate"); //Avant Frédo
        //result.addObject("product", product);
//        return result; //Avant Frédo

        return new ModelAndView("productCreate", "product", new Product());
    }


    @RequestMapping(path="/CreateProduct", method=RequestMethod.POST)
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
//    public ModelAndView createProduct(@ModelAttribute Product product){ //Avant Frédo
//        String name = request.getParameter("Nom");
//        String EAN = request.getParameter("EAN");
//        String prix = request.getParameter("price");
//        String quantity = request.getParameter("quantity");

//        Version doc, à voir si il faut faire d'une autre façon
        String name = product.getNom();
        String EAN = product.getCode();
        double prix = product.getPrix();
        int quantity = product.getQuantite();

        if (product != null) {
            //Product product = new Product(name, EAN, Double.parseDouble(prix), Integer.parseInt(quantity), LocalDate.now());
            product.setDatePeremption(LocalDate.now());
            srv.createProduct(product);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }

//    @RequestMapping(path="/UpdateProduct") //Remplacé par les méthodes ci-dessous
//    public ModelAndView updateProduct(){
////    public ModelAndView createProduct(@ModelAttribute Product product){
//        //Mock
//        Product product = srv.getProductById("978020137962");
//        product.setNom("BananeModifiee");
//
//        // For realsies
//        srv.updateProduct(product);
//        return new ModelAndView("redirect:/GetProductsList");
//    }

    @RequestMapping(path="/UpdateProduct", method=RequestMethod.GET)
    public ModelAndView goToProductUpdateForm(String id){

        return new ModelAndView("productUpdate", "product", srv.getProductById(id));
    }


    @RequestMapping(path="/UpdateProduct", method=RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("product") Product product){

        String name = product.getNom();
        String EAN = product.getCode();
        double prix = product.getPrix();
        int quantity = product.getQuantite();

        if (product != null) {

            product.setDatePeremption(LocalDate.now());
            srv.updateProduct(product);
        }
        return new ModelAndView("redirect:/GetProductsList");
    }


}
