package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Iterator;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;

/**
 * A simple model of a hunter.
 * Hunters kill everything, and won't die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Hunter implements Actor
{    
    private static final int MAX_KILLS = 50;
    
    private static final int STEPS_TO_ACTIVE = 25;
    // Individual characteristics (instance fields).
    // The hunter his field
    private Field field;
    // The hunter's position in the field.
    private Location location;
    // Determine if the hunter is alive
    private boolean alive;
    
    private boolean canKill;
    
    private int killCounter = 0;
    
    private int restCounter = 0;

    /**
     * Create a hunter. A hunter can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Hunter(Field field, Location location)
    {
        alive = true;
        canKill = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * This is what the hunter does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newHunter A list to return newly born hunteres.
     */
    public void act(List<Actor> newHunter)
    {
        if(killCounter >= MAX_KILLS) {
            canKill = false;
            killCounter = 0;
        }
        else if (canKill == false && restCounter >= STEPS_TO_ACTIVE) {
            restCounter = 0;
            canKill = true;    
        }
        else if (canKill == false) {
            restCounter++;
        }
        
        if(canKill) {
	        Location newLocation = findFood();
	        if(newLocation == null) { 
	            // No food found - try to move to a free location.
	            newLocation = getField().freeAdjacentLocation(getLocation());
	        }
	        // See if it was possible to move.
	        if(newLocation != null) {
	            setLocation(newLocation);
	        }
        }
    }
    
    /**
     * Return if hunter is still active
     * @return alive if hunter is still active.
     */
    @Override
    public boolean isActive()
    {
        return alive;
    }
    
    /**
     * Look for rabbits adjacent to the current location.
     * Only the first live rabbit is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isActive()) { 
                    rabbit.setDead();
                    killCounter++;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isActive()) { 
                    fox.setDead();
                    killCounter++;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if(animal instanceof Lynx) {
                Lynx lynx = (Lynx) animal;
                if(lynx.isActive()) { 
                    lynx.setDead();
                    killCounter++;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
        }
        return null;
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
    
    /**
     * Return the hunters location.
     * @return The hunters location.
     */
    protected Location getLocation()
    {
        return location;
    }
}
