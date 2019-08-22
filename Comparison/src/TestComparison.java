import java.util.Arrays;
import java.util.Scanner;

public class TestComparison {

    public static void main(String[] arg)
    {
        ColorPencil[] pencils = {
                                 new ColorPencil("red",10,87),
                                 new ColorPencil("blue",30,47),

                                 new ColorPencil("black",40,97),
                                 new ColorPencil("yellow",20,57)
                                };

        /*
         ColorPencil pencil = pencils[0];
         ColorPencil penci2 = pencils[1];
        ColorPencil penci3 = pencils[2];

         if(pencil.compareTo(penci2) < 0)
         {
             System.out.println("pencil2 has biger then pencil1 size");
         }
         else if (pencil.compareTo(penci2) > 0)
         {
             System.out.println("pencil1 has biger then pencil2 size");
         }
         else
         {
             System.out.println("Both pencils have the same point size");
         }

        */

        //Comparator Example
       // Arrays.sort(pencils, new PontSizecomparator());

        // Comprable Example
       // Arrays.sort(pencils);


        Scanner console = new Scanner(System.in);
        System.out.println("1. sort by point size \n2. Sort by price");
        int menuChoice = console.nextInt();

        if(menuChoice == 1)
        {
            //short by input array
            Arrays.sort(pencils, new PontSizecomparator());
        }
        else if(menuChoice == 2)
        {
            Arrays.sort(pencils, new PriceComparator());
        }



        for (int i = 0; i < pencils.length; i ++)
        {
            System.out.println(pencils[i]);
        }


    }
}
