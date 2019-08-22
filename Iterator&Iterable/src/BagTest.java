import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class BagTest {


    public static void main (String[] args)
    {
        // create a bag
        Bag schoolBag = new Bag(6);

        // add a few elements to the Bag
        schoolBag.add("book");
        schoolBag.add("pencile");
        schoolBag.add("pen");

        System.out.println(schoolBag.toString());
/*
        for (int i = 0; i < schoolBag.size(); i++)
        {
           // System.out.println(schoolBag.get(i));
        }
        */
        // Not appear NUlL when use Iterator
        System.out.println(" ");
        Iterator<Object> it = schoolBag.iterator();
        while (it.hasNext())
        {
            String insidBag = (String)it.next();
            System.out.println(insidBag);
        }


        //another Example
        ArrayList<String> colors = new ArrayList<>();

        colors.add("green");
        colors.add("Black");
        colors.add("Orange");

        Iterator<String>iterator = colors.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
