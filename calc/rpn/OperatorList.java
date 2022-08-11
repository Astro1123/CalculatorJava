package calc.rpn;
import java.util.ArrayList;

public class OperatorList {
	String op;
	int rank;
	
    ArrayList<OperatorList> list;
	
	OperatorList() {
		list = new ArrayList<>();
	}
   	
	public OperatorList InputOperatorList(String op, int rank) {
		OperatorList oplist = new OperatorList();
		oplist.rank = rank;
		oplist.op = op;
		return oplist;
	}
}