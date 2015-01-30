package vossen_en_konijnen.model.actor; 

import java.util.List;
import java.util.Random;

import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;
import vossen_en_konijnen.model.Randomizer;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author Ronald Scholten
 * @version 2015.01.30
 */
public abstract class Animal implements Actor
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
     // The animal's age.
    private int age;
    // true is male, false is female
    private boolean gender;
     // The animal's food level
    private int foodLevel;
    
    private static final Random rand = Randomizer.getRandom();
    
    @Override
    abstract public void act(List<Actor> newActors);
    abstract double getBreedingProbability();
    abstract int getMaxLitterSize();
    abstract int getMaxAge();
    abstract int getBreedingAge();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     * @param gender The gender of an animal
     */
    public Animal(Field field, Location location, boolean gender)
    {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;
        this.gender = gender;
    }
    
    /**
     * Check whether or not this animal is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newAnimals A list to return newly born animals.
     */
    protected void giveBirth(List<Actor> newAnimals)
    {
        if(findMate(this)) {
	    Animal animal = this;
	    Field field = getField();
	    List<Location> free = field.getFreeAdjacentLocations(getLocation());
	    int births = breed();
	    boolean gender = rand.nextBoolean();
	    for(int b = 0; b < births && free.size() > 0; b++) {
	        Location loc = free.remove(0);
	        if(animal instanceof Fox) {
	            Fox young = new Fox(false, field, loc, gender);
	            newAnimals.add(young);
	        }
	        else if(animal instanceof Rabbit) {
	            Rabbit young = new Rabbit(false, field, loc, gender);
	            newAnimals.add(young);
	        }
                else if(animal instanceof Lynx) {
	            Lynx young = new Lynx(false, field, loc, gender);
	            newAnimals.add(young);
	        }
	    }
    	}
    }
    
    /**
     * Find a mate to breed with
     * @param Animal The animal that wants to find a mate.
     */
    protected boolean findMate(Animal animal)
    {
        List<Location> adjacent = field.adjacentLocations(location);
        for(Location next : adjacent) {
        	Object c = field.getObjectAt(next);
            if(c instanceof Rabbit && animal instanceof Rabbit) {
            	Animal a = (Animal) c;
            	return (!a.getGender()||!animal.getGender())&&(a.getGender()||animal.getGender());
            }
            if(c instanceof Fox && animal instanceof Fox) {
            	Animal a = (Animal) c;
            	return (!a.getGender()||!animal.getGender())&&(a.getGender()||animal.getGender());
            }
            if(c instanceof Lynx && animal instanceof Lynx) {
            	Animal a = (Animal) c;
            	return (!a.getGender()||!animal.getGender())&&(a.getGender()||animal.getGender());
            }
        }
    	return false;
    }
    
    /**
     * Setter for age of the animal
     * @param age The age of the animal
     */
    protected void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    protected void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
        
    /**
     * Increase the age. This could result in the animals death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }
    
    /**
     * Set the animals food level.
     * @param foodLevel int The value of the animals food level
     */
    protected void setFoodLevel(int foodLevel)
    {
        this.foodLevel = foodLevel;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
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
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
    
    /**
     * An animal can breed if it has reached the breeding age.
     */
    protected boolean canBreed()
    {
        return age >= getBreedingAge();
    }
    
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    
    /**
     * Getter for age of the animal
     * @return The age of the animal
     */
    protected int getAge()
    {
        return age;
    }
    
    /**
     * Getter for gender of the animal
     * @return The gender of the animal
     */
    public boolean getGender()
    {
        return gender;
    }
    
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    public boolean isActive()
    {
        return alive;
    }
}
