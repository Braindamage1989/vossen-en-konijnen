package vossen_en_konijnen.view;

import java.awt.*;

import vossen_en_konijnen.controller.*;
import vossen_en_konijnen.model.FieldStats;

/**
 * This class creates a view of a Field representing a field in which animals and other actors exist.
 * 
 * @author David Bor
 * @version 2015.01.30
 */
public class FieldView extends AbstractView
{
    

    /**
     * Create a new FieldView component.
	 * @param model The currently used model
	 * @param stats The statistics of the current model
	 * @param height The height of the grid
	 * @param width The width of the grid
     */
    public FieldView(Controller model, FieldStats stats, int height, int width)
    {
    	super(model, stats, height, width);
    }

    /**
     * Tell the GUI manager how big we would like to be.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                             gridHeight * GRID_VIEW_SCALING_FACTOR);
    }

    /**
     * Prepare for a new round of painting. Since the component
     * may be resized, compute the scaling factor again.
     */
    public void preparePaint()
    {
        if(! size.equals(getSize())) {  // if the size has changed...
            size = getSize();
            fieldImage = this.createImage(size.width, size.height);
            g = this.fieldImage.getGraphics();

            xScale = size.width / gridWidth;
            if(xScale < 1) {
                xScale = GRID_VIEW_SCALING_FACTOR;
            }
            yScale = size.height / gridHeight;
            if(yScale < 1) {
                yScale = GRID_VIEW_SCALING_FACTOR;
            }
        }
    }
    
    /**
     * Paint on grid location on this field in a given color.
     * @param x coordinate
     * @param y coordinate
     * @param color Color the mark has to become
     */
    public void drawMark(int x, int y, Color color)
    {
        g.setColor(color);
        g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
    }

    /**
     * The field view component needs to be redisplayed. Copy the
     * internal image to screen.
     */
    public void paintComponent(Graphics g)
    {
        if(fieldImage != null) {
            Dimension currentSize = getSize();
            if(size.equals(currentSize)) {
                g.drawImage(fieldImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(fieldImage, 0, 0, currentSize.width, currentSize.height, null);
            }
        }
    }
}