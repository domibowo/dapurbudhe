package com.domibowo.dapurbudhe.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "history")
public class TrxHistory {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private Double grandTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z", timezone = "GMT+7")
    private Timestamp trx_time;

    @OneToMany(mappedBy = "history")
    @JsonIgnoreProperties(value = {"history"})
    private List<TrxDetail> details;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties(value = {"histories"})
    private Customer customer;

    @Transient
    private String customerId;

    public TrxHistory(String id, Double grandTotal, Timestamp trx_time, List<TrxDetail> details, Customer customer, String customerId) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.trx_time = trx_time;
        this.details = details;
        this.customer = customer;
        this.customerId = customerId;
    }

    public TrxHistory() {
    }

    public String getId() {
        return id;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Timestamp getTrx_time() {
        return trx_time;
    }

    public void setTrx_time(Timestamp trx_time) {
        this.trx_time = trx_time;
    }

    public List<TrxDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TrxDetail> details) {
        this.details = details;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
