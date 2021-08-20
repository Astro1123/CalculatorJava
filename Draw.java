import javax.swing.*;
import java.awt.*;
import OS.*;

public class Draw {
    // Card1
    public JPanel dc1(Calculator calc) {
    	JPanel p1 = new JPanel();
    	p1.setLayout(new BorderLayout());
    	JPanel p1p1 = new JPanel();
    	p1p1.setLayout(new BorderLayout());
    	JPanel p1p2 = new JPanel();
    	p1p2.setLayout(new BorderLayout());
    	JPanel p1p3 = new JPanel();
    	p1p3.setLayout(new BorderLayout());
    	JPanel p1p1p1 = new JPanel();
    	p1p1p1.setLayout(new FlowLayout());
    	JPanel p1p1p2 = new JPanel();
    	p1p1p2.setLayout(new FlowLayout());
		JPanel p1p1p3 = new JPanel();
    	p1p1p3.setLayout(new FlowLayout());
		JPanel p1p2p1 = new JPanel();
    	p1p2p1.setLayout(new FlowLayout());
		JPanel p1p3p1 = new JPanel();
    	p1p3p1.setLayout(new FlowLayout());
    	JPanel p1p2p2 = new JPanel();
		p1p2p2.setLayout(new FlowLayout());
    	JPanel p1p3p2 = new JPanel();
    	p1p3p2.setLayout(new FlowLayout());
    	JPanel p1p2p3 = new JPanel();
    	p1p2p3.setLayout(new FlowLayout());
    	p1p1.add(p1p1p1, BorderLayout.NORTH);
		p1p2.add(p1p2p1, BorderLayout.NORTH);
    	p1p3.add(p1p3p1, BorderLayout.NORTH);
    	p1p1.add(p1p1p2, BorderLayout.CENTER);
    	p1p2.add(p1p2p2, BorderLayout.CENTER);
    	p1p3.add(p1p3p2, BorderLayout.CENTER);
    	p1p1.add(p1p1p3, BorderLayout.SOUTH);
    	p1p2.add(p1p2p3, BorderLayout.SOUTH);
		p1.add(p1p1, BorderLayout.NORTH);
    	p1.add(p1p2, BorderLayout.CENTER);
    	p1.add(p1p3, BorderLayout.SOUTH);
    
		JButton btnmp = Button("M+");
    	btnmp.addActionListener(calc);
    	btnmp.setActionCommand("MP");
    	JButton btnmm = Button("M-");
    	btnmm.addActionListener(calc);
    	btnmm.setActionCommand("MM");
    	JButton btnmr = Button("MR");
    	btnmr.addActionListener(calc);
    	btnmr.setActionCommand("MR");
    	JButton btnmc = Button("MC");
    	btnmc.addActionListener(calc);
    	btnmc.setActionCommand("MC");
    	p1p1p1.add(btnmp);
    	p1p1p1.add(btnmm);
    	p1p1p1.add(btnmr);
    	p1p1p1.add(btnmc);
    
    	JButton btndpm = Button("+/-");
    	btndpm.addActionListener(calc);
    	btndpm.setActionCommand("pm");
    	JButton btnbs = Button("BS");
    	btnbs.addActionListener(calc);
    	btnbs.setActionCommand("BS");
    	JButton btnC = Button("C");
    	btnC.addActionListener(calc);
    	btnC.setActionCommand("C");
    	JButton btnAC = Button("AC");
    	btnAC.addActionListener(calc);
    	btnAC.setActionCommand("AC");
    	p1p1p2.add(btndpm);
		p1p1p2.add(btnbs);
    	p1p1p2.add(btnC);
    	p1p1p2.add(btnAC);
    
    	JButton btn1 = Button("1");
    	btn1.addActionListener(calc);
    	btn1.setActionCommand("1");
		JButton btn2 = Button("2");
    	btn2.addActionListener(calc);
    	btn2.setActionCommand("2");
    	JButton btn3 = Button("3");
    	btn3.addActionListener(calc);
    	btn3.setActionCommand("3");
    	JButton btnpl = Button("+");
    	btnpl.addActionListener(calc);
    	btnpl.setActionCommand("+");
    	p1p1p3.add(btn1);
    	p1p1p3.add(btn2);
    	p1p1p3.add(btn3);
    	p1p1p3.add(btnpl);
    
    	JButton btn4 = Button("4");
    	btn4.addActionListener(calc);
    	btn4.setActionCommand("4");
    	JButton btn5 = Button("5");
    	btn5.addActionListener(calc);
    	btn5.setActionCommand("5");
    	JButton btn6 = Button("6");
    	btn6.addActionListener(calc);
    	btn6.setActionCommand("6");
    	JButton btnmi = Button("-");
    	btnmi.addActionListener(calc);
    	btnmi.setActionCommand("-");
    	p1p2p1.add(btn4);
    	p1p2p1.add(btn5);
    	p1p2p1.add(btn6);
    	p1p2p1.add(btnmi);
    
    	JButton btn7 = Button("7");
    	btn7.addActionListener(calc);
    	btn7.setActionCommand("7");
    	JButton btn8 = Button("8");
    	btn8.addActionListener(calc);
    	btn8.setActionCommand("8");
    	JButton btn9 = Button("9");
    	btn9.addActionListener(calc);
    	btn9.setActionCommand("9");
    	JButton btnmu = Button("×");
    	btnmu.addActionListener(calc);
    	btnmu.setActionCommand("*");
    	p1p2p2.add(btn7);
		p1p2p2.add(btn8);
    	p1p2p2.add(btn9);
    	p1p2p2.add(btnmu);
    
    	JButton btn0 = Button("0");
    	btn0.addActionListener(calc);
		btn0.setActionCommand("0");
    	JButton btn00 = Button("00");
    	btn00.addActionListener(calc);
    	btn00.setActionCommand("00");
    	JButton btndot = Button(".");
		btndot.addActionListener(calc);
    	btndot.setActionCommand(".");
    	JButton btndiv = Button("÷");
    	btndiv.addActionListener(calc);
    	btndiv.setActionCommand("/");
    	p1p2p3.add(btn0);
    	p1p2p3.add(btn00);
    	p1p2p3.add(btndot);
    	p1p2p3.add(btndiv);
   	
		JButton btnd1 = Button("");
    	btnd1.setEnabled(false);
    	JButton btnd2 = Button("");
    	btnd2.setEnabled(false);
    	JButton btnpercent = Button("%");
    	btnpercent.addActionListener(calc);
    	btnpercent.setActionCommand("percent");
    	JButton btneq = Button("=");
    	btneq.addActionListener(calc);
		btneq.setActionCommand("=");
    	p1p3p1.add(btnd1);
    	p1p3p1.add(btnd2);
    	p1p3p1.add(btnpercent);
		p1p3p1.add(btneq);
	
		return p1;
  	}
  	
