import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class searchUSA {
	static String destCity;
	static double destLat;
	static double destLong;
	
	//Custom object
	 static class customObject {
		String cityName;
		int pathCost;
		String parent;
		String coordinates;
		customObject(String c, int p, String par, String coord) {
			cityName=c;
			pathCost=p;
			parent=par;
			coordinates=coord;
		}
		public String getCityName() {
			return cityName;
		}
		public int getPathCost() {
			return pathCost;
		}
		public String getParent() {
			return parent;
		}
		public String getCoordinates() {
			return coordinates;
		}
		public void setPathCost(int c) {
			pathCost = c;
		}
	}
	 //Hashmap of Link list of customobjects & parent city
	 //Hashmap of parent and current city
	 static class USANetwork {
		Map<String, LinkedList<customObject>> map = new HashMap<String, LinkedList<customObject>>();
		static Map<String, String> heuristic = new HashMap<String, String>();
	 }
	
	 //Add into hashmap
	static void addDistancetoDestn(USANetwork network, String city, String coordinates) {
		network.heuristic.put(city,coordinates);
	}

	//call the function which puts details in hashmap 
	static void createHeuristic(USANetwork usnw) {
		addDistancetoDestn(usnw,"albanyGA",   "31.58,84.17");
		addDistancetoDestn(usnw,"albanyNY",   "42.66,73.78");
		addDistancetoDestn(usnw,"albuquerque","35.11,106.61");
		addDistancetoDestn(usnw,"atlanta",    "33.76,84.40");
		addDistancetoDestn(usnw,"augusta",    "33.43,82.02");
		addDistancetoDestn(usnw,"austin",     "30.30,97.75");
		addDistancetoDestn(usnw,"bakersfield","35.36,119.03");
		addDistancetoDestn(usnw,"baltimore",  "39.31,76.62");
		addDistancetoDestn(usnw,"batonRouge", "30.46,91.14");
		addDistancetoDestn(usnw,"beaumont",   "30.08,94.13");
		addDistancetoDestn(usnw,"boise",      "43.61,116.24");
		addDistancetoDestn(usnw,"boston",     "42.32,71.09");
		addDistancetoDestn(usnw,"buffalo",    "42.90,78.85");
		addDistancetoDestn(usnw,"calgary",    "51.00,114.00");
		addDistancetoDestn(usnw,"charlotte",  "35.21,80.83");
		addDistancetoDestn(usnw,"chattanooga","35.05,85.27");
		addDistancetoDestn(usnw,"chicago",    "41.84,87.68");
		addDistancetoDestn(usnw,"cincinnati", "39.14,84.50");
		addDistancetoDestn(usnw,"cleveland",  "41.48,81.67");
		addDistancetoDestn(usnw,"coloradoSprings", "38.86,104.79");
		addDistancetoDestn(usnw,"columbus",   "39.99,82.99");
		addDistancetoDestn(usnw,"dallas",     "32.80,96.79");
		addDistancetoDestn(usnw,"dayton",     "39.76,84.20");
		addDistancetoDestn(usnw,"daytonaBeach",    "29.21,81.04");
		addDistancetoDestn(usnw,"denver",     "39.73,104.97");
		addDistancetoDestn(usnw,"desMoines",  "41.59,93.62");
		addDistancetoDestn(usnw,"elPaso",     "31.79,106.42");
		addDistancetoDestn(usnw,"eugene",     "44.06,123.11");
		addDistancetoDestn(usnw,"europe",     "48.87,-2.33");
		addDistancetoDestn(usnw,"ftWorth",    "32.74,97.33");
		addDistancetoDestn(usnw,"fresno",     "36.78,119.79");
		addDistancetoDestn(usnw,"grandJunction",   "39.08,108.56");
		addDistancetoDestn(usnw,"greenBay",   "44.51,88.02");
		addDistancetoDestn(usnw,"greensboro", "36.08,79.82");
		addDistancetoDestn(usnw,"houston",    "29.76,95.38");
		addDistancetoDestn(usnw,"indianapolis",    "39.79,86.15");
		addDistancetoDestn(usnw,"jacksonville",    "30.32,81.66");
		addDistancetoDestn(usnw,"japan",      "35.68,220.23");
		addDistancetoDestn(usnw,"kansasCity", "39.08,94.56");
		addDistancetoDestn(usnw,"keyWest",    "24.56,81.78");
		addDistancetoDestn(usnw,"lafayette",  "30.21,92.03");
		addDistancetoDestn(usnw,"lakeCity",   "30.19,82.64");
		addDistancetoDestn(usnw,"laredo",     "27.52,99.49");
		addDistancetoDestn(usnw,"lasVegas",   "36.19,115.22");
		addDistancetoDestn(usnw,"lincoln",    "40.81,96.68");
		addDistancetoDestn(usnw,"littleRock", "34.74,92.33");
		addDistancetoDestn(usnw,"losAngeles", "34.03,118.17");
		addDistancetoDestn(usnw,"macon",      "32.83,83.65");
		addDistancetoDestn(usnw,"medford",    "42.33,122.86");
		addDistancetoDestn(usnw,"memphis",    "35.12,89.97");
		addDistancetoDestn(usnw,"mexia",      "31.68,96.48");
		addDistancetoDestn(usnw,"mexico",     "19.40,99.12");
		addDistancetoDestn(usnw,"miami",      "25.79,80.22");
		addDistancetoDestn(usnw,"midland",    "43.62,84.23");
		addDistancetoDestn(usnw,"milwaukee",  "43.05,87.96");
		addDistancetoDestn(usnw,"minneapolis","44.96,93.27");
		addDistancetoDestn(usnw,"modesto",    "37.66,120.99");
		addDistancetoDestn(usnw,"montreal",   "45.50,73.67");
		addDistancetoDestn(usnw,"nashville",  "36.15,86.76");
		addDistancetoDestn(usnw,"newHaven",   "41.31,72.92");
		addDistancetoDestn(usnw,"newOrleans", "29.97,90.06");
		addDistancetoDestn(usnw,"newYork",    "40.70,73.92");
		addDistancetoDestn(usnw,"norfolk",    "36.89,76.26");
		addDistancetoDestn(usnw,"oakland",    "37.80,122.23");
		addDistancetoDestn(usnw,"oklahomaCity",    "35.48,97.53");
		addDistancetoDestn(usnw,"omaha",      "41.26,96.01");
		addDistancetoDestn(usnw,"orlando",    "28.53,81.38");
		addDistancetoDestn(usnw,"ottawa",     "45.42,75.69");
		addDistancetoDestn(usnw,"pensacola",  "30.44,87.21");
		addDistancetoDestn(usnw,"philadelphia",    "40.72,76.12");
		addDistancetoDestn(usnw,"phoenix",    "33.53,112.08");
		addDistancetoDestn(usnw,"pittsburgh", "40.40,79.84");
		addDistancetoDestn(usnw,"pointReyes", "38.07,122.81");
		addDistancetoDestn(usnw,"portland",   "45.52,122.64");
		addDistancetoDestn(usnw,"providence", "41.80,71.36");
		addDistancetoDestn(usnw,"provo",      "40.24,111.66");
		addDistancetoDestn(usnw,"raleigh",    "35.82,78.64");
		addDistancetoDestn(usnw,"redding",    "40.58,122.37");
		addDistancetoDestn(usnw,"reno",       "39.53,119.82");
		addDistancetoDestn(usnw,"richmond",   "37.54,77.46");
		addDistancetoDestn(usnw,"rochester",  "43.17,77.61");
		addDistancetoDestn(usnw,"sacramento", "38.56,121.47");
		addDistancetoDestn(usnw,"salem",      "44.93,123.03");
		addDistancetoDestn(usnw,"salinas",    "36.68,121.64");
		addDistancetoDestn(usnw,"saltLakeCity",    "40.75,111.89");
		addDistancetoDestn(usnw,"sanAntonio", "29.45,98.51");
		addDistancetoDestn(usnw,"sanDiego",   "32.78,117.15");
		addDistancetoDestn(usnw,"sanFrancisco",    "37.76,122.44");
		addDistancetoDestn(usnw,"sanJose",    "37.30,121.87");
		addDistancetoDestn(usnw,"sanLuisObispo",   "35.27,120.66");
		addDistancetoDestn(usnw,"santaFe",    "35.67,105.96");
		addDistancetoDestn(usnw,"saultSteMarie",   "46.49,84.35");
		addDistancetoDestn(usnw,"savannah",   "32.05,81.10");
		addDistancetoDestn(usnw,"seattle",    "47.63,122.33");
		addDistancetoDestn(usnw,"stLouis",    "38.63,90.24");
		addDistancetoDestn(usnw,"stamford",   "41.07,73.54");
		addDistancetoDestn(usnw,"stockton",   "37.98,121.30");
		addDistancetoDestn(usnw,"tallahassee","30.45,84.27");
		addDistancetoDestn(usnw,"tampa",      "27.97,82.46");
		addDistancetoDestn(usnw,"thunderBay", "48.38,89.25");
		addDistancetoDestn(usnw,"toledo",     "41.67,83.58");
		addDistancetoDestn(usnw,"toronto",    "43.65,79.38");
		addDistancetoDestn(usnw,"tucson",     "32.21,110.92");
		addDistancetoDestn(usnw,"tulsa",      "36.13,95.94");
		addDistancetoDestn(usnw,"uk1",        "51.30,0.00");
		addDistancetoDestn(usnw,"uk2",        "51.30,0.00");
		addDistancetoDestn(usnw,"vancouver",  "49.25,123.10");
		addDistancetoDestn(usnw,"washington", "38.91,77.01");
		addDistancetoDestn(usnw,"westPalmBeach",   "26.71,80.05");
		addDistancetoDestn(usnw,"wichita",    "37.69,97.34");
		addDistancetoDestn(usnw,"winnipeg",   "49.90,97.13");
		addDistancetoDestn(usnw,"yuma",       "32.69,114.62");
	}

	//Calls function which add details in hashmap of strng and linklist of custom objects
	 static void createNetwork(USANetwork usnw) {
		addCity(usnw, "albanyNY", "montreal", 226);
		addCity(usnw, "albanyNY", "boston", 166); 
		addCity(usnw, "albanyNY", "rochester", 148);
		addCity(usnw, "albanyGA", "tallahassee", 120);
		addCity(usnw, "albanyGA", "macon", 106);
		addCity(usnw, "albuquerque", "elPaso", 267);
		addCity(usnw, "albuquerque", "santaFe", 61);
		addCity(usnw, "atlanta", "macon", 82);
		addCity(usnw, "atlanta", "chattanooga", 117);
		addCity(usnw, "augusta", "charlotte", 161);
		addCity(usnw, "augusta", "savannah", 131);
		addCity(usnw, "austin", "houston", 186);  
		addCity(usnw, "austin", "sanAntonio", 79);
		addCity(usnw, "bakersfield", "losAngeles", 112);  
		addCity(usnw, "bakersfield", "fresno", 107);
		addCity(usnw, "baltimore", "philadelphia", 102);  
		addCity(usnw, "baltimore", "washington", 45);
		addCity(usnw, "batonRouge", "lafayette", 50);  
		addCity(usnw, "batonRouge", "newOrleans", 80);
		addCity(usnw, "beaumont", "houston", 69);  
		addCity(usnw, "beaumont", "lafayette", 122);
		addCity(usnw, "boise", "saltLakeCity", 349); 
		addCity(usnw, "boise", "portland", 428);
		addCity(usnw, "boston", "providence", 51);
		addCity(usnw, "buffalo", "toronto", 105); 
		addCity(usnw, "buffalo", "rochester", 64);  
		addCity(usnw, "buffalo", "cleveland", 191);
		addCity(usnw, "calgary", "vancouver", 605);  
		addCity(usnw, "calgary", "winnipeg", 829);
		addCity(usnw, "charlotte", "greensboro", 91);
		addCity(usnw, "chattanooga", "nashville", 129);
		addCity(usnw, "chicago", "milwaukee", 90);  
		addCity(usnw, "chicago", "midland", 279);
		addCity(usnw, "cincinnati", "indianapolis", 110);  
		addCity(usnw, "cincinnati", "dayton", 56);
		addCity(usnw, "cleveland", "pittsburgh", 157);  
		addCity(usnw, "cleveland", "columbus", 142);
		addCity(usnw, "coloradoSprings", "denver", 70);  
		addCity(usnw, "coloradoSprings", "santaFe", 316);
		addCity(usnw, "columbus", "dayton", 72);
		addCity(usnw, "dallas", "denver", 792);  
		addCity(usnw, "dallas", "mexia", 83);
		addCity(usnw, "daytonaBeach", "jacksonville", 92);  
		addCity(usnw, "daytonaBeach", "orlando", 54);
		addCity(usnw, "denver", "wichita", 523);  
		addCity(usnw, "denver", "grandJunction", 246);
		addCity(usnw, "desMoines", "omaha", 135);  
		addCity(usnw, "desMoines", "minneapolis", 246);
		addCity(usnw, "elPaso", "sanAntonio", 580); 
		addCity(usnw, "elPaso", "tucson", 320);
		addCity(usnw, "eugene", "salem", 63);  
		addCity(usnw, "eugene", "medford", 165);
		addCity(usnw, "europe", "philadelphia", 3939);
		addCity(usnw, "ftWorth", "oklahomaCity", 209);
		addCity(usnw, "fresno", "modesto", 109);
		addCity(usnw, "grandJunction", "provo", 220);
		addCity(usnw, "greenBay", "minneapolis", 304); 
		addCity(usnw, "greenBay", "milwaukee", 117);
		addCity(usnw, "greensboro", "raleigh", 74);
		addCity(usnw, "houston", "mexia", 165);
		addCity(usnw, "indianapolis", "stLouis", 246);
		addCity(usnw, "jacksonville", "savannah", 140);  
		addCity(usnw, "jacksonville", "lakeCity", 113);
		addCity(usnw, "japan", "pointReyes", 5131);  
		addCity(usnw, "japan", "sanLuisObispo", 5451);
		addCity(usnw, "kansasCity", "tulsa", 249);  
		addCity(usnw, "kansasCity", "stLouis", 256); 
		addCity(usnw, "kansasCity", "wichita", 190);
		addCity(usnw, "keyWest", "tampa", 446);
		addCity(usnw, "lakeCity", "tampa", 169);  
		addCity(usnw, "lakeCity", "tallahassee", 104);
		addCity(usnw, "laredo", "sanAntonio", 154); 
		addCity(usnw, "laredo", "mexico", 741);
		addCity(usnw, "lasVegas", "losAngeles", 275);  
		addCity(usnw, "lasVegas", "saltLakeCity", 486);
		addCity(usnw, "lincoln", "wichita", 277);  
		addCity(usnw, "lincoln", "omaha", 58);
		addCity(usnw, "littleRock", "memphis", 137); 
		addCity(usnw, "littleRock", "tulsa", 276);
		addCity(usnw, "losAngeles", "sanDiego", 124);  
		addCity(usnw, "losAngeles", "sanLuisObispo", 182);
		addCity(usnw, "medford", "redding", 150);
		addCity(usnw, "memphis", "nashville", 210);
		addCity(usnw, "miami", "westPalmBeach", 67);
		addCity(usnw, "midland", "toledo", 82);
		addCity(usnw, "minneapolis", "winnipeg", 463);
		addCity(usnw, "modesto", "stockton", 29);
		addCity(usnw, "montreal", "ottawa", 132);
		addCity(usnw, "newHaven", "providence", 110);  
		addCity(usnw, "newHaven", "stamford", 92);
		addCity(usnw, "newOrleans", "pensacola", 268);
		addCity(usnw, "newYork", "philadelphia", 101);
		addCity(usnw, "norfolk", "richmond", 92);  
		addCity(usnw, "norfolk", "raleigh", 174);
		addCity(usnw, "oakland", "sanFrancisco", 8); 
		addCity(usnw, "oakland", "sanJose", 42);
		addCity(usnw, "oklahomaCity", "tulsa", 105);
		addCity(usnw, "orlando", "westPalmBeach", 168); 
		addCity(usnw, "orlando", "tampa", 84);
		addCity(usnw, "ottawa", "toronto", 269);
		addCity(usnw, "pensacola", "tallahassee", 120);
		addCity(usnw, "philadelphia", "pittsburgh", 319); 
		addCity(usnw, "philadelphia", "newYork", 101); 
		addCity(usnw, "philadelphia", "uk1", 3548);
		addCity(usnw, "philadelphia", "uk2", 3548);
		addCity(usnw, "phoenix", "tucson", 117);  
		addCity(usnw, "phoenix", "yuma", 178);
		addCity(usnw, "pointReyes", "redding", 215);  
		addCity(usnw, "pointReyes", "sacramento", 115);
		addCity(usnw, "portland", "seattle", 174);  
		addCity(usnw, "portland", "salem", 47);
		addCity(usnw, "reno", "saltLakeCity", 520);  
		addCity(usnw, "reno", "sacramento", 133);
		addCity(usnw, "richmond", "washington", 105);
		addCity(usnw, "sacramento", "sanFrancisco", 95);  
		addCity(usnw, "sacramento", "stockton", 51);
		addCity(usnw, "salinas", "sanJose", 31);  
		addCity(usnw, "salinas", "sanLuisObispo", 137);
		addCity(usnw, "sanDiego", "yuma", 172);
		addCity(usnw, "saultSteMarie", "thunderBay", 442);  
		addCity(usnw, "saultSteMarie", "toronto", 436);
		addCity(usnw, "seattle", "vancouver", 115);
		addCity(usnw, "thunderBay", "winnipeg", 440);
		addTwoWayRoad(usnw);		
	}

	 	//Adding 2 way rode . Path from B-A
	static void addTwoWayRoad(USANetwork usnw) {
		addCity(usnw, "montreal", "albanyNY", 226);
		addCity(usnw, "boston", "albanyNY", 166); 
		addCity(usnw, "rochester", "albanyNY", 148);
		addCity(usnw, "tallahassee", "albanyGA", 120);
		addCity(usnw, "macon", "albanyGA", 106);
		addCity(usnw, "elPaso", "albuquerque", 267);
		addCity(usnw, "santaFe", "albuquerque", 61);
		addCity(usnw, "macon", "atlanta", 82);
		addCity(usnw, "chattanooga", "atlanta", 117);
		addCity(usnw, "charlotte", "augusta", 161);
		addCity(usnw, "savannah", "augusta", 131);
		addCity(usnw, "houston", "austin", 186);  
		addCity(usnw, "sanAntonio", "austin", 79);
		addCity(usnw, "losAngeles", "bakersfield", 112);  
		addCity(usnw, "fresno", "bakersfield", 107);
		addCity(usnw, "philadelphia", "baltimore", 102);  
		addCity(usnw, "washington", "baltimore", 45);
		addCity(usnw, "lafayette", "batonRouge", 50);  
		addCity(usnw, "newOrleans", "batonRouge", 80);
		addCity(usnw, "houston", "beaumont", 69);  
		addCity(usnw, "lafayette", "beaumont", 122);
		addCity(usnw, "saltLakeCity", "boise", 349); 
		addCity(usnw, "portland", "boise", 428);
		addCity(usnw, "providence", "boston", 51);
		addCity(usnw, "toronto", "buffalo", 105); 
		addCity(usnw, "rochester", "buffalo", 64);  
		addCity(usnw, "cleveland", "buffalo", 191);
		addCity(usnw, "vancouver", "calgary", 605);  
		addCity(usnw, "winnipeg", "calgary", 829);
		addCity(usnw, "greensboro", "charlotte", 91);
		addCity(usnw, "nashville", "chattanooga", 129);
		addCity(usnw, "milwaukee", "chicago", 90);  
		addCity(usnw, "midland", "chicago", 279);
		addCity(usnw, "indianapolis", "cincinnati", 110);  
		addCity(usnw, "dayton", "cincinnati", 56);
		addCity(usnw, "pittsburgh", "cleveland", 157);  
		addCity(usnw, "columbus", "cleveland", 142);
		addCity(usnw, "denver", "coloradoSprings", 70);  
		addCity(usnw, "santaFe", "coloradoSprings", 316);
		addCity(usnw, "dayton", "columbus", 72);
		addCity(usnw, "denver", "dallas", 792);  
		addCity(usnw, "mexia", "dallas", 83);
		addCity(usnw, "jacksonville", "daytonaBeach", 92);  
		addCity(usnw, "orlando", "daytonaBeach", 54);
		addCity(usnw, "wichita", "denver", 523);  
		addCity(usnw, "grandJunction", "denver", 246);
		addCity(usnw, "omaha", "desMoines", 135);  
		addCity(usnw, "minneapolis", "desMoines", 246);
		addCity(usnw, "sanAntonio", "elPaso", 580); 
		addCity(usnw, "tucson", "elPaso", 320);
		addCity(usnw, "salem", "eugene", 63);  
		addCity(usnw, "medford", "eugene", 165);
		addCity(usnw, "philadelphia", "europe", 3939);
		addCity(usnw, "oklahomaCity", "ftWorth", 209);
		addCity(usnw, "modesto", "fresno", 109);
		addCity(usnw, "provo", "grandJunction", 220);
		addCity(usnw, "minneapolis", "greenBay", 304); 
		addCity(usnw, "milwaukee", "greenBay", 117);
		addCity(usnw, "raleigh", "greensboro", 74);
		addCity(usnw, "mexia", "houston", 165);
		addCity(usnw, "stLouis", "indianapolis", 246);
		addCity(usnw, "savannah", "jacksonville", 140);  
		addCity(usnw, "lakeCity", "jacksonville", 113);
		addCity(usnw, "pointReyes", "japan", 5131);  
		addCity(usnw, "sanLuisObispo", "japan", 5451);
		addCity(usnw, "tulsa", "kansasCity", 249);  
		addCity(usnw, "stLouis", "kansasCity", 256); 
		addCity(usnw, "wichita", "kansasCity", 190);
		addCity(usnw, "tampa", "keyWest", 446);
		addCity(usnw, "tampa", "lakeCity", 169);  
		addCity(usnw, "tallahassee", "lakeCity", 104);
		addCity(usnw, "sanAntonio", "laredo", 154); 
		addCity(usnw, "mexico", "laredo", 741);
		addCity(usnw, "losAngeles", "lasVegas", 275);  
		addCity(usnw, "saltLakeCity", "lasVegas", 486);
		addCity(usnw, "wichita", "lincoln", 277);  
		addCity(usnw, "omaha", "lincoln", 58);
		addCity(usnw, "memphis", "littleRock", 137); 
		addCity(usnw, "tulsa", "littleRock", 276);
		addCity(usnw, "sanDiego", "losAngeles", 124);  
		addCity(usnw, "sanLuisObispo", "losAngeles", 182);
		addCity(usnw, "redding", "medford", 150);
		addCity(usnw, "nashville", "memphis", 210);
		addCity(usnw, "westPalmBeach", "miami", 67);
		addCity(usnw, "toledo", "midland", 82);
		addCity(usnw, "winnipeg", "minneapolis", 463);
		addCity(usnw, "stockton", "modesto", 29);
		addCity(usnw, "ottawa", "montreal", 132);
		addCity(usnw, "providence", "newHaven", 110);  
		addCity(usnw, "stamford", "newHaven", 92);
		addCity(usnw, "pensacola", "newOrleans", 268);
		addCity(usnw, "philadelphia", "newYork", 101);
		addCity(usnw, "richmond", "norfolk", 92);  
		addCity(usnw, "raleigh", "norfolk", 174);
		addCity(usnw, "sanFrancisco", "oakland", 8); 
		addCity(usnw, "sanJose", "oakland", 42);
		addCity(usnw, "tulsa", "oklahomaCity", 105);
		addCity(usnw, "westPalmBeach", "orlando", 168); 
		addCity(usnw, "tampa", "orlando", 84);
		addCity(usnw, "toronto", "ottawa", 269);
		addCity(usnw, "tallahassee", "pensacola", 120);
		addCity(usnw, "pittsburgh", "philadelphia", 319); 
		addCity(usnw, "newYork", "philadelphia", 101); 
		addCity(usnw, "uk1", "philadelphia", 3548);
		addCity(usnw, "uk2", "philadelphia", 3548);
		addCity(usnw, "tucson", "phoenix", 117);  
		addCity(usnw, "yuma", "phoenix", 178);
		addCity(usnw, "redding", "pointReyes", 215);  
		addCity(usnw, "sacramento", "pointReyes", 115);
		addCity(usnw, "seattle", "portland", 174);  
		addCity(usnw, "salem", "portland", 47);
		addCity(usnw, "saltLakeCity", "reno", 520);  
		addCity(usnw, "sacramento", "reno", 133);
		addCity(usnw, "washington", "richmond", 105);
		addCity(usnw, "sanFrancisco", "sacramento", 95);  
		addCity(usnw, "stockton", "sacramento", 51);
		addCity(usnw, "sanJose", "salinas", 31);  
		addCity(usnw, "sanLuisObispo", "salinas", 137);
		addCity(usnw, "yuma", "sanDiego", 172);
		addCity(usnw, "thunderBay", "saultSteMarie", 442);  
		addCity(usnw, "toronto", "saultSteMarie", 436);
		addCity(usnw, "vancouver", "seattle", 115);
		addCity(usnw, "winnipeg", "thunderBay", 440);
	}

		//Add details in hasmap of string and linklist
	 static void addCity(USANetwork network, String curcity, String nextcity, int cost) {
	 	String coordinates = network.heuristic.get(nextcity);
		 if(network.map.containsKey(curcity)) {
			 (network.map.get(curcity)).add(new customObject(nextcity, cost, curcity, coordinates));
		 }
		 else {
			 LinkedList<customObject> l = new LinkedList<customObject>();
			 l.add(new customObject(nextcity, cost, curcity, coordinates));
			 network.map.put(curcity, l);
		 } 
	}


	 //Calculate heuristic function value
	static double calculateHeuristic(double aLat, double aLong, double bLat, double bLong) {
		//Value is sqrt((69.5 * (Lat1 - Lat2)) ^ 2 + (69.5 * cos((Lat1 + Lat2)/360 * pi) * (Long1 - Long2)) ^ 2)
		double power1 = 69.5*(aLat-bLat);
		double cosTerm  = ((aLat+bLat)/360)*Math.PI;
		double power2 = 69.5*Math.cos(cosTerm)*(aLong-bLong);
		return Math.sqrt(Math.pow(power1, 2) + Math.pow(power2, 2));
	}
	
	//Split the string by , to get lat and long
	static String[] findLatitudeAndLongitude(String coordinate) {
		String[] s = coordinate.split(",");
		return s;
	}

	//Comparator used by priority queue for Astar
	static class customObjectAStarComparator implements Comparator<customObject> {
		public int compare(customObject c1, customObject c2) {
			String c1coordinate = USANetwork.heuristic.get(c1.getCityName());
			String c2coordinate = USANetwork.heuristic.get(c2.getCityName());
			String[] c1coordinates = findLatitudeAndLongitude(c1coordinate);
			String[] c2coordinates = findLatitudeAndLongitude(c2coordinate);
			double c1Lat = Double.parseDouble(c1coordinates[0]);
			double c1Long = Double.parseDouble(c1coordinates[1]);
			double c2Lat = Double.parseDouble(c2coordinates[0]);
			double c2Long = Double.parseDouble(c2coordinates[1]);
			double c1toDest = calculateHeuristic(c1Lat, c1Long, destLat, destLong);
			double c2toDest = calculateHeuristic(c2Lat, c2Long, destLat, destLong);
			double c1TotalCost = c1.getPathCost()+c1toDest;
			double c2TotalCost = c2.getPathCost()+c2toDest;
			if(c1TotalCost > c2TotalCost) {
				return 1;
			}
			return -1;
		}
	}

	//Comparator used by priority queue for Greedy
	static class customObjectGreedyComparator implements Comparator<customObject> {
		public int compare(customObject c1, customObject c2) {
			String c1coordinate = USANetwork.heuristic.get(c1.getCityName());
			String c2coordinate = USANetwork.heuristic.get(c2.getCityName());
			String[] c1coordinates = findLatitudeAndLongitude(c1coordinate);
			String[] c2coordinates = findLatitudeAndLongitude(c2coordinate);
			double c1Lat = Double.parseDouble(c1coordinates[0]);
			double c1Long = Double.parseDouble(c1coordinates[1]);
			double c2Lat = Double.parseDouble(c2coordinates[0]);
			double c2Long = Double.parseDouble(c2coordinates[1]);
			double c1toDest = calculateHeuristic(c1Lat, c1Long, destLat, destLong);
			double c2toDest = calculateHeuristic(c2Lat, c2Long, destLat, destLong);
			if(c1toDest > c2toDest) {
				return 1;
			}
			return -1;
		}
	}

	//Comparator used by priority queue for Dynamic
	static class customObjectComparator implements Comparator<customObject> {
		public int compare(customObject c1, customObject c2) {
			return c1.getPathCost()-c2.getPathCost();
		}
	}


	//This function evaluates for all astar, dynamic, & greedy
	static boolean implementAlgo(USANetwork usnw, PriorityQueue<customObject> frontier, HashMap<String, String> exploredList, String sourceCity, String destCity) {
		frontier.add(new customObject(sourceCity, 0, "", usnw.heuristic.get(sourceCity)));
		int totalCost = 0;
		List<String> pathList = new ArrayList<String>();
		while(frontier.size()!=0) {
			//Remove the highest priority node
			customObject removedObject = frontier.poll();
			//If destination found in frontier
			if(destCity.equals(removedObject.getCityName())) {
				String backtrackNode = removedObject.getParent();
				//Print explore list
				printExploredList(exploredList);
				System.out.println("Size of explored list : "+exploredList.size());
				//Get the path list
				getPathList(backtrackNode, exploredList, pathList);
				Collections.reverse(pathList);
				//Add destination to path list
				pathList.add(removedObject.getCityName());
				System.out.println();
				System.out.println("Path List : ");
				for(String path : pathList) {
					System.out.print(path+",");
				}
				System.out.println();
				System.out.println("Size of path list : "+pathList.size());
				System.out.println();
				System.out.println("Total distance is : "+removedObject.getPathCost());
				return true;
			}
			//Now explore the highest priority node
			String parentNode = removedObject.getCityName();

			int parentCost = removedObject.getPathCost();
			//Put the higest priorty in explore list
			exploredList.put(parentNode, removedObject.getParent());
			if(usnw.map.get(parentNode) == null) {
				System.out.println("Can't go beyond...");
				return false;
			}
			//For all succesors of the node
			LinkedList<customObject> successors = usnw.map.get(parentNode);
			for(customObject mapNode : successors) {
				int sourcetoNodeCost = parentCost + mapNode.getPathCost();
				String successorNode = mapNode.getCityName();
				//Chcek if frontier & explore list already contains the city, if not then add in frontier.
				if(!frontier.contains(mapNode) && !exploredList.containsKey(successorNode)) {
					frontier.add(new customObject(successorNode, sourcetoNodeCost, mapNode.getParent(), mapNode.getCoordinates()));
				}
				//If already contains and the path cost is more in frontier, replace it with lower cost.
				else if(frontier.contains(mapNode)) {
					for(customObject frontierNode : frontier) {
						if(frontierNode.getCityName() == mapNode.getCityName()){
							if(frontierNode.getPathCost() > mapNode.getPathCost()) {
								frontier.remove(frontierNode);
								frontier.add(new customObject(mapNode.getCityName(), mapNode.getPathCost(), mapNode.getParent(), mapNode.getCoordinates()));
							}
						}
					}
				}

			}
		}
		return false;
	}

	public static void printExploredList(HashMap<String, String> exploredList) {
		System.out.println("Explored List : ");
		for(String s : exploredList.keySet()) {
			System.out.print(s+",");
		}
		System.out.println();
	}	

	public static void getPathList(String node, HashMap<String, String> exploredList, List<String> pathList) {
		if(node == "") {
			return;
		}
		pathList.add(node);
		getPathList(exploredList.get(node), exploredList, pathList);
	}



	public static void main(String[] args) {
		USANetwork usnw = new USANetwork();
		createNetwork(usnw);
		PriorityQueue<customObject> frontier = new PriorityQueue<customObject>(usnw.map.size(), new customObjectComparator());
		HashMap<String, String> exploredList = new HashMap<String, String>();
		createHeuristic(usnw);
		//Retrive cityname and search type from arguments
		String searchType = args[0];
		String sourceCity = args[1];
		destCity = args[2];
		String coordinate = usnw.heuristic.get(destCity);
		String[] coordinates = findLatitudeAndLongitude(coordinate);
		destLat = Double.parseDouble(coordinates[0]);
		destLong = Double.parseDouble(coordinates[1]);
		//If dynamic:
		if(searchType.equals("dynamic")) {
			boolean canImplementDynamic = implementAlgo(usnw, frontier, exploredList, sourceCity, destCity);
			if(canImplementDynamic){
				System.out.println("Successfully Implemented Dynamic algorithm");
			}
			else {
				System.out.println("Cannot Implement Dynamic algorithm");
			}
		}
		//If astar:
		else if(searchType.equals("astar")) {
			PriorityQueue<customObject> frontierAStar = new PriorityQueue<customObject>(usnw.map.size(), new customObjectAStarComparator());
			boolean canImplementAstar = implementAlgo(usnw, frontierAStar, exploredList, sourceCity, destCity);
			if(canImplementAstar) {
				System.out.println("Successfully Implemented A* algorithm");
			}
			else {
				System.out.println("Cannot Implement A* algorithm");
			}
		}
		//If greedy
		else if(searchType.equals("greedy")) {
			PriorityQueue<customObject> frontierGreedy = new PriorityQueue<customObject>(usnw.map.size(), new customObjectGreedyComparator());
			boolean canImplementGreedy = implementAlgo(usnw, frontierGreedy, exploredList, sourceCity, destCity);
			if(canImplementGreedy) {
				System.out.println("Successfully Implemented Greedy algorithm");
			}
			else {
				System.out.println("Cannot Implement Greedy algorithm");
			}
		}	
		else {
			System.out.println("Enter valid search type!!");
		}
	}

}


