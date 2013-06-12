package de.taubefichte.plant.color;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Color
{
    private int red;
    private int green;
    private int blue;
    
    public Color( int red, int green, int blue )
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public int getRed()
    {
        return red;
    }
    
    public int getGreen()
    {
        return green;
    }
    
    public int getBlue()
    {
        return blue;
    }
    
    @Override
    public boolean equals( Object that )
    {
        return EqualsBuilder.reflectionEquals( this, that );
    }
    
    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode( this );
    }
}
