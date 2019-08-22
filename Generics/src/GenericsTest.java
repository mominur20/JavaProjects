public class GenericsTest {

    public static void main(String[] args)
    {
        IntegerStorage number = new IntegerStorage(300);

        System.out.println("value: " + number.getData());
        number.setData(200);
        System.out.println("Value: "+ number.getData());

        // String

        StringStorage string = new StringStorage("String information");
        System.out.println("Value: "+ string.getData());

        // Object
        ObjectStorage object1 = new ObjectStorage("Object information");
        System.out.println("Value: "+ object1.getData().toString());


        // Object 2
        ObjectStorage object2 = new ObjectStorage(new Car());
        System.out.println("Value: "+ object1.getData().toString());


        // Generic to store and retrieve the object
        DataStorage<String> stringValue = new DataStorage<String>("welcome");

        DataStorage<Integer> intergerValue = new DataStorage<Integer>(55);

        DataStorage<Boolean> booleanValue = new DataStorage<Boolean>(true);

        DataStorage<Car> carValue = new DataStorage<Car>(new Car());


        // print information
        System.out.println(stringValue.getData().toUpperCase());
        System.out.println(booleanValue.getData());


        // Another Example
        int number1 = 8;
        int number2 = 6;

        AnotherExample<Integer, Integer> results = new AnotherExample<Integer, Integer>(number1 / number2, number1 % number2);

        System.out.println("Quotient: " + results.getFirst());
        System.out.println("Remainder: " + results.getSecond());

        AnotherExample<String,Boolean> Testresult = new AnotherExample<String, Boolean>("Ten",true);
        System.out.println("AnotherEx: " + Testresult.getFirst());
        System.out.println("AnotherEx: " + Testresult.getSecond());

    }



}
