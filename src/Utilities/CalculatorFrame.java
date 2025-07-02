package studenttools.Utilities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame implements ActionListener {
    TextField tf;
    String s0="",s1="",s2="";
    double res;
    
    public CalculatorFrame() {
        setTitle("CALCULATOR");
        setSize(400,525);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JButton add=new JButton("+");
        JButton sub=new JButton("-");
        JButton mul=new JButton("*");
        JButton div=new JButton("/");
        JButton eq=new JButton("=");
        JButton clear=new JButton("C");
        
        Panel p1=new Panel();
        Panel p2=new Panel();
        
        p2.setLayout(new GridLayout(4,4,4,4));
        p2.setBackground(Color.CYAN);
        p1.setBackground(Color.CYAN);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
        tf=new TextField(40);
        tf.setBackground(Color.WHITE);
        p1.add(tf);
        
        JButton b[]=new JButton[10];
        for(int i=0;i<10;i++) {
            b[i]=new JButton(""+i);
            b[i].setBackground(Color.WHITE);
            p2.add(b[i]);
            b[i].addActionListener(this);
        }
        
        p2.add(add); add.setBackground(Color.ORANGE);
        p2.add(sub); sub.setBackground(Color.ORANGE);
        p2.add(mul); mul.setBackground(Color.ORANGE);
        p2.add(div); div.setBackground(Color.ORANGE);
        p2.add(eq); eq.setBackground(Color.GREEN);
        p2.add(clear); clear.setBackground(Color.RED);
        
        setVisible(true);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        eq.addActionListener(this);
        clear.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    
		String ae=e.getActionCommand();
		char ch=ae.charAt(0);
		if(ch>='1'&&ch<='9'||ch=='.')
		{
			if(s1=="")
			{
				s0=s0+String.valueOf(ch);
			}
			else
			{
				s2=s2+Character.toString(ch);
			}
			tf.setText(s0+s1+s2);
		}
		else if(ch=='C')
		{
			s1=s2=s0="";
			tf.setText("");
		}
		else if(ch=='=')
		{
			if(s1.equals("+"))
			{
				res=Double.parseDouble(s0)+Double.parseDouble(s2);
			}
			if(s1.equals("-"))
			{
				res=Double.parseDouble(s0)-Double.parseDouble(s2);
			}
			if(s1.equals("/"))
			{
				res=Double.parseDouble(s0)/Double.parseDouble(s2);
			}
			if(s1.equals("*"))
			{
				res=Double.parseDouble(s0)*Double.parseDouble(s2);
			}
			s0=String.valueOf(res);
			tf.setText(s0);
			s1=s2="";
		}
		else//operator
		{
			if(s1=="")
			{
			s1=String.valueOf(ch);
			tf.setText(s0+s1+s2);
		    }
			else
			{
				if(s1.equals("+"))
				{
					res=Double.parseDouble(s0)+Double.parseDouble(s2);
				}
				if(s1.equals("-"))
				{
					res=Double.parseDouble(s0)-Double.parseDouble(s2);
				}
				if(s1.equals("/"))
				{
					res=Double.parseDouble(s0)/Double.parseDouble(s2);
				}
				if(s1.equals("*"))
				{
					res=Double.parseDouble(s0)*Double.parseDouble(s2);
				}
				s0=String.valueOf(res);
				
				s2="";
				s1=Character.toString(ch);
				tf.setText(s0+s1);
			}
		}
		
	}
	
}
