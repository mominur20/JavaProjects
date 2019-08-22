import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args)
    {
       // basics();
        example();
    }

    private static void basics()
    {
        //built for speed = hash table internally
        HashSet<String> words = new HashSet<>();

        //  build for ordering elements = binary search tree internally

        TreeSet<Integer> number = new TreeSet<>();

        //Both set class use the set<T> interface
        Set<String> names = new HashSet<>();

        // add
        String[] elements = {"Monier","Rasel", "Keya", "Sume","Sumon"};
        for ( int i = 0; i <elements.length; i++)
        {
            names.add(elements[i]);
        }

        // Iterate over the elements in th set
        for (int i = 0; i <names.size(); i++)
        {
            //System.out.println(names.get(i));
        }

        // enhanced for-loop
        for (String name : names)
        {
            System.out.println(name);
        }

        // other method-= contains(), remove()
        System.out.println();
        System.out.println(names.contains("Monier"));
        names.remove("Monier");
        System.out.println(names.contains("Monier"));

        // Set methods = Union (Join all elemnts in to set )
        Set<String> OtherNames = new TreeSet<>();
        OtherNames.add("Hasen");
        OtherNames.add("Rumy");

        names.addAll(OtherNames);
        System.out.println();
        for (String name : names)
        {
            System.out.println(name);
        }

        for (String name : OtherNames)
        {
            System.out.println(name);
        }



        // Set methods = Intersection (Remove all the elements that are not shared in to set)
        OtherNames = new TreeSet<>();
        OtherNames.add("Samea");
        OtherNames.add("Pintu");
        OtherNames.add("Rumy");

        names.retainAll(OtherNames); // The name set contain the result of the intersection
        for (String name : names)
        {
            System.out.println(name);
        }

        // Set methods = Difference (Remove all elements in a set from another set)
        OtherNames.removeAll(names);
        for (String name : OtherNames)
        {
            System.out.println(name);
        }

    }

    private static void example()

    {
        char[] letters = {'a', 's','b','s','w','b','a','b'};
        // with a group of elements, There are any Duplicate
        Set<Character> letterSet = new HashSet<>();
        for (int i = 0; i < letters.length; i++)
        {
            letterSet.add(letters[i]);
        }
        System.out.println("Duplicates? " + (letters.length !=letterSet.size()));

        // How many Duplicate ?
        System.out.println("Number of Duplicates? " + (letters.length - letterSet.size()));

    }

}
