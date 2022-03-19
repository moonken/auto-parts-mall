package com.example.autopartsmall.purchase.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PurchaseOrderDAO extends JpaRepository<PurchaseOrderPO, Long>, JpaSpecificationExecutor<PurchaseOrderPO> {

}
