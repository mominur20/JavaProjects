public class AppTest {

    public static void main(String[] args) {
        StackList theStack = new StackList(21);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(60);


        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.println(value);
        }
    }
}