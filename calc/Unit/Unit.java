package calc.Unit;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Unit {
	UnitList ul;
	
	public Unit() {
		ul = new UnitList();
		unitinit();
	}
	
	public BigDecimal getnum(String unit) {
		BigDecimal num = new BigDecimal(0);
		for(int i = 0; i < ul.list.size(); i++) {
			if(unit.equals(ul.list.get(i).str)) {
				num = ul.list.get(i).num;
				break;
			}
		}
		return num;
	}
	
	private void unitinit() {
		// Length
		ul.list.add(ul.InputUnitList("m","1"));
		ul.list.add(ul.InputUnitList("km","1000"));
		ul.list.add(ul.InputUnitList("cm","0.01"));
		ul.list.add(ul.InputUnitList("mm","0.001"));
		ul.list.add(ul.InputUnitList("μm","0.000001"));
		ul.list.add(ul.InputUnitList("nm","1.0E-9"));
		ul.list.add(ul.InputUnitList("pm","1.0E-12"));
		ul.list.add(ul.InputUnitList("fm","1.0E-15"));
		ul.list.add(ul.InputUnitList("Å","1.0E-10"));
		ul.list.add(ul.InputUnitList("ly","9460730472580800.0"));
		ul.list.add(ul.InputUnitList("au","149597870700.0"));
		ul.list.add(ul.InputUnitList("pc","3.085677581E16"));
		ul.list.add(ul.InputUnitList("kpc","3.085677581E19"));
		ul.list.add(ul.InputUnitList("Mpc","3.085677581E22"));
		ul.list.add(ul.InputUnitList("Gpc","3.085677581E25"));
		ul.list.add(ul.InputUnitList("inch","25.4E-3"));
		ul.list.add(ul.InputUnitList("feet","0.3048"));
		ul.list.add(ul.InputUnitList("yard","0.9144"));
		ul.list.add(ul.InputUnitList("mile","1609.344"));
		ul.list.add(ul.InputUnitList("nautical mile","1852"));
		ul.list.add(ul.InputUnitList("寸",BigDecimal.valueOf(1).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("尺",BigDecimal.valueOf(10).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("間",BigDecimal.valueOf(60).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("尋",BigDecimal.valueOf(60).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("町",BigDecimal.valueOf(3600).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("里",BigDecimal.valueOf(3600*36).divide(BigDecimal.valueOf(33),100,RoundingMode.HALF_UP).toString()));
		
		// Mass
		ul.list.add(ul.InputUnitList("t","1000"));
		ul.list.add(ul.InputUnitList("kg","1"));
		ul.list.add(ul.InputUnitList("g","0.001"));
		ul.list.add(ul.InputUnitList("mg","0.000001"));
		ul.list.add(ul.InputUnitList("momme","3.75E-3"));
		ul.list.add(ul.InputUnitList("貫","3.75"));
		ul.list.add(ul.InputUnitList("斤","0.6"));
		ul.list.add(ul.InputUnitList("eV/c^2","1.782662E-36"));
		ul.list.add(ul.InputUnitList("keV/c^2","1.782662E-33"));
		ul.list.add(ul.InputUnitList("MeV/c^2","1.782662E-30"));
		ul.list.add(ul.InputUnitList("GeV/c^2","1.782662E-27"));
		ul.list.add(ul.InputUnitList("lb","0.45359237"));
		ul.list.add(ul.InputUnitList("oz","28.349523125E-3"));
		ul.list.add(ul.InputUnitList("ct","0.2E-3"));
		
		// Time
		ul.list.add(ul.InputUnitList("ms","0.001"));
		ul.list.add(ul.InputUnitList("s","1"));
		ul.list.add(ul.InputUnitList("min","60"));
		ul.list.add(ul.InputUnitList("h","3600"));
		ul.list.add(ul.InputUnitList("day",BigDecimal.valueOf(3600*24).toString()));
		ul.list.add(ul.InputUnitList("week","604.800E3"));
		ul.list.add(ul.InputUnitList("month","2.592E6"));
		ul.list.add(ul.InputUnitList("year",BigDecimal.valueOf(3600*24*365).toString()));
		ul.list.add(ul.InputUnitList("solar year",BigDecimal.valueOf(3600*24*365.24218944).toString()));
		ul.list.add(ul.InputUnitList("Gregorian year",BigDecimal.valueOf(3600*24*365.2425).toString()));
		ul.list.add(ul.InputUnitList("Julian year","31557600"));
	}
}
