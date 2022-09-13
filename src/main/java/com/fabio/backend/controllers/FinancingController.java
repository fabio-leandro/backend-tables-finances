package com.fabio.backend.controllers;


import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import com.fabio.backend.services.FinancingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/financing")
public class FinancingController {

    @Autowired
    private FinancingService financingService;

    @PostMapping("/price")
    public ResponseEntity<List<TableFinancing>> getFinancingPriceTable(@RequestBody Financing financing){
        return ResponseEntity.status(HttpStatus.CREATED).body(financingService.getFinancingPriceTable(financing));
    }

    @PostMapping("/sac")
    public ResponseEntity<List<TableFinancing>> getFinancingSacTable(@RequestBody Financing financing){
        return ResponseEntity.status(HttpStatus.CREATED).body(financingService.getFinancingSACTable(financing));
    }
}
