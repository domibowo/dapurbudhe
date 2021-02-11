package com.domibowo.dapurbudhe.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class TrxDetail {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private Integer quantity;
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private TrxHistory history;

    @Transient
    private String productId;

    @Transient
    private String historyId;

    public TrxDetail(String id, Integer quantity, Double subTotal, Product product, TrxHistory history, String productId, String historyId) {
        this.id = id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.product = product;
        this.history = history;
        this.productId = productId;
        this.historyId = historyId;
    }

    public TrxDetail() {
    }

    public String getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public TrxHistory getHistory() {
        return history;
    }

    public void setHistory(TrxHistory history) {
        this.history = history;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }
}
