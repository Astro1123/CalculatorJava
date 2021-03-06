package calc;

import calc.makelist.*;
import calc.rpn.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

class Calculator extends JFrame implements KeyListener, ActionListener, ItemListener {
	String title;
	JPanel cardPanel;
	CardLayout layout;
	JPanel cardUnit;
	CardLayout cardUnitlayout;
	JComboBox<String> combo;
	JComboBox<String> comboc5;
	JComboBox<String> combounit;
	static Calculator frame;
	JFrame frame2;
    String strlistLen[] = {"m","km","cm","mm","μm","nm","pm","fm","Å","ly","au","pc","kpc","Mpc","Gpc","inch","feet","yard","mile","nautical mile","寸","尺","間","尋","町","里"};
    String strlistTemp[] = {"℃","℉","K"};
    String strlistMass[] = {"g","kg","t","mg","eV/c^2","keV/c^2","MeV/c^2","GeV/c^2","lb","oz","ct","momme","貫","斤"};
    String strlistTime[] = {"s","min","h","day","week","month","year","solar year","Julian year","Gregorian year"};
    String strlistAngle[] = {"deg","arcmin","arcsec","rad","grad","mil","percent","permil"};
    String strlistSAngle[] = {"sr","deg^2"};
    String strlistForce[] = {"N","dyn","kgf"};
    String strlistRatio[] = {"%","1","‰","ppm","ppb"};
    String strlistVelocity[] = {"m/s","km/h","feet/s","mile/h","kn","Mach","c"};
    String strlistEnergy[] = {"J","erg","kWh","cal","kcal","cal I.T.","kcal I.T.","eV"};
    String strlistPress[] = {"Pa","hPa","bar","atm","at","mH2O","mmH2O","cmH2O","inH2O","feetH2O","mmHg","Torr","mHg","cmHg","inHg","psi"};
    String strlistArea[] = {"m^2","cm^2","mm^2","km^2","a","ha","sq inch","sq feet","sq yard","sq mile","acre","rood","坪","畝","反","町(Area)"};
    String strlistVolume[] = {"m^3","cm^3","mm^3","km^3","cc","kL","L","mL","cu inch","cu feet","acre feet","gal","U.S. fluid gallon","Imperial gallon","U.S. dry gallon","bbl","勺","合","升","斗","石"};
    String strlistSIp[] = {"1","da","h","k","M","G","T","P","E","Z","Y","d","c","m","μ","n","p","f","a","z","y"};
    JComboBox<String> combo1Temp;
    JComboBox<String> combo2Temp;
    JComboBox<String> combo1Len;
    JComboBox<String> combo2Len;
    JComboBox<String> combo1Time;
    JComboBox<String> combo2Time;
    JComboBox<String> combo1Mass;
    JComboBox<String> combo2Mass;
    JComboBox<String> combo1Angle;
    JComboBox<String> combo2Angle;
    JComboBox<String> combo1SAngle;
    JComboBox<String> combo2SAngle;
    JComboBox<String> combo1Force;
    JComboBox<String> combo2Force;
    JComboBox<String> combo1Ratio;
    JComboBox<String> combo2Ratio;
    JComboBox<String> combo1Velocity;
    JComboBox<String> combo2Velocity;
    JComboBox<String> combo1Energy;
    JComboBox<String> combo2Energy;
    JComboBox<String> combo1Press;
    JComboBox<String> combo2Press;
    JComboBox<String> combo1Area;
    JComboBox<String> combo2Area;
    JComboBox<String> combo1Volume;
    JComboBox<String> combo2Volume;
    JComboBox<String> combo1SIp;
    JComboBox<String> combo2SIp;
	String combodata[] = {"Standard", "Scientific", "Area", "Script", "Solve","Programmer","Unit","Table","Graph"};
	String combodataunit[] = {"Length","Mass","Time","Temperature","Angle","Solid Angle","Force","Ratio","Velocity","Energy","Pressure","Area","Volume","SI prefixes"};
	String pcombodata[] = {"HEX","DEC","OCT","BIN"};
	String combodatac5[] = {"NewtonModified", "Newton", "FalsePosition"};
	Deque<String> PushList;
	ArrayList<String> list;
	ArrayList<String> typelist;
    boolean inputnum = false;
    boolean inputid = false;
    boolean inputeq = false;
    boolean inputmem = false;
    boolean inputop = true;
    double memory = 0,ans = 0;
    StringBuilder sb;
    JTextField text1;
    JTextField text7;
    JTextArea texta1;
    JTextArea textc3;
    JTextArea textc4;
    JTextArea textc5;
    JTextField textc5in1;
    JTextField textc5in2;
    JTextField textc5in3;
    JTextField textc8in1;
    JTextField textc8in2;
    JTextField textc8in3;
    JTextField textc8in4;
    JTextArea textc8;
    JTextField textc9in1;
    JTextField textc9in2;
    JTextField textc9in3;
    JTextField textc9in4;
    JTextArea texta6;
    JComboBox<String> pcombo;
    JButton pbtn00;
    JButton pbtn0;
    JButton pbtn1;
    JButton pbtn2;
    JButton pbtn3;
    JButton pbtn4;
    JButton pbtn5;
    JButton pbtn6;
    JButton pbtn7;
    JButton pbtn8;
    JButton pbtn9;
    JButton pbtnA;
    JButton pbtnB;
    JButton pbtnC;
    JButton pbtnD;
    JButton pbtnE;
    JButton pbtnF;
    JPanel p7;
    Object pcomboselected;
    ArrayList<Double> graphout = new ArrayList<Double>();
    GCanvas canv;
	
