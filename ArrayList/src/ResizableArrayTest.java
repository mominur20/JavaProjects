public class ResizableArrayTest {
    public static void main(String[] args)
    {
        ResizableArray list = new ResizableArray(5);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");


        list.printList();

        list.remove("g");
        list.printList();
    }
}
