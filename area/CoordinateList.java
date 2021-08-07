package area;
import java.util.ArrayList;

public class CoordinateList {
	double x;
	double y;
	
    static ArrayList<CoordinateList> list = new ArrayList<>();
   	
	public CoordinateList inputCoordinateList(double x, double y) {
		CoordinateList clist = new CoordinateList();
		clist.x = x;
		clist.y = y;
		return clist;
	}
}