    public static void main(String args[]){
        frame = new Calculator();
        frame.setVisible(true);
    }

    Calculator() {
        frame2 = GWindow();
        
        setBounds(100, 100, 640, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PushList = new ArrayDeque<>();
        sb = new StringBuilder();
        
        title = combodata[0];
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel card4 = new JPanel();
        JPanel card5 = new JPanel();
        JPanel card6 = new JPanel();
        JPanel card7 = new JPanel();
        JPanel card8 = new JPanel();
        JPanel card9 = new JPanel();
        
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(card1, combodata[0]);
        cardPanel.add(card2, combodata[1]);
        cardPanel.add(card3, combodata[2]);
        cardPanel.add(card4, combodata[3]);
        cardPanel.add(card5, combodata[4]);
        cardPanel.add(card6, combodata[5]);
        cardPanel.add(card7, combodata[6]);
        cardPanel.add(card8, combodata[7]);
        cardPanel.add(card9, combodata[8]);
        
        JPanel p0 = new JPanel();
        p0.setLayout(new FlowLayout());
        JButton quitbtn = new JButton("Quit");
        quitbtn.addActionListener(this);
        quitbtn.setActionCommand("Quit");
        //JButton changebtn = new JButton("Change");
        //changebtn.addActionListener(this);
        //changebtn.setActionCommand("Change");
        combo = new JComboBox<>(combodata);
        combo.addItemListener(this);
        //combo.setEnabled(false);
        
        p0.add(quitbtn);
        p0.add(combo);
        //p0.add(changebtn);
        
        JPanel pt = new JPanel();
        pt.setLayout(new BorderLayout());
        JPanel ptt = new JPanel();
        ptt.setLayout(new FlowLayout());
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JPanel pp = new JPanel();
        pp.setLayout(new BorderLayout());
        text1 = new JTextField("0", 35);
        text1.setEditable(false);
        texta1 = new JTextArea("",2,35);
        texta1.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(texta1);
        //text1.setText("1");
        pt.add(ptt, BorderLayout.NORTH);
        pt.add(p, BorderLayout.CENTER);
        
        p.add(pp);
        pp.add(text1,BorderLayout.CENTER);
        pp.add(scrollpane,BorderLayout.NORTH);
        Draw draw = new Draw();
        
        JPanel p1 = draw.dc1(this);
        card1.add(p1);
        
        JPanel p2 = draw.dc2(this);    
        card2.add(p2);
        
        JPanel p3 = draw.dc3(this);
        card3.add(p3);
        
        JPanel p4 = draw.dc4(this);
        card4.add(p4);
        
        JPanel p5 = draw.dc5(this);
        card5.add(p5);
        
        JPanel p6 = draw.dc6(this);
        card6.add(p6);
        
        p7 = draw.dc7(this);
        card7.add(p7);
        
        JPanel p8 = draw.dc8(this);
        card8.add(p8);
        
        JPanel p9 = draw.dc9(this);
        card9.add(p9);
        
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(pt, BorderLayout.NORTH);
        getContentPane().add(p0, BorderLayout.SOUTH);
        setTitle(title);
        
        //setFocusable(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String str,str2;
        String conststr = "(pi|e|c|g|G|h|hbar|k|e0)";
        String operatorstr = "(\\+|-|\\*|/|%|\\^|//|%%|SL|SR|SRNS|AND|OR|XOR|XNOR)";
        String shiftopstr = "(SL|SR|SRNS)";
        String numberstr = "(00|[0-9A-F]|\\.)";
        String funcstr = "(mod|mod2|round|int|revn|rinf|ceil|floor|sum|abs|sqrt|exp|sin|cos|tan|asin|acos|atan|fact|atan2|rad|deg|log|tenexp|H|C|P|lcm|gcd|fibonacci|NOT|percent|fib|pc)";
        BufferedReader br;
	    SignSymbols ss = new SignSymbols();
        MakeScript ms = new MakeScript();
        MakeList ml = new MakeList();
        Process pro = new Process();

        if (cmd.equals("Quit")) {
            System.exit(0);
        } else if (cmd.equals("GraphOpen")) {
            GWindowRepaint(pro.graphequal(this, textc9in1.getText(), Double.parseDouble(textc9in2.getText()), Double.parseDouble(textc9in3.getText()), Integer.parseInt(textc9in4.getText())));
            frame2.setVisible(true);
            return;
        } else if (cmd.equals("GraphClose")) {
            frame2.setVisible(false);
            return;
        } else if (cmd.equals("SolveCard5")) {
            pro.solveequal(this, textc5in1.getText(), Double.parseDouble(textc5in2.getText()), Double.parseDouble(textc5in3.getText()),(String)comboc5.getSelectedItem());
            return;
        } else if (cmd.equals("SolveCard8")) {
            pro.tableequal(this, textc8in1.getText(), Double.parseDouble(textc8in2.getText()), Double.parseDouble(textc8in3.getText()), Integer.parseInt(textc8in4.getText()));
            return;
        } else if (cmd.equals("OpenFileCard4")) {
            pro.openFile(this, textc4);
        } else if (cmd.equals("SaveFileCard4")) {
            pro.saveFile(this, textc4);
        } else if (cmd.equals("DeleteTextCard4")) {
            textc4.setText("");
        } else if (cmd.equals("EnterTextCard4")) {
            str = textc4.getText(); 
            texta1.setText(pro.equalcalc(this,str));
            return;
        } else if (cmd.equals("EnterUnit")) {
            str = text7.getText();
            str2 = (String)combounit.getSelectedItem();
            pro.equalunit(this,str,str2);
            return;
        } else if (cmd.equals("SaveFileCard3")) {
            pro.saveFile(this, textc3);
        } else if (cmd.equals("OpenFileCard3")) {
            pro.openFile(this, textc3);
        } else if (cmd.equals("DeleteTextCard3")) {
            textc3.setText("");
        } else if (cmd.equals("EnterTextCard3")) {
            pro.equalarea(this,textc3.getText().replace(","," "));
            return;
        } else if (cmd.equals("MP")) {
            memplus(this,Double.parseDouble(sb.toString()));
        } else if (cmd.equals("MM")) {
            memplus(this,-Double.parseDouble(sb.toString()));
        } else if (cmd.equals("MR")) {
            inputeq = false;
            inputnum = true;
            inputid = false;
            inputmem = true;
            inputop = false;
            sb.delete(0, sb.length());
            sb.append(String.valueOf(memory));
            text1.setText(sb.toString());
        } else if (cmd.equals("MC")) {
            memory = 0;
        } else if (cmd.equals("AC")) {
            AllClear(this);
        } else if (cmd.equals("Cl")) {
            setClear(this,text1);
        } else if (cmd.equals("BS")) {
            inputmem = false;
            sb.delete(sb.length()-1, sb.length());
            text1.setText(sb.toString());
        } else if (cmd.equals("ans")) {
                eqnext(this);
                numnext(this);
                inputop = false;
                PushList.add(String.valueOf(ans));
                text1.setText(String.valueOf(ans));
        } else if (cmd.equals("=")) {
            numnext(this);
            inputnum = false;
            inputid = false;
            inputeq = true;
            inputmem = false;
            inputop = true;
            
            if (PushList.getLast().matches(operatorstr)) {
                if (PushList.getLast().matches(shiftopstr)) PushList.addLast("1");
                else PushList.addLast(text1.getText());
            }
            list = ml.makeList(PushList);
            //System.out.println(list);
            if (combo.getSelectedItem().equals("Programmer")) pro.equalcalc(this,ms.makeScript(list),pcombo.getSelectedItem().toString(),true);
            else pro.equalcalc(this,ms.makeScript(list));
            return;
        } else {
            if (cmd.matches(operatorstr)) {
                numnext(this);
                eqnext(this);
                inputid = false;
                inputop = true;
                if (PushList.size() == 0) {
                        PushList.add(text1.getText());
                        PushList.add(cmd);
                } else {
                    if (PushList.peekLast().matches(operatorstr)) {
                        PushList.pollLast();
                        PushList.add(cmd);
                    } else {
                        PushList.add(cmd);
                    }
                }
            } else if (cmd.equals("pm")) {
                eqnext(this);
                numnext(this);
                if (PushList.size() == 0) PushList.add("0");
                if (PushList.peekLast().equals("pm")) {
                    PushList.pollLast();
                } else {
                    inputid=true;
                    inputop = false;
                    PushList.add(cmd);
                }
            } else if (cmd.matches(conststr)) {                 // 定数
                eqnext(this);
                numnext(this);
                inputop = false;
                PushList.add(cmd);
                text1.setText(cmd);
            } else if (cmd.equals("(") || cmd.equals(")")) {
                eqnext(this);
                numnext(this);
                inputop = false;
                PushList.add(cmd);
            } else if(cmd.matches(numberstr)) {               // 数
                eqnext(this);
                if (inputmem == true) sb.delete(0, sb.length());
                if (inputid == false) {
                    if (cmd.equals("00") && sb.toString().equals("")) {
                        sb.append("0");
                    } else if ((cmd.equals("00") || cmd.equals("0") ) && sb.toString().equals("0")) {
                        sb.append("");
                    } else if (cmd.equals("1") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("2") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("3") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("4") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("5") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("6") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("7") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("8") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else if (cmd.equals("9") && sb.toString().equals("0")) {
                        sb.delete(0, sb.length());
                        sb.append(cmd);
                    } else {
                        sb.append(cmd);
                    }
                    text1.setText(sb.toString());
                    inputnum = true;
                    inputeq = false;
                    inputop = false;
                }
                if (combo.getSelectedItem().equals("Programmer")) {
                    pcomboselected = pcombo.getSelectedItem();
                }
        	} else if (cmd.equals("percent")) {
        		if (inputnum == true) {
                	eqnext(this);
                	numnext(this);
                	inputid=true;
                	inputeq = false;
        			inputnum = false;
                    inputop = false;
                	PushList.add(cmd);
        		}
        	} else if (cmd.matches(funcstr)) {
        	    if (inputop==true) PushList.add("0");
                eqnext(this);
                numnext(this);
                inputid=true;
                inputeq = false;
                inputop = false;
                PushList.add(cmd);
            } else {
                eqnext(this);
                numnext(this);
                inputid=true;
                inputeq = false;
                inputop = false;
                PushList.add(cmd);
            }
            inputmem = false;
        }
        ArrayDeque<String> Pushlistc = new ArrayDeque<String>(PushList);
        Pushlistc.add(sb.toString());
        texta1.setText(ms.makeScript(ms.replacepm(ml.makeList(Pushlistc))).replace(" ",""));
    }
    
    public void itemStateChanged(ItemEvent e) {
        String conststr = "(pi|e|c|g|G|h|hbar|k|e0)";
        String operatorstr = "(\\+|-|\\*|/|%|\\^|//|%%|SL|SR|SRNS|AND|OR|XOR|XNOR)";
        String shiftopstr = "(SL|SR|SRNS)";
        String numberstr = "(00|[0-9A-F]|\\.)";
        String funcstr = "(mod|mod2|round|int|revn|rinf|ceil|floor|sum|abs|sqrt|exp|sin|cos|tan|asin|acos|atan|fact|atan2|rad|deg|log|tenexp|H|C|P|lcm|gcd|fibonacci|NOT)";
        BufferedReader br;
	    SignSymbols ss = new SignSymbols();
        MakeScript ms = new MakeScript();
        MakeList ml = new MakeList();
        Process pro = new Process();
        Draw draw = new Draw();
        if (e.getItemSelectable() == combo) {
            texta1.setText("");
            text1.setText("0");
            PushList.clear();
            inputid = false;
            inputeq = true;
            setClear(this,text1);
            String str = (String)combo.getSelectedItem();
            layout.show(cardPanel, str);
            frame.setTitle(title = str);
        } else if (e.getItemSelectable() == pcombo) {
            numnext(this, pcomboselected);
                if (PushList.size()==0) {
                    if (inputnum == true) {
                        System.out.println(text1.getText());
                        if (pcombo.getSelectedItem().equals("HEX")) {
                            PushList.add(String.valueOf(Integer.parseInt(text1.getText(),16)));
                        } else if (pcombo.getSelectedItem().equals("DEC")) {
                            PushList.add(String.valueOf(Integer.parseInt(text1.getText(),10)));
                        } else if (pcombo.getSelectedItem().equals("OCT")) {
                            PushList.add(String.valueOf(Integer.parseInt(text1.getText(),8)));
                        } else if (pcombo.getSelectedItem().equals("BIN")) {
                            PushList.add(String.valueOf(Integer.parseInt(text1.getText(),2)));
                        }
                        inputnum = false;
                    } else {
                        PushList.add(String.valueOf(ans));
                    }
                }
            inputid = false;
            inputmem = false;
            inputop = true;
            inputeq = true;
            if (PushList.getLast().matches(operatorstr)) {
                if (PushList.getLast().matches(shiftopstr)) PushList.addLast("1");
                else PushList.addLast(text1.getText());
            }
            list = ml.makeList(PushList);
            //System.out.println(list);
            pro.equalcalc(this,ms.makeScript(list),pcombo.getSelectedItem().toString(),false);
            btnenabled(this,pcombo.getSelectedItem());
        } else if (e.getItemSelectable() == combounit) {
            String str = (String)combounit.getSelectedItem();
            cardUnitlayout.show(cardUnit, str);
        }
    }
    
    private void btnenabled(Calculator calc, Object str) {
        if (str.equals("HEX")) {
            calc.pbtn00.setEnabled(true);
            calc.pbtn0.setEnabled(true);
            calc.pbtn1.setEnabled(true);
            calc.pbtn2.setEnabled(true);
            calc.pbtn3.setEnabled(true);
            calc.pbtn4.setEnabled(true);
            calc.pbtn5.setEnabled(true);
            calc.pbtn6.setEnabled(true);
            calc.pbtn7.setEnabled(true);
            calc.pbtn8.setEnabled(true);
    	    calc.pbtn9.setEnabled(true);
            calc.pbtnA.setEnabled(true);
	        calc.pbtnB.setEnabled(true);
    	    calc.pbtnC.setEnabled(true);
    	    calc.pbtnD.setEnabled(true);
            calc.pbtnE.setEnabled(true);
	        calc.pbtnF.setEnabled(true);
    	} else if (str.equals("DEC")) {
    	    calc.pbtn00.setEnabled(true);
    	    calc.pbtn0.setEnabled(true);
    	    calc.pbtn1.setEnabled(true);
    	    calc.pbtn2.setEnabled(true);
    	    calc.pbtn3.setEnabled(true);
    	    calc.pbtn4.setEnabled(true);
    	    calc.pbtn5.setEnabled(true);
    	    calc.pbtn6.setEnabled(true);
    	    calc.pbtn7.setEnabled(true);
    	    calc.pbtn8.setEnabled(true);
    	    calc.pbtn9.setEnabled(true);
    	    calc.pbtnA.setEnabled(false);
    	    calc.pbtnB.setEnabled(false);
    	    calc.pbtnC.setEnabled(false);
    	    calc.pbtnD.setEnabled(false);
    	    calc.pbtnE.setEnabled(false);
    	    calc.pbtnF.setEnabled(false);
    	} else if (str.equals("OCT")) {
    	    calc.pbtn00.setEnabled(true);
    	    calc.pbtn0.setEnabled(true);
    	    calc.pbtn1.setEnabled(true);
    	    calc.pbtn2.setEnabled(true);
    	    calc.pbtn3.setEnabled(true);
    	    calc.pbtn4.setEnabled(true);
    	    calc.pbtn5.setEnabled(true);
    	    calc.pbtn6.setEnabled(true);
    	    calc.pbtn7.setEnabled(true);
    	    calc.pbtn8.setEnabled(false);
    	    calc.pbtn9.setEnabled(false);
    	    calc.pbtnA.setEnabled(false);
    	    calc.pbtnB.setEnabled(false);
    	    calc.pbtnC.setEnabled(false);
    	    calc.pbtnD.setEnabled(false);
    	    calc.pbtnE.setEnabled(false);
    	    calc.pbtnF.setEnabled(false);
    	} else if (str.equals("BIN")) {
    	    calc.pbtn00.setEnabled(true);
    	    calc.pbtn0.setEnabled(true);
    	    calc.pbtn1.setEnabled(true);
    	    calc.pbtn2.setEnabled(false);
    	    calc.pbtn3.setEnabled(false);
    	    calc.pbtn4.setEnabled(false);
    	    calc.pbtn5.setEnabled(false);
    	    calc.pbtn6.setEnabled(false);
    	    calc.pbtn7.setEnabled(false);
    	    calc.pbtn8.setEnabled(false);
    	    calc.pbtn9.setEnabled(false);
    	    calc.pbtnA.setEnabled(false);
            calc.pbtnB.setEnabled(false);
    	    calc.pbtnC.setEnabled(false);
    	    calc.pbtnD.setEnabled(false);
    	    calc.pbtnE.setEnabled(false);
    	    calc.pbtnF.setEnabled(false);
    	}
    }
    
    private void numnext(Calculator calc) {
        if (calc.inputnum == true) {
            calc.PushList.add(calc.sb.toString());
            calc.sb.delete(0, calc.sb.length());
            calc.inputnum = false;
            calc.inputeq = false;
        }
    }
    
    private void numnext(Calculator calc, Object str) {
        if (calc.inputnum == true) {
            if (str.equals("HEX")) {
                calc.PushList.add(String.valueOf(Integer.parseInt(calc.sb.toString(),16)));
            } else if (str.equals("OCT")) {
                calc.PushList.add(String.valueOf(Integer.parseInt(calc.sb.toString(),8)));
            } else if (str.equals("BIN")) {
                calc.PushList.add(String.valueOf(Integer.parseInt(calc.sb.toString(),2)));
            } else {
                calc.PushList.add(calc.sb.toString());
            }
            calc.sb.delete(0, calc.sb.length());
            calc.inputnum = false;
            calc.inputeq = false;
        }
  }
  
    private void eqnext(Calculator calc) {
        if (calc.inputeq == true) {
            calc.inputeq = false;
            calc.sb.delete(0, calc.sb.length());
            calc.inputnum = false;
        }
  }
  
  private void setClear(Calculator calc, JTextField text) {
        calc.inputnum = false;
        calc.inputmem = false;
        calc.sb.delete(0, calc.sb.length());
        text.setText("0");
  }
  
  private void memplus(Calculator calc, double p1) {
        calc.inputeq = false;
        calc.inputnum = false;
        calc.inputid = false;
        calc.inputmem = true;
        calc.memory += p1;
    }
    
    private void AllClear(Calculator calc) {
            calc.PushList.clear();
            calc.inputnum = false;
            calc.inputid = false;
            calc.inputeq = true;
            calc.inputmem = false;
            calc.inputop = true;
            setClear(calc,text1);
    }
    
    @Override
	public void keyTyped(KeyEvent e) {
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
        Process pro = new Process();
		switch ( e.getKeyCode() ) {
		case KeyEvent.VK_ENTER:
			//System.out.println("Enterが押されました");
            String str = textc4.getText(); 
            texta1.setText(pro.equalcalc(this,str));
			break;
		case KeyEvent.VK_ESCAPE:
            textc4.setText("");
			break;
		}
	}
 
	@Override
	public void keyReleased(KeyEvent e) {
	}

    private JFrame GWindow() {
        JFrame frame2 = new JFrame();
        frame2.setTitle("Graph");
        frame2.setBounds(150, 150, 640, 500);
        frame2.setResizable(false);
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        frame2.add(p);
        
        canv = new GCanvas();
        p.add(canv, BorderLayout.CENTER);
        JButton btn = new JButton("Close");
        btn.addActionListener(this);
        btn.setActionCommand("GraphClose");
        p.add(btn, BorderLayout.SOUTH);
        
        return frame2;
    }

    private void GWindowRepaint(ArrayList<Double> data) {
        canv.rp(data);
    }
    
    static class GCanvas extends Canvas {
        Dimension dimension;
        int cnt;
        ArrayList<Double> x;
        ArrayList<Double> y;
        double xmin,ymin,xmax,ymax;
        
        GCanvas() {
            dimension = getSize();
            setBackground(Color.lightGray);
            
            x = new ArrayList<>();
            y = new ArrayList<>();
        }
        
        void rp(ArrayList<Double> data) {
            x = new ArrayList<>();
            y = new ArrayList<>();
            ymin=data.get(2);
            ymax=data.get(2);
            double z;
            
            cnt = (int)Double.parseDouble(String.valueOf(data.get(0)));
            for (int i = 0; i < cnt; i++) {
                x.add(data.get(2*i+1));
                z = data.get(2*i+2);
                y.add(z);
                if (ymin > z) {
                    ymin = z;
                }
                if (ymax < z) {
                    ymax = z;
                }
            }
            xmin = x.get(0);
            xmax = x.get(x.size()-1);
            
            if ((ymax - ymin) < 0.001) {
                ymax += 1;
                ymin -= 1;
            }
            
            if ((xmax - xmin) < 0.001) {
                xmax += 1;
                xmin -= 1;
            }
            //*/
            repaint();
        }
        
        private double yc(double y) {
            return dimension.height - (y - ymin)/(ymax-ymin)*(dimension.height-20) - 10;
        }
        
        private double xc(double x) {
            return (x - xmin)/(xmax-xmin)*(dimension.width-20) + 10;
        }
        /*
        private double xc(int x) {
            return dimension.width / 2.0 + x;
        }//*/
        
        public void paint(Graphics g) {
            dimension = getSize();
            
            g.setColor(Color.white);
            g.fillRect(10, 10, dimension.width - 20, dimension.height - 20);
            
            //軸の色は黒
            g.setColor(Color.black);
            //x軸
            g.drawLine((int)xc(xmin),(int)yc(0),(int)xc(xmax),(int)yc(0));
            //y軸
            g.drawLine((int)xc(0),(int)yc(ymin),(int)xc(0),(int)yc(ymax));
            
            double dx = (xmax-xmin) / 4;
            double dy = (ymax-ymin) / 4;
            
            g.drawLine((int)xc(0)-2,(int)yc(ymin),(int)xc(0)+2,(int)yc(ymin));
            g.drawLine((int)xc(0)-2,(int)yc(ymin + dy),(int)xc(0)+2,(int)yc(ymin + dy));
            g.drawLine((int)xc(0)-2,(int)yc(ymin + dy * 2),(int)xc(0)+2,(int)yc(ymin + dy * 2));
            g.drawLine((int)xc(0)-2,(int)yc(ymin + dy * 3),(int)xc(0)+2,(int)yc(ymin + dy * 3));
            g.drawLine((int)xc(0)-2,(int)yc(ymin + dy * 4),(int)xc(0)+2,(int)yc(ymin + dy * 4));
            
            g.drawLine((int)xc(xmin),(int)yc(0)-2,(int)xc(xmin),(int)yc(0)+2);
            g.drawLine((int)xc(xmin + dx),(int)yc(0)-2,(int)xc(xmin + dx),(int)yc(0)+2);
            g.drawLine((int)xc(xmin + dx * 2),(int)yc(0)-2,(int)xc(xmin + dx * 2),(int)yc(0)+2);
            g.drawLine((int)xc(xmin + dx * 3),(int)yc(0)-2,(int)xc(xmin + dx * 3),(int)yc(0)+2);
            g.drawLine((int)xc(xmin + dx * 4),(int)yc(0)-2,(int)xc(xmin + dx * 4),(int)yc(0)+2);
            
            DecimalFormat format = new DecimalFormat("0.######");
            
            if (yc(0) > dimension.height-10) {
                g.drawLine((int)xc(xmin),dimension.height-12,(int)xc(xmin),dimension.height-8);
                g.drawLine((int)xc(xmin + dx),dimension.height-12,(int)xc(xmin + dx),dimension.height-8);
                g.drawLine((int)xc(xmin + dx * 2),dimension.height-12,(int)xc(xmin + dx * 2),dimension.height-8);
                g.drawLine((int)xc(xmin + dx * 3),dimension.height-12,(int)xc(xmin + dx * 3),dimension.height-8);
                g.drawLine((int)xc(xmin + dx * 4),dimension.height-12,(int)xc(xmin + dx * 4),dimension.height-8);
                g.drawLine((int)xc(xmin),dimension.height-10,(int)xc(xmax),dimension.height-10);
                
                if (!(format.format(xmin).equals("0")))
                    g.drawString(format.format(xmin), (int)xc(xmin), dimension.height-15);
                if (!(format.format(xmin+dx).equals("0")))
                    g.drawString(format.format(xmin + dx), (int)xc(xmin + dx), dimension.height-15);
                if (!(format.format(xmin+dx*2).equals("0")))
                    g.drawString(format.format(xmin+2*dx), (int)xc(xmin+2*dx), dimension.height-15);
                if (!(format.format(xmin+dx*3).equals("0")))
                    g.drawString(format.format(xmin+3*dx), (int)xc(xmin+3*dx), dimension.height-15);
                if (!(format.format(xmin+dx*4).equals("0")))
                    g.drawString(format.format(xmin+4*dx), (int)xc(xmin+4*dx)-20, dimension.height-15);
            } else if (yc(0)+25 > dimension.height) {
                g.drawString("O", (int)xc(0)+5, (int)yc(0)-5);
                
                if (!(format.format(xmin).equals("0")))
                    g.drawString(format.format(xmin), (int)xc(xmin), (int)yc(0)-5);
                if (!(format.format(xmin+dx).equals("0")))
                    g.drawString(format.format(xmin + dx), (int)xc(xmin + dx), (int)yc(0)-5);
                if (!(format.format(xmin+dx*2).equals("0")))
                    g.drawString(format.format(xmin + 2*dx), (int)xc(xmin + 2*dx), (int)yc(0)-5);
                if (!(format.format(xmin+dx*3).equals("0")))
                    g.drawString(format.format(xmin + 3*dx), (int)xc(xmin + 3*dx), (int)yc(0)-5);
                if (!(format.format(xmin+dx*4).equals("0")))
                    g.drawString(format.format(xmin + 4*dx), (int)xc(xmin + 4*dx)-20, (int)yc(0)-5);
            } else if (yc(0) < 10) {
                g.drawLine((int)xc(xmin),8,(int)xc(xmin),12);
                g.drawLine((int)xc(xmin + dx),8,(int)xc(xmin + dx),12);
                g.drawLine((int)xc(xmin + dx * 2),8,(int)xc(xmin + dx * 2),12);
                g.drawLine((int)xc(xmin + dx * 3),8,(int)xc(xmin + dx * 3),12);
                g.drawLine((int)xc(xmin + dx * 4),8,(int)xc(xmin + dx * 4),12);
                g.drawLine((int)xc(xmin),10,(int)xc(xmax),10);
                
                if (!(format.format(xmin).equals("0")))
                    g.drawString(format.format(xmin), (int)xc(xmin), 25);
                if (!(format.format(xmin+dx).equals("0")))
                    g.drawString(format.format(xmin + dx), (int)xc(xmin + dx), 25);
                if (!(format.format(xmin+dx*2).equals("0")))
                    g.drawString(format.format(xmin + 2*dx), (int)xc(xmin + 2*dx), 25);
                if (!(format.format(xmin+dx*3).equals("0")))
                    g.drawString(format.format(xmin + 3*dx), (int)xc(xmin + 3*dx), 25);
                if (!(format.format(xmin+dx*4).equals("0")))
                    g.drawString(format.format(xmin + 4*dx), (int)xc(xmin + 4*dx)-20, 25);
            } else {
                g.drawString("O", (int)xc(0)+5, (int)yc(0)+15);
                
                if (!(format.format(xmin).equals("0")))
                    g.drawString(format.format(xmin), (int)xc(xmin), (int)yc(0)+15);
                if (!(format.format(xmin+dx).equals("0")))
                    g.drawString(format.format(xmin + dx), (int)xc(xmin + dx), (int)yc(0)+15);
                if (!(format.format(xmin+dx*2).equals("0")))
                    g.drawString(format.format(xmin + 2*dx), (int)xc(xmin + 2*dx), (int)yc(0)+15);
                if (!(format.format(xmin+dx*3).equals("0")))
                    g.drawString(format.format(xmin + 3*dx), (int)xc(xmin + 3*dx), (int)yc(0)+15);
                if (!(format.format(xmin+dx*4).equals("0")))
                    g.drawString(format.format(xmin + 4*dx), (int)xc(xmin + 4*dx)-20, (int)yc(0)+15);
            }
            
            if (xc(0) > dimension.width-10) {
                g.drawLine(dimension.width-10,(int)yc(ymin),dimension.width-10,(int)yc(ymax));
                g.drawLine(dimension.width-12,(int)yc(ymin),dimension.width-8,(int)yc(ymin));
                g.drawLine(dimension.width-12,(int)yc(ymin + dy),dimension.width-8,(int)yc(ymin + dy));
                g.drawLine(dimension.width-12,(int)yc(ymin + dy * 2),dimension.width-8,(int)yc(ymin + dy * 2));
                g.drawLine(dimension.width-12,(int)yc(ymin + dy * 3),dimension.width-8,(int)yc(ymin + dy * 3));
                g.drawLine(dimension.width-12,(int)yc(ymin + dy * 4),dimension.width-8,(int)yc(ymin + dy * 4));
                if (!(format.format(ymin+dy*4).equals("0")))
                    g.drawString(format.format(ymin + 4*dy), dimension.width-30, (int)yc(ymin + 4*dy)+15);
                if (!(format.format(ymin+dy*3).equals("0")))
                    g.drawString(format.format(ymin + 3*dy), dimension.width-30, (int)yc(ymin + 3*dy)+10);
                if (!(format.format(ymin+dy*2).equals("0")))
                    g.drawString(format.format(ymin + 2*dy), dimension.width-30, (int)yc(ymin + 2*dy)+10);
                if (!(format.format(ymin+dy*1).equals("0")))
                    g.drawString(format.format(ymin + dy), dimension.width-30, (int)yc(ymin + dy)+10);
                if (!(format.format(ymin).equals("0")))
                    g.drawString(format.format(ymin), dimension.width-30, (int)yc(ymin)-5);
            } else if (xc(0) < 10) {
                g.drawLine(10,(int)yc(ymin),10,(int)yc(ymax));
                g.drawLine(8,(int)yc(ymin),12,(int)yc(ymin));
                g.drawLine(8,(int)yc(ymin + dy),12,(int)yc(ymin + dy));
                g.drawLine(8,(int)yc(ymin + dy * 2),12,(int)yc(ymin + dy * 2));
                g.drawLine(8,(int)yc(ymin + dy * 3),12,(int)yc(ymin + dy * 3));
                g.drawLine(8,(int)yc(ymin + dy * 4),12,(int)yc(ymin + dy * 4));
                
                if (!(format.format(ymin+dy*4).equals("0")))
                    g.drawString(format.format(ymin + 4*dy), 15, (int)yc(ymin + 4*dy)+15);
                if (!(format.format(ymin+dy*3).equals("0")))
                    g.drawString(format.format(ymin + 3*dy), 15, (int)yc(ymin + 3*dy)+10);
                if (!(format.format(ymin+dy*2).equals("0")))
                    g.drawString(format.format(ymin + 2*dy), 15, (int)yc(ymin + 2*dy)+10);
                if (!(format.format(ymin+dy*1).equals("0")))
                    g.drawString(format.format(ymin + dy), 15, (int)yc(ymin + dy)+10);
                if (!(format.format(ymin).equals("0")))
                    g.drawString(format.format(ymin), 15, (int)yc(ymin)-5);
            } else {
                if (!(format.format(ymin+dy*4).equals("0")))
                    g.drawString(format.format(ymin + 4*dy), (int)xc(0)+5, (int)yc(ymin + 4*dy)+15);
                if (!(format.format(ymin+dy*3).equals("0")))
                    g.drawString(format.format(ymin + 3*dy), (int)xc(0)+5, (int)yc(ymin + 3*dy)+10);
                if (!(format.format(ymin+dy*2).equals("0")))
                    g.drawString(format.format(ymin + 2*dy), (int)xc(0)+5, (int)yc(ymin + 2*dy)+10);
                if (!(format.format(ymin+dy*1).equals("0")))
                    g.drawString(format.format(ymin + dy), (int)xc(0)+5, (int)yc(ymin + dy)+10);
                if (!(format.format(ymin).equals("0")))
                    g.drawString(format.format(ymin), (int)xc(0)+5, (int)yc(ymin)-5);
            }
            
            
            g.setColor(Color.blue);
            for(int i=0;i<x.size()-1;i++) {
                g.drawLine( (int)(xc(x.get(i))), (int)(yc(y.get(i))), (int)(xc(x.get(i+1))), (int)(yc(y.get(i+1))) );
            }
        }
    }
}