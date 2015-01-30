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

import vossen_en_konijnen.controller.Controller.SimulationActionListeners;
import vossen_en_konijnen.model.actor.*;


public class SliderController extends AbstractController
{
	private JFrame settings;
	private JPanel sliderPanel;
	private ChangeListener listener;
	private ActionListener actionListener;
	private JSlider rabbitCreationProbability, foxCreationProbability, lynxCreationProbability, hunterCreationProbability,
					rabbitAgeSlider, foxAgeSlider, lynxAgeSlider,
					rabbitBreedingSlider, foxBreedingSlider, lynxBreedingSlider,
					rabbitBreedingProbability, foxBreedingProbability, lynxBreedingProbability,
					rabbitMaxLitterSizeSlider, foxMaxLitterSizeSlider, lynxMaxLitterSizeSlider,
					rabbitFoodLevelSlider, foxFoodLevelSlider, lynxFoodLevelSlider,
					grassCreationProbability, grassAgeSlider, grassMultiplyingSlider, grassMultiplyingProbability, grassMaxMultiplySize;
					
	private JTextField textField;
	private JButton defaultValues;
	
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
        JPanel grassPanel = new JPanel();
        JPanel hunterPanel = new JPanel();
        
        rabbitPanel.setLayout(new GridLayout(6, 1));
        foxPanel.setLayout(new GridLayout(6, 1));
        lynxPanel.setLayout(new GridLayout(6, 1));
        grassPanel.setLayout(new GridLayout(6, 1));
        hunterPanel.setLayout(new GridLayout(1, 1));
        
        defaultValues = new JButton("Default values");
        
        addDefaultListener(new ButtonActionListener());
        
        
        //*********************************************************************Probability sliders
        
