package com.fabio.backend.services;

import com.fabio.backend.exemples.PriceTableExample;
import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import com.fabio.backend.models.enums.RateType;
import com.fabio.backend.models.enums.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FinancingServiceTest {

    private final List<TableFinancing> tabela = PriceTableExample.priceTable;

    @Test
    void shouldReturnFinancingTableOfPrice(){
        Financing financing = new Financing(Table.PRICE,30000d, 0d,1.2, RateType.MENSAL,24);
        List<TableFinancing> esperado = tabela;
        List<TableFinancing> obtido = FinancingService.getFinancingPriceTable(financing);
        for (int i = 0; i < tabela.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance(),obtido.get(i).getBalance());
        }

    }
}
