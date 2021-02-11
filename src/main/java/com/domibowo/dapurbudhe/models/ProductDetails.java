package com.domibowo.dapurbudhe.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "prd_details")
public class ProductDetails {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String prdDetails;

    @OneToOne(mappedBy = "prdDetails")
    private Product product;

    public ProductDetails(String id, String prdDetails, Product product) {
        this.id = id;
        this.prdDetails = prdDetails;
        this.product = product;
    }

    public ProductDetails() {
    }

    public String getId() {
        return id;
    }

    public String getPrdDetails() {
        return prdDetails;
    }

    public void setPrdDetails(String prdDetails) {
        this.prdDetails = prdDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
