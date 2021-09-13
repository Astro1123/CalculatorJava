package calc.makelist;
import java.util.ArrayList;

public class MakeScript {
	public String makeScript(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		for(String s: list)
            sb.append(s+" ");
        return sb.toString();
	}
	
	public ArrayList<String> replacepm(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("pm")) {
				list.remove(i);
				list.add(i,"(");
				i++;
				list.remove(i);
				list.add(i,"-");
			}
		}
		return list;
	}
}