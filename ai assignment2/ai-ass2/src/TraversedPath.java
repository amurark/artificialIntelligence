import java.util.LinkedList;

public class TraversedPath {
	LinkedList<String> path = new LinkedList<String>();
	int pathCost;
	public TraversedPath(LinkedList<String> travPath, int pathCost, int prevPathCost)
	{
		this.path = travPath;
		/**
		 * This is the path cost or the heuristic cost or both, based on the search.
		 */
		this.pathCost = pathCost+prevPathCost;
	}
}
