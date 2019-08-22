public class ColorPencil implements Comparable<ColorPencil>{

    private String color;
    private int pointSize;
    private double price;

    public ColorPencil(String color, int pointSize, double price) {
        this.color = color;
        this.pointSize = pointSize;
        this.price = price;
    }

    //comparable mathode
    @Override
    public int compareTo(ColorPencil other)
    {
        //first compare pencile
        if(this.pointSize < other.pointSize)
        {
            return  -1;
        }
        if(this.pointSize > other.pointSize)
        {
            return  1;
        }

        else {
              return 0;
            }

            // return this.pointSize - other.pointSize;
           // return this.color.compareTo(other.color);

           /*
           int colorComparison = this.color.compareTo(other.color);
           if (colorComparison == 0)
           {
             return this.pointSize - other.pointSize;
           }
           else
           {
            return colorComparison;
           }


            */

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPointSize() {
        return pointSize;
    }

    public void setPointSize(int pointSize) {
        this.pointSize = pointSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    @Override
    public String toString()
    {
        return "ColorePencil [color" + color + ", pointSize=" + pointSize +", price=" + price + "]";
    }



}
