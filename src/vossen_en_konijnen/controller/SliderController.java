package vossen_en_konijnen.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Hashtable;

import vossen_en_konijnen.model.actor.*;

/**
 * This class will create a frame with various settings
 * 
 * @author Frank Mulder
 * @version 2015.01.30
 */
public class SliderController extends JFrame implements ItemListener
{
	private JFrame settings;
	private JPanel sliderPanel;
	private ChangeListener listener;
	private JCheckBox useGenderToggle, muteToggle;
	private JSlider rabbitCreationProbability, foxCreationProbability, lynxCreationProbability, hunterCreationProbability,
					rabbitAgeSlider, foxAgeSlider, lynxAgeSlider,
					rabbitBreedingSlider, foxBreedingSlider, lynxBreedingSlider,
					rabbitBreedingProbability, foxBreedingProbability, lynxBreedingProbability,
					rabbitMaxLitterSizeSlider, foxMaxLitterSizeSlider, lynxMaxLitterSizeSlider,
					rabbitFoodLevelSlider, foxFoodLevelSlider, lynxFoodLevelSlider,
					grassCreationProbability, grassAgeSlider, grassMultiplyingSlider, grassMultiplyingProbability, grassMaxMultiplySize,
					rockCreationProbability, speedSlider;
					
	private JTextField textField;
	private JButton defaultValues;
	
	/**
	 * Constructor for SliderController.
	 * All settings are created here.
	 */
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
        
        
        JPanel generalPanel = new JPanel();
        JPanel rabbitPanel = new JPanel();
        JPanel foxPanel = new JPanel();
        JPanel lynxPanel = new JPanel();
        JPanel environmentPanel = new JPanel();
        JPanel hunterPanel = new JPanel();
        
        generalPanel.setLayout(new GridLayout(6, 1));
        rabbitPanel.setLayout(new GridLayout(6, 1));
        foxPanel.setLayout(new GridLayout(6, 1));
        lynxPanel.setLayout(new GridLayout(6, 1));
        environmentPanel.setLayout(new GridLayout(6, 1));
        hunterPanel.setLayout(new GridLayout(6, 1));
        
        defaultValues = new JButton("Default values");
        
        addDefaultListener(new ButtonActionListener());
        
        
        //*********************************************************************General settings
        
        useGenderToggle = new JCheckBox("Use genders");
        useGenderToggle.setSelected(Animal.getUseGender());
        useGenderToggle.addItemListener(this);
        generalPanel.add(useGenderToggle);
        
        muteToggle = new JCheckBox("Mute sounds");
        muteToggle.setSelected(Controller.isMuted());
        muteToggle.addItemListener(this);
        generalPanel.add(muteToggle);
        
