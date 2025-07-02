package studenttools.MainFrames;

import javax.swing.*;

import studenttools.Clock.ClockThread;
import studenttools.Utilities.CalculatorFrame;
import studenttools.Utilities.GPAFrame;
import studenttools.Utilities.ScribbleFrame;
import studenttools.Utilities.ToDoListManager_;
import studenttools.Utilities.UnitConverterFrame;
import studenttools.Utilities.WordReplacerFrame;

import java.awt.*;
import java.awt.event.*;

public class UtilityFrame extends JFrame {
	
    public UtilityFrame() {
        setTitle("Student Utilities");
        setSize(600, 400);
        
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JPanel topPanel = new JPanel(new BorderLayout(1,2));
        topPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel clockLabel = new JLabel("", JLabel.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 14));
        new ClockThread(clockLabel).start();
        topPanel.add(clockLabel, BorderLayout.CENTER);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(UtilityFrame.this, "Logging Out.....");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
			    JOptionPane.showMessageDialog(UtilityFrame.this, "Logged out successfully.");
			    setVisible(false);
			}
		});
        
        
        topPanel.add(logoutButton, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10)); 
        centerPanel.setBackground(Color.LIGHT_GRAY);
        
        ImageIcon i1 = new ImageIcon("src/studenttools/MainFrames/cal.jpg");
        Image img = i1.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);//for scaling the image properly in grid
        JButton calcBtn = new JButton("Calculator", new ImageIcon(img));
        calcBtn.setBackground(Color.CYAN);
        
        
        
        ImageIcon i2 = new ImageIcon("src/studenttools/MainFrames/unit.png");
        Image img2 = i2.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
        JButton convertBtn = new JButton("Unit Converter",new ImageIcon(img2));
        convertBtn.setBackground(Color.MAGENTA);
        
        
        ImageIcon i3 = new ImageIcon("src/studenttools/MainFrames/OIP_.jpeg");
        Image img3 = i3.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
        JButton gpaBtn = new JButton("GPA Calculator",new ImageIcon(img3));
        gpaBtn.setBackground(Color.GREEN);
        
        
        ImageIcon i4 = new ImageIcon("src/studenttools/MainFrames/word.jpeg");
        Image img4 = i4.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
        JButton wordCountBtn = new JButton("Word Replacer",new ImageIcon(img4)); 
        wordCountBtn.setBackground(Color.PINK);
        
        
        
        ImageIcon i5 = new ImageIcon("src/studenttools/MainFrames/todo.jpeg");
        Image img5 = i5.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
        JButton todoBtn = new JButton("To-Do List",new ImageIcon(img5)); 
        todoBtn.setBackground(Color.ORANGE); 
        
        
        ImageIcon i6 = new ImageIcon("src/studenttools/MainFrames/draw.jpeg");
        Image img6 = i6.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
        JButton drawBtn = new JButton("Drawing Pad",new ImageIcon(img6)); 
        drawBtn.setBackground(new Color(200, 200, 255)); 
        
        calcBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CalculatorFrame();
			}
		});
        convertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UnitConverterFrame();
			}
		});
        gpaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GPAFrame();
			}
		});
        wordCountBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordReplacerFrame();
			}
		});
        todoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ToDoListManager_();
			}
		}); 
        drawBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScribbleFrame();
			}
		});

        centerPanel.add(calcBtn);
        centerPanel.add(convertBtn);
        centerPanel.add(gpaBtn);
        centerPanel.add(wordCountBtn);
        centerPanel.add(todoBtn);
        centerPanel.add(drawBtn);

        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}