package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.TrxDetail;
import com.domibowo.dapurbudhe.service.TrxDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrxDetailController {

    @Autowired
    TrxDetailServices services;

    @PostMapping("/transaction")
    public TrxDetail saveTrxDetail(@RequestBody TrxDetail detail){
        return services.saveDetail(detail);
    }

    @PutMapping("/transaction")
    public TrxDetail updateTrxDetail(@RequestBody TrxDetail detail){
        return services.updateDetail(detail);
    }

    @GetMapping("/transaction/detail/{id}")
    public TrxDetail getDetailById(@PathVariable String id){
        return services.getDetailById(id);
    }

    @GetMapping("/cart")
    public List<TrxDetail> getTrxDetailsWithoutHistory(){
        return services.getDetailListWithNullHistory();
    }

    @GetMapping("/transaction/detail")
    public List<TrxDetail> getAllTrxDetails(){
        return services.getAllDetails();
    }

    @DeleteMapping("/transaction/detail/{id}")
    public void deleteTrxDetail(@PathVariable String id){
        services.deleteDetail(id);
    }
}
