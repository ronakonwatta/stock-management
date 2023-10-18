package online.ronakon.stockmanagement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.TreeSet;

@Repository
public interface StockRepository extends ListCrudRepository<Stock, Long> {
    List<Stock> findByCompanyOrderByCreateTimeDesc (String companyCode);

    @Query("SELECT s " +
            "FROM Stock s " +
            "WHERE (s.company, s.productCode, s.entityId) IN " +
            "(SELECT s2.company, s2.productCode, MAX(s2.entityId) " +
            "FROM Stock s2 " +
            "GROUP BY s2.company, s2.productCode) " +
            "ORDER BY s.company, s.productCode")
    List<Stock> findLatestStockByDistinctProductCodeAndCompany();
}
