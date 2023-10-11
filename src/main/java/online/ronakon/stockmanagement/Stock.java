package online.ronakon.stockmanagement;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "STOCK_TRANSACTION")
public class Stock {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long entityId;
    @Column(name = "COMPANY")
    public String company;

    @Deprecated
    @Column(name = "OPERATION_CODE")
    public String operationCode;

    @Deprecated
    @Column(name = "SUB_OPERATION")
    public String subOperation;

    @Column(name = "PRODUCT_CODE")
    public String productCode;

    @Column(name = "QUANTITY")
    public String quantity;

    @Deprecated
    @Column(name = "WEIGHT")
    public String weight;

    @Deprecated
    @Column(name = "SOURCE_OF_DATA")
    public String sourceOfData;
    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    public Date createTime;

    @Column(name = "CREATE_BY")
    public String createBy;
}
