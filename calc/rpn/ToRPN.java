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
					if (stack.peek() == null) {
						tp2 = 0;
					} else {
						for ( int j = 0; j < opl.list.size(); j++ ) {
							if ( opl.list.get(j).op.equals(stack.peek())) {
								tp2 = opl.list.get(j).rank;
								break;
							}
						}
					}
					if (tp1 > tp2) break;
					if (stack.size()==0) break;
					if (mode && tp2 == 100 && tp1 == 100) break;
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
					if (stack.peek() == null) {
						tp2 = 0;
					} else {
						for ( int j = 0; j < opl.list.size(); j++ ) {
							if ( opl.list.get(j).op.equals(stack.peek())) {
								tp2 = opl.list.get(j).rank;
								break;
							}
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
	
	private void oplinit(OperatorList opl, boolean mode) {
		if (mode == true) {
			opl.list.add(opl.InputOperatorList("*",70));
			opl.list.add(opl.InputOperatorList("/",70));
			opl.list.add(opl.InputOperatorList("//",70));
			opl.list.add(opl.InputOperatorList("%",70));
			opl.list.add(opl.InputOperatorList("%%",70));
			opl.list.add(opl.InputOperatorList("+",60));
			opl.list.add(opl.InputOperatorList("-",60));
			opl.list.add(opl.InputOperatorList("=",0));
			opl.list.add(opl.InputOperatorList("(",0));
			opl.list.add(opl.InputOperatorList(",",0));
			opl.list.add(opl.InputOperatorList("^",80));
			opl.list.add(opl.InputOperatorList("abs",100));
			opl.list.add(opl.InputOperatorList("sqrt",100));
			opl.list.add(opl.InputOperatorList("sin",100));
			opl.list.add(opl.InputOperatorList("cos",100));
			opl.list.add(opl.InputOperatorList("sinh",100));
			opl.list.add(opl.InputOperatorList("cosh",100));
			opl.list.add(opl.InputOperatorList("tanh",100));
			opl.list.add(opl.InputOperatorList("tan",100));
			opl.list.add(opl.InputOperatorList("asin",100));
			opl.list.add(opl.InputOperatorList("acos",100));
			opl.list.add(opl.InputOperatorList("atan",100));
			opl.list.add(opl.InputOperatorList("exp",100));
			opl.list.add(opl.InputOperatorList("log",100));
			opl.list.add(opl.InputOperatorList("deg",100));
			opl.list.add(opl.InputOperatorList("rad",100));
			opl.list.add(opl.InputOperatorList("sum",100));
			opl.list.add(opl.InputOperatorList("fact",100));
			opl.list.add(opl.InputOperatorList("atan2",100));
			opl.list.add(opl.InputOperatorList("mod",100));
			opl.list.add(opl.InputOperatorList("mod2",100));
			opl.list.add(opl.InputOperatorList("floor",100));
			opl.list.add(opl.InputOperatorList("ceil",100));
			opl.list.add(opl.InputOperatorList("int",100));
			opl.list.add(opl.InputOperatorList("rinf",100));
			opl.list.add(opl.InputOperatorList("round",100));
			opl.list.add(opl.InputOperatorList("revn",100));
			opl.list.add(opl.InputOperatorList("pm",100));
			opl.list.add(opl.InputOperatorList("percent",100));
			opl.list.add(opl.InputOperatorList("pc",100));
			opl.list.add(opl.InputOperatorList("tenexp",100));
			opl.list.add(opl.InputOperatorList("lcm",100));
			opl.list.add(opl.InputOperatorList("gcd",100));
			opl.list.add(opl.InputOperatorList("fibonacci",100));
			opl.list.add(opl.InputOperatorList("fib",100));
			opl.list.add(opl.InputOperatorList("H",100));
			opl.list.add(opl.InputOperatorList("C",100));
			opl.list.add(opl.InputOperatorList("P",100));
			opl.list.add(opl.InputOperatorList("NOT",50));
			opl.list.add(opl.InputOperatorList("XOR",20));
			opl.list.add(opl.InputOperatorList("XNOR",20));
			opl.list.add(opl.InputOperatorList("OR",10));
			opl.list.add(opl.InputOperatorList("AND",30));
			opl.list.add(opl.InputOperatorList("SL",40));
			opl.list.add(opl.InputOperatorList("SR",40));
			opl.list.add(opl.InputOperatorList("SRNS",40));
		} else {
			opl.list.add(opl.InputOperatorList("*",10));
			opl.list.add(opl.InputOperatorList("/",10));
			opl.list.add(opl.InputOperatorList("//",10));
			opl.list.add(opl.InputOperatorList("%",10));
			opl.list.add(opl.InputOperatorList("%%",10));
			opl.list.add(opl.InputOperatorList("+",10));
			opl.list.add(opl.InputOperatorList("-",10));
			opl.list.add(opl.InputOperatorList("=",0));
			opl.list.add(opl.InputOperatorList("(",0));
			opl.list.add(opl.InputOperatorList(",",0));
			opl.list.add(opl.InputOperatorList("^",10));
			opl.list.add(opl.InputOperatorList("abs",10));
			opl.list.add(opl.InputOperatorList("sqrt",10));
			opl.list.add(opl.InputOperatorList("sin",10));
			opl.list.add(opl.InputOperatorList("cos",10));
			opl.list.add(opl.InputOperatorList("tan",10));
			opl.list.add(opl.InputOperatorList("sinh",10));
			opl.list.add(opl.InputOperatorList("cosh",10));
			opl.list.add(opl.InputOperatorList("tanh",10));
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
			opl.list.add(opl.InputOperatorList("pm",100));
			opl.list.add(opl.InputOperatorList("percent",100));
			opl.list.add(opl.InputOperatorList("pc",100));
			opl.list.add(opl.InputOperatorList("tenexp",10));
			opl.list.add(opl.InputOperatorList("lcm",10));
			opl.list.add(opl.InputOperatorList("gcd",10));
			opl.list.add(opl.InputOperatorList("fibonacci",10));
			opl.list.add(opl.InputOperatorList("fib",10));
			opl.list.add(opl.InputOperatorList("H",10));
			opl.list.add(opl.InputOperatorList("C",10));
			opl.list.add(opl.InputOperatorList("P",10));
			opl.list.add(opl.InputOperatorList("NOT",10));
			opl.list.add(opl.InputOperatorList("XOR",10));
			opl.list.add(opl.InputOperatorList("XNOR",10));
			opl.list.add(opl.InputOperatorList("OR",10));
			opl.list.add(opl.InputOperatorList("AND",10));
			opl.list.add(opl.InputOperatorList("SL",10));
			opl.list.add(opl.InputOperatorList("SR",10));
			opl.list.add(opl.InputOperatorList("SRNS",10));
		}
	}
}
