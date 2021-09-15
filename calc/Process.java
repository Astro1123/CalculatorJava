package calc;

import calc.script.*;
import calc.rpn.*;
import calc.area.*;
import calc.Unit.*;
import calc.utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.lang.ArithmeticException;
import java.lang.NumberFormatException;
import java.math.RoundingMode;
import java.math.MathContext;
import java.net.URISyntaxException;

public class Process {
	public String equalcalc(Calculator calc, String str) {
        Token t;
		SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        //System.out.println(str);
        Reader reader = new StringReader(str);
        Lexer l = new Lexer(reader);
        calc.typelist = new ArrayList<>();
        calc.list = new ArrayList<>();
        try {
            for (int i = 0; (t = l.read()) != Token.EOF; i++) {
			    if(t.getText()==Token.EOL) continue;
			    calc.list.add(t.getText());
			    calc.typelist.add(t.getType().getLabel());
			    //System.out.println(list.get(list.size()-1));
		    }
		}
		catch (ParseException e) {
		    System.exit(-1);
		}
		//System.out.println(list);
		if (calc.list.size() == 0) {
		    calc.list.add("0");
		    calc.typelist.add("整数");
		}
		cons.constant(calc.list,calc.typelist);
		ss.signSymbols(calc.list,calc.typelist);
		boolean mode;
		if (calc.title.equals("Standard")) mode = false;
		else mode = true;
		calc.list=trpn.toRPN(calc.list,calc.typelist,mode);
		//System.out.println(list);
		/*
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)+" ");
		}
		System.out.println(sb.toString());
		//*/
		String s = "";
		for (int i = 0; i < calc.list.size(); i++) {
			s += calc.list.get(i) + " ";
		}
		try {
			BigDecimal bans = cal.calc(calc.list);
			calc.ans = Double.parseDouble(cal.calc(calc.list).toString());
			if (Math.abs(Math.log(calc.ans)/Math.log(10)) < 12) {
				calc.text1.setText(cal.calc(calc.list).setScale(12, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
			} else {
				calc.text1.setText(cal.calc(calc.list).toString());
			}
		}
		catch (ArithmeticException e) {
			calc.text1.setText("error ("+e.getMessage()+")");
			calc.sb.delete(0, calc.sb.length());
			return s;
		}
		calc.texta1.setText("");
		calc.sb.delete(0, calc.sb.length());
		calc.sb.append(String.valueOf(calc.ans));
		return s;
    }
    
	public String equalcalc(Calculator calc, String str, String outputType) {
        Token t;
		SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        //System.out.println(str);
        Reader reader = new StringReader(str);
        Lexer l = new Lexer(reader);
        calc.typelist = new ArrayList<>();
        calc.list = new ArrayList<>();
        try {
            for (int i = 0; (t = l.read()) != Token.EOF; i++) {
			    if(t.getText()==Token.EOL) continue;
			    calc.list.add(t.getText());
			    calc.typelist.add(t.getType().getLabel());
			    //System.out.println(list.get(list.size()-1));
		    }
		}
		catch (ParseException e) {
		    System.exit(-1);
		}
		//System.out.println(list);
		if (calc.list.size() == 0) {
		    calc.list.add("0");
		    calc.typelist.add("整数");
		}
		cons.constant(calc.list,calc.typelist);
		ss.signSymbols(calc.list,calc.typelist);
		boolean mode;
		if (calc.title.equals("Standard")) mode = false;
		else mode = true;
		calc.list=trpn.toRPN(calc.list,calc.typelist,mode);
		//System.out.println(list);
		/*
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)+" ");
		}
		System.out.println(sb.toString());
		//*/
		String s = "";
		for (int i = 0; i < calc.list.size(); i++) {
			s += calc.list.get(i) + " ";
		}
		try {
			BigDecimal bans = cal.calc(calc.list);
			calc.ans = Double.parseDouble(cal.calc(calc.list).toString());
			if (outputType.equals("BIN")) {
				calc.text1.setText(Integer.toBinaryString((int)calc.ans));
			} else if (outputType.equals("OCT")) {
				calc.text1.setText(Integer.toOctalString((int)calc.ans));
			} else if (outputType.equals("HEX")) {
				calc.text1.setText(Integer.toHexString((int)calc.ans));
			} else {
				calc.text1.setText(String.valueOf((int)calc.ans));
			}
		}
		catch (ArithmeticException e) {
			calc.text1.setText("error ("+e.getMessage()+")");
			calc.sb.delete(0, calc.sb.length());
			return s;
		}
		String str2 = "";
		str2 += "BIN : "+Integer.toBinaryString((int)calc.ans)+"\n";
		str2 += "OCT : "+Integer.toOctalString((int)calc.ans)+"\n";
		str2 += "DEC : "+String.valueOf((int)calc.ans)+"\n";
		str2 += "HEX : "+Integer.toHexString((int)calc.ans)+"\n";
		calc.texta6.setText(str2);
		calc.texta1.setText("");
		calc.sb.delete(0, calc.sb.length());
		calc.sb.append(String.valueOf(calc.ans));
		return s;
    }
    
    public void equalarea(Calculator calc, String str) {
		Area area = new Area();
		ArrayList<String> list = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new StringReader(str))) {
            String line = null;
            String[] words = {"" , ""};
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) continue;
                if (line.startsWith("\n")) continue;
                if (line.length() == 0) continue;
                if (line.indexOf(" ") == -1 || line.endsWith(" ")) {
                    line+=" 0.0";
                }
                words = line.split("[\\s]+",2);
                list.add(words[0].replace("\n",""));
                list.add(words[1].replace("\n",""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(list.size());
        ShapeStruct ss = area.calc(list);
		calc.sb.delete(0, calc.sb.length());
        if (ss.shape < 1) {
		    calc.text1.setText("error\n");
		    calc.texta1.setText("");
        } else if (ss.shape == 1) {
            calc.text1.setText("Shape : Point\n");
		    calc.texta1.setText("");
        } else if (ss.shape == 2) {
            calc.text1.setText("Shape : Line\n");
            calc.texta1.setText("Length = " + String.valueOf(ss.len));
        } else {
            calc.text1.setText("Shape : "+String.valueOf(ss.shape)+"-gon\n");
            calc.texta1.setText("Perimeter = " + String.valueOf(ss.len) + "\nArea = " + String.valueOf(ss.area));
        }
    }
    
    public void equalunit(Calculator calc, String input1, String input2) {
    	Unit unit = new Unit();
    	String input3="",input4="",input0="";
    	BigDecimal before,after,num,ans,tmp;
    	try {
    		num = new BigDecimal(input1);
    	} catch (NumberFormatException e) {
    		num = new BigDecimal("0");
    	}
    	double d1;
    	ans = new BigDecimal(0);
    	if (input2.equals("Temperature")) {
    		input3 = (String)calc.combo1Temp.getSelectedItem();
    		input4 = (String)calc.combo2Temp.getSelectedItem();
    		//{"℃","℉","K"};
    		if (input3.equals("℃") && input4.equals("℉")) {
    			ans = num.divide(new BigDecimal(5), 100, RoundingMode.HALF_UP).multiply(new BigDecimal(9),new MathContext(15)).add(new BigDecimal(32),new MathContext(15));
    		} else if (input3.equals("℉") && input4.equals("℃")) {
    			ans = num.subtract(new BigDecimal(32),new MathContext(15)).divide(new BigDecimal(9), 100, RoundingMode.HALF_UP).multiply(new BigDecimal(5),new MathContext(15));
       		} else if (input3.equals("℃") && input4.equals("K")) {
       			ans = num.add(new BigDecimal(273.15),new MathContext(15));
    		} else if (input3.equals("K") && input4.equals("℃")) {
       			ans = num.subtract(new BigDecimal(273.15),new MathContext(15));
    		} else if (input3.equals("℉") && input4.equals("K")) {
    			ans = num.subtract(new BigDecimal(32),new MathContext(15)).divide(new BigDecimal(9), 100, RoundingMode.HALF_UP).multiply(new BigDecimal(5),new MathContext(15)).add(new BigDecimal(273.15),new MathContext(15));
    		} else if (input3.equals("K") && input4.equals("℉")) {
    			ans = num.subtract(new BigDecimal(273.15),new MathContext(15)).divide(new BigDecimal(5), 100, RoundingMode.HALF_UP).multiply(new BigDecimal(9),new MathContext(15)).add(new BigDecimal(32),new MathContext(15));
    		}
    	} else if (input2.equals("Angle")) {
    		input3 = (String)calc.combo1Angle.getSelectedItem();
    		input4 = (String)calc.combo2Angle.getSelectedItem();
    		input0 = "rad";
    		if (input3.equals("percent")) {
    			tmp = num.divide(new BigDecimal(100), 100, RoundingMode.HALF_UP);
    			d1 = Math.atan(Double.parseDouble(tmp.toString()));
    			tmp = new BigDecimal(d1);
    		} else if (input3.equals("permil")) {
    			tmp = num.divide(new BigDecimal(1000), 100, RoundingMode.HALF_UP);
    			d1 = Math.atan(Double.parseDouble(tmp.toString()));
    			tmp = new BigDecimal(d1);
    		} else {
    			before = unit.getnum(input3);
    			after = unit.getnum(input0);
    			tmp = num.divide(after, 100, RoundingMode.HALF_UP).multiply(before,new MathContext(15));
    		}
    		
    		if (input4.equals("percent")) {
    			d1 = Math.tan(Double.parseDouble(tmp.toString()))*100;
    			ans = new BigDecimal(d1);
    			ans = ans.multiply(new BigDecimal(1),new MathContext(15));
    		} else if (input4.equals("permil")) {
    			d1 = Math.tan(Double.parseDouble(tmp.toString()))*1000;
    			ans = new BigDecimal(d1);
    			ans = ans.multiply(new BigDecimal(1),new MathContext(15));
    		} else {
    			before = unit.getnum(input0);
    			after = unit.getnum(input4);
    			ans = tmp.divide(after, 100, RoundingMode.HALF_UP).multiply(before,new MathContext(15));
    		}
    	} else if (input2.equals("SI prefixes")) {
    		input3 = (String)calc.combo1SIp.getSelectedItem();
    		input4 = (String)calc.combo2SIp.getSelectedItem();
    		before = unit.getSInum(input3);
    		after = unit.getSInum(input4);
    		ans = num.divide(after, 100, RoundingMode.HALF_UP).multiply(before,new MathContext(15));
    	} else {
    		if (input2.equals("Length")) {
    			input3 = (String)calc.combo1Len.getSelectedItem();
    			input4 = (String)calc.combo2Len.getSelectedItem();
    		} else if (input2.equals("Mass")) {
    			input3 = (String)calc.combo1Mass.getSelectedItem();
    			input4 = (String)calc.combo2Mass.getSelectedItem();
    		} else if (input2.equals("Time")) {
    			input3 = (String)calc.combo1Time.getSelectedItem();
    			input4 = (String)calc.combo2Time.getSelectedItem();
    		} else if (input2.equals("Solid Angle")) {
    			input3 = (String)calc.combo1SAngle.getSelectedItem();
    			input4 = (String)calc.combo2SAngle.getSelectedItem();
    		} else if (input2.equals("Force")) {
    			input3 = (String)calc.combo1Force.getSelectedItem();
    			input4 = (String)calc.combo2Force.getSelectedItem();
    		} else if (input2.equals("Ratio")) {
    			input3 = (String)calc.combo1Ratio.getSelectedItem();
    			input4 = (String)calc.combo2Ratio.getSelectedItem();
    		} else if (input2.equals("Velocity")) {
    			input3 = (String)calc.combo1Velocity.getSelectedItem();
    			input4 = (String)calc.combo2Velocity.getSelectedItem();
    		} else if (input2.equals("Energy")) {
    			input3 = (String)calc.combo1Energy.getSelectedItem();
    			input4 = (String)calc.combo2Energy.getSelectedItem();
    		} else if (input2.equals("Pressure")) {
    			input3 = (String)calc.combo1Press.getSelectedItem();
    			input4 = (String)calc.combo2Press.getSelectedItem();
    		} else if (input2.equals("Area")) {
    			input3 = (String)calc.combo1Area.getSelectedItem();
    			input4 = (String)calc.combo2Area.getSelectedItem();
    		} else if (input2.equals("Volume")) {
    			input3 = (String)calc.combo1Volume.getSelectedItem();
    			input4 = (String)calc.combo2Volume.getSelectedItem();
    		}

    		before = unit.getnum(input3);
    		after = unit.getnum(input4);
    		ans = num.divide(after, 100, RoundingMode.HALF_UP).multiply(before,new MathContext(15));
    	}
		calc.sb.delete(0, calc.sb.length());
		d1 = Math.abs(Math.log10(Double.parseDouble(ans.toString())));
		if (d1 > 6) {
	        calc.texta1.setText(num + " [" + input3 + "] = " + ans.stripTrailingZeros() + " [" + input4 + "]");
	    } else {
	        calc.texta1.setText(num + " [" + input3 + "] = " + ans.stripTrailingZeros().toPlainString() + " [" + input4 + "]");
	    } 
    }
        
    public void solveequal(Calculator calc, String input1, double input2, double input3, String input4) {
    	Token t;
		SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        //System.out.println(str);
        Reader reader = new StringReader(input1);
        Lexer l = new Lexer(reader);
        calc.typelist = new ArrayList<>();
        calc.list = new ArrayList<>();
        ArrayList<String> listc1;
        ArrayList<String> listc2;
        ArrayList<String> listc3;
        ArrayList<String> typelistc1;
        ArrayList<String> typelistc2;
        ArrayList<String> typelistc3;
        BigDecimal yd;
        
        try {
            for (int i = 0; (t = l.read()) != Token.EOF; i++) {
			    if(t.getText()==Token.EOL) continue;
			    calc.list.add(t.getText());
			    calc.typelist.add(t.getType().getLabel());
			    //System.out.println(list.get(list.size()-1));
		    }
		}
		catch (ParseException e) {
		    System.exit(-1);
		}
		//System.out.println(list);
		if (calc.list.size() == 0) {
		    calc.list.add("0");
		    calc.typelist.add("整数");
		}
    	double x0 = input2;
    	double x1 = input3;
		listc1 = new ArrayList<>(calc.list);
		listc2 = new ArrayList<>(calc.list);
		typelistc1 = new ArrayList<>(calc.typelist);
		typelistc2 = new ArrayList<>(calc.typelist);
		cons.constant(listc1,typelistc1,x0);
		cons.constant(listc2,typelistc2,x1);
		ss.signSymbols(listc1,typelistc1);
		ss.signSymbols(listc2,typelistc2);
		listc1=trpn.toRPN(listc1,typelistc1,true);
		listc2=trpn.toRPN(listc2,typelistc2,true);
		if (cal.calc(listc1).abs().compareTo(cal.calc(listc2).abs()) > 0) {
			double tmp = x0;
			x0 = x1;
			x1 = tmp;
		}
		listc1 = new ArrayList<>(calc.list);
		listc2 = new ArrayList<>(calc.list);
		listc3 = new ArrayList<>(calc.list);
		typelistc1 = new ArrayList<>(calc.typelist);
		typelistc2 = new ArrayList<>(calc.typelist);
		typelistc3 = new ArrayList<>(calc.typelist);
		double x = 0.0;
		if (input4.equals("FalsePosition")) {
			cons.constant(listc1,typelistc1,x0);
			cons.constant(listc2,typelistc2,x1);
			ss.signSymbols(listc1,typelistc1);
			ss.signSymbols(listc2,typelistc2);
			listc1=trpn.toRPN(listc1,typelistc1,true);
			listc2=trpn.toRPN(listc2,typelistc2,true);
			x = FalsePosition(calc,x0,x1,listc1,listc2,typelistc1,typelistc2);
		} else if (input4.equals("Newton")) {
			x = Newton(calc,x0,listc1,typelistc1);
		} else {
			x = ModNewton(calc,x0,listc1,typelistc1);
		}
		cons.constant(calc.list,calc.typelist,x);
		ss.signSymbols(calc.list,calc.typelist);
		calc.list=trpn.toRPN(calc.list,calc.typelist,true);
		yd=derivative(calc,x,listc3,typelistc3,0.00000001);
		calc.text1.setText("x = " + String.format("%.12f", x));
		calc.texta1.setText("f(x) = " + cal.calc(calc.list).setScale(12, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
		calc.texta1.append("\nf'(x) = " + yd.toPlainString());
    }
    
    private BigDecimal derivative(Calculator calc, double x0, ArrayList<String> list, ArrayList<String> typelist,double h) {
    	SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        ArrayList<String> listph = new ArrayList<>(list);
        ArrayList<String> listmh = new ArrayList<>(list);
        ArrayList<String> typelistph = new ArrayList<>(typelist);
        ArrayList<String> typelistmh = new ArrayList<>(typelist);
		cons.constant(listph,typelistph,x0+h/2);
		cons.constant(listmh,typelistmh,x0-h/2);
		ss.signSymbols(listph,typelistph);
		ss.signSymbols(listmh,typelistmh);
		listph=trpn.toRPN(listph,typelistph,true);
		listmh=trpn.toRPN(listmh,typelistmh,true);
		return cal.calc(listph).subtract(cal.calc(listmh)).divide((new BigDecimal(h)), 15, RoundingMode.HALF_UP);
    }
        
    private double ModNewton(Calculator calc, double x0, ArrayList<String> list, ArrayList<String> typelist) {
    	SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        
    	int countmax = 500;
        double x = x0;
        double dx0=0.0,dx1=0.0,xc = x0,y1=0.0,y0=0.0;
        BigDecimal y;
        BigDecimal x1,yd;
        for (int i = 0; i < countmax; i++) {
       		ArrayList<String> listc = new ArrayList<>(list);
        	ArrayList<String> typelistc = new ArrayList<>(typelist);
       		ArrayList<String> listc2 = new ArrayList<>(list);
        	ArrayList<String> typelistc2 = new ArrayList<>(typelist);
       		ArrayList<String> listc3 = new ArrayList<>(list);
        	ArrayList<String> typelistc3 = new ArrayList<>(typelist);
        	cons.constant(listc,typelistc,x);
			ss.signSymbols(listc,typelistc);
			listc=trpn.toRPN(listc,typelistc,true);
			yd = derivative(calc,x0,listc2,typelistc2,0.00000001);
			if (yd.compareTo(new BigDecimal(0)) == 0) x = FalsePosition1(calc,x,xc,listc3,typelistc3);
        	x1 = new BigDecimal(x);
        	xc=x;
        	y = cal.calc(listc);
			if (y.compareTo(new BigDecimal(0)) == 0) {
				x=x1.doubleValue();
				break;
			}
			x = x1.subtract(y.divide(yd, 15, RoundingMode.HALF_UP)).doubleValue();
			dx1 = dx0;
			dx0 = x-xc;
        	if (Math.abs(dx0)<0.0000000000001) {
        		x=x1.doubleValue();
				break;
        	}
			y1=y0;
			y0 = y.doubleValue();
			if (dx0*dx1<0 && Math.abs(dx1)<=Math.abs(dx0)) {
				if(Math.abs(y0) < Math.abs(y1)) {
					x = FalsePosition1(calc,x,xc,listc3,typelistc3);
				} else {
					double tmp = x;
					x = xc;
					xc = tmp;
					x = FalsePosition1(calc,x,xc,listc3,typelistc3);
				}
			}
			if (y.compareTo(new BigDecimal(0)) == 0) break;
        }
        return x;
    }
    
    private double Newton(Calculator calc, double x0, ArrayList<String> list, ArrayList<String> typelist) {
    	SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        
    	int countmax = 500;
        double x = x0;
        double xc=x0;
        BigDecimal x1,yd;
        for (int i = 0; i < countmax; i++) {
       		ArrayList<String> listc = new ArrayList<>(list);
        	ArrayList<String> typelistc = new ArrayList<>(typelist);
       		ArrayList<String> listc2 = new ArrayList<>(list);
        	ArrayList<String> typelistc2 = new ArrayList<>(typelist);
        	cons.constant(listc,typelistc,x);
			ss.signSymbols(listc,typelistc);
			listc=trpn.toRPN(listc,typelistc,true);
			yd = derivative(calc,x0,listc2,typelistc2,0.00000001);
			//System.out.println(yd);
			//System.out.println("#"+x);
			if (yd.compareTo(new BigDecimal(0)) == 0) break;
        	x1 = new BigDecimal(x);
        	xc = x;
        	//System.out.println(listc);
			if (cal.calc(listc).compareTo(new BigDecimal(0)) == 0) {
				x=x1.doubleValue();
				break;
			}
			x = x1.subtract(cal.calc(listc).divide(yd, 15, RoundingMode.HALF_UP)).doubleValue();
        	if (Math.abs(x-xc)<0.0000000000001) {
        		x=x1.doubleValue();
				break;
        	}
			if (cal.calc(listc).compareTo(new BigDecimal(0)) == 0) break;
        }
        //System.out.println(x);
        return x;
    }
    
    private double FalsePosition1(Calculator calc, double x0, double x1, ArrayList<String> listc1, ArrayList<String> typelistc1) {
   		SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        ArrayList<String> listc2 = new ArrayList<>(listc1);
        ArrayList<String> typelistc2 = new ArrayList<>(typelistc1);
        ArrayList<String> listc3;
        ArrayList<String> typelistc3;

        double x = 0.0;
        
		listc1 = new ArrayList<>(calc.list);
		listc2 = new ArrayList<>(calc.list);
		listc3 = new ArrayList<>(calc.list);
		typelistc1 = new ArrayList<>(calc.typelist);
		typelistc2 = new ArrayList<>(calc.typelist);
		typelistc3 = new ArrayList<>(calc.typelist);
		cons.constant(listc1,typelistc1,x0);
		cons.constant(listc2,typelistc2,x1);
		ss.signSymbols(listc1,typelistc1);
		ss.signSymbols(listc2,typelistc2);
		listc1=trpn.toRPN(listc1,typelistc1,true);
		listc2=trpn.toRPN(listc2,typelistc2,true);
		if (cal.calc(listc1).compareTo(new BigDecimal(0)) == 0) {
			x=x0;
			return x;
		} else if (cal.calc(listc2).compareTo(new BigDecimal(0)) == 0) {
			x=x1;
			return x;
		} else {
			if (x0-x1==0) {
				return x;
			}
			x = cal.calc(listc1).multiply(new BigDecimal(x1)).subtract(cal.calc(listc2).multiply(new BigDecimal(x0))).divide(cal.calc(listc1).subtract(cal.calc(listc2)), 15, RoundingMode.HALF_UP).doubleValue();
			if (cal.calc(listc1).multiply(cal.calc(listc2)).compareTo(new BigDecimal(0))<0) {
				cons.constant(listc3,typelistc3,x);
				ss.signSymbols(listc3,typelistc3);
				listc3=trpn.toRPN(listc3,typelistc3,true);
				if (cal.calc(listc1).multiply(cal.calc(listc3)).compareTo(new BigDecimal(0))<0) {
					x0 = x;
				} else {
					x1 = x;
				}
			} else {
				if (cal.calc(listc1).abs().compareTo(cal.calc(listc2).abs()) > 0) {
					x0 = x;
				} else {
					x1 = x;
				}
			}
		}
		return x;
	}
	
	private double FalsePosition(Calculator calc, double x0, double x1, ArrayList<String> listc1, ArrayList<String> listc2, ArrayList<String> typelistc1, ArrayList<String> typelistc2) {
   		SignSymbols ss = new SignSymbols();
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		Const cons = new Const();
        ArrayList<String> listc3;
        ArrayList<String> typelistc3;

        int countmax = 500;
        double x = 0.0;
        
    	for (int i = 0; i < countmax; i++) {
			listc1 = new ArrayList<>(calc.list);
			listc2 = new ArrayList<>(calc.list);
			listc3 = new ArrayList<>(calc.list);
			typelistc1 = new ArrayList<>(calc.typelist);
			typelistc2 = new ArrayList<>(calc.typelist);
			typelistc3 = new ArrayList<>(calc.typelist);
			cons.constant(listc1,typelistc1,x0);
			cons.constant(listc2,typelistc2,x1);
			ss.signSymbols(listc1,typelistc1);
			ss.signSymbols(listc2,typelistc2);
			listc1=trpn.toRPN(listc1,typelistc1,true);
			listc2=trpn.toRPN(listc2,typelistc2,true);
			if (cal.calc(listc1).compareTo(new BigDecimal(0)) == 0) {
				x=x0;
				break;
			} else if (cal.calc(listc2).compareTo(new BigDecimal(0)) == 0) {
				x=x1;
				break;
			} else {
				if (x0-x1==0) {
					break;
				}
				x = cal.calc(listc1).multiply(new BigDecimal(x1)).subtract(cal.calc(listc2).multiply(new BigDecimal(x0))).divide(cal.calc(listc1).subtract(cal.calc(listc2)), 15, RoundingMode.HALF_UP).doubleValue();
				if (cal.calc(listc1).multiply(cal.calc(listc2)).compareTo(new BigDecimal(0))<0) {
					cons.constant(listc3,typelistc3,x);
					ss.signSymbols(listc3,typelistc3);
					listc3=trpn.toRPN(listc3,typelistc3,true);
					if (cal.calc(listc1).multiply(cal.calc(listc3)).compareTo(new BigDecimal(0))<0) {
						x0 = x;
					} else {
						x1 = x;
					}
				} else {
					if (cal.calc(listc1).abs().compareTo(cal.calc(listc2).abs()) > 0) {
						x0 = x;
					} else {
						x1 = x;
					}
				}
			}
		}
		return x;
    }
    
    public void openFile(Calculator calc, JTextArea text) {
	    ToRPN trpn = new ToRPN();
		Calc cal = new Calc();
		ExecPath ep = new ExecPath();
		PlatformUtils pu = new PlatformUtils();
    	String str;
    	BufferedReader br;
    	File file,dir = new File(System.getProperty("user.dir"));
        try{
        	/*
        	try {
	        	dir = new File(ep.getApplicationPath());
        		//System.out.println(dir);
	        	dir = new File(dir.getParent());
        		//System.out.println(dir);
	        } catch (URISyntaxException e) {
	        	System.out.println(e);
	        	dir = new File(System.getProperty("user.dir"));
	        }//*/
	        //dir = new File(System.getProperty("user.dir"));
	        if (pu.isWindows()) {
		        dir = new File(ep.get_currentpath()+"TestData\\");
	        } else {
		        dir = new File(ep.get_currentpath()+"TestData/");
		    }
	        
            JFileChooser filechooser = new JFileChooser(dir);
            if ( filechooser.showOpenDialog(calc) == JFileChooser.APPROVE_OPTION ) {
                file = filechooser.getSelectedFile();
                br = new BufferedReader(new FileReader(file));
                StringBuilder sb2 = new StringBuilder();
                while((str = br.readLine()) != null) {
                    sb2.append(str + "\n");
                }
                br.close();
                text.setText(sb2.toString());
            }
        } catch(FileNotFoundException er) {
            System.out.println(er);
        } catch(IOException er) {
            System.out.println(er);
        }
    }
}