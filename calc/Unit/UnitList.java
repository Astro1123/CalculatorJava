package calc.Unit;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitList {
	String str;
	BigDecimal num;
	
    static ArrayList<UnitList> list = new ArrayList<>();
    static ArrayList<UnitList> SIlist = new ArrayList<>();
   	
	public UnitList InputUnitList(String str, String num) {
		UnitList ulist = new UnitList();
		ulist.str = str;
		ulist.num = new BigDecimal(num);
		return ulist;
	}
}