package studenttools.Clock;

import javax.swing.*;
import java.time.LocalTime;

public class ClockThread extends Thread { 
    JLabel label;//IT REQ LABEL TO SHOW WHERE TO SHOW TIME

    public ClockThread(JLabel label) {
        this.label = label;
    }

    public void run() {
        while (true) {
        	
            label.setText("Time: " + LocalTime.now().withNano(0).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                label.setText("Clock Error");
            }
        }
    }
}