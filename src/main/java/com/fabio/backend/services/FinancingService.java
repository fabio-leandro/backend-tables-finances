package com.fabio.backend.services;

import com.fabio.backend.models.Financing;
import com.fabio.backend.models.TableFinancing;
import com.fabio.backend.models.TableFinancingCalculo;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinancingService {

    public List<TableFinancing> getFinancingSACTable(Financing financing){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        List<TableFinancing> tb = new ArrayList<>();
        List<TableFinancingCalculo> tbc = new ArrayList<>();

        if (financing.getEntrance() > 0) financing.setFinancedAmount(financing.getFinancedAmount() - financing.getEntrance());

        for (int i = 0; i <= financing.getPeriod(); i++){
            if(i == 0) {
                TableFinancingCalculo tbcal = new TableFinancingCalculo(0,0d,0d,0d, financing.getFinancedAmount().doubleValue());
                tbc.add(tbcal);
                TableFinancing tbf = new TableFinancing(tbcal.getNumber(), df.format(tbcal.getPayment()), df.format(tbcal.getInterest()), df.format(tbcal.getAmortization()), df.format(tbcal.getBalance()));
                tb.add(tbf);
            }else if(i == 1) {
                TableFinancingCalculo tbf = new TableFinancingCalculo();
                tbf.setNumber(i);
                tbf.setInterest(tbc.get(0).getBalance() * financing.getRate() / 100);
                tbf.setAmortization(financing.getFinancedAmount() / financing.getPeriod());
                tbf.setPayment(tbf.getAmortization() + tbf.getInterest());
                tbf.setBalance(tbc.get(0).getBalance() - tbf.getAmortization());
                tbc.add(tbf);

                TableFinancing tbl = new TableFinancing(tbf.getNumber(), df.format(tbf.getPayment()), df.format(tbf.getInterest()), df.format(tbf.getAmortization()), df.format(tbf.getBalance()));
                tb.add(tbl);
            }else {
                TableFinancingCalculo tbf = new TableFinancingCalculo();
                tbf.setNumber(i);
                tbf.setInterest(tbc.get(i-1).getBalance() * financing.getRate() / 100);
                tbf.setAmortization(financing.getFinancedAmount() / financing.getPeriod());
                tbf.setPayment(tbf.getAmortization() + tbf.getInterest());
                tbf.setBalance(tbc.get(i - 1).getBalance() - tbf.getAmortization());
                tbc.add(tbf);

                TableFinancing tbl = new TableFinancing(tbf.getNumber(), df.format(tbf.getPayment()), df.format(tbf.getInterest()), df.format(tbf.getAmortization()), df.format(tbf.getBalance()));
                if (tbl.getBalance().equals("-0,00") ) tbl.setBalance("0,00");
                tb.add(tbl);
            }
        }



        return tb;
    }

    //P = PV * ( ((1+i)n * i) / ((1+i)n - 1) )

    public List<TableFinancing> getFinancingPriceTable(Financing financing){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        List<TableFinancing> tb = new ArrayList<>();
        List<TableFinancingCalculo> tbc = new ArrayList<>();

        if (financing.getEntrance() > 0) financing.setFinancedAmount(financing.getFinancedAmount() - financing.getEntrance());

//        double numerador = Math.pow((1+ (financing.getRate()/100)), financing.getPeriod()) * financing.getRate() / 100;
//        double denominador = Math.pow((1+ (financing.getRate()/100)), financing.getPeriod()) - 1;
//        double prestacao = (financing.getFinancedAmount() * (numerador / denominador));

        double prestacao = getPaymentPrice(financing.getFinancedAmount(), financing.getRate(), financing.getPeriod());

        for (int i = 0; i <= financing.getPeriod(); i++){
            if(i == 0) {
                TableFinancingCalculo tbcal = new TableFinancingCalculo(0,0d,0d,0d, financing.getFinancedAmount().doubleValue());
                tbc.add(tbcal);
                TableFinancing tbf = new TableFinancing(tbcal.getNumber(), df.format(tbcal.getPayment()), df.format(tbcal.getInterest()), df.format(tbcal.getAmortization()), df.format(tbcal.getBalance()));
                tb.add(tbf);
            }else if(i == 1) {
                TableFinancingCalculo tbf = new TableFinancingCalculo();
                tbf.setNumber(i);
                tbf.setPayment(prestacao);
                tbf.setInterest(tbc.get(0).getBalance() * financing.getRate() / 100);
                tbf.setAmortization(prestacao - tbf.getInterest());
                tbf.setBalance(tbc.get(0).getBalance() - tbf.getAmortization());
                tbc.add(tbf);

                TableFinancing tbl = new TableFinancing(tbf.getNumber(), df.format(tbf.getPayment()), df.format(tbf.getInterest()), df.format(tbf.getAmortization()), df.format(tbf.getBalance()));
                tb.add(tbl);
            }else {
                TableFinancingCalculo tbf = new TableFinancingCalculo();
                tbf.setNumber(i);
                tbf.setPayment(prestacao);
                tbf.setInterest(tbc.get(i-1).getBalance() * financing.getRate() / 100);
                tbf.setAmortization(prestacao - tbf.getInterest());
                tbf.setBalance(tbc.get(i - 1).getBalance() - tbf.getAmortization());
                tbc.add(tbf);

                TableFinancing tbl = new TableFinancing(tbf.getNumber(), df.format(tbf.getPayment()), df.format(tbf.getInterest()), df.format(tbf.getAmortization()), df.format(tbf.getBalance()));
                tb.add(tbl);
            }
        }

        return tb;
    }

    public static double getPaymentPrice(double valor, double taxa, double periodo){
        double numerador = Math.pow((1+ (taxa/100)), periodo) * taxa / 100;
        double denominador = Math.pow((1+ (taxa/100)), periodo) - 1;
        return (valor * (numerador / denominador));
    }


}
