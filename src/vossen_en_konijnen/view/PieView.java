package vossen_en_konijnen.view;

import java.util.*;
import java.awt.*;
import vossen_en_konijnen.logic.*;

public class PieView extends AbstractView
{
	
	private Map<Class, Color> colors;
	private int fieldCount;
	private static final Color UNKNOWN_COLOR = Color.gray;
	
	private int scale;

	public PieView(FieldStats stats, Map<Class, Color> colors, int fieldCount) 
	{
		super(stats);
		this.colors = colors;
		this.fieldCount = fieldCount;
		this.size = new Dimension(0,0);
	}
	
	public void updateStats(FieldStats stats, Map<Class, Color> colors)
	{
		this.stats = stats;
		this.colors = colors;
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
	
	private Color getColor(Class animalClass)
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
	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, scale, scale);
		
		int pieScale = (int) (scale/100.0) * 95;
		int pieStart = (scale - pieScale)/2;
		
		HashMap<Class, Counter> counters = stats.getCounters();
		int position = 0;
		int fullFill = 0;
		
		for(Counter value : counters.values()) { fullFill += value.getCount(); }
		
		for(Class key : counters.keySet()) {
            int count = counters.get(key).getCount();
            int arc = (int) Math.round(((float) count/fullFill) * 360);
            Color color = getColor(key);
            int i = 0;
            g.setColor(color);
    		g.fillArc(pieStart, pieStart, pieScale, pieScale, position, arc);
    		position += arc;
        }
		
		if(position < 360) {
			g.setColor(Color.WHITE);
			g.fillArc(pieStart, pieStart, pieScale, pieScale, position, 360-position);
		}
	}	
}
