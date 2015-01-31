package vossen_en_konijnen.model.actor; 

import java.util.List;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author Ronald Scholten
 * @version 2015.01.30
 */
public class Rock implements Actor
{    
    // Individual characteristics (instance fields).
    // The rock his field
    private Field field;
    // The rocks position in the field.
    private Location location;

    /**
     * Create a rock. A rock only has a location and
     * is always active
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rock(Field field, Location location)
    {
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Overrides act methode from actor
     * does nothing
     * @param newRock override
     */
    @Override
    public void act(List<Actor> newRock)
    {
        //Do nothing
    }
    
    /**
     * Return the rocks location.
     * @return The rocks location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the rock at the new location in the given field.
     * @param newLocation The rocks new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the rocks field.
     * @return The rocks field.
     */
    protected Field getField()
    {
        return field;
    }
   
    
    /**
     * Return if the rock is active
     * @return true (rocks are always active)
     */
    @Override
    public boolean isActive()
    {
        return true;
    }
}
