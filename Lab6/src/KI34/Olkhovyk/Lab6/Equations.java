package KI34.Olkhovyk.Lab6;

public class Equations {
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = Math.cos(2 * rad) / Math.tan((3 * rad) - 1);
            if (y == Double.NaN || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || x == 90 || x == -90)
                throw new ArithmeticException();

        } catch (ArithmeticException ex) {
           
            if (rad == 0 || rad == Math.PI  || rad == 2 * Math.PI)
                throw new CalcException("Exception reason: Illegal value of X for cotangent calculation");
            else if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0)
                throw new CalcException("Exception reason: Divide by zero");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }
}
