package com.fabio.backend.controllers;


import com.fabio.backend.exemples.PriceTableExample;
import com.fabio.backend.exemples.SACTableExample;
import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import com.fabio.backend.models.enums.RateType;
import com.fabio.backend.services.FinancingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class FinancingControllerTest {

    @Mock
    private FinancingService financingService;

    @InjectMocks
    private FinancingController financingController;

    private final List<TableFinancing> tabelaPrice = PriceTableExample.priceTable;

    private final List<TableFinancing> tabelaSac = SACTableExample.sacTable;

    @Test
    void shouldReturnStatusCreatedForPriceTable(){
        Financing financing = new Financing("PRICE",30000d, 0d,1.2, "MENSAL",24);
        Mockito.when(financingService.getFinancingPriceTable(financing)).thenReturn(tabelaPrice);
        var response = financingController.getFinancingPriceTable(financing);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(tabelaPrice),response);
    }

    @Test
    void shouldReturnStatusCreatedForSacTable(){
        Financing financing = new Financing("SAC",30000d, 0d,1.2, "MENSAL",24);
        Mockito.when(financingService.getFinancingSACTable(financing)).thenReturn(tabelaSac);
        var response = financingController.getFinancingSacTable(financing);
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(tabelaSac),response);
    }

}
