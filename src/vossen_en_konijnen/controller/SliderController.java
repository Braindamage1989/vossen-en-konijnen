package vossen_en_konijnen.controller;

import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vossen_en_konijnen.model.actor.*;


public class SliderController extends AbstractController
{
	private JPanel sliderPanel;
	private ChangeListener listener;
	private JTextField textField;
	
	public SliderController()
	{
		JFrame settings = new JFrame("Settings");
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 2, 5, 10));
        sliderPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        listener = new ChangeListener()
        {
           public void stateChanged(ChangeEvent event)
           {
              // update text field when the slider value changes
              JSlider source = (JSlider) event.getSource();
              textField.setText("" + source.getValue());
           }
        };
        
        JSlider rabbitAgeSlider = new JSlider(0, 50, 40);
        rabbitAgeSlider.setPaintTicks(true);
        rabbitAgeSlider.setSnapToTicks(true);
        rabbitAgeSlider.setPaintLabels(true);
        rabbitAgeSlider.setMajorTickSpacing(10);
        rabbitAgeSlider.setMinorTickSpacing(1);
        rabbitAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxAge(source.getValue());
        	}
        });
        addSlider(rabbitAgeSlider, "Rabbit age");
        
        JSlider foxAgeSlider = new JSlider(0, 50, 40);
        addSlider(foxAgeSlider, "Fox age");
        foxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxAge(source.getValue());
        	}
        });
        

        // add the text field that displays the slider value
        textField = new JTextField();
        settings.add(sliderPanel);
        //add(textField, BorderLayout.SOUTH);
        
        settings.pack();
        settings.setVisible(true);
	}
    
    public void addSlider(JSlider s, String description)
    {
    	s.setPaintTicks(true);
        s.setSnapToTicks(true);
        s.setPaintLabels(true);
        s.setMajorTickSpacing(10);
        s.setMinorTickSpacing(1);
        
        JPanel panel = new JPanel();
        
        panel.add(new JLabel(description));
        panel.add(s);
        sliderPanel.add(panel);
    }
    
    public void setRabbitAge(int age)
    {
    	Rabbit.setMaxAge(age);
    }
}