  	// Card2
  	public JPanel dc2(Calculator calc) {
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        JPanel p2p1 = new JPanel();
        p2p1.setLayout(new BorderLayout());
        JPanel p2p2 = new JPanel();
        p2p2.setLayout(new BorderLayout());
        JPanel p2p3 = new JPanel();
        p2p3.setLayout(new BorderLayout());
        JPanel p2p1p1 = new JPanel();
        p2p1p1.setLayout(new FlowLayout());
        JPanel p2p1p2 = new JPanel();
        p2p1p2.setLayout(new FlowLayout());
        JPanel p2p1p3 = new JPanel();
        p2p1p3.setLayout(new FlowLayout());
        JPanel p2p2p1 = new JPanel();
        p2p2p1.setLayout(new FlowLayout());
        JPanel p2p3p1 = new JPanel();
        p2p3p1.setLayout(new FlowLayout());
        JPanel p2p2p2 = new JPanel();
        p2p2p2.setLayout(new FlowLayout());
        JPanel p2p3p2 = new JPanel();
        p2p3p2.setLayout(new FlowLayout());
        JPanel p2p2p3 = new JPanel();
        p2p2p3.setLayout(new FlowLayout());
        JPanel p2p3p3 = new JPanel();
        p2p3p3.setLayout(new FlowLayout());
        p2p1.add(p2p1p1, BorderLayout.NORTH);
        p2p2.add(p2p2p1, BorderLayout.NORTH);
        p2p3.add(p2p3p1, BorderLayout.NORTH);
        p2p1.add(p2p1p2, BorderLayout.CENTER);
        p2p2.add(p2p2p2, BorderLayout.CENTER);
        p2p3.add(p2p3p2, BorderLayout.CENTER);
        p2p1.add(p2p1p3, BorderLayout.SOUTH);
        p2p2.add(p2p2p3, BorderLayout.SOUTH);
        p2p3.add(p2p3p3, BorderLayout.SOUTH);
        p2.add(p2p1, BorderLayout.NORTH);
        p2.add(p2p2, BorderLayout.CENTER);
        p2.add(p2p3, BorderLayout.SOUTH);
    
        JButton btnmpc2 = Button("M+");
        btnmpc2.addActionListener(calc);
        btnmpc2.setActionCommand("MP");
        JButton btnmmc2 = Button("M-");
        btnmmc2.addActionListener(calc);
        btnmmc2.setActionCommand("MM");
        JButton btnmrc2 = Button("MR");
        btnmrc2.addActionListener(calc);
        btnmrc2.setActionCommand("MR");
        JButton btnmcc2 = Button("MC");
        btnmcc2.addActionListener(calc);
        btnmcc2.setActionCommand("MC");
        p2p1p1.add(btnmpc2);
        p2p1p1.add(btnmmc2);
        p2p1p1.add(btnmrc2);
        p2p1p1.add(btnmcc2);
    
        JButton btndpmc2 = Button("+/-");
        btndpmc2.addActionListener(calc);
        btndpmc2.setActionCommand("pm");
        JButton btnfact = Button("!");
        btnfact.addActionListener(calc);
        btnfact.setActionCommand("fact");
        JButton btnrad = Button("rad");
        btnrad.addActionListener(calc);
        btnrad.setActionCommand("rad");
        JButton btndeg = Button("deg");
        btndeg.addActionListener(calc);
        btndeg.setActionCommand("deg");
        JButton btnbsc2 = Button("BS");
        btnbsc2.addActionListener(calc);
        btnbsc2.setActionCommand("BS");
        JButton btnCc2 = Button("C");
        btnCc2.addActionListener(calc);
        btnCc2.setActionCommand("C");
        JButton btnACc2 = Button("AC");
        btnACc2.addActionListener(calc);
        btnACc2.setActionCommand("AC");
        p2p1p2.add(btndpmc2);
        p2p1p2.add(btnfact);
        p2p1p2.add(btnrad);
        p2p1p2.add(btndeg);
        p2p1p2.add(btnbsc2);
        p2p1p2.add(btnCc2);
        p2p1p2.add(btnACc2);
    
        JButton btn1c2 = Button("1");
        btn1c2.addActionListener(calc);
        btn1c2.setActionCommand("1");
        JButton btn2c2 = Button("2");
        btn2c2.addActionListener(calc);
        btn2c2.setActionCommand("2");
        JButton btn3c2 = Button("3");
        btn3c2.addActionListener(calc);
        btn3c2.setActionCommand("3");
        JButton btnplc2 = Button("+");
        btnplc2.addActionListener(calc);
        btnplc2.setActionCommand("+");
        JButton btnpercentc2 = Button("%");
        btnpercentc2.addActionListener(calc);
        btnpercentc2.setActionCommand("percent");
        JButton btnsin = Button("sin");
        btnsin.addActionListener(calc);
        btnsin.setActionCommand("sin");
        JButton btnasin = Button("asin");
        btnasin.addActionListener(calc);
        btnasin.setActionCommand("asin");
        p2p1p3.add(btn1c2);
        p2p1p3.add(btn2c2);
        p2p1p3.add(btn3c2);
        p2p1p3.add(btnplc2);
        p2p1p3.add(btnpercentc2);
        p2p1p3.add(btnsin);
        p2p1p3.add(btnasin);
    
        JButton btn4c2 = Button("4");
        btn4c2.addActionListener(calc);
        btn4c2.setActionCommand("4");
        JButton btn5c2 = Button("5");
        btn5c2.addActionListener(calc);
        btn5c2.setActionCommand("5");
        JButton btn6c2 = Button("6");
        btn6c2.addActionListener(calc);
        btn6c2.setActionCommand("6");
        JButton btnmic2 = Button("-");
        btnmic2.addActionListener(calc);
        btnmic2.setActionCommand("-");
        JButton btnpow = Button("^");
        btnpow.addActionListener(calc);
        btnpow.setActionCommand("^");
        JButton btncos = Button("cos");
        btncos.addActionListener(calc);
        btncos.setActionCommand("cos");
        JButton btnacos = Button("acos");
        btnacos.addActionListener(calc);
        btnacos.setActionCommand("acos");
        p2p2p1.add(btn4c2);
        p2p2p1.add(btn5c2);
        p2p2p1.add(btn6c2);
        p2p2p1.add(btnmic2);
        p2p2p1.add(btnpow);
        p2p2p1.add(btncos);
        p2p2p1.add(btnacos);
    
        JButton btn7c2 = Button("7");
        btn7c2.addActionListener(calc);
        btn7c2.setActionCommand("7");
        JButton btn8c2 = Button("8");
        btn8c2.addActionListener(calc);
        btn8c2.setActionCommand("8");
        JButton btn9c2 = Button("9");
        btn9c2.addActionListener(calc);
        btn9c2.setActionCommand("9");
        JButton btnmuc2 = Button("×");
        btnmuc2.addActionListener(calc);
        btnmuc2.setActionCommand("*");
        JButton btnsqrt = Button("√");
        btnsqrt.addActionListener(calc);
        btnsqrt.setActionCommand("sqrt");
        JButton btntan = Button("tan");
        btntan.addActionListener(calc);
        btntan.setActionCommand("tan");
        JButton btnatan = Button("atan");
        btnatan.addActionListener(calc);
        btnatan.setActionCommand("atan");
        p2p2p2.add(btn7c2);
        p2p2p2.add(btn8c2);
        p2p2p2.add(btn9c2);
        p2p2p2.add(btnmuc2);
        p2p2p2.add(btnsqrt);
        p2p2p2.add(btntan);
        p2p2p2.add(btnatan);
    
        JButton btn0c2 = Button("0");
        btn0c2.addActionListener(calc);
        btn0c2.setActionCommand("0");
        JButton btn00c2 = Button("00");
        btn00c2.addActionListener(calc);
        btn00c2.setActionCommand("00");
        JButton btndotc2 = Button(".");
        btndotc2.addActionListener(calc);
        btndotc2.setActionCommand(".");
        JButton btndivc2 = Button("÷");
        btndivc2.addActionListener(calc);
        btndivc2.setActionCommand("/");
        JButton btnmod = Button("mod");
        btnmod.addActionListener(calc);
        btnmod.setActionCommand("%");
        JButton btnexp = Button("exp");
        btnexp.addActionListener(calc);
        btnexp.setActionCommand("exp");
        JButton btnlog = Button("log");
        btnlog.addActionListener(calc);
        btnlog.setActionCommand("log");
        p2p2p3.add(btn0c2);
        p2p2p3.add(btn00c2);
        p2p2p3.add(btndotc2);
        p2p2p3.add(btndivc2);
        p2p2p3.add(btnmod);
        p2p2p3.add(btnexp);
        p2p2p3.add(btnlog);
        
        JButton btneqc2 = Button("=");
        btneqc2.addActionListener(calc);
        btneqc2.setActionCommand("=");
        JButton btnParenL = Button("(");
        btnParenL.addActionListener(calc);
        btnParenL.setActionCommand("(");
        JButton btnParenR = Button(")");
        btnParenR.addActionListener(calc);
        btnParenR.setActionCommand(")");
        JButton btndivic2 = Button("quot");
        btndivic2.addActionListener(calc);
        btndivic2.setActionCommand("//");
        JButton btnsum = Button("sum");
        btnsum.addActionListener(calc);
        btnsum.setActionCommand("sum");
        JButton btnabs = Button("abs");
        btnabs.addActionListener(calc);
        btnabs.setActionCommand("abs");
        p2p3p1.add(btneqc2);
        p2p3p1.add(btnParenL);
        p2p3p1.add(btnParenR);
        p2p3p1.add(btndivic2);
        p2p3p1.add(btnsum);
        p2p3p1.add(btnabs);
        
        JButton btnpi = Button("π");
        btnpi.addActionListener(calc);
        btnpi.setActionCommand("pi");
        JButton btnround = Button("round");
        btnround.addActionListener(calc);
        btnround.setActionCommand("round");
        JButton btnrevn = Button("revn");
        btnrevn.addActionListener(calc);
        btnrevn.setActionCommand("revn");
        JButton rinf = Button("rinf");
        rinf.addActionListener(calc);
        rinf.setActionCommand("rinf");
        JButton btnint = Button("int");
        btnint.addActionListener(calc);
        btnint.setActionCommand("int");
        JButton btnceil = Button("ceil");
        btnceil.addActionListener(calc);
        btnceil.setActionCommand("ceil");
        JButton btnfloor = Button("floor");
        btnfloor.addActionListener(calc);
        btnfloor.setActionCommand("floor");
        p2p3p2.add(btnpi);
        p2p3p2.add(btnround);
        p2p3p2.add(btnrevn);
        p2p3p2.add(rinf);
        p2p3p2.add(btnint);
        p2p3p2.add(btnceil);
        p2p3p2.add(btnfloor);
        
        JButton btnm_e = Button("e");
        btnm_e.addActionListener(calc);
        btnm_e.setActionCommand("e");
        JButton c2btnc = Button("c");
        c2btnc.addActionListener(calc);
        c2btnc.setActionCommand("c");
        JButton c2btnLG = Button("G");
        c2btnLG.addActionListener(calc);
        c2btnLG.setActionCommand("G");
        JButton c2btnh = Button("h");
        c2btnh.addActionListener(calc);
        c2btnh.setActionCommand("h");
        JButton c2btnhbar = Button("hbar");
        c2btnhbar.addActionListener(calc);
        c2btnhbar.setActionCommand("hbar");
        JButton c2btnk = Button("k");
        c2btnk.addActionListener(calc);
        c2btnk.setActionCommand("k");
        JButton c2btng = Button("g");
        c2btng.addActionListener(calc);
        c2btng.setActionCommand("g");
        p2p3p3.add(btnm_e);
        p2p3p3.add(c2btnc);
        p2p3p3.add(c2btnLG);
        p2p3p3.add(c2btnh);
        p2p3p3.add(c2btnhbar);
        p2p3p3.add(c2btnk);
        p2p3p3.add(c2btng);
        return p2;
    }
    
