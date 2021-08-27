package calc.rpn;

import java.math.*;
import java.util.ArrayList;

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
	public static double atan(double x,double y) {
		if (x == 0) return Math.PI/2 * y / Math.abs(y);
		else {
			if (x > 0) {
				return Math.atan(y / x);
			} else {
				return Math.atan(y / x)-Math.PI;
			}
		}
	}
	public static double fibonacci(double n) {
		int m = (int)n;
		double[] list = new double[m+1];
		list[0]=0.0;
		list[1]=1.0;
		for (int i = 2; i <= m; i++) {
			list[i]=list[i-1]+list[i-2];
		}
		return list[m];
	}
	public static double gcd(double a, double b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	public static double  lcm(double a,double b) {
    	double d = gcd(a, b);
    	return a / d * b;
	}
	public static double homogeneous(double n,double k) {
		return combination(n+k-1,k);
	}
	public static double combination(double n,double k) {
		double d=1;
		for (int i = 1; i <= k ; i++) {
			d *= (n - i + 1) / i;
		}
		return d;
	}
	public static double permutation(double n,double k) {
		double d=1;
		for (int i = (int)n-(int)k+1; i <= n; i++) {
			d *= i;
		}
		return d;
	}
}