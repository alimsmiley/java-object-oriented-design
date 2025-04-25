package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Sale;

public class PrinterTest {
    private RegistryCreator exSystems;
    private Printer printer;
    private Sale testSale;
    private int validItemIdentifier1 = 1;
    private int validItemIdentifier2 = 2;
    private int validItemIdentifier3 = 3;
    private int quantity = 1;
    private double paidAmountMore = 1150;
    private double paidAmountExact = 765;

    private Payment payment; 

    private Receipt receipt;
  
    @BeforeEach
    void setUp(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);
        testSale.registerItem(validItemIdentifier1, quantity);
        testSale.registerItem(validItemIdentifier2, quantity*2);
        testSale.registerItem(validItemIdentifier3, quantity*3);
        testSale.endSale();
        payment = new Payment(paidAmountMore);
        testSale.pay(payment);
        receipt = new Receipt(testSale);
    
    }


    @Test
    void testPrintReceipt() {

        printer.printReceipt(receipt);

    }
}
