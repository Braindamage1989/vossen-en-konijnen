package vossen_en_konijnen.logic;

import java.util.List;

/**
 * De interface die uitgebreid kan worden door elke klasse
 * die deel wil nemen aan de simulatie
 */
public interface Actor
{
    /**
    * Voer het gebruikelijke gedrag van de deelnemer uit.
    * @param newActors Een lijst waarin zojuist gemaakte
    * deelnemers worden opgelsagen.
    */
    void act(List<Actor> newActors);
    
    /**
    * Is de deelnemer nog steeds actief?
    * @return true als de deelnemer nog actief, anders false.
    */
    boolean isActive();
}
