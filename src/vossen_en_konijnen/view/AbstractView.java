package vossen_en_konijnen.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import vossen_en_konijnen.controller.SimulatorView;
import vossen_en_konijnen.model.FieldStats;

@SuppressWarnings({"serial"})
/**
 * Create a view of the given width and height.
 * @param step
 */
public abstract class AbstractView extends JPanel
{
	protected SimulatorView model;
    public Graphics g;
    public int xScale, yScale;
    protected final int GRID_VIEW_SCALING_FACTOR = 6;
    protected int gridWidth, gridHeight;
    protected Dimension size;
    protected Image fieldImage;
	protected FieldStats stats;
	
	
    public AbstractView(SimulatorView model, FieldStats stats, int height, int width)
    {
    	this.model = model;
    	this.stats = stats;
		this.size = new Dimension();
        gridHeight = height;
        gridWidth = width;
    }
}
