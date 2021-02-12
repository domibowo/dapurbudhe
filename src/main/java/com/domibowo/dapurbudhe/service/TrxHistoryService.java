package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.TrxHistory;

import java.util.List;

public interface TrxHistoryService {

    TrxHistory submitTransaction(TrxHistory history);
    TrxHistory updateTransaction(TrxHistory history);
    TrxHistory getTransactionHistoryById(String id);
    List<TrxHistory> getAllTransactions();
    void deleteTransaction(String id);
}
