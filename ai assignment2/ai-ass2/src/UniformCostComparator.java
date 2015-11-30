import java.util.Comparator;
public class UniformCostComparator implements Comparator<TraversedPath>
{
	@Override
    public int compare(TraversedPath x, TraversedPath y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.pathCost < y.pathCost)
        {
            return -1;
        }
        if (x.pathCost > y.pathCost)
        {
            return 1;
        }
        return 0;
    }
}
