package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.models.TrxDetail;
import com.domibowo.dapurbudhe.repositories.TrxDetailRepository;
import com.domibowo.dapurbudhe.service.ProductServices;
import com.domibowo.dapurbudhe.service.TrxDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrxDetailServicesImpl implements TrxDetailServices {

    @Autowired
    TrxDetailRepository repository;

    @Autowired
    ProductServices productServices;

    @Override
    public TrxDetail saveDetail(TrxDetail detail) {
        detail.setProduct(productServices.getProductByID(detail.getProductId()));
        detail.setSubTotal(detail.getQuantity()*productServices.getProductByID(detail.getProductId()).getPrice());
        return repository.save(detail);
    }

    @Override
    public TrxDetail updateDetail(TrxDetail detail) {
        detail.setProduct(productServices.getProductByID(detail.getProductId()));
        detail.setSubTotal(detail.getQuantity()*productServices.getProductByID(detail.getProductId()).getPrice());
        return repository.save(detail);
    }

    @Override
    public TrxDetail saveHistory(TrxDetail detail) {
        return repository.save(detail);
    }

    @Override
    public TrxDetail getDetailById(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public List<TrxDetail> getDetailListWithNullHistory() {
        return repository.findAll().stream().filter(trx -> trx.getHistory() == null).collect(Collectors.toList());
    }

    @Override
    public List<TrxDetail> getAllDetails() {
        return repository.findAll();
    }

    @Override
    public void deleteDetail(String id) {
        repository.deleteById(id);
    }
}
