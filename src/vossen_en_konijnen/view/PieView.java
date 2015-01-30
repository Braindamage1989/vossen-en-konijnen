package vossen_en_konijnen.view;

import java.util.*;
import java.awt.*;

import vossen_en_konijnen.controller.*;
import vossen_en_konijnen.model.Counter;
import vossen_en_konijnen.model.FieldStats;

@SuppressWarnings({"serial", "rawtypes"})
/**
 * This class creates a view of a pie graph representing statistics from an FieldStats instance.
 * 
 * @author David Bor
 * @version 30-01-2015
 */
public class PieView extends AbstractView
{
	private int scale;

	/**
	 * Create a new PieView component.
	 */
	public PieView(Controller model, FieldStats stats, int height, int width) 
	{
		super(model, stats, height, width);
	}
	
	/**
	 * Create a new PieView component.
	 * @param model The currently used model
	 * @param stats The statistics of the current model
	 * @param height The height of the grid
	 * @param width The width of the grid
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

            int xScale = size.width;
            int yScale = size.height;
            if(xScale <= yScale) { scale = xScale; } else { scale = yScale; }
            if(scale < 1) { scale = GRID_VIEW_SCALING_FACTOR; }
        }
    }
	
    /**
     * Paint the chart with the already used colors.
     */
	public void paintChart() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, size.width, size.height);
		
		int pieScale = (int) (scale/100.0) * 95;
		int pieStart = (scale - pieScale)/2;
		
		HashMap<Class, Counter> counters = stats.getCounters();
		int position = 0;
		int fullFill = 0;
		
		for(Counter value : counters.values()) { fullFill += value.getCount(); }
		
		for(Class key : counters.keySet()) {
            int count = counters.get(key).getCount();
            int arc = (int) Math.round(((float) count/fullFill) * 360);
            Color color = model.getColor(key);
            g.setColor(color);
    		g.fillArc(pieStart, pieStart, pieScale, pieScale, position, arc);
    		position += arc;
        }
		
		if(position < 360) {
			g.setColor(Color.WHITE);
			g.fillArc(pieStart, pieStart, pieScale, pieScale, position, 360-position);
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
