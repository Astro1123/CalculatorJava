package rpn;

import java.math.*;

public class Compute {
	public static double mod(double i, double j) {
    	return (i % j) < 0 ? (i % j) + (j < 0 ? -j : j) : (i % j);
	}
	public static double round(double x) {
    	return BigDecimal.valueOf(x).setScale(0, RoundingMode.HALF_UP).doubleValue();
	}
	public static double revn(double x) {
		return BigDecimal.valueOf(x).setScale(0, RoundingMode.HALF_EVEN).doubleValue();
	}
	public static double floor(double x) {
		return BigDecimal.valueOf(x).setScale(0, RoundingMode.FLOOR).doubleValue();
	}
	public static double ceil(double x) {
		return BigDecimal.valueOf(x).setScale(0, RoundingMode.CEILING).doubleValue();
	}
	public static double rint(double x) {
		return BigDecimal.valueOf(x).setScale(0, RoundingMode.DOWN).doubleValue();
	}
	public static double rinf(double x) {
		return BigDecimal.valueOf(x).setScale(0, RoundingMode.UP).doubleValue();
	}
}