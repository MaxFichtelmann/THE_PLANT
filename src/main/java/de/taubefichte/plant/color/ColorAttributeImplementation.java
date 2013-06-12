package de.taubefichte.plant.color;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ColorAttributeImplementation implements ColorAttribute
{
    private Color color;
    
    public ColorAttributeImplementation( Color color )
    {
        this.color = color;
    }
    
    @Override
    public Color getColor()
    {
        return color;
    }
    
    @Override
    public ColorAttribute combine( ColorAttribute other )
    {
        Color otherColor = other.getColor();
        
        int red = (color.getRed() + otherColor.getRed()) / 2;
        int green = (color.getGreen() + otherColor.getGreen()) / 2;
        int blue = (color.getBlue() + otherColor.getBlue()) / 2;
        
        return new ColorAttributeImplementation( new Color( red, green, blue ) );
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
