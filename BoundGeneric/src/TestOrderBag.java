public class TestOrderBag {

    public static void main (String[] args)
    {
        // create the bag and elements to insert
        OrderBag<Integer> numberBag = new OrderBag<>(10);
        int[] elements = {10, 2, 5, 9, 20, 40};

        // insert the element inside the bag
        for (int element : elements)
        {
            numberBag.add(element);
        }
        System.out.println(numberBag.toString());
        System.out.println();

        System.out.println("Min Element: " + numberBag.findMinimum());
        // Sort and show results
        numberBag.sort();
        System.out.println("Sort order Bag" + numberBag.toString());
        System.out.println("Min Element search: " + numberBag.findMinimum());
    }
}
