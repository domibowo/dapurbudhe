package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.models.TrxDetail;
import com.domibowo.dapurbudhe.models.TrxHistory;
import com.domibowo.dapurbudhe.repositories.TrxHistoryRepository;
import com.domibowo.dapurbudhe.service.CustomerServices;
import com.domibowo.dapurbudhe.service.TrxDetailServices;
import com.domibowo.dapurbudhe.service.TrxHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrxHistoryServicesImpl implements TrxHistoryService {

    @Autowired
    TrxHistoryRepository repository;

    @Autowired
    TrxDetailServices detailServices;

    @Autowired
    CustomerServices customerServices;

    @Override
    public TrxHistory submitTransaction(TrxHistory history) {
        List<TrxDetail> details = new ArrayList<>(detailServices.getDetailListWithNullHistory());
        history.setGrandTotal(details.stream().mapToDouble(TrxDetail::getSubTotal).sum());
        history.setTrx_time(new Timestamp(System.currentTimeMillis()));
        history.setDetails(details);
        history.setCustomer(customerServices.getCustomerById(history.getCustomerId()));
        repository.save(history);
        for(TrxDetail detail: details){
            detail.setHistory(history);
            detailServices.saveHistory(detail);
        }
        return history;
    }

    @Override
    public TrxHistory updateTransaction(TrxHistory history) {
        return repository.save(history);
    }

    @Override
    public TrxHistory getTransactionHistoryById(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public List<TrxHistory> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public void deleteTransaction(String id) {
        repository.deleteById(id);
    }
}