  	// Card3
  	public JPanel dc3(Calculator calc) {
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        JPanel p3p1 = new JPanel();
        p3p1.setLayout(new BorderLayout());
        JPanel p3p1p1 = new JPanel();
        JPanel p3p1p2 = new JPanel();
        JPanel p3p2 = new JPanel();
        p3p2.setLayout(new BoxLayout(p3p2, BoxLayout.Y_AXIS));
        calc.textc3 = new JTextArea(15, 41);
        JScrollPane scrollpanec3 = new JScrollPane(calc.textc3);
	    calc.textc3.setLineWrap(true);
        calc.textc3ans = new JTextArea(3, 41);
        JScrollPane scrollpanec3ans = new JScrollPane(calc.textc3ans);
	    calc.textc3ans.setLineWrap(true);
        JButton btnc3textenter = new JButton("Enter");
        btnc3textenter.addActionListener(calc);
        btnc3textenter.setActionCommand("EnterTextCard3");
        JButton btnc3textdel = new JButton("Delete");
        btnc3textdel.addActionListener(calc);
        btnc3textdel.setActionCommand("DeleteTextCard3");
        JButton btnc3openf = new JButton("Open");
        btnc3openf.addActionListener(calc);
        btnc3openf.setActionCommand("OpenFileCard3");
        p3.add(p3p1, BorderLayout.CENTER);
        p3.add(p3p2, BorderLayout.EAST);
	    p3p2.add(btnc3textenter);
	    p3p2.add(btnc3textdel);
	    p3p2.add(btnc3openf);
	    //p3p1.add(textc3);
        p3p1.add(p3p1p1, BorderLayout.CENTER);
        p3p1.add(p3p1p2, BorderLayout.SOUTH);
	    p3p1p1.add(scrollpanec3);
	    p3p1p2.add(scrollpanec3ans);
	    return p3;
    }
    
