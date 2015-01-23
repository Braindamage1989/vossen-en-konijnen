package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;

/**
 * A simple model of a hunter.
 * Hunters kill everything, and won't die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Rock implements Actor
{    
    // Individual characteristics (instance fields).
    // The hunter his field
    private Field field;
    // The hunter's position in the field.
    private Location location;

    /**
     * Create a hunter. A hunter can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the hunter will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rock(Field field, Location location)
    {
        this.field = field;
        setLocation(location);
    }
    
    public void act(List<Actor> newRock)
    {
            /*Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }*/
    }
    
    /**
     * Return the hunters location.
     * @return The hunters location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the hunter at the new location in the given field.
     * @param newLocation The hunters new location.
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
     * Return the hunters field.
     * @return The hunters field.
     */
    protected Field getField()
    {
        return field;
    }
    
    public boolean isActive()
    {
        return true;
    }
}
