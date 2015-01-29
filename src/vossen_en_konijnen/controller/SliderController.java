package vossen_en_konijnen.controller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vossen_en_konijnen.model.actor.*;


public class SliderController extends AbstractController
{
	private JFrame settings;
	private JPanel sliderPanel;
	private ChangeListener listener;
	private ActionListener actionListener;
	private JTextField textField;
	
	public SliderController()
	{
		settings = new JFrame("Settings");
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
        sliderPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JTabbedPane settingsTab = new JTabbedPane();
        settingsTab.setPreferredSize(new Dimension(550,550));
        
        listener = new ChangeListener()
        {
           public void stateChanged(ChangeEvent event)
           {
              // update text field when the slider value changes
              JSlider source = (JSlider) event.getSource();
              textField.setText("" + source.getValue());
           }
        };
        
        
        JPanel rabbitPanel = new JPanel();
        JPanel foxPanel = new JPanel();
        JPanel lynxPanel = new JPanel();
        
        rabbitPanel.setLayout(new GridLayout(5, 1));
        foxPanel.setLayout(new GridLayout(5, 1));
        lynxPanel.setLayout(new GridLayout(5, 1));
        
        
        //**************************************Age sliders
        
        //Slider to change max age of rabbits
        JSlider rabbitAgeSlider = new JSlider(10, 100);
        rabbitAgeSlider.setValue(Rabbit.getMaxRabbitAge());
        addSlider(rabbitPanel, rabbitAgeSlider, "Maximum age of rabbits", 10, 10);
        rabbitAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxAge(source.getValue());
        	}
        });
        
        
        //Slider to change max age of foxes
        JSlider foxAgeSlider = new JSlider(100, 200);
        foxAgeSlider.setValue(Fox.getMaxFoxAge());
        addSlider(foxPanel, foxAgeSlider, "Maximum age of foxes", 50, 10);
        foxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxAge(source.getValue());
        	}
        });
        
        //Slider to change max age of lynxes
        JSlider lynxAgeSlider = new JSlider(100, 200);
        lynxAgeSlider.setValue(Lynx.getMaxLynxAge());
        addSlider(lynxPanel, lynxAgeSlider, "Maximum age of lynxes", 50, 10);
        lynxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setMaxAge(source.getValue());
        	}
        });
        
        //*****************************************************Breeding age sliders
        
        //Slider to change minimum breeding age for rabbits
        JSlider rabbitBreedingSlider = new JSlider(0, 50);
        rabbitBreedingSlider.setValue(Rabbit.getRabbitBreedingAge());
        addSlider(rabbitPanel, rabbitBreedingSlider, "Minimum breeding age for rabbits", 10, 5);
        rabbitBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingAge(source.getValue());
        	}
        });
        
        //Slider to change minimum breeding age for foxes
        JSlider foxBreedingSlider = new JSlider(0, 50);
        foxBreedingSlider.setValue(Fox.getFoxBreedingAge());
        addSlider(foxPanel, foxBreedingSlider, "Minimum breeding age for foxes", 10, 5);
        foxBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setBreedingAge(source.getValue());
        	}
        });
        
        //Slider to change minimum breeding age for lynxes
        JSlider lynxBreedingSlider = new JSlider(0, 50);
        lynxBreedingSlider.setValue(Lynx.getLynxBreedingAge());
        addSlider(lynxPanel, lynxBreedingSlider, "Minimum breeding age for lynxes", 10, 5);
        lynxBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingAge(source.getValue());
        	}
        });
        
        //*****************************************************Breeding probability sliders
        
        //Slider to change the chance of breeding for rabbits (in %)
        JSlider rabbitBreedingProbability = new JSlider(0, 100);
        rabbitBreedingProbability.setValue((int) (Rabbit.getRabbitBreedingProbability()*100));
        addSlider(rabbitPanel, rabbitBreedingProbability, "The probability a rabbit will breed", 50, 25);
        rabbitBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //Slider to change the chance of breeding for foxes (in %)
        JSlider foxBreedingProbability = new JSlider(0, 100);
        foxBreedingProbability.setValue((int) (Fox.getFoxBreedingProbability()*100));
        addSlider(foxPanel, foxBreedingProbability, "The probability a fox will breed", 50, 25);
        foxBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //Slider to change the chance of breeding for lynxes (in %)
        JSlider lynxBreedingProbability = new JSlider(0, 100);
        lynxBreedingProbability.setValue((int) (Lynx.getLynxBreedingProbability()*100));
        addSlider(lynxPanel, lynxBreedingProbability, "The probability a lynx will breed", 50, 25);
        lynxBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //*****************************************************************Max litter sizes
        
        //Max litter size for rabbits
        JSlider rabbitMaxLitterSizeSlider = new JSlider(0, 8);
        rabbitMaxLitterSizeSlider.setValue(Rabbit.getMaxRabbitLitterSize());
        addSlider(rabbitPanel, rabbitMaxLitterSizeSlider, "The maximum litter for rabbits", 2, 1);
        rabbitMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingProbability(source.getValue());
        	}
        });
        
        //Max litter size for foxes
        JSlider foxMaxLitterSizeSlider = new JSlider(0, 8);
        foxMaxLitterSizeSlider.setValue(Fox.getMaxFoxLitterSize());
        addSlider(foxPanel, foxMaxLitterSizeSlider, "The maximum litter for foxes", 2, 1);
        foxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setBreedingProbability(source.getValue());
        	}
        });
        
        //Max litter size for lynxes
        JSlider lynxMaxLitterSizeSlider = new JSlider(0, 8);
        lynxMaxLitterSizeSlider.setValue(Lynx.getMaxLynxLitterSize());
        addSlider(lynxPanel, lynxMaxLitterSizeSlider, "The maximum litter for lynxes", 2, 1);
        lynxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingProbability(source.getValue());
        	}
        });
        
        //******************************************************************Food value sliders
        
        //Maximum food value for rabbits
        JSlider rabbitFoodLevelSlider = new JSlider(0, 100);
        rabbitFoodLevelSlider.setValue(Rabbit.getGrassFoodValue());
        addSlider(rabbitPanel, rabbitFoodLevelSlider, "Steps a rabbit can go without food", 25, 5);
        rabbitFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setGrassFoodValue(source.getValue());
        	}
        });
        
        //Maximum food value for foxes
        JSlider foxFoodLevelSlider = new JSlider(0, 100);
        foxFoodLevelSlider.setValue(Fox.getRabbitFoodValue());
        addSlider(foxPanel, foxFoodLevelSlider, "Steps a fox can go without food", 25, 5);
        foxFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setRabbitFoodValue(source.getValue());
        	}
        });
        
        //Maximum food value for lynxes
        JSlider lynxFoodLevelSlider = new JSlider(0, 100);
        lynxFoodLevelSlider.setValue(Lynx.getFoodValue());
        addSlider(lynxPanel, lynxFoodLevelSlider, "Steps a lynx can go without food", 25, 5);
        lynxFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setFoodValue(source.getValue());
        	}
        });
        
        settingsTab.addTab("Rabbit", rabbitPanel);
        settingsTab.addTab("Fox", foxPanel);
        settingsTab.addTab("Lynx", lynxPanel);
        
        JPanel settingsButtons = new JPanel();
        settingsButtons.setLayout(new FlowLayout());
        
        JButton ok = new JButton("Ok");
        ok.addActionListener(new ButtonActionListener());
        
        settingsButtons.add(ok);
        
        settings.add(settingsTab, BorderLayout.CENTER);
        settings.add(settingsButtons, BorderLayout.SOUTH);
        settings.pack();
        settings.setVisible(true);
	}
    
    public void addSlider(JPanel panel, JSlider s, String description, int majorTick, int minorTick)
    {
    	s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.setMajorTickSpacing(majorTick);
        s.setMinorTickSpacing(minorTick);
        
        panel.add(new JLabel(description));
        panel.add(s);
        sliderPanel.add(panel);
    }
    
    class ButtonActionListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
			String buttonText = source.getText();
			if (buttonText.equals("Ok")){
				settings.dispose();
			}
		}
    }
}
