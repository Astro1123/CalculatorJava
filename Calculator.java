import makelist.*;
import rpn.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;

class Calculator extends JFrame implements ActionListener, ItemListener {
	String title;
	JPanel cardPanel;
	CardLayout layout;
	JComboBox<String> combo;
	JComboBox<String> comboc5;
	static Calculator frame;
	String combodata[] = {"Standard", "Scientific", "Area", "Script", "Solve"};
	String combodatac5[] = {"NewtonModified", "Newton", "FalsePosition"};
	Deque<String> PushList;
	ArrayList<String> list;
	ArrayList<String> typelist;
    boolean inputnum = false;
    boolean inputid = false;
    boolean inputeq = false;
    boolean inputmem = false;
    double memory = 0,ans = 0;
    StringBuilder sb;
    JTextField text1;
    JTextArea textc3;
    JTextArea textc3ans;
    JTextArea textc4;
    JTextField textc5in1;
    JTextField textc5in2;
    JTextField textc5in3;
    JTextArea textc5ans;
	
    public static void main(String args[]){
        frame = new Calculator();
        frame.setVisible(true);
    }

    Calculator() {
        setBounds(100, 100, 640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PushList = new ArrayDeque<>();
        sb = new StringBuilder();
        
        title = combodata[0];
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel card4 = new JPanel();
        JPanel card5 = new JPanel();
        
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(card1, combodata[0]);
        cardPanel.add(card2, combodata[1]);
        cardPanel.add(card3, combodata[2]);
        cardPanel.add(card4, combodata[3]);
        cardPanel.add(card5, combodata[4]);
        
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
        text1 = new JTextField("0", 30);
        text1.setEditable(false);
        text1.setHorizontalAlignment(JTextField.RIGHT);
        //text1.setText("1");
        pt.add(ptt, BorderLayout.NORTH);
        pt.add(p, BorderLayout.CENTER);
        
        p.add(text1);
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
        
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(pt, BorderLayout.NORTH);
        getContentPane().add(p0, BorderLayout.SOUTH);
        setTitle(title);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String str;
        String conststr = "(pi|e|c|g|G|h|hbar|k)";
        String operatorstr = "(\\+|-|\\*|/|%|^|//|%%)";
        String numberstr = "(|00|[0-9]|.)";
        BufferedReader br;
	    SignSymbols ss = new SignSymbols();
        MakeScript ms = new MakeScript();
        MakeList ml = new MakeList();
        Process pro = new Process();

        if (cmd.equals("Change")) {
            PushList.clear();
            inputid = false;
            inputeq = true;
            setClear(this,text1);
            str = (String)combo.getSelectedItem();
            layout.show(cardPanel, str);
            frame.setTitle(title = str);
        } else if (cmd.equals("Quit")) {
            System.exit(0);
        } else if (cmd.equals("SolveCard5")) {
            pro.solveequal(this, textc5in1.getText(), Double.parseDouble(textc5in2.getText()), Double.parseDouble(textc5in3.getText()),(String)comboc5.getSelectedItem());
        }  else if (cmd.equals("OpenFileCard4")) {
            pro.openFile(this, textc4);
        } else if (cmd.equals("DeleteTextCard4")) {
            textc4.setText("");
        } else if (cmd.equals("EnterTextCard4")) {
            pro.equal(this,textc4.getText());
        } else if (cmd.equals("OpenFileCard3")) {
            pro.openFile(this, textc3);
        } else if (cmd.equals("DeleteTextCard3")) {
            textc3.setText("");
        } else if (cmd.equals("EnterTextCard3")) {
            pro.equalarea(this,textc3.getText().replace(","," "));
        } else if (cmd.equals("MP")) {
            memplus(this,Double.parseDouble(sb.toString()));
        } else if (cmd.equals("MM")) {
            memplus(this,-Double.parseDouble(sb.toString()));
        } else if (cmd.equals("MR")) {
            inputeq = false;
            inputnum = true;
            inputid = false;
            inputmem = true;
            sb.delete(0, sb.length());
            sb.append(String.valueOf(memory));
            text1.setText(sb.toString());
        } else if (cmd.equals("MC")) {
            memory = 0;
        } else if (cmd.equals("AC")) {
            PushList.clear();
            setClear(this,text1);
        } else if (cmd.equals("C")) {
            setClear(this,text1);
        } else if (cmd.equals("BS")) {
            inputmem = false;
            sb.delete(sb.length()-1, sb.length());
            text1.setText(sb.toString());
        } else if (cmd.equals("=")) {
            numnext(this);
            inputnum = true;
            inputid = false;
            inputeq = true;
            inputmem = false;
            
            if (PushList.getLast().matches(operatorstr)) PushList.addLast(text1.getText());
            list = ml.makeList(PushList);
            //System.out.println(list);
            pro.equal(this,ms.makeScript(list));
        } else {
            if (cmd.matches(operatorstr)) {
                numnext(this);
                eqnext(this);
                inputid = false;
                if (PushList.peekLast().matches(operatorstr)) {
                    PushList.pollLast();
                    PushList.add(cmd);
                } else {
                    PushList.add(cmd);
                }
            } else if (cmd.equals("pm")) {
                eqnext(this);
                numnext(this);
                if (PushList.peekLast().equals("pm")) {
                    PushList.pollLast();
                } else {
                    inputid=true;
                    PushList.add(cmd);
                }
            } else if (cmd.matches(conststr)) {                 // 定数
                eqnext(this);
                numnext(this);
                PushList.add(cmd);
                text1.setText(cmd);
            } else if (cmd.equals("(") || cmd.equals(")")) {
                eqnext(this);
                numnext(this);
                PushList.add(cmd);
            } else if(cmd.matches(numberstr)) {               // 数
                eqnext(this);
                if (inputmem == true) sb.delete(0, sb.length());
                if (inputid == false) {
                    if (cmd.equals("00") && sb.toString().equals("")) sb.append("0");
                    else if ((cmd.equals("00") || cmd.equals("0") ) && sb.toString().equals("0")) sb.append("");
                    else sb.append(cmd);
                    text1.setText(sb.toString());
                    inputnum = true;
                    inputeq = false;
                }
            } else {
                eqnext(this);
                numnext(this);
                inputid=true;
                inputeq = false;
                PushList.add(cmd);
            }
            inputmem = false;
        }
    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            PushList.clear();
            inputid = false;
            inputeq = true;
            setClear(this,text1);
            String str = (String)combo.getSelectedItem();
            layout.show(cardPanel, str);
            frame.setTitle(title = str);
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
}