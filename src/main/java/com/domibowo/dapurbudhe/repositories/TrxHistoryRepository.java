package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.TrxHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrxHistoryRepository extends JpaRepository<TrxHistory, String> {
}
