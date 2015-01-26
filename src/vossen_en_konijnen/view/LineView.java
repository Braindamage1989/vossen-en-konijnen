package vossen_en_konijnen.view;

import java.util.*;
import java.awt.*;

import vossen_en_konijnen.controller.Controller;
import vossen_en_konijnen.model.Counter;
import vossen_en_konijnen.model.FieldStats;

@SuppressWarnings({"serial"})
public class LineView extends AbstractView
{
	private int scale;

	public LineView(Controller model, FieldStats stats, int height, int width) 
	{
		super(model, stats, height, width);
	}
	
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
	
	public void paintChart() {
		for(Class c : stats.getHistory().keySet()) {
			
		}
	}
	
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
