import java.util.Comparator;

public class PontSizecomparator implements Comparator<ColorPencil> {


    @Override
    public int compare(ColorPencil pencil, ColorPencil pencil2) {
        return pencil.getPointSize() - pencil.getPointSize();
    }
}
