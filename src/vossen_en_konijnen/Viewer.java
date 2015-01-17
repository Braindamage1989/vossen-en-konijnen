package vossen_en_konijnen; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Viewer {
	
	private JFrame frame;
	private JLabel filenameLabel;
	private JLabel statusLabel;
    
    public Viewer(SimulatorView simulatorView)
    {
        makeFrame(simulatorView);
    }
    
    private void makeFrame(SimulatorView simulatorView)
    {
    	frame = new JFrame("Simulator");
        //makeMenuBar(frame);
        
        Container contentPane = frame.getContentPane();
        
        contentPane.setLayout(new BorderLayout());
        
        filenameLabel = new JLabel();
        contentPane.add(filenameLabel, BorderLayout.NORTH);
        
        //simulatorView = new SimulatorView(120, 80);
        contentPane.add(simulatorView, BorderLayout.CENTER);
        
        statusLabel = new JLabel("Version 1.0");
        contentPane.add(statusLabel, BorderLayout.SOUTH);

        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
    }
}
