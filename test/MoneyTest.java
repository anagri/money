import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {


    @Test
    public void shouldAddSameCurrency() throws Exception, BadCurrencyException {
        Money money1 = new Money(100, Money.Currency.USD);
        Money money2 = new Money(200, Money.Currency.USD);
        assertEquals(new Money(300, Money.Currency.USD), money1.add(money2));
    }

    @Test(expected = BadCurrencyException.class)
    public void shouldNotAddDifferentCurrency() throws Exception, BadCurrencyException {
        Money money1 = new Money(100, Money.Currency.USD);
        Money money2 = new Money(200, Money.Currency.EUR);
        Money total = money1.add(money2);
    }

    @Test
    public void shouldConvertPoundToDollar() {
        Money result = new Money(1, Money.Currency.GBP);
        assertEquals(new Money(1.26, Money.Currency.USD), result.convertToBase());

    }

    @Test
    public void compareToShouldReturnOne() {
        int result = new Money(1, Money.Currency.EUR).compareTo(new Money(1, Money.Currency.USD));
        assertEquals(1, result);
    }

    @Test
    public void compareToShouldReturnNegativeOne() {
        int result = new Money(1, Money.Currency.EUR).compareTo(new Money(1, Money.Currency.GBP));
        assertEquals(-1, result);
    }

    @Test
    public void compareToShouldReturnZero() {
        int result = new Money(1, Money.Currency.USD).compareTo(new Money(1, Money.Currency.USD));
        assertEquals(0, result);
    }


}
