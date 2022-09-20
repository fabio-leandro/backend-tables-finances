package com.fabio.backend.services;

import com.fabio.backend.exemples.PriceTableExample;
import com.fabio.backend.exemples.PriceTableExapleWithEntrance;
import com.fabio.backend.exemples.SACTableExample;
import com.fabio.backend.exemples.SACTableExampleEntrance;
import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FinancingServiceTest {

    private final List<TableFinancing> tabelaPrice = PriceTableExample.priceTable;
    private final List<TableFinancing> tabelaSAC = SACTableExample.sacTable;
    private final List<TableFinancing> tabelaPriceEntrada = PriceTableExapleWithEntrance.priceEntrance;
    private final List<TableFinancing> tabelaSACEntrada = SACTableExampleEntrance.sacEntrance;

    private FinancingService financingService;

    void setup(){
        financingService = new FinancingService();
    }

    @Test
    void shouldReturnPaymentTableOfPrice(){
        //P = PV * ( ((1+i)n * i) / ((1+i)n - 1) )
        var valorFinanciado = 30000.00;
        var periodo = 24;
        var taxa = 1.2;
        var esperado = 1446.061951275023;
        var obtido = FinancingService.getPaymentPrice(valorFinanciado,taxa,periodo);
        Assertions.assertEquals(esperado,obtido);

    }

    @Test
    void shouldReturnFinancingTableOfPrice(){
        Financing financing = new Financing("PRICE",30000d, 0d,1.2, "MENSAL",24);
        List<TableFinancing> esperado = tabelaPrice;
        List<TableFinancing> obtido = financingService.getFinancingPriceTable(financing);
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
        Financing financing = new Financing("SAC",30000d, 0d,1.2, "MENSAL",24);
        List<TableFinancing> esperado = tabelaSAC;
        List<TableFinancing> obtido = financingService.getFinancingSACTable(financing);
        for (int i = 0; i < tabelaSAC.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment().strip(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest().strip(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization().strip(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance().strip(),obtido.get(i).getBalance());
        }
    }

    @Test
    void shouldReturnFinancingTablePriceWithEntrance(){
        Financing financing = new Financing("PRICE",30000d, 5000d,1.2, "MENSAL",24);
        List<TableFinancing> esperado = tabelaPriceEntrada;
        List<TableFinancing> obtido = financingService.getFinancingPriceTable(financing);
        for (int i = 0; i < tabelaPriceEntrada.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment().strip(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest().strip(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization().strip(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance().strip(),obtido.get(i).getBalance());
        }
    }

    @Test
    void shouldReturnFinancingTableSACWithEntrance(){
        Financing financing = new Financing("SAC",30000d, 5000d,1.2, "MENSAL",24);
        List<TableFinancing> esperado = tabelaSACEntrada;
        List<TableFinancing> obtido = financingService.getFinancingSACTable(financing);
        for (int i = 0; i < tabelaSACEntrada.size();i++){
            Assertions.assertEquals(esperado.get(i).getNumber(),obtido.get(i).getNumber());
            Assertions.assertEquals(esperado.get(i).getPayment().strip(),obtido.get(i).getPayment());
            Assertions.assertEquals(esperado.get(i).getInterest().strip(),obtido.get(i).getInterest());
            Assertions.assertEquals(esperado.get(i).getAmortization().strip(),obtido.get(i).getAmortization());
            Assertions.assertEquals(esperado.get(i).getBalance().strip(),obtido.get(i).getBalance());
        }
    }


}
