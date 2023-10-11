package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    StockService stockService;

//    @GetMapping("/all-lastest")
//    ResponseEntity<Object> getAllStockLastest() {
//        var _temp = stockService.findAllLastest();
//        return ResponseEntity.status(HttpStatus.OK).body(_temp);
//    }

    @GetMapping("/stock-in-company/{id}")
    ResponseEntity<Object> getAllStockByCompany(@PathVariable("id") String company){
        var _temp = stockService.findStockByCompanyCode(company);
        return ResponseEntity.status(HttpStatus.OK).body(_temp);
    }

    @GetMapping("/all")
    ResponseEntity<Object> getAllStock() {
        var _temp = stockService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(_temp);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ResponseEntity<Void> addToStock(@RequestBody Stock stock) {
        stockService.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value = "/add-list")
    ResponseEntity<Void> addListToStock(@RequestBody List<Stock> stockList){
        stockService.saveList(stockList);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
