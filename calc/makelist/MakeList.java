package calc.makelist;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;

public class MakeList {
	public ArrayList<String> makeList(Deque<String> PushList) {
	    ArrayList<String> cpylist = new ArrayList<>();
	    ArrayList<String> list = new ArrayList<>();
	    
	    while (true) {
            if(PushList.size()==0) break;
	        cpylist.add(PushList.getFirst());
	        PushList.pollFirst();
	    }
	    PushList.clear();
	    //System.out.println(cpylist);
		int Brackets;
		while (true) {
            if(cpylist.size()==0) break;
            else {
            	if(cpylist.get(0).equals("pm")||cpylist.get(0).equals("sin")||cpylist.get(0).equals("cos")||cpylist.get(0).equals("tan")||cpylist.get(0).equals("exp")||cpylist.get(0).equals("log")||cpylist.get(0).equals("asin")||cpylist.get(0).equals("acos")||cpylist.get(0).equals("atan")||cpylist.get(0).equals("sqrt")||cpylist.get(0).equals("abs")||cpylist.get(0).equals("deg")||cpylist.get(0).equals("rad")||cpylist.get(0).equals("sum")||cpylist.get(0).equals("mod")||cpylist.get(0).equals("mod2")||cpylist.get(0).equals("fact")||cpylist.get(0).equals("rinf")||cpylist.get(0).equals("round")||cpylist.get(0).equals("floor")||cpylist.get(0).equals("ceil")||cpylist.get(0).equals("int")||cpylist.get(0).equals("revn")||cpylist.get(0).equals("atan2")||cpylist.get(0).equals("tenexp")||cpylist.get(0).equals("fib")||cpylist.get(0).equals("pc")||cpylist.get(0).equals("percent")) {
            	    if (list.size()>0) {
            		    if (list.get(list.size()-1).equals(")")) {
            		    	Brackets = 0;
            			    for (int i = list.size()-1; i >= 0; i--) {
            				    if (list.get(i)==")") {
            					    Brackets++;
            				    } else if (list.get(i).equals("(")) {
            				    	Brackets--;
            				    }
            				    if(Brackets==0) {
            				        if (i == 0) {
            					        list.add(0,"(");
            					        list.add(0,cpylist.get(0));
            					        cpylist.remove(0);
            					        break;
            				        } else { 
            					        list.add(i-1,"(");
            					        list.add(i-1,cpylist.get(0));
            					        cpylist.remove(0);
            					        break;
            					    }
            				    }
            			    }
            			    list.add(")");
            		    } else {
            			    list.add(")");
            			    list.add(list.size()-2,cpylist.get(0));
            			    cpylist.remove(0);
            			    list.add(list.size()-2,"(");
            		    }
            		} else {
            	        list.add(cpylist.get(0));
            	        cpylist.remove(0);
            	    }
                } else {
            	    list.add(cpylist.get(0));
            	    cpylist.remove(0);
            	}
            }
        }
        return list;
	}
}