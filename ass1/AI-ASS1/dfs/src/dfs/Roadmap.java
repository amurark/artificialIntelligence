package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Roadmap {
	public City rootCity;
	public City destCity;
	public ArrayList<City> cities = new ArrayList<City>();
	public int[][] connectivityTable;
	
	int cityCount;
	
	/**
	 * Method to add cities to the map of Romania
	 * @param c
	 */
	public void addCity(City c) {
		cities.add(c);
		//System.out.println("'"+c.name+"' added to the list of cities");
	}
	
	/**
	 * MEthod to set the root city.
	 * @param rCity
	 */
	public void setRootCity(String rCity) {
		
		for (City c : cities) {
			if(c.name.equals(rCity))
			{
				this.rootCity = c;
			}
        }
	}
	
	/**
	 * Method to set the destination city
	 * @param dCity
	 */
	public void setDestCity(String dCity) {
		
		for (City c : cities) {
			if(c.name.equals(dCity))
			{
				this.destCity = c;
			}
        }
	}
	
	/**
	 * Method to initialize the table with size.
	 */
	public void initTable() {
		this.cityCount = cities.size();
		this.connectivityTable = new int[this.cityCount][this.cityCount];
	}
	
	/**
	 * Method to lay the paths between the cities c1 and c2
	 * @param c1
	 * @param c2
	 */
	public void connectCities(City c1, City c2) {
		if(this.connectivityTable == null) {
			this.initTable();
		}
		connectivityTable[cities.indexOf(c1)][cities.indexOf(c2)] = 1;
		connectivityTable[cities.indexOf(c2)][cities.indexOf(c1)] = 1;	
	}
	
	/**
	 * Display the destCity
	 */
	public void dispDestCity() {
		System.out.println("\nThe destination city is: "+this.destCity.name);
	}
	
	/**
	 * Display the rootCity
	 */
	public void dispRootCity() {
		System.out.println("\nThe root city is: "+this.rootCity.name);
	}
	
	/**
	 * To display the connectivity table
	 */
	public void dispTable() {
		for(int i=0; i < this.cityCount; i++)
		{
			System.out.println("\n");
			for(int j=0; j < this.cityCount; j++)
			{
				System.out.print(this.connectivityTable[i][j]+" ");
			}
		}
	}
	
	private City getChildren(City c)
	{	
		int index=cities.indexOf(c);
		int j=0;
		while(j<cityCount)
		{
			if(connectivityTable[index][j]==1 && ((City)cities.get(j)).traversed==false)
			{
				return (City)cities.get(j);
			}
			j++;
		}
		return null;
	}
	
	/**
	 * Function for depth-First Search
	 */
	public void depthFirst()
	{
		System.out.println("\nThe depth-first-search will give the following results:");
		Stack s = new Stack();
		/**
		 * Mark the root node as traversed and...
		 */
		this.rootCity.traversed = true;
		/**
		 * Initialize the stack of paths with the root-city
		 */
		s.push(this.rootCity);
		/**
		 * Display the traversed city.
		 */
		System.out.print(this.rootCity.name+" ");
		while(!s.isEmpty())
		{
			City n=(City)s.peek();//actually gives the last object
			City child=getChildren(n);
			
			if(child != null)
			{
				child.traversed=true;
				System.out.print(child.name+" ");
				s.push(child);
				if(child.name==this.destCity.name)
				{
					break;
				}
			}
			else
			{
				s.pop();
			}
		}
	
		//Clear visited property of nodes
		clearNodes();
	}
	
	/**
	 * Function for breadth-First Search
	 */
	public void breadthFirst()
	{
		System.out.println("\nThe breadth-first-search will give the following results:");
		
		Queue q=new LinkedList();
		q.add(this.rootCity);
		System.out.print(this.rootCity.name+" ");
		rootCity.traversed = true;
		while(!q.isEmpty())
		{
			City c=(City)q.remove();
			City child=null;
			boolean destReached = false;
			
			while((child=getChildren(c))!=null)
			{
				child.traversed=true;
				System.out.print(child.name+" ");
				q.add(child);
				if(child.name == this.destCity.name)
				{
					destReached = true;
					break;
				}
			}
			if(destReached)
			{
				break;
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
		int i=0;
		while(i<cityCount)
		{
			City n=(City)cities.get(i);
			n.traversed=false;
			i++;
		}
	}
}