        speedSlider = new JSlider(0, 200);
        speedSlider.setValue(Controller.getSimulationSpeed());
        
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(0), new JLabel("Fast") );
        labelTable.put(new Integer(100), new JLabel("Moderate") );
        labelTable.put(new Integer(200), new JLabel("Slow") );
        speedSlider.setLabelTable( labelTable );
        speedSlider.setInverted(true);
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        
        generalPanel.add(new JLabel("Change the speed of the simulation"));
        generalPanel.add(speedSlider);
        sliderPanel.add(generalPanel);
        speedSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setSimulationSpeed(source.getValue());
        	}
        });
        
        //*********************************************************************Probability sliders
        
        //Slider to change rabbit creation probability
        rabbitCreationProbability = new JSlider(0, 20);
        rabbitCreationProbability.setValue((int) (Controller.getRabbitCreationProbability()*100));
        addSlider(rabbitPanel, rabbitCreationProbability, "Rabbit creation probability", 5, 1);
        rabbitCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setRabbitCreationProbability(((double) source.getValue()) / 100);
        	}
        });
        
        //Slider to change fox creation probability
        foxCreationProbability = new JSlider(0, 20);
        foxCreationProbability.setValue((int) (Controller.getFoxCreationProbability()*100));
        addSlider(foxPanel, foxCreationProbability, "Fox creation probability", 5, 1);
        foxCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setFoxCreationProbability(((double)source.getValue())/100);
        	}
        });
        
        //Slider to change lynx creation probability
        lynxCreationProbability = new JSlider(0, 20);
        lynxCreationProbability.setValue((int) (Controller.getLynxCreationProbability()*100));
        addSlider(lynxPanel, lynxCreationProbability, "Lynx creation probability", 5, 1);
        lynxCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setLynxCreationProbability(((double)source.getValue())/100);
        	}
        });
        
        //Slider to change hunter creation probability
        hunterCreationProbability = new JSlider(0, 20);
        hunterCreationProbability.setValue((int) (Controller.getHunterCreationProbability()*1000));
        addSlider(hunterPanel, hunterCreationProbability, "Hunter creation probability", 5, 1);
        hunterCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setHunterCreationProbability(((double)source.getValue())/1000);
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
        		Rabbit.setBreedingProbability(((double)source.getValue()) / 100);
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
        		Fox.setBreedingProbability(((double)source.getValue()) / 100);
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
        		Lynx.setBreedingProbability(((double)source.getValue()) / 100);
        	}
        });
        
        //*************************************************************************Max litter sizes
        
        //Max litter size for rabbits
        rabbitMaxLitterSizeSlider = new JSlider(1, 8);
        rabbitMaxLitterSizeSlider.setValue(Rabbit.getMaxRabbitLitterSize());
        addSlider(rabbitPanel, rabbitMaxLitterSizeSlider, "The maximum litter for rabbits", 1, 1);
        rabbitMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setMaxLitterSize(source.getValue());
        	}
        });
        
        //Max litter size for foxes
        foxMaxLitterSizeSlider = new JSlider(1, 8);
        foxMaxLitterSizeSlider.setValue(Fox.getMaxFoxLitterSize());
        addSlider(foxPanel, foxMaxLitterSizeSlider, "The maximum litter for foxes", 1, 1);
        foxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setMaxLitterSize(source.getValue());
        	}
        });
        
        //Max litter size for lynxes
        lynxMaxLitterSizeSlider = new JSlider(1, 8);
        lynxMaxLitterSizeSlider.setValue(Lynx.getMaxLynxLitterSize());
        addSlider(lynxPanel, lynxMaxLitterSizeSlider, "The maximum litter for lynxes", 1, 1);
        lynxMaxLitterSizeSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setMaxLitterSize(source.getValue());
        	}
        });
        
        //******************************************************************Food value sliders
        
        //Maximum food value for rabbits
        rabbitFoodLevelSlider = new JSlider(5, 40);
        rabbitFoodLevelSlider.setValue(Rabbit.getGrassFoodValue());
        addSlider(rabbitPanel, rabbitFoodLevelSlider, "Steps a rabbit can go without food", 5, 5);
        rabbitFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Rabbit.setGrassFoodValue(source.getValue());
        	}
        });
        
        //Maximum food value for foxes
        foxFoodLevelSlider = new JSlider(5, 40);
        foxFoodLevelSlider.setValue(Fox.getRabbitFoodValue());
        addSlider(foxPanel, foxFoodLevelSlider, "Steps a fox can go without food", 5, 5);
        foxFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Fox.setRabbitFoodValue(source.getValue());
        	}
        });
        
        //Maximum food value for lynxes
        lynxFoodLevelSlider = new JSlider(5, 40);
        lynxFoodLevelSlider.setValue(Lynx.getFoodValue());
        addSlider(lynxPanel, lynxFoodLevelSlider, "Steps a lynx can go without food", 5, 5);
        lynxFoodLevelSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Lynx.setFoodValue(source.getValue());
        	}
        });
        
        //********************************************************Environment sliders
        
        //Slider to change grass creation probability
        grassCreationProbability = new JSlider(0, 40);
        grassCreationProbability.setValue((int) (Controller.getGrassCreationProbability()*100));
        addSlider(environmentPanel, grassCreationProbability, "Grass creation probability", 10, 5);
        grassCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setGrassCreationProbability(((double)source.getValue())/100);
        	}
        });
        /*
        //Slider to change max age of grass
        grassAgeSlider = new JSlider(5, 50);
        grassAgeSlider.setValue(Grass.getMaxAge());
        addSlider(environmentPanel, grassAgeSlider, "Maximum age of grass", 5, 5);
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
        addSlider(environmentPanel, grassMultiplyingSlider, "Minimum age grass can multiply", 10, 5);
        grassMultiplyingSlider.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMultiplyingAge(source.getValue());
        	}
        });*/
        
        //Slider to change the chance of multiplying for grass (in %)
        grassMultiplyingProbability = new JSlider(0, 100);
        grassMultiplyingProbability.setValue((int) (Grass.getMultiplyingProbability()*100));
        addSlider(environmentPanel, grassMultiplyingProbability, "The probability grass will multiply", 20, 5);
        grassMultiplyingProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMultiplyingProbability(((double)source.getValue()) / 100);
        	}
        });
        
        //Slider to change maximum grass multiplies
        grassMaxMultiplySize = new JSlider(1, 8);
        grassMaxMultiplySize.setValue(Grass.getMaxMultiplyingSize());
        addSlider(environmentPanel, grassMaxMultiplySize, "Amount of grass per multiply", 1, 1);
        grassMaxMultiplySize.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Grass.setMaxMultiplyingSize(source.getValue());
        	}
        });
        
        //Slider to change rock creation probability
        rockCreationProbability = new JSlider(0, 20);
        rockCreationProbability.setValue((int) (Controller.getRockCreationProbability()*100));
        addSlider(environmentPanel, rockCreationProbability, "Rock creation probability", 5, 1);
        rockCreationProbability.addChangeListener(new ChangeListener(){
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		JSlider source = (JSlider) e.getSource();
        		Controller.setRockCreationProbability(((double)source.getValue())/100);
        	}
        });
        
        
        
        settingsTab.addTab("General", generalPanel);
        settingsTab.addTab("Rabbit", rabbitPanel);
        settingsTab.addTab("Fox", foxPanel);
        settingsTab.addTab("Lynx", lynxPanel);
        settingsTab.addTab("Environment", environmentPanel);
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
    
	/**
	 * Method to add a slider to a panel
	 * @param panel JPanel
	 * @param s The JSlider to be added
	 * @param description
	 * @param majorTick
	 * @param minorTick
	 */
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
    
    /**
     * Set all values back to default values.
     */
    public void backToDefault()
    {
    	//defaults for general settings
    	Animal.setUseGender(false);
    	useGenderToggle.setSelected(Animal.getUseGender());
    	Controller.setMute(false);
    	muteToggle.setSelected(Controller.isMuted());
    	Controller.setSimulationSpeed(100);
    	speedSlider.setValue(Controller.getSimulationSpeed());
    	
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
    	
    	//defaults for environment
    	Controller.setGrassCreationProbability(0.14);
    	grassCreationProbability.setValue((int) (Controller.getGrassCreationProbability()*100));
    	Grass.setMultiplyingProbability(0.5);
    	grassMultiplyingProbability.setValue((int) (Grass.getMultiplyingProbability()*100));
    	Grass.setMaxMultiplyingSize(8);
    	grassMaxMultiplySize.setValue(Grass.getMaxMultiplyingSize());
    	Controller.setRockCreationProbability(0.05);
    	rockCreationProbability.setValue((int) (Controller.getRockCreationProbability()*100));
    	
    	//defaults for hunter
    	Controller.setHunterCreationProbability(0.005);
    	hunterCreationProbability.setValue((int) (Controller.getHunterCreationProbability()*1000));
    }
    
    /**
     * Listener when clicking on Default Values.
     * @param listenForDefault
     */
    public void addDefaultListener(ActionListener listenForDefault)
    {
    	defaultValues.addActionListener(listenForDefault);
    }
    
    /**
     * Listener when changing Use Genders checkbox.
     * @param listenForGender
     */
    public void addGenderListener(ActionListener listenForGender)
    {
    	useGenderToggle.addActionListener(listenForGender);
    }
    
    public void muteListener(ActionListener listenforMute)
    {
    	muteToggle.addActionListener(listenforMute);
    }
    
    /**
     * Listener when clicking the Default Values button.
     */
    class ButtonActionListener implements ActionListener
    {
    	/**
    	 * Set to default values.
    	 */
    	@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
			String buttonText = source.getText();
			if (buttonText.equals("Default values")){
				backToDefault();
			}
		}
    }
    
    /**
     * Use genders when checkbox is checked.
     */
    @Override
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getItem();
		if (source == useGenderToggle) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Animal.setUseGender(true);
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				Animal.setUseGender(false);
			}
	    }
		else if(source == muteToggle) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Controller.setMute(true);
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				Controller.setMute(false);
			}
		}
	}
}