import java.util.HashMap;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class SearchUSA {
	public static HashMap<String,String> telecomLinkMap = new HashMap<String,String>();
	public static HashMap<String,Integer> telecomLinkPathCosts = new HashMap<String,Integer>();
	public static void main(String[] args) {
		/**
		 * Validating the arguments
		 */
		if(args.length == 0)
		{
			System.out.println("Please enter valid arguments for the program to work. The format is: SearchType StartingPoint Destination");
			return;
		}
		else
		{
			if(args.length == 3)
			{
				if(args[0] != null && args[0].length() > 0)
				{
					if(args[1] != null && args[1].length() > 0)
					{
						if(args[2] != null && args[2].length() > 0)
						{
							Paths.populateTelecomLinkMap();
							Paths.populateLatLong();
							//System.out.println(Paths.getPaths("keyWest"));
							if(args[0].equals("uniform"))
							{
								implementUniformCostSearch(args[1], args[2]);
							}
							else if(args[0].equals("greedy"))
							{
								implementGreedySearch(args[1], args[2]);
							}
							else if(args[0].equals("astar"))
							{
								implementAStar(args[1], args[2]);
							}
						}
						else
						{
							System.out.println("Invalid destination");
						}
					}
					else
					{
						System.out.println("Invalid startingPoint");
					}
				}
				else
				{
					System.out.println("Invalid searchtype, allowed values:- astar, greedy, uniform");
				}
			}
			else
			{
				System.out.println("Invalid arguments");
			}
		}
	}
	
	private static void implementUniformCostSearch(String startPoint, String endPoint) 
	{
		LinkedList<String> InitialNode = new LinkedList<String>();
		/**
		 * Starting node of the path is added to the linked list to start a path
		 */
		InitialNode.add(startPoint);
		/**
		 * Path object is created.
		 */
		TraversedPath tp = new TraversedPath(InitialNode, 0, 0);
		/**
		 * A comparator is defined for the priority queue
		 */
		Comparator<TraversedPath> comparator = new UniformCostComparator();
		/**
		 * Priority queue is initialized
		 */
		PriorityQueue<TraversedPath> queue = new PriorityQueue<TraversedPath>(10, comparator);
		/**
		 * Initialize a priority queue of paths with the one node path consisting of the initial node.
		 */
		queue.add(tp);
		TraversedPath finalPath;
		LinkedList<String> finalPathString = new LinkedList<String>();
		int finalCost = 0;
		while(queue.size() != 0)
		{
			/**
			 * Remove the path at root
			 */
			TraversedPath tPath = queue.remove();
			/**
			 * Get the last node in the path
			 */
			String lastNode = tPath.path.peekLast();
			/**
			 * If the lastNode in the path matches the endPoint, return the TraversedPath object.
			 */
			//System.out.println(lastNode);
			if(lastNode.equals(endPoint))
			{
				finalPath = tPath;
				finalPathString = finalPath.path;
				finalCost = finalPath.pathCost;
				break;
			}
			else
			{
				ArrayList<String> childNodes = new ArrayList<String>(Paths.getPaths(lastNode));
				for(String children: childNodes)
				{
					LinkedList<String> newPath = new LinkedList<String>(tPath.path);
					String nextCity = children.split("\\:")[0];
					int costForPath = Integer.parseInt(children.split("\\:")[1]);
					if(!tPath.path.contains(nextCity))
					{
						newPath.add(nextCity);
						/**
						 * Path object is created.
						 */
						TraversedPath tpChild = new TraversedPath(newPath, costForPath, tPath.pathCost);
						queue.add(tpChild);
					}
				}
			}
		}
		System.out.println("Expanded nodes: ");
		ArrayList<String> enodes = new ArrayList<String>();
		for(TraversedPath q: queue)
		{
			enodes.add(q.path.peekLast());
		}
		System.out.println(enodes);
		System.out.println("Number of Expanded nodes: "+enodes.size());
		System.out.println("Solution Path:");
		System.out.println(finalPathString);
		System.out.println("Number of nodes in soution path "+finalPathString.size());
		System.out.println("Total distance from startPoint to endPoint: "+finalCost);
	}
	
	
	
	
	
	
	
	
	
	
	private static void implementGreedySearch(String startPoint, String endPoint) 
	{
		LinkedList<String> InitialNode = new LinkedList<String>();
		/**
		 * Starting node of the path is added to the linked list to start a path
		 */
		InitialNode.add(startPoint);
		/**
		 * Path object is created.
		 */
		TraversedPathForGBF tp = new TraversedPathForGBF(InitialNode, 0, 0, 0);
		/**
		 * A comparator is defined for the priority queue
		 */
		Comparator<TraversedPathForGBF> comparator = new GBFComparator();
		/**
		 * Priority queue is initialized
		 */
		PriorityQueue<TraversedPathForGBF> queue = new PriorityQueue<TraversedPathForGBF>(10, comparator);
		/**
		 * Initialize a priority queue of paths with the one node path consisting of the initial node.
		 */
		queue.add(tp);
		TraversedPathForGBF finalPath;
		LinkedList<String> finalPathString = new LinkedList<String>();
		int finalCost = 0;
		while(queue.size() != 0)
		{
			/**
			 * Remove the path at root
			 */
			TraversedPathForGBF tPath = queue.remove();
			/**
			 * Get the last node in the path
			 */
			String lastNode = tPath.path.peekLast();
			/**
			 * If the lastNode in the path matches the endPoint, return the TraversedPath object.
			 */
			//System.out.println(lastNode);
			if(lastNode.equals(endPoint))
			{
				finalPath = tPath;
				finalPathString = finalPath.path;
				finalCost = finalPath.pathCost;
				break;
			}
			else
			{
				ArrayList<String> childNodes = new ArrayList<String>(Paths.getPaths(lastNode));
				for(String children: childNodes)
				{	
					LinkedList<String> newPath = new LinkedList<String>(tPath.path);
					String nextCity = children.split("\\:")[0];
					double heuristicVal = Paths.getHeuristic(nextCity,endPoint);
					int costForPath = Integer.parseInt(children.split("\\:")[1]);
					if(!tPath.path.contains(nextCity))
					{
						newPath.add(nextCity);
						/**
						 * Path object is created.
						 */
						TraversedPathForGBF tpChild = new TraversedPathForGBF(newPath, heuristicVal, costForPath, tPath.pathCost);
						queue.add(tpChild);
					}
				}
			}
		}
		System.out.println("Expanded nodes: ");
		ArrayList<String> enodes = new ArrayList<String>();
		for(TraversedPathForGBF q: queue)
		{
			enodes.add(q.path.peekLast());
		}
		System.out.println(enodes);
		System.out.println("Number of Expanded nodes: "+enodes.size());
		System.out.println("Solution Path:");
		System.out.println(finalPathString);
		System.out.println("Number of nodes in soution path "+finalPathString.size());
		System.out.println("Total distance from startPoint to endPoint: "+finalCost);
	}
	
	
	
	private static void implementAStar(String startPoint, String endPoint) 
	{
		LinkedList<String> InitialNode = new LinkedList<String>();
		/**
		 * Starting node of the path is added to the linked list to start a path
		 */
		InitialNode.add(startPoint);
		/**
		 * Path object is created.
		 */
		TraversedPathForGBF tp = new TraversedPathForGBF(InitialNode, 0, 0, 0, 1);
		/**
		 * A comparator is defined for the priority queue
		 */
		Comparator<TraversedPathForGBF> comparator = new GBFComparator();
		/**
		 * Priority queue is initialized
		 */
		PriorityQueue<TraversedPathForGBF> queue = new PriorityQueue<TraversedPathForGBF>(10, comparator);
		/**
		 * Initialize a priority queue of paths with the one node path consisting of the initial node.
		 */
		queue.add(tp);
		TraversedPathForGBF finalPath;
		LinkedList<String> finalPathString = new LinkedList<String>();
		double finalCost = 0;
		while(queue.size() != 0)
		{
			/**
			 * Remove the path at root
			 */
			TraversedPathForGBF tPath = queue.remove();
			/**
			 * Get the last node in the path
			 */
			String lastNode = tPath.path.peekLast();
			/**
			 * If the lastNode in the path matches the endPoint, return the TraversedPath object.
			 */
			//System.out.println(lastNode);
			if(lastNode.equals(endPoint))
			{
				finalPath = tPath;
				finalPathString = finalPath.path;
				finalCost = finalPath.heuristicVal;
				break;
			}
			else
			{
				ArrayList<String> childNodes = new ArrayList<String>(Paths.getPaths(lastNode));
				for(String children: childNodes)
				{	
					LinkedList<String> newPath = new LinkedList<String>(tPath.path);
					String nextCity = children.split("\\:")[0];
					double heuristicVal = Paths.getHeuristic(nextCity,endPoint);
					int costForPath = Integer.parseInt(children.split("\\:")[1]);
					if(!tPath.path.contains(nextCity))
					{
						newPath.add(nextCity);
						/**
						 * Path object is created.
						 */
						TraversedPathForGBF tpChild = new TraversedPathForGBF(newPath, heuristicVal, costForPath, tPath.pathCost, 1);
						queue.add(tpChild);
					}
				}
			}
		}
		System.out.println("Expanded nodes: ");
		ArrayList<String> enodes = new ArrayList<String>();
		for(TraversedPathForGBF q: queue)
		{
			enodes.add(q.path.peekLast());
		}
		System.out.println(enodes);
		System.out.println("Number of Expanded nodes: "+enodes.size());
		System.out.println("Solution Path:");
		System.out.println(finalPathString);
		System.out.println("Number of nodes in soution path "+finalPathString.size());
		System.out.println("Total distance from startPoint to endPoint: "+finalCost);
	}
}
