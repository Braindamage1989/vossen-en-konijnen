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

	public PieView(FieldStats stats, Map<Class, Color> colors, int fieldCount) 
	{
		super(stats);
		colors = new LinkedHashMap<>();
		this.fieldCount = fieldCount;
		setSize(200,200);
	}
	
	private void setColors(Map<Class, Color> colors)
	{
		//Iterator it = colors.getIterator();
	}
	
	public void updateView() 
	{
		repaint();
	}
	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		
		HashMap<Class, Counter> counters = stats.getCounters();
		int position = 0;
		
		for(Class key : counters.keySet()) {
            int count = counters.get(key).getCount();
            Color color = colors.get(key);
            
            g.setColor(color);
    		g.fillArc(10, 10, 180, 180, position, count);
    		position += count;
        }
		
		
		
	}	
}
