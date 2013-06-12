package de.taubefichte.plant;

public interface Gene<A extends Attribute<A>>
{
    Dominance getDominance();
    
    A getValue();
    
    @Override
    boolean equals( Object that );
    
    @Override
    int hashCode();
}
