package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.TrxDetail;

import java.util.List;

public interface TrxDetailServices {

    TrxDetail saveDetail(TrxDetail detail);
    TrxDetail updateDetail(TrxDetail detail);
    void saveHistory(TrxDetail detail);
    TrxDetail getDetailById(String id);
    List<TrxDetail> getDetailListWithNullHistory();
    List<TrxDetail> getAllDetails();
    void deleteDetail(String id);
}
