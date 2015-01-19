package vossen_en_konijnen;

/**
 * Create a view of the given width and height.
 * @param step
 */
public abstract class AbstractView
{
	//private int step;
	private FieldStats stats;
	
    public AbstractView(FieldStats stats)
    {
    	this.stats = stats;
    }
}
