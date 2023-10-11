package online.ronakon.stockmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all")
    ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok((List<Product>) productRepository.findAll());
    }

    @PostMapping("/add")
    ResponseEntity<Void> addProduct(@RequestBody Product product) {
        Product _product = productRepository.save(product);
        return entityWithLocation(_product.getEntityId());
    }

    @PostMapping("/add-all")
    ResponseEntity<Iterable<Product>> addProduct(@RequestBody List<Product> productList) {
        Iterable<Product> iterableProductList = productList;
        return ResponseEntity.status(201).body(productRepository.saveAll(iterableProductList));
    }

    @PutMapping("/{id}")
    void putProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepository.save(product);
    }

    @PatchMapping("/{id}")
    void patchProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteProduct(@PathVariable("id") String id) {
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("id remove" + id);
    }


    /**
     * Return a response with the location of the new resource.
     *
     * Suppose we have just received an incoming URL of, say,
     * http://localhost:8080/accounts and resourceId is "1111". Then the URL of the
     * new resource will be http://localhost:8080/accounts/1111.
     */
    private ResponseEntity<Void> entityWithLocation(Object resourceId) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(resourceId).toUri();
        return ResponseEntity.created(uri).build(); // Return something other than null
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ IllegalArgumentException.class })
    public void handleNotFound(Exception ex) {
        logger.error("Exception is: ", ex);
        // just return empty 404
    }
}
