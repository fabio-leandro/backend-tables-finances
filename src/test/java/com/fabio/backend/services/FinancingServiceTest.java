package com.fabio.backend.services;

import com.fabio.backend.exemples.PriceTableExample;
import com.fabio.backend.exemples.SACTableExample;
import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import com.fabio.backend.models.enums.RateType;
import com.fabio.backend.models.enums.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FinancingServiceTest {

    private final List<TableFinancing> tabelaPrice = PriceTableExample.priceTable;
    private final List<TableFinancing> tabelaSAC = SACTableExample.sacTable;

    @Test
    void shouldReturnFinancingTableOfPrice(){
        Financing financing = new Financing(Table.PRICE,30000d, 0d,1.2, RateType.MENSAL,24);
        List<TableFinancing> esperado = tabelaPrice;
        List<TableFinancing> obtido = FinancingService.getFinancingPriceTable(financing);
        for (int i = 0; i < tabelaPrice.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance(),obtido.get(i).getBalance());
        }
    }

    @Test
    void shouldReturnFinancingTableOfSAC(){
        Financing financing = new Financing(Table.SAC,30000d, 0d,1.2, RateType.MENSAL,24);
        List<TableFinancing> esperado = tabelaSAC;
        List<TableFinancing> obtido = FinancingService.getFinancingSACTable(financing);
        for (int i = 0; i < tabelaSAC.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment().strip(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest().strip(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization().strip(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance().strip(),obtido.get(i).getBalance());
        }

    }
}
