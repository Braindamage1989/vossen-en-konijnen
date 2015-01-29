package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;
import vossen_en_konijnen.model.Randomizer;

/**
 * A simple model of a grass.
 * Grass age, multiply and die.
 * 
 * @author Bor D., Mulder F., Scholten R.
 * @version 2011.07.31
 */
public class Grass implements Actor
{
    // Characteristics shared by all grass (class variables).
    
    // The grass his field
    private Field field;
    // The grasses position in the field.
    private Location location;
    // Determine if the grass is active
    private boolean active;
    // Determine the age of the grass
    private int age;
    
    // The age grass can multiply
    private static int MULTIPLYING_AGE = 3;
    // The age to which a grass can live.
    private static int MAX_AGE = 15;
    // The likelihood of a grass breeding.
    private static double MULTIPLYING_PROBABILITY = 0.5;
    // The maximum number of multiplies.
    private static int MAX_MULTIPLYING_SIZE = 8;
    // A shared random number generator to control multiplying.
    private static final Random rand = Randomizer.getRandom();

    /**
     * Create a new grass. A grass may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the grass will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Grass(boolean randomAge, Field field, Location location)
    {
        active = true;
        this.field = field;
        setLocation(location);
        setAge(0);
        if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newGrass A list to return newly born rabbits.
     */
    @Override
    public void act(List<Actor> newGrass)
    {
        incrementAge();
        if(isActive()) {
            goMultiply(newGrass);            
        }
    }
    
    public static void setMultiplyingAge(int age)
    {
    	MULTIPLYING_AGE = age;
    }
    
    public static void setMaxAge(int age)
    {
    	MAX_AGE = age;
    }
    
    public static void setMultiplyingProbability(double chance)
    {
    	MULTIPLYING_PROBABILITY = chance;
    }
    
    public static void setMaxMultiplyingSize(int size)
    {
    	MAX_MULTIPLYING_SIZE = size;
    }
    
    /**
     * Indicate that the grass is no longer alive.
     * It is removed from the field.
     */
    public void setDead()
    {
        active = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * Place the grass at the new location in the given field.
     * @param newLocation The grasses new location.
     */
    private void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /*
     * Setter for the grasses age
     * @param age The new age to be setted for grasses
     */
    private void setAge(int age)
    {
        this.age = age;
    }
    
    public static int getMultiplyingAge()
    {
    	return MULTIPLYING_AGE;
    }
    
    public static int getMaxAge()
    {
    	return MAX_AGE;
    }
    
    public static double getMultiplyingProbability()
    {
    	return MULTIPLYING_PROBABILITY;
    }
    
    public static int getMaxMultiplyingSize()
    {
    	return MAX_MULTIPLYING_SIZE;
    }
    
    /**
     * Return the grasses field.
     * @return The grasses field.
     */
    private Field getField()
    {
        return field;
    }
    
    /**
     * Return the grasses location.
     * @return The grasses location.
     */
    private Location getLocation()
    {
        return location;
    }
    
    /**
     * Increase the age. This could result in the grasses death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Generate a number representing the number of multiplies,
     * if it can multiply.
     * @return The number of multiplies (may be zero).
     */
    private int multiply()
    {
        int newGrass = 0;
        if(canMultiply() && rand.nextDouble() <= MULTIPLYING_PROBABILITY) {
            newGrass = rand.nextInt(MAX_MULTIPLYING_SIZE) + 1;
        }
        return newGrass;
    }
    
    /**
     * Check whether or not this grass is to multiply at this step.
     * New multiplies will be made into free adjacent locations.
     * @param newGrass A list to return newly created grasses.
     */
    private void goMultiply(List<Actor> newGrass)
    {
        // New grasses are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int youngGrass = multiply();
        for(int b = 0; b < youngGrass && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Grass young = new Grass(false, field, loc);
            newGrass.add(young);
        }
    }
    
    /**
     * Return if grass can multiply.
     * @return if grass can multiply.
     */
    protected boolean canMultiply()
    {
        return age >= MULTIPLYING_AGE;
    }
    
    /**
     * Return if grasses are still active
     * @return if grasses are still active.
     */
    @Override
    public boolean isActive()
    {
        return active;
    }
}
