import java.util.Comparator;
public class GBFComparator implements Comparator<TraversedPathForGBF>
{
	@Override
    public int compare(TraversedPathForGBF x, TraversedPathForGBF y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.heuristicVal < y.heuristicVal)
        {
            return -1;
        }
        if (x.heuristicVal > y.heuristicVal)
        {
            return 1;
        }
        return 0;
    }
}
