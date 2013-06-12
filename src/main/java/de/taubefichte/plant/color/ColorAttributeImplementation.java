package de.taubefichte.plant.color;

public class ColorAttributeImplementation implements ColorAttribute
{
    private Color color;
    
    public ColorAttributeImplementation( Color color )
    {
        this.color = color;
    }
    
    @Override
    public Color getColor()
    {
        return color;
    }
    
    @Override
    public ColorAttribute combine( ColorAttribute other )
    {
        Color otherColor = other.getColor();
        
        int red = (color.getRed() + otherColor.getRed()) / 2;
        int green = (color.getGreen() + otherColor.getGreen()) / 2;
        int blue = (color.getBlue() + otherColor.getBlue()) / 2;
        
        return new ColorAttributeImplementation( new Color( red, green, blue ) );
    }
    
}
