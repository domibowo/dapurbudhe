package com.domibowo.dapurbudhe.models;

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
    private Timestamp trx_time;

    @OneToMany(mappedBy = "history")
    private List<TrxDetail> details;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public TrxHistory(String id, Double grandTotal, Timestamp trx_time, List<TrxDetail> details, Customer customer) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.trx_time = trx_time;
        this.details = details;
        this.customer = customer;
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
}
