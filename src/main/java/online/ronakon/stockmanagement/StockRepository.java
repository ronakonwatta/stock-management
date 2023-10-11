package online.ronakon.stockmanagement;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends ListCrudRepository<Stock, Long> {
    List<Stock> findStocksByOrderByCreateTime();
}
