package vossen_en_konijnen;

import javax.swing.*;

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
	
	public TextView(FieldStats stats)
	{
		super(stats);
		population = new JLabel("LOlolololol", JLabel.CENTER);
		//textField = new JTextField(population);
	}
	
	public void updatePopulation(Field field)
	{
		String line = stats.getPopulationDetails(field);
		population.setText(line);
	}
}
