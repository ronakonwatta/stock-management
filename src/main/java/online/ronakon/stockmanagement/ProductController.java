package online.ronakon.stockmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController() {
    }

    @GetMapping("/all")
    List<Product> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/")
    ResponseEntity<List<Product>>  getAll() {
        var a =  productService.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @PostMapping("/add")
    ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
//
//    @PostMapping("/add-all")
//    ResponseEntity<Void> addProduct(@RequestBody List<Product> productList) {
//        for(Product _elem : productList){
////            productService.save(_elem);
//        }
//        return ResponseEntity.status(201).body(null);
//    }
//
//    @PutMapping("/{id}")
//    ResponseEntity<Object> putProduct(@PathVariable("id") String id, @RequestBody Product product) {
////        productService.save(product);
//        return ResponseEntity.status(204).body(null);
//    }
//
//    @PatchMapping("/{id}")
//    ResponseEntity<Object>  patchProduct(@PathVariable("id") String id, @RequestBody Product product) {
////        productService.save(product);
//        return ResponseEntity.status(204).body(null);
//    }
//
//    @DeleteMapping("/{id}")
//    ResponseEntity deleteProduct(@PathVariable("id") String id) {
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("id remove" + id);
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler({IllegalArgumentException.class})
//    public void handleNotFound(Exception ex) {
//        logger.error("Exception is: ", ex);
//        // just return empty 404
//    }
}
