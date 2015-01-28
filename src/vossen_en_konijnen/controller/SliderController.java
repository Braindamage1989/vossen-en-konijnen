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
        sliderPanel.setLayout(new GridLayout(10, 2, 5, 10));
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
        //Slider to change max age of rabbits
        JSlider rabbitAgeSlider = new JSlider(0, 200);
        rabbitAgeSlider.setValue(Fox.getMaxFoxAge());
        rabbitAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxAge(source.getValue());
        	}
        });
        addSlider(rabbitAgeSlider, "Maximum age of rabbits");
        
        //Slider to change max age of foxes
        JSlider foxAgeSlider = new JSlider(0, 200);
        foxAgeSlider.setValue(Fox.getMaxFoxAge());
        addSlider(foxAgeSlider, "Maximum age of foxes");
        foxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxAge(source.getValue());
        	}
        });
        
        //Slider to change max age of lynxes
        JSlider lynxAgeSlider = new JSlider(0, 200);
        lynxAgeSlider.setValue(Lynx.getMaxLynxAge());
        addSlider(lynxAgeSlider, "Maximum age of lynxes");
        lynxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setMaxAge(source.getValue());
        	}
        });
        
        JSlider rabbitBreedingSlider = new JSlider(0, 200);
        rabbitBreedingSlider.setValue(Rabbit.getRabbitBreedingAge());
        addSlider(rabbitBreedingSlider, "Minimum breeding age for rabbits");
        rabbitBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingAge(source.getValue());
        	}
        });
        
        JSlider foxBreedingSlider = new JSlider(0, 200);
        foxBreedingSlider.setValue(Fox.getFoxBreedingAge());
        addSlider(foxBreedingSlider, "Minimum breeding age for foxes");
        foxBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setBreedingAge(source.getValue());
        	}
        });
        
        JSlider lynxBreedingSlider = new JSlider(0, 200);
        lynxBreedingSlider.setValue(Lynx.getLynxBreedingAge());
        addSlider(lynxBreedingSlider, "Minimum breeding age for lynxes");
        lynxBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingAge(source.getValue());
        	}
        });
        
        JSlider rabbitBreedingProbability = new JSlider(0, 1);
        rabbitBreedingProbability.setValue((int) (Rabbit.getRabbitBreedingProbability() * 100));
        addSlider(rabbitBreedingProbability, "The probability a rabbit will breed");
        rabbitBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingProbability(source.getValue() / 100);
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
        s.setPaintLabels(true);
        s.setMajorTickSpacing(50);
        s.setMinorTickSpacing(25);
        
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
