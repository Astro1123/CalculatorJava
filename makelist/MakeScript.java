package makelist;
import java.util.ArrayList;

public class MakeScript {
	public String makeScript(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		for(String s: list)
            sb.append(s+" ");
        return sb.toString();
	}
}