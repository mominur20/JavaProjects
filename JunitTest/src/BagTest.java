public class BagTest {
    public static void main(String[] args)

    {
        BagSet<Integer> set = new BagSet<>(5);

        // add elemtnt
        set.add(10);
        set.add(20);
        set.add(30);

        //are the elements present in the set
        System.out.println("contains(10):" + set.contains(10));
        System.out.println("size():" +set.size());

        // iterate over the set?
        System.out.println();
        for (int element : set)
        {
            System.out.println("Element:" + element);
        }

    }
}
