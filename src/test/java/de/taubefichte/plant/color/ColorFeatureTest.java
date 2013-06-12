package de.taubefichte.plant.color;

import static de.taubefichte.plant.Dominance.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ColorFeatureTest
{
    /**
     * gene1: dominant, red gene2: dominant, red
     */
    ColorFeature pureRed;
    
    /**
     * gene1: dominant, red gene2: recessive, yellow
     */
    ColorFeature redDominant;
    
    /**
     * gene1: dominant, blue gene2: standard, red
     */
    ColorFeature blueDominant;
    
    /**
     * gene1: standard, red gene2: standard, white
     */
    ColorFeature pinkStandardMix;
    
    /**
     * gene1: standard, red gene2: recessive, yellow
     */
    ColorFeature redStandard;
    
    /**
     * gene1: recessive, red gene2: recessive, yellow
     */
    ColorFeature orangeRecessiveMix;
    
    @Before
    public void setup()
    {
        ColorAttribute red = new ColorAttributeImplementation( new Color( 255, 0, 0 ) );
        ColorAttribute yellow = new ColorAttributeImplementation( new Color( 255, 255, 0 ) );
        ColorAttribute blue = new ColorAttributeImplementation( new Color( 0, 0, 255 ) );
        ColorAttribute white = new ColorAttributeImplementation( new Color( 255, 255, 255 ) );
        
        ColorGeneImplementation redDominant = new ColorGeneImplementation( DOMINANT, red );
        ColorGeneImplementation redStandard = new ColorGeneImplementation( STANDARD, red );
        ColorGeneImplementation redRecessive = new ColorGeneImplementation( RECESSIVE, red );
        ColorGeneImplementation yellowRecessive = new ColorGeneImplementation( RECESSIVE, yellow );
        ColorGeneImplementation blueDominant = new ColorGeneImplementation( DOMINANT, blue );
        ColorGeneImplementation whiteStandard = new ColorGeneImplementation( STANDARD, white );
        
        this.pureRed = new ColorFeatureImplementation( redDominant, redDominant );
        this.redDominant = new ColorFeatureImplementation( redDominant, yellowRecessive );
        this.blueDominant = new ColorFeatureImplementation( blueDominant, redStandard );
        this.pinkStandardMix = new ColorFeatureImplementation( redStandard, whiteStandard );
        this.redStandard = new ColorFeatureImplementation( redStandard, yellowRecessive );
        this.orangeRecessiveMix = new ColorFeatureImplementation( redRecessive, yellowRecessive );
    }
    
    @Test
    public void pure()
    {
        ColorAttribute result = pureRed.getPhenotype();
        Color expected = new Color( 255, 0, 0 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
    
    @Test
    public void dominantVsRecessive()
    {
        ColorAttribute result = redDominant.getPhenotype();
        Color expected = new Color( 255, 0, 0 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
    
    @Test
    public void dominantVsStandard()
    {
        ColorAttribute result = blueDominant.getPhenotype();
        Color expected = new Color( 0, 0, 255 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
    
    @Test
    public void standardMix()
    {
        ColorAttribute result = pinkStandardMix.getPhenotype();
        Color expected = new Color( 255, 127, 127 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
    
    @Test
    public void standardVsRecessive()
    {
        ColorAttribute result = redStandard.getPhenotype();
        Color expected = new Color( 255, 0, 0 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
    
    @Test
    public void recessiveMix()
    {
        ColorAttribute result = orangeRecessiveMix.getPhenotype();
        Color expected = new Color( 255, 127, 0 );
        
        assertThat( result.getColor(), is( equalTo( expected ) ) );
    }
}
