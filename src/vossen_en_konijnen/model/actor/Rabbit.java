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
 * @author David J. Barnes, Michael Kölling, Ronald Scholten
 * @version 2015.01.31
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static int breedingAge = 7;
    // The age to which a rabbit can live.
    private static int maxAge = 40;
    
    private static final int maxDiseaseAge = 5;
    // The likelihood of a rabbit breeding.
    private static double breedingProbability = 0.2;
    // The maximum number of births.
    private static int maxLitterSize = 4;
    
    private static int grassFoodValue = 6;
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
    public Rabbit(boolean randomAge, Field field, Location location, boolean gender)
    {
        super(field, location, gender);
        if(randomAge) {
            setAge(rand.nextInt(maxAge));
            setFoodLevel(rand.nextInt(grassFoodValue));
        }
        else {
            setAge(0);
            setFoodLevel(grassFoodValue);
        }
        ziekte = false;
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    @Override
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
                if(ziekteAge >= maxDiseaseAge) {
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
                    setFoodLevel(grassFoodValue);
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
    
    /**
     * Setter for the maximum age of foxes
     * @param age the maximum age for foxes
     */
    public static void setMaxAge(int age)
    {
    	maxAge = age;
    }
    
    /**
     * Setter for the breeding age of foxes
     * @param age the breeding age for foxes
     */
    public static void setBreedingAge(int age)
    {
    	breedingAge = age;
    }
    
    /**
     * Setter for the chance foxes will breed
     * @param chance The chance a fox will breed
     */
    public static void setBreedingProbability(double chance)
    {
    	breedingProbability = chance;
    }
    
    /**
     * Setter for the food value of foxes
     * @param value The food value of a fox
     */
    public static void setGrassFoodValue(int value)
    {
    	grassFoodValue = value;
    }
    
    /**
     * Setter for the max litter size of foxes
     * @param litterSize The maximum of births a fox can give
     */
    public static void setMaxLitterSize(int litterSize)
    {
    	maxLitterSize = litterSize;
    }
    
    /**
     * Setter for the disease for rabbits
     * @param ziekte Determine if the rabbit is sick
     */
    public void setZiekte(boolean ziekte)
    {
        this.ziekte = ziekte;
    }
    
    /**
     * Getter for the breeding age of foxes
     * @return breedingAge The breeding age of foxes
     */
    @Override
    public int getBreedingAge()
    {
        return breedingAge;
    }
    
    /**
     * Getter for the breeding age of foxes
     * @return breedingAge The breeding age of foxes
     */
    public static int getRabbitBreedingAge()
    {
        return breedingAge;
    }
    
    /**
     * Getter for the maximum age of foxes
     * @return maxAge The maximum age of foxes
     */
    @Override
    public int getMaxAge()
    {
        return maxAge;
    }
    
    /**
     * Getter for the maximum age of foxes
     * @return maxAge The maximum age of foxes
     */
    public static int getMaxRabbitAge()
    {
        return maxAge;
    }
    
    /**
     * Getter for the chance foxes will breed
     * @return breedingProbability The chance a fox will breed
     */
    @Override
    public double getBreedingProbability()
    {
        return breedingProbability;
    }
    
    /**
     * Getter for the chance foxes will breed
     * @return breedingProbability The chance a fox will breed
     */
    public static double getRabbitBreedingProbability()
    {
        return breedingProbability;
    }
    
    /**
     * Getter for the max litter size of foxes
     * @return maxLitterSize The maximum of births a fox can give
     */
    @Override
    public int getMaxLitterSize()
    {
        return maxLitterSize;
    }
    
    /**
     * Getter for the max litter size of foxes
     * @return maxLitterSize The maximum of births a fox can give
     */
    public static int getMaxRabbitLitterSize()
    {
        return maxLitterSize;
    }
    
     /**
     * Getter for the food value of foxes
     * @return rabbitFoodValue The food value of a fox
     */
    public static int getGrassFoodValue()
    {
        return grassFoodValue;
    }
    
    /**
     * Getter for if a rabbit is prone for disease
     * @return ZIEKTE_GEN Determine if a rabbit is prone for disease
     */
    public boolean getZiekteGen()
    {
        return ZIEKTE_GEN;
    }
    
    /**
     * Getter for the disease of rabbits
     * @return ziekte Determine if the rabbit is sick
     */
    public boolean getZiekte()
    {
        return ziekte;
    }
}