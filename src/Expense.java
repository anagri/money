import java.util.ArrayList;
import java.util.Collections;


public class Expense {
    private ArrayList<Money> moneys;

    public Expense(ArrayList<Money> moneys) {
        this.moneys = moneys;
    }

    public Money getLeastExpensive() {
        Collections.sort(moneys);
        return moneys.get(0);
    }
}
