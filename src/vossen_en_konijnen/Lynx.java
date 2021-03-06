package vossen_en_konijnen; 

import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a lynx.
 * Lynxes age, move, eat rabbits and foxes, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Lynx extends Animal
{
    // Characteristics shared by all Lynxes (class variables).
    
    // The age at which a lynx can start to breed.
    private static final int BREEDING_AGE = 25;
    // The age to which a lynx can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a lynx breeding.
    private static final double BREEDING_PROBABILITY = 0.05;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a lynx can go before it has to eat again.
    private static final int FOOD_VALUE = 15;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    // The lynxes food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a lynx. A lynx can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the lynx will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Lynx(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            super.setAge(rand.nextInt(MAX_AGE));
            foodLevel = rand.nextInt(FOOD_VALUE);
        }
        else {
            super.setAge(0);
            foodLevel = FOOD_VALUE;
        }
    }
    
    /**
     * This is what the lynx does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newLynxes A list to return newly born lynxes.
     */
    public void act(List<Actor> newLynxes)
    {
        incrementAge();
        incrementHunger();
        if(isActive()) {
            super.giveBirth(newLynxes);            
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
     * Make this lynx more hungry. This could result in the lynx's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
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
                    foodLevel = FOOD_VALUE;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isActive()) { 
                    fox.setDead();
                    foodLevel = FOOD_VALUE;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
        }
        return null;
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
}
