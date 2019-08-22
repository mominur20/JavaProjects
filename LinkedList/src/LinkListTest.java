public class LinkListTest {

    public static void main(String[] args)
    {
        LinkedList addList = new LinkedList();

        // add element
        addList.add("a");
        addList.add("b");

        System.out.println("Size(): " + addList.toString());
        System.out.println(addList.toString());

        addList.add("c");
        addList.add("d");



        System.out.println(addList.toString());
        addList.add("E");
        addList.add("F");
        System.out.println("new Size " + addList.toString());
        //Test remove
        addList.remove("a");
        addList.remove("b");
        System.out.println("Corent Size(): " + addList.toString());
        System.out.println(addList.toString());
    }


}
