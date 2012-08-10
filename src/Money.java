
public class Money implements Comparable<Money> {

    private double amount;

    public enum Currency {USD(1), EUR(1.2), GBP(1.26);
        private double conversionFactor;

        Currency(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
    }

    private Currency currency;

    public Money(double i, Currency c) {
        amount = i;
        currency = c;
    }

    public int compareTo(Money money) {
        Money first = this.convertToBase();
        Money second = money.convertToBase();
        return Double.compare(first.amount, second.amount);
    }

    public Money convertToBase(){
        return new Money(amount*currency.conversionFactor, Currency.USD);
    }

    public Money add(Money money2) throws Exception, BadCurrencyException {
      if(currency!=money2.currency)  {
          throw new BadCurrencyException();
      }
        return new Money(amount+money2.amount, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (Double.compare(money.amount, amount) != 0) return false;
        if (currency != money.currency) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }
}
