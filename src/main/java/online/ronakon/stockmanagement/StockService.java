package online.ronakon.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

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
        stockRepository.saveAll(stockList);
    }

    List<Stock> findAll(){
        return stockRepository.findAll();
    }


    List<Stock> findStockByCompanyCode(String companyCode){
        return stockRepository.findLatestStockByDistinctProductCodeAndCompany();
    }


}
