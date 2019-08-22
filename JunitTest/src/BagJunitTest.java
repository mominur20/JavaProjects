import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagJunitTest
{

    private BagSet<Integer> set;
    @Before
    public void setup()
    {

         set = new BagSet<>(5);
    }
    @Test
    public void testConstructor()
    {

        // test IllegalArgumentException is throw when a non-positive capacity set
        try
        {
            set = new BagSet<>(0); // wrong capacity

            //should not be reach this line
            Assert.fail("An illegalArgumentException was not thrown when entering a non-positive capacity");

        }
        catch (IllegalArgumentException e)
        {
            // the goal is to reach this catch block, most of them are fine
        }
    }

    @Test
    public void testAdd()
    {

       // BagSet<Integer> set = new BagSet<>(5);
        // can add a few items to the bagset
        set.add(10);
        set.add(20);
        set.add(30);

        Assert.assertEquals("the size() of the BagSet should be 3 after adding 3 elements", 3,set.size());
        // verify that and cannot add duplicates

        set.add(10); // this should not be inserted into the BagSet
        Assert.assertEquals("This should not be inserted into the BagSet",3,set.size());

        // verify that cannot add more elements than the capacity
        set.add(40);
        set.add(50);
        set.add(60); //this should not be added to the Bagset;
        Assert.assertEquals("size() has increased the capacity of the BagSet",5,set.size());
    }

    @Test
    public void tesContains()
    {

       // BagSet<Integer> set = new BagSet<>(5);
        // verify that and find an element that is inside the BagSet
        set.add(10);
        Assert.assertTrue("contains() should return true if the element is found in the BagSet",set.contains(10));

        //verify that find an element that is not inside BagSet
        Assert.assertFalse("contains() should return False if the element is found in the BagSet",set.contains(20));
    }



    @Test
    public void testSize()
    {
       // BagSet<Integer> set = new BagSet<>(5);
        //Verify size() is zero for an empty BagSet
        Assert.assertEquals("the size() should be zero for an empty BagSet", 0,set.size());

        // verify size() increase as add element
        set.add(10);
        Assert.assertEquals("size() should increase after calling add()", 1,set.size());
        set.add(20);
        Assert.assertEquals("size() should increase after calling add()", 2,set.size());


        // verify size() Decreases as remove elements
        set.remove(10);
        Assert.assertEquals("size() should Decrease after calling Remove()", 1,set.size());
        set.remove(20);
        Assert.assertEquals("size() should Decrease after calling Remove()", 0,set.size());

    }

    @Test
    public void testRemove()
    {

        set.add(10);
        set.add(20);
        set.add(30);

        set.remove(10);
        Assert.assertEquals("size() should be 2 after removing on element", 2,set.size());

        //Existing element
        boolean result = set.remove(20);
        Assert.assertTrue("Removing on element that exists in the bag should return true",result);

        // not existing element
        result = set.remove(-10);
        Assert.assertFalse("Removing an element that does not exist in the bag should return false",result);

        // Repeatedly remove same element
        result = set.remove(20);
        Assert.assertFalse("Removing a previously removed element should return false",result);
    }

}
