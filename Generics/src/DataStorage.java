public class DataStorage<T>


{
    private T data;

    // constructor
    public DataStorage (T data)
    {
        this.data = data;
    }

    // methods
    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

}
