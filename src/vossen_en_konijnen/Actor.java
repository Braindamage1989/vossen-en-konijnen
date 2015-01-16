package vossen_en_konijnen;

import java.util.List;

/**
 *
 * @author R
 */
public abstract class Actor
{
    abstract public void act(List<Actor> newActors);
    abstract public boolean isActive();
}
