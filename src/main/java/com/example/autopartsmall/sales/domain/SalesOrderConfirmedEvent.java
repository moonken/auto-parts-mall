package com.example.autopartsmall.sales.domain;

import com.example.autopartsmall.common.ddd.DomainEvent;
import lombok.Value;

@Value(staticConstructor = "of")
public class SalesOrderConfirmedEvent extends DomainEvent {
    SalesOrderId salesOrderId;
}
