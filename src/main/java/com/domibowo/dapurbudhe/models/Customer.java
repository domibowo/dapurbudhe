package com.domibowo.dapurbudhe.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;
    private String address;
    private String city;
    private String province;

    @OneToMany(mappedBy = "customer")
    private List<TrxHistory> histories;

    public Customer() {
    }

    public Customer(String id, String name, String address, String city, String province, List<TrxHistory> histories) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.histories = histories;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<TrxHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<TrxHistory> histories) {
        this.histories = histories;
    }
}
