package rpn;

import java.math.*;
import java.util.ArrayList;

public class Const {
	public void constant(ArrayList<String> list, ArrayList<String> typelist) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("pi")) {
				list.set(i,String.valueOf(Math.PI));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("e")) {
				list.set(i,String.valueOf(Math.E));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("c")) {
				list.set(i,String.valueOf(299792458.0));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("G")) {
				list.set(i,String.valueOf(6.67430E-11));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("k")) {
				list.set(i,String.valueOf(1.380649E-23));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("h")) {
				list.set(i,String.valueOf(6.62607015E-34));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("hbar")) {
				list.set(i,String.valueOf(6.62607015E-34/2/Math.PI));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("g")) {
				list.set(i,String.valueOf(9.80665));
				typelist.set(i,"実数");
			}
		}
	}
	public void constant(ArrayList<String> list, ArrayList<String> typelist, double x) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("pi")) {
				list.set(i,String.valueOf(Math.PI));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("e")) {
				list.set(i,String.valueOf(Math.E));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("c")) {
				list.set(i,String.valueOf(299792458.0));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("G")) {
				list.set(i,String.valueOf(6.67430E-11));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("k")) {
				list.set(i,String.valueOf(1.380649E-23));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("h")) {
				list.set(i,String.valueOf(6.62607015E-34));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("hbar")) {
				list.set(i,String.valueOf(6.62607015E-34/2/Math.PI));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("g")) {
				list.set(i,String.valueOf(9.80665));
				typelist.set(i,"実数");
			} else if (list.get(i).equals("x")) {
				list.set(i,String.valueOf(x));
				typelist.set(i,"実数");
			}
		}
	}
}