package area;
import java.math.*;
import java.util.ArrayList;
import java.lang.Math;

public class Area {
	double len,area,x0,x1,y0,y1;
	public void Area() {
		len=0.0;
		area=0.0;
	}
	public double calcArea(ArrayList<String> list) {
		int shape = calcShape(list);
		if (shape < 3) {
			return -1.0;
		}
		CoordinateList clist = makeCList(list);
		int size = clist.list.size();
		double area=0.0,x0,x1,y0,y1;
		for (int i = 1; i < size; i++) {
			x0 = clist.list.get(i-1).x;
			y0 = clist.list.get(i-1).y;
			x1 = clist.list.get(i).x;
			y1 = clist.list.get(i).y;
			area += (x0*y1-y0*x1)/2;
		}
		x0 = clist.list.get(size-1).x;
		y0 = clist.list.get(size-1).y;
		x1 = clist.list.get(0).x;
		y1 = clist.list.get(0).y;
		area += (x0*y1-y0*x1)/2;
		return Math.abs(area);
	}
	public double calcLength(ArrayList<String> list) {
		int shape = calcShape(list);
		if (shape < 2) {
			return -1.0;
		}
		CoordinateList clist = makeCList(list);
		int size = clist.list.size();
		double len=0.0,x0,x1,y0,y1;
		for (int i = 1; i < size; i++) {
			x0 = clist.list.get(i-1).x;
			y0 = clist.list.get(i-1).y;
			x1 = clist.list.get(i).x;
			y1 = clist.list.get(i).y;
			len += Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
		}
		if (shape > 2) {
			x0 = clist.list.get(size-1).x;
			y0 = clist.list.get(size-1).y;
			x1 = clist.list.get(0).x;
			y1 = clist.list.get(0).y;
			len += Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
		}
		return len;
	}
	public int calcShape(ArrayList<String> list) {
		if (list.size()%2==0) return list.size()/2;
		else return -1;
 	}
 	private CoordinateList makeCList(ArrayList<String> list) {
 		CoordinateList clist = new CoordinateList();
 		for (int i = 0; i < list.size(); i+=2) {
 			clist.list.add(clist.inputCoordinateList(Double.parseDouble(list.get(i)),Double.parseDouble(list.get(i+1))));
 		}
 		list.clear();
 		return clist;
 	}
	public ShapeStruct calc(ArrayList<String> list) {
		ShapeStruct ss = new ShapeStruct();
		int size;
		ss.shape = calcShape(list);
		if (ss.shape < 2) {
			ss.len = -1.0;
			ss.area = -1.0;
			return ss;
		}
		CoordinateList clist = makeCList(list);
		size = clist.list.size();
		len=0.0;
		area=0.0;
		for (int i = 1; i < size; i++) {
			x0 = clist.list.get(i-1).x;
			y0 = clist.list.get(i-1).y;
			x1 = clist.list.get(i).x;
			y1 = clist.list.get(i).y;
			len += Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
			area += (x0*y1-y0*x1)/2;
		}
		if (ss.shape > 2) {
			x0 = clist.list.get(size-1).x;
			y0 = clist.list.get(size-1).y;
			x1 = clist.list.get(0).x;
			y1 = clist.list.get(0).y;
			len += Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
			area += (x0*y1-y0*x1)/2;
		}
		ss.len=len;
		if (ss.shape == 2) ss.area=-1;
		else ss.area=Math.abs(area);
		clist.list.clear();
		return ss;
	}
}