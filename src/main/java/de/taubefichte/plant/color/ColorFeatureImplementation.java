package de.taubefichte.plant.color;

import de.taubefichte.plant.util.AbstractFeature;

public class ColorFeatureImplementation extends AbstractFeature<ColorGene, ColorAttribute> implements ColorFeature
{
    public ColorFeatureImplementation( ColorGene gene2, ColorGene gene1 )
    {
        super( gene1, gene2 );
    }
}
