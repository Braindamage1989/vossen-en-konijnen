package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Iterator;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;
import vossen_en_konijnen.model.Randomizer;

/**
 * A simple model of a lynx.
 * Lynxes age, move, eat rabbits and lynxes, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Lynx extends Animal
{
    // Characteristics shared by all Lynxes (class variables).
    
    // The age at which a lynx can start to breed.
    private static int breedingAge = 20;
    // The age to which a lynx can live.
    private static int maxAge = 150;
    // The likelihood of a lynx breeding.
    private static double breedingProbability = 0.08;
    // The maximum number of births.
    private static int maxLitterSize = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a lynx can go before it has to eat again.
    private static int foodValue = 15;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * Create a lynx. A lynx can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the lynx will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     * @param gender The gender of a lynx
     */
    public Lynx(boolean randomAge, Field field, Location location, boolean gender)
    {
        super(field, location, gender);
        if(randomAge) {
            setAge(rand.nextInt(maxAge));
            setFoodLevel(rand.nextInt(foodValue));
        }
        else {
            setAge(0);
            setFoodLevel(foodValue);
        }
    }
    
    /**
     * This is what the lynx does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param newLynxes A list to return newly born lynxes.
     */
    public void act(List<Actor> newLynxes)
    {
        incrementAge();
        incrementHunger();
        if(isActive()) {
            giveBirth(newLynxes);            
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
                    setFoodLevel(foodValue);
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if(animal instanceof Fox) {
                Fox lynx = (Fox) animal;
                if(lynx.isActive()) { 
                    lynx.setDead();
                    setFoodLevel(foodValue);
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
        }
        return null;
    }
    
    /**
     * Setter for the maximum age of lynxes
     * @param age the maximum age for lynxes
     */
    public static void setMaxAge(int age)
    {
    	maxAge = age;
    }
    
    /**
     * Setter for the breeding age of lynxes
     * @param age the breeding age for lynxes
     */
    public static void setBreedingAge(int age)
    {
    	breedingAge = age;
    }
    
    /**
     * Setter for the chance lynxes will breed
     * @param chance The chance a lynx will breed
     */
    public static void setBreedingProbability(double chance)
    {
    	breedingProbability = chance;
    }
    
    /**
     * Setter for the food value of lynxes
     * @param value The food value of a lynx
     */
    public static void setFoodValue(int value)
    {
    	foodValue = value;
    }
    
     /**
     * Setter for the max litter size of lynxes
     * @param litterSize The maximum of births a lynx can give
     */
    public static void setMaxLitterSize(int litterSize)
    {
    	maxLitterSize = litterSize;
    }
    
    /**
     * Getter for the breeding age of lynxes
     * @return breedingAge The breeding age of lynxes
     */
    @Override
    public int getBreedingAge()
    {
        return breedingAge;
    }
    
    /**
     * Getter for the breeding age of lynxes
     * @return breedingAge The breeding age of lynxes
     */
    public static int getLynxBreedingAge()
    {
        return breedingAge;
    }
    
    /**
     * Getter for the maximum age of lynxes
     * @return maxAge The maximum age of lynxes
     */
    @Override
    public int getMaxAge()
    {
        return maxAge;
    }
    
    /**
     * Getter for the maximum age of lynxes
     * @return maxAge The maximum age of lynxes
     */
    public static int getMaxLynxAge()
    {
        return maxAge;
    }
    
    /**
     * Getter for the chance lynxes will breed
     * @return breedingProbability The chance a lynx will breed
     */
    @Override
    public double getBreedingProbability()
    {
        return breedingProbability;
    }
    
    /**
     * Getter for the chance lynxes will breed
     * @return breedingProbability The chance a lynx will breed
     */
    public static double getLynxBreedingProbability()
    {
        return breedingProbability;
    }
    
    /**
     * Getter for the max litter size of lynxes
     * @return maxLitterSize The maximum of births a lynx can give
     */
    @Override
    public int getMaxLitterSize()
    {
        return maxLitterSize;
    }
    
    /**
     * Getter for the max litter size of lynxes
     * @return maxLitterSize The maximum of births a lynx can give
     */
    public static int getMaxLynxLitterSize()
    {
        return maxLitterSize;
    }
    
     /**
     * Getter for the food value of lynxes
     * @return rabbitFoodValue The food value of a lynx
     */
    public static int getFoodValue()
    {
    	return foodValue;
    }
}