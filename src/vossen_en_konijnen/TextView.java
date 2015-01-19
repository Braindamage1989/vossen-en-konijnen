package vossen_en_konijnen;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a textview with current population
 * @author Frank Mulder
 */
public class TextView extends AbstractView
{
	private JFrame frame;
	private String population;
	
	public TextView(FieldStats stats)
	{
		super(stats);
		population = null;
		//textField = new JTextField(population);
	}
}
