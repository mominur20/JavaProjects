public class QueueTest {
    public static void main(String[] args) {
        QueueList myQueue = new QueueList(4);
        myQueue.insert(10000);
        myQueue.insert(1000);
        myQueue.insert(500);
        myQueue.insert(200);
        myQueue.insert(100);
        myQueue.view();

    }
}
