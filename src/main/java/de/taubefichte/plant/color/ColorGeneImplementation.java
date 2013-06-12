package de.taubefichte.plant.color;

import de.taubefichte.plant.Dominance;

public class ColorGeneImplementation implements ColorGene
{
    private Dominance      dominance;
    private ColorAttribute value;
    
    public ColorGeneImplementation( Dominance dominance, ColorAttribute value )
    {
        this.dominance = dominance;
        this.value = value;
    }
    
    @Override
    public Dominance getDominance()
    {
        return dominance;
    }
    
    @Override
    public ColorAttribute getValue()
    {
        return value;
    }
    
}
