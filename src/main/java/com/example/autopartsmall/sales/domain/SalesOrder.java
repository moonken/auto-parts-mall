package com.example.autopartsmall.sales.domain;

import com.example.autopartsmall.agency.domain.AgencyId;
import com.example.autopartsmall.agency.domain.AgencyService;
import com.example.autopartsmall.common.ddd.AggregateRoot;
import com.example.autopartsmall.common.support.Default;
import com.example.autopartsmall.material.domain.MaterialId;
import com.example.autopartsmall.material.domain.MaterialService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// AllArgsConstructor 只提供给MapStructure PO转DO使用，其他则应走工厂方法
@AllArgsConstructor(onConstructor_={@Default})
// 禁用无参构造函数
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SalesOrder extends AggregateRoot {

    private SalesOrderId id;

    private AgencyId agencyId;

    private Status status;

    private List<SalesOrderLine> orderLines;

    private SalesOrder(AgencyId agencyId, List<SalesOrderLine> orderLines) {
        this.assertNotNull(agencyId, "agencyId can not be null");
        this.assertNotEmpty(orderLines, "orderLines can not be empty");
        this.status = Status.CREATED;
        this.agencyId = agencyId;
        this.orderLines = orderLines;
    }

    public static SalesOrder newOrder(AgencyId agencyId, List<SalesOrderLine> orderLines, AgencyService agencyService) {
        agencyService.validateExist(agencyId);
        return new SalesOrder(agencyId, orderLines);
    }

    public static SalesOrderLine newOrderLine(MaterialId materialId, Integer quantity, MaterialService materialService) {
        return new SalesOrderLine(materialId, quantity, materialService);
    }

    public void confirmed() {
        if (this.status != Status.CREATED) {
            throw new SalesOrderAlreadyConfirmedException();
        }
        this.status = Status.CONFIRMED;
    }

    public enum Status {
        CREATED, CONFIRMED
    }
}
