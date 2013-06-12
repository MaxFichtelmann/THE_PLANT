package de.taubefichte.plant.color;

import de.taubefichte.plant.Attribute;

public interface Color extends Attribute<Color>
{   
    @Override
    public Color combine( Color other );
    
    public int getRed();
    
    public int getGreen();
    
    public int getBlue();
}
