import java.util.LinkedList;
public class TraversedPathForGBF {
	LinkedList<String> path = new LinkedList<String>();
	double heuristicVal;
	int pathCost;
	public TraversedPathForGBF(LinkedList<String> travPath, double heuristicVal, int pathCost, int prevPathCost)
	{
		this.path = travPath;
		/**
		 * This is the path cost or the heuristic cost or both, based on the search.
		 */
		this.heuristicVal = heuristicVal;
		this.pathCost = prevPathCost+pathCost;
	}
	
	public TraversedPathForGBF(LinkedList<String> travPath, double heuristicVal, int pathCost, int prevPathCost, int forSearch)
	{
//		System.out.println("watsup");
//		System.out.println(travPath);
//		System.out.println(heuristicVal);
//		System.out.println(pathCost);
		this.path = travPath;
		this.pathCost = prevPathCost+pathCost;
		/**
		 * This is the path cost or the heuristic cost or both, based on the search.
		 */
		this.heuristicVal = heuristicVal+this.pathCost;
	}
}
