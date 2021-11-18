package calc.rpn;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class ToRPN {
	Deque<String> stack;
	ArrayList<String> list;
	OperatorList opl;
	public ArrayList<String> toRPN(ArrayList<String> inlist,ArrayList<String> typelist,boolean mode) {
		int tp1=0,tp2=0;
		stack = new ArrayDeque<>();
		opl = new OperatorList();
		list = new ArrayList<>();
		
		oplinit(opl,mode);
		
		for ( int i = 0; i < inlist.size(); i++ ) {
			if(typelist.get(i).equals("整数") || typelist.get(i).equals("実数")) {
				list.add(inlist.get(i));
			} else if(inlist.get(i).equals("x") || inlist.get(i).equals("y") || inlist.get(i).equals("z") || inlist.get(i).equals("k") || inlist.get(i).equals("h") || inlist.get(i).equals("c") || inlist.get(i).equals("G") || inlist.get(i).equals("g") || inlist.get(i).equals("hbar") || inlist.get(i).equals("p") || inlist.get(i).equals("q") || inlist.get(i).equals("r") || inlist.get(i).equals("s") || inlist.get(i).equals("m") || inlist.get(i).equals("n") || inlist.get(i).equals("theta") || inlist.get(i).equals("pi") || inlist.get(i).equals("e")) {
				list.add(inlist.get(i));
			} else if (inlist.get(i).equals("(")) {
				stack.push(inlist.get(i));
			} else if (inlist.get(i).equals(")")) {
				while(true) {
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					} else if (stack.size() == 0) {
						System.exit(-1);
					} else {
						list.add(stack.pop());
					}
				}
			} else if (inlist.get(i).equals(",")) {
				while(true) {
					if(stack.peek().equals("(") || stack.peek().equals("=")) {
						break;
					} else if (stack.size()==0) {
						break;
					} else {
						list.add(stack.pop());
					}
				}
			} else {
				for ( int j = 0; j < opl.list.size(); j++ ) {
					if ( opl.list.get(j).op.equals(inlist.get(i))) {
						tp1 = opl.list.get(j).rank;
						break;
					}
				}
				while (true) {
					for ( int j = 0; j < opl.list.size(); j++ ) {
						if ( opl.list.get(j).op.equals(stack.peek())) {
							tp2 = opl.list.get(j).rank;
							break;
						}
					}
					if (tp1 > tp2) break;
					if (stack.size()==0) break;
					list.add(stack.pop());
				}
				stack.push(inlist.get(i));
			}
		}
		while(true) {
			if (stack.size()==0) {
				break;
			} else {
				list.add(stack.pop());
			}
		}
		inlist.clear();
		typelist.clear();
		return list;
	}
	
	public ArrayList<String> toRPN(ArrayList<String> inlist,ArrayList<String> typelist) {
		int tp1=0,tp2=0;
		stack = new ArrayDeque<>();
		opl = new OperatorList();
		list = new ArrayList<>();
		
		oplinit(opl,true);
		
		for ( int i = 0; i < inlist.size(); i++ ) {
			if(typelist.get(i).equals("整数") || typelist.get(i).equals("実数")) {
				list.add(inlist.get(i));
			} else if(inlist.get(i).equals("x") || inlist.get(i).equals("y") || inlist.get(i).equals("z") || inlist.get(i).equals("k") || inlist.get(i).equals("h") || inlist.get(i).equals("c") || inlist.get(i).equals("G") || inlist.get(i).equals("g") || inlist.get(i).equals("hbar") || inlist.get(i).equals("p") || inlist.get(i).equals("q") || inlist.get(i).equals("r") || inlist.get(i).equals("s") || inlist.get(i).equals("m") || inlist.get(i).equals("n") || inlist.get(i).equals("theta") || inlist.get(i).equals("pi") || inlist.get(i).equals("e")) {
				list.add(inlist.get(i));
			} else if (inlist.get(i).equals("(")) {
				stack.push(inlist.get(i));
			} else if (inlist.get(i).equals(")")) {
				while(true) {
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					} else if (stack.size() == 0) {
						System.exit(-1);
					} else {
						list.add(stack.pop());
					}
				}
			} else if (inlist.get(i).equals(",")) {
				while(true) {
					if(stack.peek().equals("(") || stack.peek().equals("=")) {
						break;
					} else if (stack.size()==0) {
						break;
					} else {
						list.add(stack.pop());
					}
				}
			} else {
				for ( int j = 0; j < opl.list.size(); j++ ) {
					if ( opl.list.get(j).op.equals(inlist.get(i))) {
						tp1 = opl.list.get(j).rank;
						break;
					}
				}
				while (true) {
					for ( int j = 0; j < opl.list.size(); j++ ) {
						if ( opl.list.get(j).op.equals(stack.peek())) {
							tp2 = opl.list.get(j).rank;
							break;
						}
					}
					if (tp1 >= tp2) break;
					if (stack.size()==0) break;
					list.add(stack.pop());
				}
				stack.push(inlist.get(i));
			}
		}
		while(true) {
			if (stack.size()==0) {
				break;
			} else {
				list.add(stack.pop());
			}
		}
		inlist.clear();
		typelist.clear();
		return list;
	}
	
	private void oplinit(OperatorList opl, boolean mode) {
		if (mode == true) {
			opl.list.add(opl.InputOperatorList("*",7));
			opl.list.add(opl.InputOperatorList("/",7));
			opl.list.add(opl.InputOperatorList("//",7));
			opl.list.add(opl.InputOperatorList("%",7));
			opl.list.add(opl.InputOperatorList("%%",7));
			opl.list.add(opl.InputOperatorList("+",6));
			opl.list.add(opl.InputOperatorList("-",6));
			opl.list.add(opl.InputOperatorList("=",0));
			opl.list.add(opl.InputOperatorList("(",0));
			opl.list.add(opl.InputOperatorList(",",0));
			opl.list.add(opl.InputOperatorList("^",8));
			opl.list.add(opl.InputOperatorList("abs",10));
			opl.list.add(opl.InputOperatorList("sqrt",10));
			opl.list.add(opl.InputOperatorList("sin",10));
			opl.list.add(opl.InputOperatorList("cos",10));
			opl.list.add(opl.InputOperatorList("tan",10));
			opl.list.add(opl.InputOperatorList("asin",10));
			opl.list.add(opl.InputOperatorList("acos",10));
			opl.list.add(opl.InputOperatorList("atan",10));
			opl.list.add(opl.InputOperatorList("exp",10));
			opl.list.add(opl.InputOperatorList("log",10));
			opl.list.add(opl.InputOperatorList("deg",10));
			opl.list.add(opl.InputOperatorList("rad",10));
			opl.list.add(opl.InputOperatorList("sum",10));
			opl.list.add(opl.InputOperatorList("fact",10));
			opl.list.add(opl.InputOperatorList("atan2",10));
			opl.list.add(opl.InputOperatorList("mod",10));
			opl.list.add(opl.InputOperatorList("mod2",10));
			opl.list.add(opl.InputOperatorList("floor",10));
			opl.list.add(opl.InputOperatorList("ceil",10));
			opl.list.add(opl.InputOperatorList("int",10));
			opl.list.add(opl.InputOperatorList("rinf",10));
			opl.list.add(opl.InputOperatorList("round",10));
			opl.list.add(opl.InputOperatorList("revn",10));
			opl.list.add(opl.InputOperatorList("pm",10));
			opl.list.add(opl.InputOperatorList("percent",10));
			opl.list.add(opl.InputOperatorList("pc",10));
			opl.list.add(opl.InputOperatorList("tenexp",10));
			opl.list.add(opl.InputOperatorList("lcm",10));
			opl.list.add(opl.InputOperatorList("gcd",10));
			opl.list.add(opl.InputOperatorList("fibonacci",10));
			opl.list.add(opl.InputOperatorList("fib",10));
			opl.list.add(opl.InputOperatorList("H",10));
			opl.list.add(opl.InputOperatorList("C",10));
			opl.list.add(opl.InputOperatorList("P",10));
			opl.list.add(opl.InputOperatorList("NOT",5));
			opl.list.add(opl.InputOperatorList("XOR",2));
			opl.list.add(opl.InputOperatorList("XNOR",2));
			opl.list.add(opl.InputOperatorList("OR",1));
			opl.list.add(opl.InputOperatorList("AND",3));
			opl.list.add(opl.InputOperatorList("SL",4));
			opl.list.add(opl.InputOperatorList("SR",4));
			opl.list.add(opl.InputOperatorList("SRNS",4));
		} else {
			opl.list.add(opl.InputOperatorList("*",1));
			opl.list.add(opl.InputOperatorList("/",1));
			opl.list.add(opl.InputOperatorList("//",1));
			opl.list.add(opl.InputOperatorList("%",1));
			opl.list.add(opl.InputOperatorList("%%",1));
			opl.list.add(opl.InputOperatorList("+",1));
			opl.list.add(opl.InputOperatorList("-",1));
			opl.list.add(opl.InputOperatorList("=",0));
			opl.list.add(opl.InputOperatorList("(",0));
			opl.list.add(opl.InputOperatorList(",",0));
			opl.list.add(opl.InputOperatorList("^",1));
			opl.list.add(opl.InputOperatorList("abs",1));
			opl.list.add(opl.InputOperatorList("sqrt",1));
			opl.list.add(opl.InputOperatorList("sin",1));
			opl.list.add(opl.InputOperatorList("cos",1));
			opl.list.add(opl.InputOperatorList("tan",1));
			opl.list.add(opl.InputOperatorList("asin",1));
			opl.list.add(opl.InputOperatorList("acos",1));
			opl.list.add(opl.InputOperatorList("atan",1));
			opl.list.add(opl.InputOperatorList("exp",1));
			opl.list.add(opl.InputOperatorList("log",1));
			opl.list.add(opl.InputOperatorList("deg",1));
			opl.list.add(opl.InputOperatorList("rad",1));
			opl.list.add(opl.InputOperatorList("sum",1));
			opl.list.add(opl.InputOperatorList("fact",1));
			opl.list.add(opl.InputOperatorList("atan2",1));
			opl.list.add(opl.InputOperatorList("mod",1));
			opl.list.add(opl.InputOperatorList("mod2",1));
			opl.list.add(opl.InputOperatorList("floor",1));
			opl.list.add(opl.InputOperatorList("ceil",1));
			opl.list.add(opl.InputOperatorList("int",1));
			opl.list.add(opl.InputOperatorList("rinf",1));
			opl.list.add(opl.InputOperatorList("round",1));
			opl.list.add(opl.InputOperatorList("revn",1));
			opl.list.add(opl.InputOperatorList("pm",10));
			opl.list.add(opl.InputOperatorList("percent",10));
			opl.list.add(opl.InputOperatorList("pc",10));
			opl.list.add(opl.InputOperatorList("tenexp",1));
			opl.list.add(opl.InputOperatorList("lcm",1));
			opl.list.add(opl.InputOperatorList("gcd",1));
			opl.list.add(opl.InputOperatorList("fibonacci",1));
			opl.list.add(opl.InputOperatorList("fib",1));
			opl.list.add(opl.InputOperatorList("H",1));
			opl.list.add(opl.InputOperatorList("C",1));
			opl.list.add(opl.InputOperatorList("P",1));
			opl.list.add(opl.InputOperatorList("NOT",1));
			opl.list.add(opl.InputOperatorList("XOR",1));
			opl.list.add(opl.InputOperatorList("XNOR",1));
			opl.list.add(opl.InputOperatorList("OR",1));
			opl.list.add(opl.InputOperatorList("AND",1));
			opl.list.add(opl.InputOperatorList("SL",1));
			opl.list.add(opl.InputOperatorList("SR",1));
			opl.list.add(opl.InputOperatorList("SRNS",1));
		}
	}
}
