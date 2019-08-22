package SinglyLinkList;

public class AppTest {

    public static void main(String[] args){
        SingleLinkList testList = new SingleLinkList();
        testList.insertFirst(100);
        testList.insertFirst(50);
        testList.insertFirst(20);
        testList.insertFirst(10);
        testList.insertLast(1000002);



        testList.displayList();
    }
}
