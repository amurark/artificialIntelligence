package dfs;

public class Main {
	public static void main(String[] args)
	{
		/**
		 * Create object for all the cities
		 */
		City C1 = new City("oradea");//13
		City C2 = new City("zerind");//20
		City C3 = new City("arad");//1
		City C4 = new City("timisoara");//17
		City C5 = new City("lugoj");//10
		City C6 = new City("mehadia");//11
		City C7 = new City("dobreta");//4
		City C8 = new City("sibiu");//16
		City C9 = new City("rimnicu_vilcea");//15
		City C10 = new City("craiova");//3
		City C11 = new City("pitesti");//14
		City C12 = new City("fagaras");//6
		City C13 = new City("giurgiu");//7
		City C14 = new City("bucharest");//2
		City C15 = new City("urziceni");//18
		City C16 = new City("hirsova");//8
		City C17 = new City("eforie");//5
		City C18 = new City("vaslui");//19
		City C19 = new City("iasi");//9
		City C20 = new City("neamt");//12
		
		
		/**
		 * Insert the cities into the map alphabetically
		 */
		Roadmap romania = new Roadmap();
		romania.addCity(C3);
		romania.addCity(C14);
		romania.addCity(C10);
		romania.addCity(C7);
		romania.addCity(C17);
		romania.addCity(C12);
		romania.addCity(C13);
		romania.addCity(C16);
		romania.addCity(C19);
		romania.addCity(C6);
		romania.addCity(C5);
		romania.addCity(C20);
		romania.addCity(C1);
		romania.addCity(C11);
		romania.addCity(C9);
		romania.addCity(C8);
		romania.addCity(C4);
		romania.addCity(C15);
		romania.addCity(C18);
		romania.addCity(C2);
		
		/**
		 * Set root-city
		 */
		romania.setRootCity(args[1]);
		/**
		 * Set Destination-city
		 */
		romania.setDestCity(args[2]);
		
		romania.dispRootCity();
		romania.dispDestCity();
	
		
		/**
		 * Form paths between cities
		 */
		romania.connectCities(C1,C2);//oradea-zerind
		romania.connectCities(C1,C8);//oradea-sibiu
		romania.connectCities(C2,C3);//zerind-arad
		romania.connectCities(C3,C8);//arad-sibiu
		romania.connectCities(C8,C9);//sibiu-rv
		romania.connectCities(C8,C12);//sibiu-fagaras
		romania.connectCities(C3,C4);//arad-timisoara
		romania.connectCities(C4,C5);//timisoara-lugoj
		romania.connectCities(C5,C6);//lugoj-mehadia
		romania.connectCities(C6,C7);//mehadia-dobreta
		romania.connectCities(C7,C10);//dobreta-craiova
		romania.connectCities(C9,C10);//rv-craiova
		romania.connectCities(C9,C11);//rv-pitesti
		romania.connectCities(C10,C11);//craiova-pitesti
		romania.connectCities(C11,C14);//pitesti-bucharest
		romania.connectCities(C12,C14);//fagaras-bucharest
		romania.connectCities(C14,C13);//giugiu-bucharest
		romania.connectCities(C14,C15);//bucharest-urziceni
		romania.connectCities(C15,C16);//urziceni-hirsova
		romania.connectCities(C15,C18);//urziceni-vaslui
		romania.connectCities(C16,C17);//hirsova-eforie
		romania.connectCities(C18,C19);//vaslui-iasi
		romania.connectCities(C19,C20);//iasi-nearnt
		
		//romania.dispTable();
		System.out.println("\nFor "+args[0]+" algorithm and rootCity = "+args[1]+" and destination city = "+args[2]);
		if(args[0].equals("dfs"))
		{
			romania.depthFirst();
		}
		else if(args[0].equals("bfs"))
		{
			romania.breadthFirst();
		}
		else
		{
			System.out.println("Invalid Arguments");
		}
		
		
		
		
	}
}
