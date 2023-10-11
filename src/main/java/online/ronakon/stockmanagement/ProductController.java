package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping( "/all")
    List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping("/add")
    void addProduct(@RequestBody Product product){
        productRepository.save(product);
        return;
    }

    @PutMapping("/{id}")
    void putProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepository.save(product);
    }

    @PatchMapping("/{id}")
    void patchProduct(@PathVariable("id") String id, @RequestBody Product product){
        productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    void delProduct(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

}
