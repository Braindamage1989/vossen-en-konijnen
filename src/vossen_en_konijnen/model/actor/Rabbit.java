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
    private static int BREEDING_AGE = 7;
    // The age to which a rabbit can live.
    private static int MAX_AGE = 40;
    
    private static final int MAX_DISEASE_AGE = 5;
    // The likelihood of a rabbit breeding.
    private static double BREEDING_PROBABILITY = 0.2;
    // The maximum number of births.
    private static int MAX_LITTER_SIZE = 4;
    
    private static int GRASS_FOOD_VALUE = 6;
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
            if(ziekte) {
                if(ziekteAge >= MAX_DISEASE_AGE) {
                    setDead();
                }
                ziekteAge++;
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
        Location goTo = null;
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Grass) {
                Grass grass = (Grass) animal;
                if(grass.isActive() && goTo == null) { 
                    grass.setDead();
                    setFoodLevel(GRASS_FOOD_VALUE);
                    // Remove the dead rabbit from the field.
                    goTo = where;
                }
            }
            else if(animal instanceof Rabbit) {
            	Rabbit r = (Rabbit) animal;
            	if(getZiekte() && r.getZiekteGen()) {
            		r.setZiekte(true);
            	}
            }
        }
        return goTo;
    }
    
    public static void setMaxAge(int age)
    {
    	MAX_AGE = age;
    }
    
    public static void setBreedingAge(int age)
    {
    	BREEDING_AGE = age;
    }
    
    public static void setBreedingProbability(int chance)
    {
    	BREEDING_PROBABILITY = chance;
    }
    
    public static void setGrassFoodValue(int value)
    {
    	GRASS_FOOD_VALUE = value;
    }
    
    public void setZiekte(boolean ziekte)
    {
        this.ziekte = ziekte;
    }
        
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }
    
    public static int getRabbitBreedingAge()
    {
        return BREEDING_AGE;
    }
    
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    public static int getMaxRabbitAge()
    {
        return MAX_AGE;
    }
    
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    public static double getRabbitBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    public int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
    
    public static int getMaxRabbitLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
    
    public static int getGrassFoodValue()
    {
        return GRASS_FOOD_VALUE;
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