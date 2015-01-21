package vossen_en_konijnen.view;

import java.util.*;
import java.awt.*;

import javax.swing.*;

import vossen_en_konijnen.main.*;
import vossen_en_konijnen.logic.*;

public class PieView extends AbstractView
{
	protected SimulatorView model;
	private Map<Class, Color> colors;
	private int fieldCount;
	private static final Color UNKNOWN_COLOR = Color.gray;

	public PieView(FieldStats stats, Map<Class, Color> colors, int fieldCount) 
	{
		super(stats);
		this.colors = colors;
		this.fieldCount = fieldCount;
		setSize(200,200);
	}
	
	private void setColors(Map<Class, Color> colors)
	{
		//Iterator it = colors.getIterator();
	}
	
	public void updateStats(FieldStats stats, Map<Class, Color> colors)
	{
		this.stats = stats;
		this.colors = colors;
	}
	
	public void updateView() 
	{
		repaint();
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
		g.fillRect(0, 0, 200, 200);
		
		HashMap<Class, Counter> counters = stats.getCounters();
		int position = 0;
		
		for(Class key : counters.keySet()) {
            int count = counters.get(key).getCount();
            int arc = (int) (count/(double) fieldCount) * 360;
            Color color = getColor(key);
            
            g.setColor(color);
    		g.fillArc(10, 10, 180, 180, position, arc);
    		position += count;
        }
		
		if(position < 360) {
			g.setColor(Color.WHITE);
			g.fillArc(10, 10, 180, 180, position, 360-position);
		}
	}	
}
