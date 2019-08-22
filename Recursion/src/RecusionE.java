public class RecusionE {

    private static int methodCount = 0;
    public static void main(String[] args){

        countT0(10);

        System.out.println("Another Example");
        System.out.println(" ****");
        // another example
        printArray(new String[] {"How", "are",  "you"}, 0);


        System.out.println("");
        System.out.println("Another Example");
        System.out.println(" ****");

        //another exampole
        System.out.println("factorial(0): " + factorial(0));
        System.out.println("factorial(1): " + factorial(1));
        System.out.println("factorial(2): " + factorial(2));
        System.out.println("factorial(3): " + factorial(3));
        System.out.println("factorial(4): " + factorial(4));





    }

    // Print the number
    public static void countT0( int n)
    {
        // base case
        if (n < 1)
        {
            return; // stop the Recursing
        }
        System.out.println(n);
        // recurse
        countT0(n - 1);
    }

    // Array with recursion
    public static void printArray(String[] words, int index)
    {

        if(index < 0 || index >= words.length)
        {

            return; // stop recursing
        }
        // what is base case
        if(index == words.length)
        {
            System.out.println(); // print a new line charecater
            return; // stop recursing
        }
        // print the current word
        System.out.print(words[index] + " ");

        //recurse and approach the base case
        printArray(words, index + 1);
    }


    // another Example
    public static int factorial(int n)
    {
        // base case
        if(n == 0)
        {
            return 1; // 0! = 1
        }
        int result = n * factorial(n - 1);
        return result;
    }

}