  	// Card4
  	public JPanel dc4(Calculator calc) {
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        JPanel p4p1 = new JPanel();
        JPanel p4p2 = new JPanel();
        p4p2.setLayout(new BoxLayout(p4p2, BoxLayout.Y_AXIS));
        calc.textc4 = new JTextArea(20, 41);
        JScrollPane scrollpanec4 = new JScrollPane(calc.textc4);
	    calc.textc4.setLineWrap(true);
        JButton btnc4textenter = new JButton("Enter");
        btnc4textenter.addActionListener(calc);
        btnc4textenter.setActionCommand("EnterTextCard4");
        JButton btnc4textdel = new JButton("Delete");
        btnc4textdel.addActionListener(calc);
        btnc4textdel.setActionCommand("DeleteTextCard4");
        JButton btnc4openf = new JButton("Open");
        btnc4openf.addActionListener(calc);
        btnc4openf.setActionCommand("OpenFileCard4");
        p4.add(p4p1, BorderLayout.CENTER);
        p4.add(p4p2, BorderLayout.EAST);
	    p4p2.add(btnc4textenter);
	    p4p2.add(btnc4textdel);
	    p4p2.add(btnc4openf);
	    //p4p1.add(textc4);
	    p4p1.add(scrollpanec4);
        return p4;
    }
    
