package online.ronakon.stockmanagement;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long entityId;

    @Column(name ="PRODUCT_CODE", nullable = false, unique = true)
    public String productCode;


    @Column(name = "PRODUCT_NAME")
    public String productName;

    @Column(name = "PRICE")
    public double price;

    //region System Stamp
    @Column(name = "VERSION", nullable = false)
    @Version
    public Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    public String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    public Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    public String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @UpdateTimestamp
    public Date lastModifiedDate;

    @Column(name = "DELETED_DATE")
    public Date deletedDate;

    @Column(name = "DELETED_BY")
    public String deleteBy;

    @Column(name = "IS_DELETED")
    public Boolean isDeleted = Boolean.FALSE;

    public Product() {
    }

}
