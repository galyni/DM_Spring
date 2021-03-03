package business.core;

import business.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class ProductsService {

    public ProductsService() {
    }

    public void Test(){
        System.out.println("On est contents");
    }

    public ArrayList<Product> GetAllProducts(){
        return null;
    }

    public Product GetProductById(int id){
        return null;
    }

    public void DeleteProduct(int id){

    }

    public void UpdateProduct(Product product){

    }

    public void CreateProduct(Product product){

    }
}
