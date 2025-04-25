package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;

public class PaymentTest {
    private RegistryCreator exSystems;
    private Printer printer;
    private Sale testSale;
    private int validItemIdentifier = 1;
    private int quantity = 2;
    private double paidAmountMore = 425;
    private double paidAmountExact = 345;


    @BeforeEach
    void setUp(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);
        testSale.registerItem(validItemIdentifier, quantity);
        testSale.endSale();
    }


    @Test
    void testCalculateChangeReturnsValidChange() {
        Payment payment = new Payment(paidAmountMore);
        payment.calculateChange(testSale);
        double result = payment.getChange();

        double expectedResult = 80;
        assertEquals(result, expectedResult, "Change is incorrect");
    }
    @Test
    void testCalculateChangeReturnsNoChange() {
        Payment payment = new Payment(paidAmountExact);
        payment.calculateChange(testSale);
        double result = payment.getChange();

        double expectedResult = 0;
        assertEquals(result, expectedResult, "Change is incorrect");
    }
}
