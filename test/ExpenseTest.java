import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class ExpenseTest {
    @Test
    public void shouldReturnLeastAmountInList() {

        ArrayList<Money> moneys = new ArrayList<Money>();
        moneys.add(new Money(100, Money.Currency.USD));
        moneys.add(new Money(200, Money.Currency.EUR));
        moneys.add(new Money(150, Money.Currency.GBP));
        Money leastExpensive = new Expense(moneys).getLeastExpensive();
        assertEquals(new Money(100, Money.Currency.USD), leastExpensive);

    }
}
