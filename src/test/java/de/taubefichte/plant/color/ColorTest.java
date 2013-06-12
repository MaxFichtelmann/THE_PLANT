package de.taubefichte.plant.color;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ColorTest
{
    /**
     * 255,0,0
     */
    ColorAttribute redColor;
    
    /**
     * 0,255,0
     */
    ColorAttribute greenColor;
    
    /**
     * 255, 255, 0
     */
    ColorAttribute yellowColor;
    
    /**
     * 0,0,0
     */
    ColorAttribute blackColor;
    
    /**
     * 255,255,255
     */
    ColorAttribute whiteColor;
    
    @Before
    public void setup()
    {
        Color red = new Color( 255, 0, 0 );
        Color green = new Color( 0, 255, 0 );
        Color yellow = new Color( 255, 255, 0 );
        Color black = new Color( 0, 0, 0 );
        Color white = new Color( 255, 255, 255 );
        
        redColor = new ColorAttributeImplementation( red );
        greenColor = new ColorAttributeImplementation( green );
        yellowColor = new ColorAttributeImplementation( yellow );
        blackColor = new ColorAttributeImplementation( black );
        whiteColor = new ColorAttributeImplementation( white );
    }
    
    @Test
    public void equalColor()
    {
        ColorAttribute result = redColor.combine( redColor );
        int expectedRed = 255;
        int expectedGreen = 0;
        int expectedBlue = 0;
        
        assertThat( result.getColor().getRed(), is( expectedRed ) );
        assertThat( result.getColor().getGreen(), is( expectedGreen ) );
        assertThat( result.getColor().getBlue(), is( expectedBlue ) );
    }
    
    @Test
    public void blackWhite()
    {
        ColorAttribute result = blackColor.combine( whiteColor );
        int expectedRed = 127;
        int expectedGreen = 127;
        int expectedBlue = 127;
        
        assertThat( result.getColor().getRed(), is( expectedRed ) );
        assertThat( result.getColor().getGreen(), is( expectedGreen ) );
        assertThat( result.getColor().getBlue(), is( expectedBlue ) );
    }
    
    @Test
    public void redYellow()
    {
        ColorAttribute result = redColor.combine( yellowColor );
        int expectedRed = 255;
        int expectedGreen = 127;
        int expectedBlue = 0;
        
        assertThat( result.getColor().getRed(), is( expectedRed ) );
        assertThat( result.getColor().getGreen(), is( expectedGreen ) );
        assertThat( result.getColor().getBlue(), is( expectedBlue ) );
        
    }
    
    @Test
    public void interChangeable()
    {
        ColorAttribute result1 = redColor.combine( yellowColor );
        ColorAttribute result2 = yellowColor.combine( redColor );
        
        Color result1Color = result1.getColor();
        Color result2Color = result2.getColor();
        
        assertThat( result1Color.getRed(), is( equalTo( result2Color.getRed() ) ) );
        assertThat( result1Color.getGreen(), is( equalTo( result2Color.getGreen() ) ) );
        assertThat( result1Color.getBlue(), is( equalTo( result2Color.getBlue() ) ) );
        
        // tests if Color implements the equals method
        assertThat( result1Color, is( equalTo( result2Color ) ) );
        
        // tests if ColorAttribute implements the equals method
        assertThat( result1, is( equalTo( result2 ) ) );
    }
    
}
