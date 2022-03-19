package com.example.autopartsmall.supplier.infrastructure.convertor;

import com.example.autopartsmall.supplier.domain.SupplierId;

public interface SupplierIdConvertor {
    default SupplierId toSupplierId(String id) {
        return new SupplierId(id);
    }

    default String toPO(SupplierId id) {
        return id == null ? null : id.getValue();
    }
}
