

package studenttools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScribbleFrame extends JFrame  {
    int x, y;
    Color currentColor = Color.BLACK;

    public ScribbleFrame() {
        setTitle("Drawing Pad");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        
        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = getGraphics();
		        Rectangle r = getBounds();
		        g.setColor(getBackground());
		        g.fillRect(0, 0, r.width, r.height);
		        currentColor = getBackground();
		        g.setColor(currentColor);
				
			}
		});
        
        
        add(clearButton);

        String colors[] = {"black", "red", "blue", "yellow"};
        JComboBox colorCombo = new JComboBox(colors);
        colorCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String color = (String) e.getItem();
		        switch (color) {
		            case "black": currentColor = Color.BLACK; break;
		            case "red": currentColor = Color.RED; break;
		            case "blue": currentColor = Color.BLUE; break;
		            case "yellow": currentColor = Color.YELLOW; break;
		        }
				
			}
		});
        add(colorCombo);

        
        this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
                y = e.getY();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        
        
        this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Graphics g = getGraphics();
		        g.setColor(currentColor);
		        int x1 = e.getX();
		        int y1 = e.getY();
		        g.drawLine(x, y, x1, y1);
		        x = x1;
		        y = y1;
				
			}
		});
        
        setVisible(true);  // Make sure to set visible at the end
    }

   

   


}