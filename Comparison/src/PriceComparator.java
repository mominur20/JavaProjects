import java.util.Comparator;

public class PriceComparator implements Comparator<ColorPencil> {
    @Override
    public int compare(ColorPencil pencil, ColorPencil pencil2)

    {
        if (pencil.getPrice() < pencil2.getPrice())
        {
            return -1;
        }

        else if (pencil.getPrice() > pencil2.getPrice())
        {
            return 1;
        }

        else
        {
            return 0;
        }
    }
}
