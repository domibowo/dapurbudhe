package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.TrxDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrxDetailRepository extends JpaRepository<TrxDetail, String> {
}
