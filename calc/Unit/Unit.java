package calc.Unit;
import java.util.ArrayList;
import java.math.*;

public class Unit {
	UnitList ul;
	final String STR_PI = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955";
	final BigDecimal PI = new BigDecimal(STR_PI);
	
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
		
		// Solid angle
		ul.list.add(ul.InputUnitList("sr","1"));
		ul.list.add(ul.InputUnitList("deg^2",PI.multiply(PI).divide(BigDecimal.valueOf(32400),100,RoundingMode.HALF_UP).toString()));
		
		// Angle
		ul.list.add(ul.InputUnitList("deg","1"));
		ul.list.add(ul.InputUnitList("arcmin",BigDecimal.valueOf(1).divide(BigDecimal.valueOf(60),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("arcsec",BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3600),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("rad",BigDecimal.valueOf(180).divide(PI,100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("grad",BigDecimal.valueOf(90).divide(BigDecimal.valueOf(100),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("mil",BigDecimal.valueOf(180).divide(BigDecimal.valueOf(3200),100,RoundingMode.HALF_UP).toString()));
		
		// Force
		ul.list.add(ul.InputUnitList("N","1"));
		ul.list.add(ul.InputUnitList("dyn","1E-5"));
		ul.list.add(ul.InputUnitList("kgf","9.80665"));
		
		// Ratio
		ul.list.add(ul.InputUnitList("1","1"));
		ul.list.add(ul.InputUnitList("%","0.01"));
		ul.list.add(ul.InputUnitList("‰","0.001"));
		ul.list.add(ul.InputUnitList("ppm","1E-6"));
		ul.list.add(ul.InputUnitList("ppb","1E-9"));
		
		// Velocity
		ul.list.add(ul.InputUnitList("m/s","1"));
		ul.list.add(ul.InputUnitList("km/h",BigDecimal.valueOf(1000).divide(BigDecimal.valueOf(3600),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("feet/s","0.3048"));
		ul.list.add(ul.InputUnitList("mile/h","0.44704"));
		ul.list.add(ul.InputUnitList("kn",BigDecimal.valueOf(1.852).divide(BigDecimal.valueOf(3.6),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("Mach","340"));
		ul.list.add(ul.InputUnitList("c","299792458"));
		
		// Energy
		ul.list.add(ul.InputUnitList("J","1"));
		ul.list.add(ul.InputUnitList("erg","1E-7"));
		ul.list.add(ul.InputUnitList("kWh","3600E3"));
		ul.list.add(ul.InputUnitList("cal","4.184"));
		ul.list.add(ul.InputUnitList("kcal","4.184E3"));
		ul.list.add(ul.InputUnitList("cal I.T.","4.1868"));
		ul.list.add(ul.InputUnitList("kcal I.T.","4.1868E3"));
		ul.list.add(ul.InputUnitList("eV","1.60217653E-19"));
		
		// Pressure
		ul.list.add(ul.InputUnitList("Pa","1"));
		ul.list.add(ul.InputUnitList("hPa","1E2"));
		ul.list.add(ul.InputUnitList("bar","1E5"));
		ul.list.add(ul.InputUnitList("atm","101325"));
		ul.list.add(ul.InputUnitList("at","98066.5"));
		ul.list.add(ul.InputUnitList("mH2O","9806.65"));
		ul.list.add(ul.InputUnitList("cmH2O","98.0665"));
		ul.list.add(ul.InputUnitList("mmH2O","9.80665"));
		ul.list.add(ul.InputUnitList("inH2O","249.0899"));
		ul.list.add(ul.InputUnitList("feetH2O","2989.0788"));
		ul.list.add(ul.InputUnitList("mmHg",BigDecimal.valueOf(101325).divide(BigDecimal.valueOf(760),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("Torr",BigDecimal.valueOf(101325).divide(BigDecimal.valueOf(760),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("mHg",BigDecimal.valueOf(101325).divide(BigDecimal.valueOf(0.76),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("cmHg",BigDecimal.valueOf(101325).divide(BigDecimal.valueOf(76),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("inHg","3386.39"));
		ul.list.add(ul.InputUnitList("psi",BigDecimal.valueOf(0.45359237).multiply(BigDecimal.valueOf(9.80665)).divide(BigDecimal.valueOf(0.0254),100,RoundingMode.HALF_UP).divide(BigDecimal.valueOf(0.0254),100,RoundingMode.HALF_UP).toString()));
		
		// Area
		ul.list.add(ul.InputUnitList("m^2","1"));
		ul.list.add(ul.InputUnitList("cm^2","1E-4"));
		ul.list.add(ul.InputUnitList("mm^2","1E-6"));
		ul.list.add(ul.InputUnitList("km^2","1E6"));
		ul.list.add(ul.InputUnitList("a","1E2"));
		ul.list.add(ul.InputUnitList("ha","1E4"));
		ul.list.add(ul.InputUnitList("sq inch","6.4516E-4"));
		ul.list.add(ul.InputUnitList("sq feet","0.09290304"));
		ul.list.add(ul.InputUnitList("sq yard","0.83612736"));
		ul.list.add(ul.InputUnitList("sq mile","2589988.110336"));
		ul.list.add(ul.InputUnitList("rood","1011.7141056"));
		ul.list.add(ul.InputUnitList("acre","4046.8564224"));
		ul.list.add(ul.InputUnitList("坪",BigDecimal.valueOf(400).divide(BigDecimal.valueOf(121),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("畝",BigDecimal.valueOf(12000).divide(BigDecimal.valueOf(121),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("反",BigDecimal.valueOf(120000).divide(BigDecimal.valueOf(121),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("町(Area)",BigDecimal.valueOf(1200000).divide(BigDecimal.valueOf(121),100,RoundingMode.HALF_UP).toString()));
		
		// Volume
		ul.list.add(ul.InputUnitList("km^3","1E9"));
		ul.list.add(ul.InputUnitList("m^3","1"));
		ul.list.add(ul.InputUnitList("mm^3","1E-9"));
		ul.list.add(ul.InputUnitList("cm^3","1E-6"));
		ul.list.add(ul.InputUnitList("cc","1E-6"));
		ul.list.add(ul.InputUnitList("kL","1"));
		ul.list.add(ul.InputUnitList("L","1E-3"));
		ul.list.add(ul.InputUnitList("mL","1E-6"));
		ul.list.add(ul.InputUnitList("bbl","158.987294928E-3"));
		ul.list.add(ul.InputUnitList("U.S. fluid gallon","3.785411784E-3"));
		ul.list.add(ul.InputUnitList("gal","3.785412E-3"));
		ul.list.add(ul.InputUnitList("Imperial gallon","4.54609E-3"));
		ul.list.add(ul.InputUnitList("U.S. dry gallon","4.4048428032E-3"));
		ul.list.add(ul.InputUnitList("acre feet","1233.48183754752"));
		ul.list.add(ul.InputUnitList("cu inch","1.6387064E-5"));
		ul.list.add(ul.InputUnitList("cu feet","0.028316846592"));
		ul.list.add(ul.InputUnitList("升",BigDecimal.valueOf(2401).divide(BigDecimal.valueOf(1331000),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("勺",BigDecimal.valueOf(2401).divide(BigDecimal.valueOf(133100000),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("合",BigDecimal.valueOf(2401).divide(BigDecimal.valueOf(13310000),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("斗",BigDecimal.valueOf(2401).divide(BigDecimal.valueOf(133100),100,RoundingMode.HALF_UP).toString()));
		ul.list.add(ul.InputUnitList("石",BigDecimal.valueOf(2401).divide(BigDecimal.valueOf(13310),100,RoundingMode.HALF_UP).toString()));
	}
}
