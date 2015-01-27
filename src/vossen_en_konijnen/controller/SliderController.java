package vossen_en_konijnen.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;

import java.awt.*;
import java.awt.Component;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderController extends AbstractController
{
	private JPanel sliderPanel;
	private ChangeListener listener;
	private JTextField textField;
	
	public SliderController()
	{
		JFrame settings = new JFrame("Settings");
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        listener = new ChangeListener()
        {
           public void stateChanged(ChangeEvent event)
           {
              // update text field when the slider value changes
              JSlider source = (JSlider) event.getSource();
              textField.setText("" + source.getValue());
           }
        };
        
        JSlider slider = new JSlider();
        
        addSlider(slider, "Plain");
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        
        Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0, new JLabel("A"));

        slider.setLabelTable(labelTable);

        // add the text field that displays the slider value
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        
        settings.getContentPane().add(sliderPanel, BorderLayout.CENTER);
        settings.pack();
        settings.setVisible(true);
	}
    
    public void addSlider(JSlider s, String description)
    {
       JPanel panel = new JPanel();
       panel.add(s);
       panel.add(new JLabel(description));
       sliderPanel.add(panel);
    }
}
