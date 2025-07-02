package studenttools.MainFrames;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        loginPanel.setBackground(Color.PINK);
        
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        userField.setBackground(Color.WHITE);
        
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        passField.setBackground(Color.WHITE);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.GREEN);
        
       
    

       

        
       

        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    String username = userField.getText();
			    String password = new String(passField.getPassword());

			    if (username.equals("admin") && password.equals("1234")) {
			    	JOptionPane.showMessageDialog(LoginFrame.this, "Logging in........");
			    	try {
						Thread.sleep(450);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
			        JOptionPane.showMessageDialog(LoginFrame.this, "Login Successful!");
			        new UtilityFrame(); 
			        setVisible(false);
			    } else {
			        JOptionPane.showMessageDialog(LoginFrame.this, "Invalid Credentials!");
			    }
			}
		});

       

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);
        
      

        add(loginPanel, BorderLayout.CENTER);
        

        setVisible(true);
    }
}