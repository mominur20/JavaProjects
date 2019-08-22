import java.util.ArrayList;

public class JavaArrayList {

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 100; i <= 1002; i += 100)
        {
            numbers.add(i);
        }

        // Size related method
        System.out.println("Size() :" + numbers.size());
        System.out.println("IsEmpty() :" + numbers.isEmpty());

        // loop and remove elements from the internal array
        numbers.clear();
        System.out.println("IsEmpty() :" + numbers.isEmpty());
        System.out.println(numbers.toString());

        // add(index) - insert operation
        for (int i = 1; i <=40; i++)
        {
            numbers.add(0,i);
        }
        System.out.println(numbers.toString());
        System.out.println();

        // remove by index or element
        numbers.remove(new Integer(40));
        System.out.println(numbers.toString());

        System.out.println();
        numbers.remove(4);
        System.out.println(numbers.toString());

        System.out.println("get() and set()");
        // get() and set()
        System.out.println(numbers.get(0));
        System.out.println(numbers.set(0, 50));
        System.out.println(numbers.toString());


        //contains()
        System.out.println("Contains(): " + numbers.contains(50));
        System.out.println("Contains(): " +numbers.contains(500000));

        // Loop
        for (int i = 0; i <numbers.size(); i++)
        {
            System.out.print(numbers.get(i) + " , ");
        }

        System.out.println();
        // for each loop
        for (int element : numbers)
        {
            System.out.print(element + ", ");
        }
        /*
        numbers.clear();
        System.out.println("Start");
        for (int i = 0; i <= 1000; i++)
        {
             numbers.add(0 , i);
        }
        System.out.println("End");

        */
    }
}
