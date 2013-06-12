package de.taubefichte.plant.color;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
     * gene1: standard, red
     * gene2: standard, white
     */
    ColorFeature pinkStandardMix;
    
    /**
     * gene1: standard, red
     * gene2: recessive, yellow
     */
    ColorFeature redStandard;
    
    /**
     * gene1: recessive, red
     * gene2: recessive, yellow
     */
    ColorFeature orangeRecessiveMix;
    
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
