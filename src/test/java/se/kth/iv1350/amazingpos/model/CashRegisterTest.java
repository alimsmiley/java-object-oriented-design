package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;

public class CashRegisterTest {

    private RegistryCreator exSystems;
    private Printer printer;
    private Sale testSale;
    private int validItemIdentifier = 1;
    private int quantity = 2;
    private double paidAmountMore = 425;
    private double paidAmountExact = 345;
    private Payment payment;


    @BeforeEach
    void setUp(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);
        testSale.registerItem(validItemIdentifier, quantity);
        testSale.endSale();
        payment = new Payment(paidAmountMore);
        payment.calculateChange(testSale);
    }

    @Test
    void testUpdateCashRegister() {
        exSystems.getCashRegister().updateCashRegister(payment);
        double result = exSystems.getCashRegister().getBalance();
        double expectedResult = 5345;

        assertEquals(result, expectedResult, "Cash register is not correct");
    }
}
