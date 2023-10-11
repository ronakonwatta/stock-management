package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping( "/all")
    Iterable  getAllProduct(){
        return  productRepository.findAll();
    }

}
