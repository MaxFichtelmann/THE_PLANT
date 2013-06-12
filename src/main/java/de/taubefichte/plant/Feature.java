package de.taubefichte.plant;

import org.apache.commons.lang3.tuple.Pair;

public interface Feature<G extends Gene<A>, A extends Attribute<A>>
{
    Pair<G, G> getGenes();
    
    A getPhenotype();
}
