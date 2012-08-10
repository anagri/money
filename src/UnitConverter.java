/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 8/10/12
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnitConverter {
    private String unit;
    private static final double FEET_TO_INCH = 12;
    private static final double INCH_TO_INCH = 1;


    public UnitConverter(String unit){
        this.unit = unit;
    }

    public double toBaseUnit(){
        if (unit.equals("ft")) return FEET_TO_INCH;
        if (unit.equals("in")) return INCH_TO_INCH;
        return 0;
    }
}
