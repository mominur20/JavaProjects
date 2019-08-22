import java.util.ArrayList;
import java.util.Arrays;

public class Utilities
{
    // Divide 14 / 4 return the reminder (2)  of the Division
    // and the quotient (3)

    // Math Example
    public static Information <Integer,Integer> divideRational(int numerator, int denominator)
    {
        // Calculate the results
        int quotient = numerator / denominator;
        int remainder = numerator % denominator;
        // Prepare a Information object and return it
        //Information<Integer,Integer> result = new Information<>(quotient, remainder);
        return new Information<>(quotient, remainder);
    }

    // Another Example
    public static ArrayList<Information<String,Integer>> wordCounts(String sentence)
    {
        String[] words = sentence.split(" ");
        ArrayList<Information<String, Integer>> counts = new ArrayList<>();

        //for each word
        for (String word : words)
        {
            boolean found = false;
            for (Information<String, Integer> count : counts)
            {
                if(count.getFirst().equals(word))
                {
                    found = true;
                    count.setSecond(count.getSecond() + 1);
                    break;
                }
            }
            // if (word) not found in Information class
            if(!found)
            {
                counts.add(new Information<String, Integer>(word, 1));
            }
        }


        return counts;
    }

}
