package de.taubefichte.plant.color;

import de.taubefichte.plant.Feature;

public interface ColorFeature extends Feature<ColorGene, Color>
{   
    @Override
    public Color getPhenotype();
}
