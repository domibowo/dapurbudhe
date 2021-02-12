package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.TrxHistory;
import com.domibowo.dapurbudhe.service.TrxHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrxHistoryController {

    @Autowired
    TrxHistoryService service;

    @PostMapping("/transaction/submit")
    public TrxHistory submitTransaction(@RequestBody TrxHistory history){
        return service.submitTransaction(history);
    }

    @GetMapping("/history/{id}")
    public TrxHistory getHistoryById(@PathVariable String id){
        return service.getTransactionHistoryById(id);
    }

    @GetMapping("/history")
    public List<TrxHistory> getAllHistory(){
        return service.getAllTransactions();
    }

    @DeleteMapping("/history/{id}")
    public void deleteHistory(@PathVariable String id){
        service.deleteTransaction(id);
    }
}
