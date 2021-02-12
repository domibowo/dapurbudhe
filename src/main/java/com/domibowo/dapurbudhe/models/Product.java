package com.domibowo.dapurbudhe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String productName;
    private String image;
    private Double price;
    private Integer preOrder;

    @OneToOne
    @JoinColumn(name="detail_id")
    @JsonIgnoreProperties(value = {"product"})
    private ProductDetails prdDetails;

    @OneToMany(mappedBy = "product")
    private List<TrxDetail> details;

    @Transient
    private String prdDetailId;

    public Product(){}

    public Product(String id, String prdDetailId, String image, String productName, Integer preOrder, Double price, ProductDetails prdDetails, List<TrxDetail> details){
        this.id = id;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.prdDetails = prdDetails;
        this.details = details;
        this.preOrder = preOrder;
        this.prdDetailId = prdDetailId;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDetails getPrdDetails() {
        return prdDetails;
    }

    public void setPrdDetails(ProductDetails prdDetails) {
        this.prdDetails = prdDetails;
    }

    public List<TrxDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TrxDetail> details) {
        this.details = details;
    }

    public Integer getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Integer preOrder) {
        this.preOrder = preOrder;
    }

    public String getPrdDetailId() {
        return prdDetailId;
    }

    public void setPrdDetailId(String prdDetailId) {
        this.prdDetailId = prdDetailId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
