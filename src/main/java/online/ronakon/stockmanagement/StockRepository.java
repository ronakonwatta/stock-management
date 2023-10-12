package online.ronakon.stockmanagement;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.TreeSet;

@Repository
public interface StockRepository extends ListCrudRepository<Stock, Long> {
    List<Stock> findByCompanyOrderByCreateTimeDesc (String companyCode);
}
