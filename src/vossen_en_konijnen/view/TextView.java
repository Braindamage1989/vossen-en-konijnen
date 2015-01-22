package vossen_en_konijnen.view;

import javax.swing.*;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.FieldStats;

/**
 * Creates a textview with current population
 * @author Frank Mulder
 */
public class TextView extends AbstractView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 522169609862382099L;
	private JLabel population;
	
	public TextView(FieldStats stats, int height, int depth)
	{
		super(stats, height, depth);
		population = new JLabel("", JLabel.CENTER);
		this.add(population);
		//textField = new JTextField(population);
	}
	
	public void updatePopulation(Field field)
	{
		String line = stats.getPopulationDetails(field);
		population.setText(line);
	}
}
