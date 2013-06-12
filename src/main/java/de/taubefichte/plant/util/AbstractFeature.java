package de.taubefichte.plant.util;

import static de.taubefichte.plant.Dominance.DOMINANT;
import static de.taubefichte.plant.Dominance.STANDARD;

import org.apache.commons.lang3.tuple.Pair;

import de.taubefichte.plant.Attribute;
import de.taubefichte.plant.Feature;
import de.taubefichte.plant.Gene;

public abstract class AbstractFeature<G extends Gene<A>, A extends Attribute<A>> implements Feature<G, A>
{
    private G gene1;
    private G gene2;
    
    public AbstractFeature( G gene1, G gene2 )
    {
        this.gene1 = gene1;
        this.gene2 = gene2;
    }
    
    @Override
    public Pair<G, G> getGenes()
    {
        return Pair.of( gene1, gene2 );
    }
    
    @Override
    public A getPhenotype()
    {
        A result;
        A value1 = gene1.getValue();
        A value2 = gene2.getValue();
        
        // check for dominance equality
        if ( gene1.getDominance() == gene2.getDominance() )
        {
            result = value1.combine( value2 );
        }
        else if ( gene1.getDominance() == DOMINANT )
        {
            result = value1;
        }
        else if ( gene2.getDominance() == DOMINANT )
        {
            result = value2;
        }
        else if ( gene1.getDominance() == STANDARD )
        {
            result = value1;
        }
        else if ( gene2.getDominance() == STANDARD )
        {
            result = value2;
        }
        else
        {
            // both are recessive and should have been mixed
            throw new IllegalStateException( "Unexpected State!" );
        }
        
        return result;
    }
    
}
