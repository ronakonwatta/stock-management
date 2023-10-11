package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public StockService() {
    }

    void save(Stock stock) {
        stockRepository.save(stock);
    }

    void saveList(List<Stock> stockList) {
        for (Stock stock : stockList) {
            stockRepository.save(stock);
        }
    }

    List<Stock> findAll(){
        return stockRepository.findAll();
    }

    List<Stock> findAllLastest(){

        // TODO find product that have lastest then distish company and productCode
        return stockRepository.findStocksByOrderByCreateTime();
    }

}
