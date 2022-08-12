package calc.rpn;
import java.util.ArrayList;

import calc.*;

public class SignSymbols {
	public void signSymbols(ArrayList<String> list, ArrayList<String> typelist) {
		int brackets;
		if(list.get(0).equals("+")) {
			list.remove(0);
			typelist.remove(0);
		} else if (list.get(0).equals("-") && list.size()>=2) {
			list.set(0, "pm");
			typelist.set(0, "識別子");
			if (list.get(1).equals("(")) {
				brackets = 0;
				for(int j = 1; j < list.size(); j++) {
					if (list.get(j).equals("(")) {
						brackets++;
					} else if (list.get(j).equals(")")) {
						brackets--;
					}
					if (brackets == 0) {
						list.add(j+1, ")");
						typelist.add(j+1, "記号");
						break;
					}
				}
			} else if (typelist.get(1).equals("識別子") && list.size()>=3) {
				if (list.get(2).equals("(")) {
					brackets = 0;
					for(int j = 1; j < list.size(); j++) {
						if (list.get(j).equals("(")) {
							brackets++;
						} else if (list.get(j).equals(")")) {
							brackets--;
						}
						if (brackets == 0) {
							list.add(j+1, ")");
							typelist.add(j+1, "記号");
							break;
						}
					}
				}
			} else {
				list.add(2, ")");
				typelist.add(2, "記号");
			}
			list.add(1, "(");
			typelist.add(1, "記号");
		}
		for( int i = 0; i < list.size(); i++ ) {
			if((list.get(i).equals("=") || list.get(i).equals("(") || list.get(i).equals(",")) && list.size()-i-1>0) {
				if(list.get(i+1).equals("+")) {
					list.remove(i+1);
					typelist.remove(i+1);
				} else if(list.get(i+1).equals("-") && list.size()>=i+3) {
					list.set(i+1, "pm");
					typelist.set(i+1, "識別子");
					if (list.get(i+2).equals("(")) {
						brackets = 0;
						for(int j = i + 2; j < list.size(); j++) {
							if (list.get(j).equals("(")) {
								brackets++;
							} else if (list.get(j).equals(")")) {
								brackets--;
							}
							if (brackets == 0) {
								list.add(j+1, ")");
								typelist.add(j+1, "記号");
								break;
							}
						}
					} else if (list.size()>=i+4) {
						if (typelist.get(i+2).equals("識別子") && list.get(i+3).equals("(")) {
							brackets = 0;
							for(int j = i + 3; j < list.size(); j++) {
								if (list.get(j).equals("(")) {
									brackets++;
								} else if (list.get(j).equals(")")) {
									brackets--;
								}
								if (brackets == 0) {
									list.add(j+1, ")");
									typelist.add(j+1, "記号");
									break;
								}
							}
						} else {
							list.add(i+3, ")");
							typelist.add(i+3, "記号");
						}
					} else {
						list.add(i+3, ")");
						typelist.add(i+3, "記号");
					}
					list.add(i+2, "(");
					typelist.add(i+2, "記号");
				}
			}
		}
	}
}