  	// Card5
  	public JPanel dc5(Calculator calc) {
        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        JPanel p5p1 = new JPanel();
        p5p1.setLayout(new BorderLayout());
        JPanel p5p1p1 = new JPanel();
        p5p1p1.setLayout(new FlowLayout());
        JPanel p5p1p2 = new JPanel();
        p5p1p2.setLayout(new FlowLayout());
        JPanel p5p1p3 = new JPanel();
        p5p1p3.setLayout(new FlowLayout());
        JPanel p5p2p1 = new JPanel();
        p5p2p1.setLayout(new FlowLayout());
        JPanel p5p2p2 = new JPanel();
        p5p2p2.setLayout(new FlowLayout());
        JPanel p5p2 = new JPanel();
        p5p2.setLayout(new BorderLayout());
        p5.add(p5p1, BorderLayout.NORTH);
        p5.add(p5p2, BorderLayout.CENTER);
        p5p1.add(p5p1p1, BorderLayout.NORTH);
        p5p1.add(p5p1p2, BorderLayout.CENTER);
        p5p1.add(p5p1p3, BorderLayout.SOUTH);
        p5p2.add(p5p2p1, BorderLayout.NORTH);
        p5p2.add(p5p2p2, BorderLayout.CENTER);
        JLabel labelc5a = new JLabel("f(x) = ");
        calc.textc5in1 = new JTextField("0", 30);
        JLabel labelc5b = new JLabel("x0 = ");
        calc.textc5in2 = new JTextField("0", 30);
        JLabel labelc5c = new JLabel("x1 = ");
        calc.textc5in3 = new JTextField("0", 30);
        calc.comboc5 = new JComboBox<>(calc.combodatac5);
        JButton btnc5 = new JButton("Solve");
        btnc5.addActionListener(calc);
        btnc5.setActionCommand("SolveCard5");
        calc.textc5ans = new JTextArea(7, 41);
        calc.textc5ans.setEditable(false);
        JScrollPane scrollpanec5ans = new JScrollPane(calc.textc5ans);
        p5p1p1.add(labelc5a);
        p5p1p1.add(calc.textc5in1);
        p5p1p2.add(labelc5b);
        p5p1p2.add(calc.textc5in2);
        p5p1p3.add(labelc5c);
        p5p1p3.add(calc.textc5in3);
        p5p2p1.add(calc.comboc5);
        p5p2p1.add(btnc5);
        p5p2p2.add(scrollpanec5ans);
        return p5;
    }
    
    JButton Button(String str) {
        JButton btn = new JButton(str);
        btn.setPreferredSize(new Dimension(3*23,1*22));
        return btn;
    }

    JButton Button2(String str) {
        JButton btn = new JButton(str);
        btn.setPreferredSize(new Dimension(3*30,1*22));
        return btn;
    }
}