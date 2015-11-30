import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Paths {
	public static HashMap<String,String> telecomLinkMap = new HashMap<String,String>();
	public static HashMap<String,String> latLong = new HashMap<String,String>();
	final static double PI = 3.14159;
	public static ArrayList<String> getPaths(String city) {
		String pathsConnected;
		pathsConnected = telecomLinkMap.get(city);
		//System.out.println(pathsConnected);
		/**
		 * If we find a value for the specific key(passed city) in the hashmap, then we add those values to an array.
		 * Then we also search for other possible values where the city is found in the value and not as a key. 
		 */
		if(pathsConnected != null)
		{
			 String[] destString = pathsConnected.split("\\|");
			 ArrayList<String> destStringArray = new ArrayList<String>(Arrays.asList(destString));
			 
			 for (Map.Entry<String, String> e : telecomLinkMap.entrySet()) {
					String key = e.getKey();
				    String value = e.getValue();
					if(value.contains(city))
					{
						//System.out.println(value);
						String[] stSplit = value.split(city,2);
						//System.out.println(stSplit[1]);
						if(!destStringArray.contains(key+stSplit[1].split("\\|",2)[0]))
						{
							destStringArray.add(key+stSplit[1].split("\\|",2)[0]);
						}
					}
				}
			 return destStringArray;
		}
		/**
		 * If we don't find the passed city in the keys, then we initialize a new array and then search for the city in the values.
		 * Upon matching, we will add the key(along with the distance) to the array.  
		 */
		else
		{
			ArrayList<String> destStringArray = new ArrayList<String>();
			for (Map.Entry<String, String> e : telecomLinkMap.entrySet()) {
				String key = e.getKey();
			    String value = e.getValue();
				if(value.contains(city))
				{
					//System.out.println(value);
					String[] stSplit = value.split(city,2);
					//System.out.println(stSplit[1]);
					if(!destStringArray.contains(key+stSplit[1].split("\\|",2)[0]))
					{
						destStringArray.add(key+stSplit[1].split("\\|",2)[0]);
					}
				}
			}
			return destStringArray;
		}
		
		
	}
	
	public static void populateTelecomLinkMap() {
		telecomLinkMap.put("albanyNY","montreal:226|boston:166|rochester:148");

		telecomLinkMap.put("albanyGA","tallahassee:120|macon:106");

		telecomLinkMap.put("albuquerque","elPaso:267|santaFe:61");

		telecomLinkMap.put("atlanta","macon:82|chattanooga:117");

		telecomLinkMap.put("augusta","charlotte:161|savannah:131");

		telecomLinkMap.put("austin","houston:186|sanAntonio:79");

		telecomLinkMap.put("bakersfield","losAngeles:112|fresno:107");

		telecomLinkMap.put("baltimore","philadelphia:102|washington:45");

		telecomLinkMap.put("batonRouge","lafayette:50|newOrleans:80");

		telecomLinkMap.put("beaumont","houston:69|lafayette:122");

		telecomLinkMap.put("boise","saltLakeCity:349|portland:428");

		telecomLinkMap.put("boston","providence:51");

		telecomLinkMap.put("buffalo","toronto:105|rochester:64|cleveland:191");

		telecomLinkMap.put("calgary","vancouver:605|winnipeg:829");

		telecomLinkMap.put("charlotte","greensboro:91");

		telecomLinkMap.put("chattanooga","nashville:129");

		telecomLinkMap.put("chicago","milwaukee:90|midland:279");

		telecomLinkMap.put("cincinnati","indianapolis:110|dayton:56");

		telecomLinkMap.put("cleveland","pittsburgh:157|columbus:142");

		telecomLinkMap.put("coloradoSprings","denver:70|santaFe:316");

		telecomLinkMap.put("columbus","dayton:72");

		telecomLinkMap.put("dallas","denver:792|mexia:83");

		telecomLinkMap.put("daytonaBeach","jacksonville:92|orlando:54");

		telecomLinkMap.put("denver","wichita:523|grandJunction:246");

		telecomLinkMap.put("desMoines","omaha:135|minneapolis:246");

		telecomLinkMap.put("elPaso","sanAntonio:580|tucson:320");

		telecomLinkMap.put("eugene","salem:63|medford:165");

		telecomLinkMap.put("europe","philadelphia:3939");

		telecomLinkMap.put("ftWorth","oklahomaCity:209");

		telecomLinkMap.put("fresno","modesto:109");

		telecomLinkMap.put("grandJunction","provo:220");

		telecomLinkMap.put("greenBay","minneapolis:304|milwaukee:117");

		telecomLinkMap.put("greensboro","raleigh:74");

		telecomLinkMap.put("houston","mexia:165");

		telecomLinkMap.put("indianapolis","stLouis:246");

		telecomLinkMap.put("jacksonville","savannah:140|lakeCity:113");

		telecomLinkMap.put("japan","pointReyes:5131|sanLuisObispo:5451");

		telecomLinkMap.put("kansasCity","tulsa:249|stLouis:256|wichita:190");

		telecomLinkMap.put("keyWest","tampa:446");

		telecomLinkMap.put("lakeCity","tampa:169|tallahassee:104");

		telecomLinkMap.put("laredo","sanAntonio:154|mexico:741");

		telecomLinkMap.put("lasVegas","losAngeles:275|saltLakeCity:486");

		telecomLinkMap.put("lincoln","wichita:277|omaha:58");

		telecomLinkMap.put("littleRock","memphis:137|tulsa:276");

		telecomLinkMap.put("losAngeles","sanDiego:124|sanLuisObispo:182");

		telecomLinkMap.put("medford","redding:150");

		telecomLinkMap.put("memphis","nashville:210");

		telecomLinkMap.put("miami","westPalmBeach:67");

		telecomLinkMap.put("midland","toledo:82");

		telecomLinkMap.put("minneapolis","winnipeg:463");

		telecomLinkMap.put("modesto","stockton:29");

		telecomLinkMap.put("montreal","ottawa:132");

		telecomLinkMap.put("newHaven","providence:110|stamford:92");

		telecomLinkMap.put("newOrleans","pensacola:268");

		telecomLinkMap.put("newYork","philadelphia:101");

		telecomLinkMap.put("norfolk","richmond:92|raleigh:174");

		telecomLinkMap.put("oakland","sanFrancisco:8|sanJose:42");

		telecomLinkMap.put("oklahomaCity","tulsa:105");

		telecomLinkMap.put("orlando","westPalmBeach:168|tampa:84");

		telecomLinkMap.put("ottawa","toronto:269");

		telecomLinkMap.put("pensacola","tallahassee:120");

		telecomLinkMap.put("philadelphia","pittsburgh:319|newYork:101|uk1:3548|uk2:3548");

		telecomLinkMap.put("phoenix","tucson:117|yuma:178");

		telecomLinkMap.put("pointReyes","redding:215|sacramento:115");

		telecomLinkMap.put("portland","seattle:174|salem:47");

		telecomLinkMap.put("reno","saltLakeCity:520|sacramento:133");

		telecomLinkMap.put("richmond","washington:105");

		telecomLinkMap.put("sacramento","sanFrancisco:95|stockton:51");

		telecomLinkMap.put("salinas","sanJose:31|sanLuisObispo:137");

		telecomLinkMap.put("sanDiego","yuma:172");

		telecomLinkMap.put("saultSteMarie","thunderBay:442|toronto:436");

		telecomLinkMap.put("seattle","vancouver:115");

		telecomLinkMap.put("thunderBay","winnipeg:440");
	}
	
	public static double getHeuristic(String city1, String city2)
	{
		String value1 = latLong.get(city1);
		float la1 = Float.parseFloat(value1.split("\\|")[0]);
		float lo1 = Float.parseFloat(value1.split("\\|")[1]);
		String value2 = latLong.get(city2);
		float la2 = Float.parseFloat(value2.split("\\|")[0]);
		float lo2 = Float.parseFloat(value2.split("\\|")[1]);
		/**
		 * sqrt((69.5 * (Lat1 - Lat2)) ^ 2 + (69.5 * cos((Lat1 + Lat2)/360 * pi) * (Long1 - Long2)) ^ 2)
		 */
		double d1 = 69.5 * Math.pow((la1-la2), 2);
		double d2 = Math.pow((69.5*Math.cos((la1-la2)/360*PI)*(lo1-lo2)), 2);
		double heuristicVal = Math.sqrt(d1+d2); 
		return heuristicVal;
	}
	
	public static void populateLatLong() 
	{
		latLong.put("albanyGA","31.58|84.17");
		latLong.put("albanyNY","42.66|73.78");
		latLong.put("albuquerque","35.11|106.61");
		latLong.put("atlanta","33.76|84.40");
		latLong.put("augusta","33.43|82.02");
		latLong.put("austin","30.30|97.75");
		latLong.put("bakersfield","35.36|119.03");
		latLong.put("baltimore","39.31|76.62");
		latLong.put("batonRouge","30.46|91.14");
		latLong.put("beaumont","30.08|94.13");
		latLong.put("boise","43.61|116.24");
		latLong.put("boston","42.32|71.09");
		latLong.put("buffalo","42.90|78.85");
		latLong.put("calgary","51.00|114.00");
		latLong.put("charlotte","35.21|80.83");
		latLong.put("chattanooga","35.05|85.27");
		latLong.put("chicago","41.84|87.68");
		latLong.put("cincinnati","39.14|84.50");
		latLong.put("cleveland","41.48|81.67");
		latLong.put("coloradoSprings","38.86|104.79");
		latLong.put("columbus","39.99|82.99");
		latLong.put("dallas","32.80|96.79");
		latLong.put("dayton","39.76|84.20");
		latLong.put("daytonaBeach","29.21|81.04");
		latLong.put("denver","39.73|104.97");
		latLong.put("desMoines","41.59|93.62");
		latLong.put("elPaso","31.79|106.42");
		latLong.put("eugene","44.06|123.11");
		latLong.put("europe","48.87|-2.33");
		latLong.put("ftWorth","32.74|97.33");
		latLong.put("fresno","36.78|119.79");
		latLong.put("grandJunction","39.08|108.56");
		latLong.put("greenBay","44.51|88.02");
		latLong.put("greensboro","36.08|79.82");
		latLong.put("houston","29.76|95.38");
		latLong.put("indianapolis","39.79|86.15");
		latLong.put("jacksonville","30.32|81.66");
		latLong.put("japan","35.68|220.23");
		latLong.put("kansasCity","39.08|94.56");
		latLong.put("keyWest","24.56|81.78");
		latLong.put("lafayette","30.21|92.03");
		latLong.put("lakeCity","30.19|82.64");
		latLong.put("laredo","27.52|99.49");
		latLong.put("lasVegas","36.19|115.22");
		latLong.put("lincoln","40.81|96.68");
		latLong.put("littleRock","34.74|92.33");
		latLong.put("losAngeles","34.03|118.17");
		latLong.put("macon","32.83|83.65");
		latLong.put("medford","42.33|122.86");
		latLong.put("memphis","35.12|89.97");
		latLong.put("mexia","31.68|96.48");
		latLong.put("mexico","19.40|99.12");
		latLong.put("miami","25.79|80.22");
		latLong.put("midland","43.62|84.23");
		latLong.put("milwaukee","43.05|87.96");
		latLong.put("minneapolis","44.96|93.27");
		latLong.put("modesto","37.66|120.99");
		latLong.put("montreal","45.50|73.67");
		latLong.put("nashville","36.15|86.76");
		latLong.put("newHaven","41.31|72.92");
		latLong.put("newOrleans","29.97|90.06");
		latLong.put("newYork","40.70|73.92");
		latLong.put("norfolk","36.89|76.26");
		latLong.put("oakland","37.80|122.23");
		latLong.put("oklahomaCity","35.48|97.53");
		latLong.put("omaha","41.26|96.01");
		latLong.put("orlando","28.53|81.38");
		latLong.put("ottawa","45.42|75.69");
		latLong.put("pensacola","30.44|87.21");
		latLong.put("philadelphia","40.72|76.12");
		latLong.put("phoenix","33.53|112.08");
		latLong.put("pittsburgh","40.40|79.84");
		latLong.put("pointReyes","38.07|122.81");
		latLong.put("portland","45.52|122.64");
		latLong.put("providence","41.80|71.36");
		latLong.put("provo","40.24|111.66");
		latLong.put("raleigh","35.82|78.64");
		latLong.put("redding","40.58|122.37");
		latLong.put("reno","39.53|119.82");
		latLong.put("richmond","37.54|77.46");
		latLong.put("rochester","43.17|77.61");
		latLong.put("sacramento","38.56|121.47");
		latLong.put("salem","44.93|123.03");
		latLong.put("salinas","36.68|121.64");
		latLong.put("saltLakeCity","40.75|111.89");
		latLong.put("sanAntonio","29.45|98.51");
		latLong.put("sanDiego","32.78|117.15");
		latLong.put("sanFrancisco","37.76|122.44");
		latLong.put("sanJose","37.30|121.87");
		latLong.put("sanLuisObispo","35.27|120.66");
		latLong.put("santaFe","35.67|105.96");
		latLong.put("saultSteMarie","46.49|84.35");
		latLong.put("savannah","32.05|81.10");
		latLong.put("seattle","47.63|122.33");
		latLong.put("stLouis","38.63|90.24");
		latLong.put("stamford","41.07|73.54");
		latLong.put("stockton","37.98|121.30");
		latLong.put("tallahassee","30.45|84.27");
		latLong.put("tampa","27.97|82.46");
		latLong.put("thunderBay","48.38|89.25");
		latLong.put("toledo","41.67|83.58");
		latLong.put("toronto","43.65|79.38");
		latLong.put("tucson","32.21|110.92");
		latLong.put("tulsa","36.13|95.94");
		latLong.put("uk1","51.30|0.00");
		latLong.put("uk2","51.30|0.00");
		latLong.put("vancouver","49.25|123.10");
		latLong.put("washington","38.91|77.01");
		latLong.put("westPalmBeach","26.71|80.05");
		latLong.put("wichita","37.69|97.34");
		latLong.put("winnipeg","49.90|97.13");
		latLong.put("yuma","32.69|114.62");	
	}
}
