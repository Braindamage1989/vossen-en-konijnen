package vossen_en_konijnen.view;

import java.util.*;
import java.awt.*;
//import java.math.*;

import vossen_en_konijnen.controller.Controller;
import vossen_en_konijnen.model.FieldStats;

/**
 * This class creates a view of a line graph representing statistics from an FieldStats instance.
 * 
 * @author David Bor
 * @version 2015.01.30
 */
public class LineView extends AbstractView
{

	/**
	 * Create a new LineView component.
	 * @param model The currently used model
	 * @param stats The statistics of the current model
	 * @param height The height of the grid
	 * @param width The width of the grid
	 */
	public LineView(Controller model, FieldStats stats, int height, int width) 
	{
		super(model, stats, height, width);
	}
	
	/**
	 * Update the statistics.
	 * @param stats Statistics form current field
	 */
	public void updateStats(FieldStats stats)
	{
		this.stats = stats;
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
            g = fieldImage.getGraphics();

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
     * Paint the chart with the already used colors.
     */
	public void paintChart() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, size.width, size.height);
		
		for(int j=0; j<5 ;j++) {
			for(int k = 1; k<10; k++) {
				int i = (int) (size.height - 100 * Math.log10(Math.pow(10, j) * k));
				int n = i;
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(0, i, size.width, i);
			}
		}
		
		
		int[] x = new int[100];
		int[] y = new int[100];
		int step = size.width / 100;
		for(int i = 0; i<100; i++) {
			y[i] = size.width - (i * step);
		}
		
		for(Class c : stats.getHistory().keySet()) {
			Color color = model.getColor(c);
			Iterator it = stats.getHistory().get(c).descendingIterator();
			int i = 0;
			while(it.hasNext()) {
				int count = (int) it.next();
				x[i] = (int) (size.height - 100 * Math.log10(count));
				i++;
			}
			if(i < 99) {
				for(; i<100 ; i++) {
					x[i]=size.height;
				}
			}
			
			g.setColor(color);
			for(i = 0; i<99 ; i++) {
				g.drawLine(y[i], x[i], y[i+1], x[i+1]);
			}
		}
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