        //Slider to change rabbit creation probability
        rabbitCreationProbability = new JSlider(0, 20);
        rabbitCreationProbability.setValue((int) (Controller.getRabbitCreationProbability()*100));
        addSlider(rabbitPanel, rabbitCreationProbability, "Rabbit creation probability", 10, 1);
        rabbitCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setRabbitCreationProbability((double) (source.getValue()/100));
        	}
        });
        
        //Slider to change fox creation probability
        foxCreationProbability = new JSlider(0, 20);
        foxCreationProbability.setValue((int) (Controller.getFoxCreationProbability()*100));
        addSlider(foxPanel, foxCreationProbability, "Fox creation probability", 10, 1);
        foxCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setFoxCreationProbability((double) (source.getValue()/100));
        	}
        });
        
        //Slider to change lynx creation probability
        lynxCreationProbability = new JSlider(0, 20);
        lynxCreationProbability.setValue((int) (Controller.getLynxCreationProbability()*100));
        addSlider(lynxPanel, lynxCreationProbability, "Lynx creation probability", 10, 1);
        lynxCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setLynxCreationProbability((double) (source.getValue()/100));
        	}
        });
        
        //Slider to change hunter creation probability
        hunterCreationProbability = new JSlider(0, 20);
        hunterCreationProbability.setValue((int) (Controller.getHunterCreationProbability()*1000));
        addSlider(hunterPanel, hunterCreationProbability, "Hunter creation probability", 10, 1);
        hunterCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setHunterCreationProbability((double) (source.getValue()/1000));
        	}
        });
        
        
        //********************************************************************Age sliders
        
        //Slider to change max age of rabbits
        rabbitAgeSlider = new JSlider(10, 100);
        rabbitAgeSlider.setValue(Rabbit.getMaxRabbitAge());
        addSlider(rabbitPanel, rabbitAgeSlider, "Maximum age of rabbits", 10, 5);
        rabbitAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxAge(source.getValue());
        	}
        });
        
        
        //Slider to change max age of foxes
        foxAgeSlider = new JSlider(100, 200);
        foxAgeSlider.setValue(Fox.getMaxFoxAge());
        addSlider(foxPanel, foxAgeSlider, "Maximum age of foxes", 20, 5);
        foxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxAge(source.getValue());
        	}
        });
        
        //Slider to change max age of lynxes
        lynxAgeSlider = new JSlider(100, 200);
        lynxAgeSlider.setValue(Lynx.getMaxLynxAge());
        addSlider(lynxPanel, lynxAgeSlider, "Maximum age of lynxes", 20, 5);
        lynxAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setMaxAge(source.getValue());
        	}
        });
        
        //**********************************************************************Breeding age sliders
        
        //Slider to change minimum breeding age for rabbits
        rabbitBreedingSlider = new JSlider(0, 50);
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
        foxBreedingSlider = new JSlider(0, 50);
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
        lynxBreedingSlider = new JSlider(0, 50);
        lynxBreedingSlider.setValue(Lynx.getLynxBreedingAge());
        addSlider(lynxPanel, lynxBreedingSlider, "Minimum breeding age for lynxes", 10, 5);
        lynxBreedingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingAge(source.getValue());
        	}
        });
        
        //*****************************************************************Breeding probability sliders
        
        //Slider to change the chance of breeding for rabbits (in %)
        rabbitBreedingProbability = new JSlider(0, 100);
        rabbitBreedingProbability.setValue((int) (Rabbit.getRabbitBreedingProbability()*100));
        addSlider(rabbitPanel, rabbitBreedingProbability, "The probability a rabbit will breed", 20, 5);
        rabbitBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //Slider to change the chance of breeding for foxes (in %)
        foxBreedingProbability = new JSlider(0, 100);
        foxBreedingProbability.setValue((int) (Fox.getFoxBreedingProbability()*100));
        addSlider(foxPanel, foxBreedingProbability, "The probability a fox will breed", 20, 5);
        foxBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //Slider to change the chance of breeding for lynxes (in %)
        lynxBreedingProbability = new JSlider(0, 100);
        lynxBreedingProbability.setValue((int) (Lynx.getLynxBreedingProbability()*100));
        addSlider(lynxPanel, lynxBreedingProbability, "The probability a lynx will breed", 20, 5);
        lynxBreedingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setBreedingProbability(source.getValue() / 100);
        	}
        });
        
        //*************************************************************************Max litter sizes
        
        //Max litter size for rabbits
        rabbitMaxLitterSizeSlider = new JSlider(0, 8);
        rabbitMaxLitterSizeSlider.setValue(Rabbit.getMaxRabbitLitterSize());
        addSlider(rabbitPanel, rabbitMaxLitterSizeSlider, "The maximum litter for rabbits", 2, 1);
        rabbitMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxLitterSize(source.getValue());
        	}
        });
        
        //Max litter size for foxes
        foxMaxLitterSizeSlider = new JSlider(0, 8);
        foxMaxLitterSizeSlider.setValue(Fox.getMaxFoxLitterSize());
        addSlider(foxPanel, foxMaxLitterSizeSlider, "The maximum litter for foxes", 2, 1);
        foxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxLitterSize(source.getValue());
        	}
        });
        
        //Max litter size for lynxes
        lynxMaxLitterSizeSlider = new JSlider(0, 8);
        lynxMaxLitterSizeSlider.setValue(Lynx.getMaxLynxLitterSize());
        addSlider(lynxPanel, lynxMaxLitterSizeSlider, "The maximum litter for lynxes", 2, 1);
        lynxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setMaxLitterSize(source.getValue());
        	}
        });
        
        //******************************************************************Food value sliders
        
        //Maximum food value for rabbits
        rabbitFoodLevelSlider = new JSlider(0, 100);
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
        foxFoodLevelSlider = new JSlider(0, 100);
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
        lynxFoodLevelSlider = new JSlider(0, 100);
        lynxFoodLevelSlider.setValue(Lynx.getFoodValue());
        addSlider(lynxPanel, lynxFoodLevelSlider, "Steps a lynx can go without food", 25, 5);
        lynxFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setFoodValue(source.getValue());
        	}
        });
        
        //********************************************************Grass sliders
        
        //Slider to change grass creation probability
        grassCreationProbability = new JSlider(0, 40);
        grassCreationProbability.setValue((int) (Controller.getGrassCreationProbability()*100));
        addSlider(grassPanel, grassCreationProbability, "Grass creation probability", 10, 5);
        grassCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setGrassCreationProbability((double) (source.getValue()/100));
        	}
        });
        
        //Slider to change max age of grass
        grassAgeSlider = new JSlider(5, 50);
        grassAgeSlider.setValue(Grass.getMaxAge());
        addSlider(grassPanel, grassAgeSlider, "Maximum age of grass", 5, 5);
        grassAgeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMaxAge(source.getValue());
        	}
        });
        
        //Slider to change minimum multiplying age for grass
        grassMultiplyingSlider = new JSlider(0, 50);
        grassMultiplyingSlider.setValue(Grass.getMultiplyingAge());
        addSlider(grassPanel, grassMultiplyingSlider, "Minimum age grass can multiply", 10, 5);
        grassMultiplyingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMultiplyingAge(source.getValue());
        	}
        });
        
        //Slider to change the chance of multiplying for grass (in %)
        grassMultiplyingProbability = new JSlider(0, 100);
        grassMultiplyingProbability.setValue((int) (Grass.getMultiplyingProbability()*100));
        addSlider(grassPanel, grassMultiplyingProbability, "The probability grass will multiply", 20, 5);
        grassMultiplyingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMultiplyingProbability(source.getValue() / 100);
        	}
        });
        
        //Slider to change maximum grass multiplies
        grassMaxMultiplySize = new JSlider(0, 8);
        grassMaxMultiplySize.setValue(Grass.getMaxMultiplyingSize());
        addSlider(grassPanel, grassMaxMultiplySize, "Amount of grass per multiply", 2, 1);
        grassMaxMultiplySize.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMaxMultiplyingSize(source.getValue());
        	}
        });
        
        
        
        settingsTab.addTab("Rabbit", rabbitPanel);
        settingsTab.addTab("Fox", foxPanel);
        settingsTab.addTab("Lynx", lynxPanel);
        settingsTab.addTab("Grass", grassPanel);
        settingsTab.addTab("Hunter", hunterPanel);
        
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());
        
        
        
        JLabel message = new JLabel("The settings are applied as soon as a slider is changed.");
        
        lowerPanel.add(defaultValues);
        lowerPanel.add(message);
        
        settings.add(settingsTab, BorderLayout.CENTER);
        settings.add(lowerPanel, BorderLayout.SOUTH);
        settings.setMinimumSize(new Dimension(415, 400));
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
    
    public void backToDefault()
    {
    	//defaults for rabbit
    	Controller.setRabbitCreationProbability(0.08);
    	rabbitCreationProbability.setValue((int) (Controller.getRabbitCreationProbability()*100));
    	Rabbit.setMaxAge(40);
    	rabbitAgeSlider.setValue(Rabbit.getMaxRabbitAge());
    	Rabbit.setBreedingAge(7);
    	rabbitBreedingSlider.setValue(Rabbit.getRabbitBreedingAge());
    	Rabbit.setBreedingProbability(0.2);
    	rabbitBreedingProbability.setValue((int) (Rabbit.getRabbitBreedingProbability()*100));
    	Rabbit.setGrassFoodValue(6);
    	rabbitFoodLevelSlider.setValue(Rabbit.getGrassFoodValue());
    	Rabbit.setMaxLitterSize(4);
    	rabbitMaxLitterSizeSlider.setValue(Rabbit.getMaxRabbitLitterSize());
    	
    	//defaults for fox
    	Controller.setFoxCreationProbability(0.02);
    	foxCreationProbability.setValue((int) (Controller.getFoxCreationProbability()*100));
    	Fox.setMaxAge(150);
    	foxAgeSlider.setValue(Fox.getMaxFoxAge());
    	Fox.setBreedingAge(9);
    	foxBreedingSlider.setValue(Fox.getFoxBreedingAge());
    	Fox.setBreedingProbability(0.1);
    	foxBreedingProbability.setValue((int) (Fox.getFoxBreedingProbability()*100));
    	Fox.setRabbitFoodValue(14);
    	foxFoodLevelSlider.setValue(Fox.getRabbitFoodValue());
    	Fox.setMaxLitterSize(4);
    	foxMaxLitterSizeSlider.setValue(Fox.getMaxFoxLitterSize());
    	
    	//defaults for lynx
    	Controller.setLynxCreationProbability(0.01);
    	lynxCreationProbability.setValue((int) (Controller.getLynxCreationProbability()*100));
    	Lynx.setMaxAge(150);
    	lynxAgeSlider.setValue(Lynx.getMaxLynxAge());
    	Lynx.setBreedingAge(20);
    	lynxBreedingSlider.setValue(Lynx.getLynxBreedingAge());
    	Lynx.setBreedingProbability(0.08);
    	lynxBreedingProbability.setValue((int) (Lynx.getLynxBreedingProbability()*100));
    	Lynx.setFoodValue(15);
    	lynxFoodLevelSlider.setValue(Lynx.getFoodValue());
    	Lynx.setMaxLitterSize(2);
    	lynxMaxLitterSizeSlider.setValue(Lynx.getMaxLynxLitterSize());
    	
    	//defaults for grass
    	Controller.setGrassCreationProbability(0.14);
    	grassCreationProbability.setValue((int) (Controller.getGrassCreationProbability()*100));
    	Grass.setMaxAge(15);
    	grassAgeSlider.setValue(Grass.getMaxAge());
    	Grass.setMultiplyingAge(3);
    	grassMultiplyingSlider.setValue(Grass.getMultiplyingAge());
    	Grass.setMultiplyingProbability(0.5);
    	grassMultiplyingProbability.setValue((int) (Grass.getMultiplyingProbability()*100));
    	Grass.setMaxMultiplyingSize(8);
    	grassMaxMultiplySize.setValue(Grass.getMaxMultiplyingSize());
    	
    	//defaults for hunter
    	Controller.setHunterCreationProbability(0.005);
    	hunterCreationProbability.setValue((int) (Controller.getHunterCreationProbability()*1000));
    }
    
    public void addDefaultListener(ActionListener listenForDefault)
    {
    	defaultValues.addActionListener(listenForDefault);
    }
    
    class ButtonActionListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
			String buttonText = source.getText();
			if (buttonText.equals("Default values")){
				backToDefault();
			}
		}
    }
}