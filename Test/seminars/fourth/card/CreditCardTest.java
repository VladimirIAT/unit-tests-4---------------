package seminars.fourth.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
    CreditCard creditCard;

    @BeforeEach
    void setUp() {
        creditCard = new CreditCard("12364589123", "John Silver", "31.12.2023", "789");
    }

    @Test
    void testGetCardNumber() {
        assertEquals("12364589123", creditCard.getCardNumber());
    }
    @Test
    void testGetCardHolder() {
        assertEquals("John Silver", creditCard.getCardHolder());
    }
    @Test
    void testGetCardDate() {
        assertEquals("31.12.2023", creditCard.getExpiryDate());
    }
    @Test
    void testGetCardCVV() {
        assertEquals("789", creditCard.getCvv());
    }
    @Test
    void testCharge() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream((outputStream)));
        creditCard.charge(1200.00);
        assertEquals("Charged amount 1200.0 from the card: 12364589123", outputStream.toString().trim());

        System.setOut(null);
    }
}
