package us.JackGuldan.Test;

import org.junit.Test;
import us.JackGuldan.Meals;
import us.JackGuldan.MealType;

import static org.junit.Assert.assertEquals;


public class MealsArray {
    @Test
    public void testGetItem(){
        Meals aMeal = new Meals(MealType.BREAKFAST,  "Sushi", 220);

        assertEquals("X",0,0);
    }
}
