package com.example.autopartsmall.sales.ui.rest.controller;

import com.example.autopartsmall.sales.application.SalesOrderReadService;
import com.example.autopartsmall.sales.application.SalesOrderWriteService;
import com.example.autopartsmall.sales.application.dto.SalesOrderDTO;
import com.example.autopartsmall.sales.application.dto.SubmitOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("sales-orders")
@AllArgsConstructor
public class SalesOrderController {

    private SalesOrderWriteService writeService;
    private SalesOrderReadService readService;

    @PostMapping
    public SalesOrderDTO create(@Valid @RequestBody SubmitOrderRequest request) {
        return SalesOrderDTO.fromDomain(writeService.create(request));
    }

    @PostMapping("{id}/confirm")
    public SalesOrderDTO confirm(@PathVariable Long id) {
        return SalesOrderDTO.fromDomain(writeService.confirm(id));
    }

    @GetMapping("{id}")
    public SalesOrderDTO get(@PathVariable Long id) {
        return SalesOrderDTO.fromPO(readService.get(id));
    }
}
