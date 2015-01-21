package vossen_en_konijnen.view;

import javax.swing.*;

import vossen_en_konijnen.logic.FieldStats;

/**
 * Create a view of the given width and height.
 * @param step
 */
public abstract class AbstractView extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8055043978325587179L;
	//private int step;
	protected FieldStats stats;
	
    public AbstractView(FieldStats stats)
    {
    	this.stats = stats;
    }
}
