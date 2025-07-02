package studenttools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GPAFrame extends JFrame {
    public GPAFrame() {
        setTitle("Multi-Subject GPA Calculator");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //grade panel
        JPanel gradePanel = new JPanel(new GridLayout(5, 2, 10, 10));
       
        
        JTextField[] gradeFields = new JTextField[5];
        for (int i = 0; i < 5; i++) 
        {
            gradePanel.add(new JLabel("Subject " + (i+1) + " GPA (1-10):"));
            gradeFields[i] = new JTextField();
            gradePanel.add(gradeFields[i]);
        }
        
        // Result display
        JLabel resultLabel = new JLabel("Overall GPA: ", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Calculate button
        JButton calculateBtn = new JButton("Calculate Overall GPA");
        calculateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    try {
			        double total = 0;
			        int validSubjects = 0;
			        boolean allValid = true;
			        
			        for (int i = 0; i < 5; i++) {
			            String gradeText = gradeFields[i].getText().trim();
			            if (!gradeText.isEmpty()) {
			                double grade = Double.parseDouble(gradeText);
			                if (grade >= 1 && grade <= 10) {
			                    total += grade;
			                    validSubjects++;
			                } else {
			                    allValid = false;
			                    break;
			                }
			            }
			        }
			        
			        if (!allValid) {
			            resultLabel.setText("All grades must be between 1-10");
			        } else if (validSubjects > 0) {
			            double gpa = total / validSubjects;
			            resultLabel.setText("GPA: " + gpa + " / 10.00 (from " + validSubjects + " subjects)");
			        } else {
			            resultLabel.setText("Please enter at least one grade");
			        }
			    } catch (NumberFormatException ex) {
			        resultLabel.setText("Invalid input - use numbers only");
			    }
			}
		});
        
        // Instruction panel
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new GridLayout(2, 1, 5, 5));
        instructionPanel.add(new JLabel("Enter grades (1-10) for up to 5 subjects"));
        instructionPanel.add(new JLabel("Leave empty for subjects not needed"));
        
        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(calculateBtn, BorderLayout.NORTH);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);
        
        add(instructionPanel, BorderLayout.NORTH);
        add(gradePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
}