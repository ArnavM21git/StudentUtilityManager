package studenttools.MainFrames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    public Dashboard() {//homeframe
        JOptionPane.showMessageDialog(this, "WELCOME TO OUR PROJECT!!!");

        setTitle("Student Productivity Dashboard");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Home", createHomePanel());

        add(tabs);
        setVisible(true);
    }

    JPanel createHomePanel() {
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        panel1.add(panel2,BorderLayout.SOUTH);
        

        JLabel welcome = new JLabel("Welcome to Student Assistant App!", JLabel.CENTER);
        welcome.setFont(new Font("ARIAL", Font.BOLD, 30));
        welcome.setForeground(Color.BLUE);
        
        JLabel id = new JLabel("By:ARNAV MUNDADA,\nATHARVA TAYADE", JLabel.RIGHT);
        
        JButton loginBtn = new JButton("Login to Utilities");
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        loginBtn.setBackground(Color.RED);
        loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
			}
		});

        panel1.add(welcome, BorderLayout.CENTER);
        panel2.add(id);
        panel2.add(loginBtn, BorderLayout.SOUTH);
        

        return panel1;
    }
}

  