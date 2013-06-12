package de.taubefichte.plant;

public interface Attribute<A extends Attribute<A>>
{
    A combine( A other );
}
