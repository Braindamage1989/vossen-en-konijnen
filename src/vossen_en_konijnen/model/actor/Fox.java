package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Iterator;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;
import vossen_en_konijnen.model.Randomizer;

/**
 * A simple model of a fox.
 * Foxes age, move, eat rabbits, and die.
 * 
 * @author David J. Barnes, Michael Kölling, Frank Mulder, Ronald Scholten
 * @version 2015.01.30
 */
public class Fox extends Animal
{
    // Characteristics shared by all foxes (class variables).
    
    // The age at which a fox can start to breed.
    private static int breedingAge = 9;
    // The age to which a fox can live.
    private static int maxAge = 150;
    // The likelihood of a fox breeding.
    private static double breedingProbability = 0.1;
    // The maximum number of births.
    private static int maxLitterSize = 4;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static int rabbitFoodValue = 14;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Fox(boolean randomAge, Field field, Location location, boolean gender)
    {
        super(field, location, gender);
        if(randomAge) {
            setAge(rand.nextInt(maxAge));
            setFoodLevel(rand.nextInt(rabbitFoodValue));
        }
        else {
            setAge(0);
            setFoodLevel(rabbitFoodValue);
        }
    }
    
    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void act(List<Actor> newFoxes)
    {
        incrementAge();
        incrementHunger();
        if(isActive()) {
            giveBirth(newFoxes);            
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
                    setFoodLevel(rabbitFoodValue);
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
        }
        return null;
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
    public static void setRabbitFoodValue(int value)
    {
    	rabbitFoodValue = value;
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
    public static int getFoxBreedingAge()
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
    public static int getMaxFoxAge()
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
    public static double getFoxBreedingProbability()
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
    public static int getMaxFoxLitterSize()
    {
        return maxLitterSize;
    }
    
    /**
     * Getter for the food value of foxes
     * @return rabbitFoodValue The food value of a fox
     */
    public static int getRabbitFoodValue()
    {
        return rabbitFoodValue;
    }
}