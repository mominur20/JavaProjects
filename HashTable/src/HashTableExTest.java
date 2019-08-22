public class HashTableExTest {

    public static void main(String[] args)
    {
        HashTableEx<String> colorSet = new HashTableEx<String>();

        // add element
        colorSet.add("red");
        colorSet.add("black");
        colorSet.add("green");
        colorSet.add("blue");
        colorSet.add("White");
        colorSet.add("green2");

        System.out.println("Before rehash(): " + colorSet.toString());
        colorSet.add("pink");

        System.out.println("After rehash(): " + colorSet.toString());


        System.out.println("Remove (red): " + colorSet.remove("red"));
        System.out.println("Remove (black2): " + colorSet.remove("black2"));

        System.out.println("Contains (Yellow): " + colorSet.contains("yellow"));


        System.out.println("Size: " + colorSet.size());
        System.out.println("isEmpty: " + colorSet.isEmpty());

/*
        System.out.println("Iterator...............");
        for (String color : colorSet)
        {
            System.out.println(color);
            //colorSet.add("Green3");
        }

     */
    }
}
