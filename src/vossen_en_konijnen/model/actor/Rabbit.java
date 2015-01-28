package vossen_en_konijnen.model.actor; 

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;
import vossen_en_konijnen.model.Randomizer;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 7;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    
    private static final int MAX_DISEASE_AGE = 5;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.2;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    
    private static final int GRASS_FOOD_VALUE = 6;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    private final boolean ZIEKTE_GEN = Randomizer.getRandomZiekteGen();
    
    private boolean ziekte;
    
    private int ziekteAge = 0;
    
    // The fox's food level, which is increased by eating rabbits.

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
            setFoodLevel(rand.nextInt(GRASS_FOOD_VALUE));
        }
        else {
            setAge(0);
            setFoodLevel(GRASS_FOOD_VALUE);
        }
        ziekte = false;
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Actor> newRabbits)
    {
        incrementAge();
        incrementHunger();
        if(isActive()) {
            if(ziekte) {
                if(ziekteAge >= MAX_DISEASE_AGE) {
                    setDead();
                }
                ziekteAge++;
            }
            else {
                giveBirth(newRabbits);            
                // Move towards a source of food if found.
                Location newLocation = findFood();
                if(newLocation == null) { 
                    // No food found - try to move to a free location.
                    newLocation = getField().freeAdjacentLocation(getLocation());
                }
                // See if it was possible to move.
                if(newLocation != null) {
                    setLocation(newLocation);
                }
                else {
                    // Overcrowding.
                    setDead();
                }
            }
        }
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
            if(animal instanceof Grass) {
                Grass grass = (Grass) animal;
                if(grass.isActive()) { 
                    grass.setDead();
                    setFoodLevel(GRASS_FOOD_VALUE);
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if(animal instanceof Rabbit) {
            	if(((Rabbit)animal).getZiekte() && getZiekteGen()) {
                    ziekte = true;
            	}
            }
        }
        return null;
    }
    
    public void setZiekte(boolean ziekte)
    {
        this.ziekte = ziekte;
    }
        
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }
    
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    public int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
    
    public boolean getZiekteGen()
    {
        return ZIEKTE_GEN;
    }
    
    public boolean getZiekte()
    {
        return ziekte;
    }
}
