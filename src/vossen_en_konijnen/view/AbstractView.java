package vossen_en_konijnen.view;

import java.awt.Dimension;
import vossen_en_konijnen.controller.*;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import vossen_en_konijnen.model.FieldStats;

/**
 * This class gives a skeletal implementation for the different views.
 * 
 * @author David Bor
 * @version 30-01-2015
 */
public abstract class AbstractView extends JPanel
{
	protected Controller model;
    public Graphics g;
    public int xScale, yScale;
    protected final int GRID_VIEW_SCALING_FACTOR = 6;
    protected int gridWidth, gridHeight;
    protected Dimension size;
    protected Image fieldImage;
	protected FieldStats stats;
	
	/**
	 * Constructor
	 * @param model The currently used model
	 * @param stats The statistics of the current model
	 * @param height The height of the grid
	 * @param width The width of the grid
	 */
    public AbstractView(Controller model, FieldStats stats, int height, int width)
    {
    	this.model = model;
    	this.stats = stats;
		this.size = new Dimension();
        gridHeight = height;
        gridWidth = width;
    }
    
    /**
     * Prepare for a new round of painting. Since the component
     * may be resized, compute the scaling factor again.
     */
    public abstract void preparePaint();
    
    /**
     * Painting the chart
     */
    public void paintChart() {};
    
    /**
     * Overridden method needed for painting
     */
    public abstract void paintComponent(Graphics g);
}
