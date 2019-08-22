public class TestBinarySerch {

public static void main(String[] args)
{
    BinarySerchList<Integer> bfg = new BinarySerchList<>();

    bfg.add(30);
    bfg.add(50);
    bfg.add(60);
    bfg.add(70);
    bfg.add(80);


    System.out.println("Contains (50)" +bfg.contains(50));
    System.out.println("Contains (80)" +bfg.contains(80));
    System.out.println("Contains (10)" +bfg.contains(10));


   // bfg.remove(50);
    System.out.println("Contains (50)" +bfg.contains(50));
   // bfg.postOrder();

    for (int element : bfg)
    {
        System.out.println(element);
    }

}


}


