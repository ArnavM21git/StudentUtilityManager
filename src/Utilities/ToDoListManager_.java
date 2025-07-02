package studenttools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListManager_ {
   public ToDoListManager_() {
	
 
        // Create the frame
        JFrame frame = new JFrame("To-Do List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        
        

        // Create components
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");
        JButton clearButton = new JButton("Clear All");

        // Panel for input and buttons
        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(clearButton);

        // Scroll pane for the task list
        JScrollPane scrollPane = new JScrollPane(taskList);
        
        

        // Add functionality to buttons
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task); 
                taskField.setText(""); 
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex); // Remove the selected task
            }
        });

        clearButton.addActionListener(e -> {
            taskListModel.clear(); // Clear all tasks from the list
        });

        // Add components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }
}
