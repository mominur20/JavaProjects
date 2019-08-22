import java.util.ArrayList;

public class Main extends Utilities {

    public static void main(String[] args) {
        Information<Integer, Integer> results = divideRational(14, 4);
        System.out.println("Quotient: " + results.getFirst() + ", Remainder: " + results.getSecond());

        // Another Example Test
        ArrayList<Information<String, Integer>> counts = wordCounts("some some about job informatin about this job is to and job is very hard to find");
        for (Information<String, Integer> count : counts) {
            System.out.println(count.getFirst() + " : " + count.getSecond());
        }
    }
    }

