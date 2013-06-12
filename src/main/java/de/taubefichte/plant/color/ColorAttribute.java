package de.taubefichte.plant.color;

import de.taubefichte.plant.Attribute;

public interface ColorAttribute extends Attribute<ColorAttribute>
{   
    
    Color getColor();
    
    @Override
    public ColorAttribute combine( ColorAttribute other );
    
}
