package de.taubefichte.plant.color;

import de.taubefichte.plant.Feature;

public interface ColorFeature extends Feature<ColorGene, ColorAttribute>
{   
    @Override
    public ColorAttribute getPhenotype();
}
