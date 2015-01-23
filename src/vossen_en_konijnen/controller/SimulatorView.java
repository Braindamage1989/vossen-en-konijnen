package vossen_en_konijnen.controller; 

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.FieldStats;
import vossen_en_konijnen.view.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A graphical view of the simulation grid.
 * The view displays a colored rectangle for each location 
 * representing its contents. It uses a default background color.
 * Colors for each type of species can be defined using the
 * setColor method.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class SimulatorView extends JFrame
{
    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    private final String STEP_PREFIX = "Step: ";
    private final String POPULATION_PREFIX = "Population: ";
    private JButton oneStep, hundredStep, reset;
    private JLabel stepLabel, population;
    private FieldView fieldView;
    private PieView pieView;
    
    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information
    private FieldStats stats;

    /**
     * Create a view of the given width and height.
     * @param height The simulation's height.
     * @param width  The simulation's width.
     */
    public SimulatorView(int height, int width)
    {
        stats = new FieldStats();
        colors = new LinkedHashMap<Class, Color>();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Fox and Rabbit Simulation");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);
        
        setLocation(100, 50);
        
        fieldView = new FieldView(this, stats, height, width);
        
        pieView = new PieView(this, stats, colors, height, width);
        
        Container buttonView = new JPanel();
        buttonView.setLayout(new FlowLayout());
        Container buttonViewSub = new JPanel();
        buttonViewSub.setLayout(new GridLayout(4, 1));
        oneStep = new JButton("1 step");
        buttonViewSub.add(oneStep, 0);
        hundredStep = new JButton("100 steps");
        buttonViewSub.add(hundredStep, 1);
        buttonViewSub.add(new JLabel(""), 2);
        reset = new JButton("reset");
        buttonViewSub.add(reset, 3);
        buttonView.add(buttonViewSub);

        JTabbedPane viewContainer = new JTabbedPane();
        viewContainer.addTab("fieldView", null, fieldView, "The field in wich it all dies...");
        viewContainer.addTab("pieView", null, pieView, "The chart representing all that still lifes. :)");
        
        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(viewContainer, BorderLayout.CENTER);
        contents.add(population, BorderLayout.SOUTH);
        contents.add(buttonView, BorderLayout.WEST);
        pack();
        setVisible(true);
    }
    
    /**
     * Define a color to be used for a given class of animal.
     * @param animalClass The animal's Class object.
     * @param color The color to be used for the given class.
     */
    public void setColor(Class animalClass, Color color)
    {
        colors.put(animalClass, color);
    }

    /**
     * @return The color to be used for a given class of animal.
     */
    public Color getColor(Class animalClass)
    {
        Color col = colors.get(animalClass);
        if(col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        }
        else {
            return col;
        }
    }

    public void addStepOneListener(ActionListener listenForStepOne)
    {
    	oneStep.addActionListener(listenForStepOne);
    }
    
    public void addStepHundredListener(ActionListener listenForStepHundred)
    {
        hundredStep.addActionListener(listenForStepHundred);
    }
    
    public void addResetListener(ActionListener listenForStepHundred)
    {
        reset.addActionListener(listenForStepHundred);
    }
    
    /**
     * Show the current status of the field.
     * @param step Which iteration step it is.
     * @param field The field whose status is to be displayed.
     */
    public void showStatus(int step, Field field)
    {
        if(!isVisible()) {
            setVisible(true);
        }
            
        stepLabel.setText(STEP_PREFIX + step);
        stats.reset();
        
        fieldView.preparePaint();
        pieView.preparePaint();

        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if(animal != null) {
                    stats.incrementCount(animal.getClass());
                    fieldView.drawMark(col, row, getColor(animal.getClass()));
                }
                else {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }
        stats.countFinished();

        population.setText(POPULATION_PREFIX + stats.getPopulationDetails(field));
        pieView.updateStats(stats, colors);
        fieldView.repaint();
        pieView.repaint();
    }

    /**
     * Determine whether the simulation should continue to run.
     * @return true If there is more than one species alive.
     */
    public boolean isViable(Field field)
    {
        return stats.isViable(field);
    }
}
