/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 8/10/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Length {
    private double value;
    private String unit;
    private UnitConverter converter = new UnitConverter(unit);

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }



    @Override
    public boolean equals(Object o) {
        if( o==null ) return false;

        Length length2 = (Length) o;
        if (length2.converter.toBaseUnit() == this.value * this.converter.toBaseUnit())  return true;
        return false;
    }
}
