package rpn;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.math.*;
import java.util.NoSuchElementException;
import java.lang.ArithmeticException;
import java.lang.NumberFormatException;

public class Calc {
	public BigDecimal calc(ArrayList<String> list) throws ArithmeticException {
		Deque<Double> stack = new ArrayDeque<>();
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
			try {
				stack.push(Double.parseDouble(list.get(i)));
			}
			catch(NumberFormatException e) {
				try {
					calculation(stack, list.get(i));
				} catch (ArithmeticException er) {
					throw er;
				}
			}
		}
		//System.out.println(stack.peek());
		//if (isFinite(stack.peek()) != false)
		if (stack.size()==0) return BigDecimal.valueOf(0);
		try {
			return BigDecimal.valueOf(stack.pop()).setScale(12, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
		} catch (NumberFormatException e) {
			return BigDecimal.valueOf(0);
		}
		//else System.exit(-1);
	}
	private void calculation(Deque<Double> stack, String op) throws ArithmeticException {
		Compute com = new Compute();
		double a,b,tmp;
		if (op.equals("+")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(b+a);
		} else if (op.equals("-")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(b-a);
		} else if (op.equals("*")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(b*a);
		} else if (op.equals("/")) {
			a = StackPop(stack);
			b = StackPop(stack);
			if (a == 0) throw new ArithmeticException("0で除算しました");
			else stack.push(b/a);
		} else if (op.equals("//")) {
			a = StackPop(stack);
			b = StackPop(stack);
			if (a == 0) throw new ArithmeticException("0で除算しました");
			else stack.push(Math.floor(b/a));
		} else if (op.equals("%") || op.equals("mod")) {
			a = StackPop(stack);
			b = StackPop(stack);
			if (a == 0) throw new ArithmeticException("0で除算しました");
			else stack.push(com.mod(b,a));
		} else if (op.equals("%%") || op.equals("mod2")) {
			a = StackPop(stack);
			b = StackPop(stack);
			if (a == 0) throw new ArithmeticException("0で除算しました");
			else stack.push(b%a);
		} else if (op.equals("^")) {
			a = StackPop(stack);
			b = StackPop(stack);
			if (b < 0 && a != com.rint(a)) throw new ArithmeticException("計算不能(pow)");
			else stack.push(Math.pow(b,a));
		} else if (op.equals("round")) {
			a = StackPop(stack);
			stack.push(com.round(a));
		} else if (op.equals("int")) {
			a = StackPop(stack);
			stack.push(com.rint(a));
		} else if (op.equals("revn")) {
			a = StackPop(stack);
			stack.push(com.revn(a));
		} else if (op.equals("rinf")) {
			a = StackPop(stack);
			stack.push(com.rinf(a));
		} else if (op.equals("ceil")) {
			a = StackPop(stack);
			stack.push(com.ceil(a));
		} else if (op.equals("floor")) {
			a = StackPop(stack);
			stack.push(Math.floor(a));
		} else if (op.equals("pm")) {
			a = StackPop(stack);
			stack.push(-a);
		} else if (op.equals("sum")) {
			a = StackPop(stack);
			stack.push(a*(a+1)/2);
		} else if (op.equals("abs")) {
			a = StackPop(stack);
			stack.push(Math.abs(a));
		} else if (op.equals("sqrt")) {
			a = StackPop(stack);
			if (a < 0) throw new ArithmeticException("sqrt(x)に負の値が代入されました");
			else stack.push(Math.sqrt(a));
		} else if (op.equals("exp")) {
			a = StackPop(stack);
			stack.push(Math.exp(a));
		} else if (op.equals("sin")) {
			a = StackPop(stack);
			stack.push(Math.sin(a));
		} else if (op.equals("cos")) {
			a = StackPop(stack);
			stack.push(Math.cos(a));
		} else if (op.equals("tan")) {
			a = StackPop(stack);
			stack.push(Math.tan(a));
		} else if (op.equals("atan")) {
			a = StackPop(stack);
			stack.push(Math.atan(a));
		} else if (op.equals("tenexp")) {
			a = StackPop(stack);
			stack.push(Math.pow(10,a));
		} else if (op.equals("fact")) {
			a = StackPop(stack);
			tmp = 1;
			for(int i = 0; i < a; i++) {
				tmp *= i+1;
			}
			stack.push(tmp);
		} else if (op.equals("asin")) {
			a = StackPop(stack);
			stack.push(Math.asin(a));
		} else if (op.equals("acos")) {
			a = StackPop(stack);
			stack.push(Math.acos(a));
		} else if (op.equals("atan2")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.atan(b,a));
		} else if (op.equals("percent")) {
			a = StackPop(stack);
			b = stack.peek();
			stack.push(b*a/100);
		} else if (op.equals("rad")) {
			a = StackPop(stack);
			stack.push(a/180.0*Math.PI);
		} else if (op.equals("deg")) {
			a = StackPop(stack);
			stack.push(a*180.0/Math.PI);
		} else if (op.equals("log")) {
			a = StackPop(stack);
			if (a <= 0) throw new ArithmeticException("log(x)に0以下の値が代入されました");
			else stack.push(Math.log(a));
		} else if (op.equals("lcm")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.lcm(b,a));
		} else if (op.equals("fibonacci")) {
			a = StackPop(stack);
			stack.push(com.fibonacci(a));
		} else if (op.equals("gcd")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.gcd(b,a));
		} else if (op.equals("H")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.homogeneous(b,a));
		} else if (op.equals("C")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.combination(b,a));
		} else if (op.equals("P")) {
			a = StackPop(stack);
			b = StackPop(stack);
			stack.push(com.permutation(b,a));
		}
	}
	private double StackPop (Deque<Double> stack) {
		if(stack.size()>0) return stack.pop();
		else return 0.0;
	}
	private double StackPop (Deque<Double> stack, double p1) {
		if(stack.size()>0) return stack.pop();
		else return p1;
	}
}