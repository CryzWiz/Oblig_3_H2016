package myHashMapTests;
import static org.junit.Assert.*;
import myHashMap.MyHashMap;
import myHashMap.MyMap;

import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
	public MyMap<String, Integer> map;
	
	@Before
	public void initialize(){
		map = new MyHashMap<>();
	    map.put("Smith", 30);
	    map.put("Anderson", 31);
	    map.put("Anderson", 32);
	    map.put("Lewis", 29);
	    map.put("Cook", 29);
	    map.put("Smith", 65);
	}
	
	@Test
	public void getTheFullMapDeleteOneAndCheckIfMapIsAccurateAfterwards(){
		System.out.println("Entries in map: " + map);
		map.remove("Smith");
	    System.out.println("Entries in map: " + map);
	}
	
	@Test
	public void checkIfWeCanLocateAllTheKeys(){
		System.out.println("Entries in map: " + map);
	}
	
	@Test
	public void checkIfWeCanFindAllTheValues() {
		System.out.println("Is age 33 in the map? " + 
			      map.containsValue(33));
	}
	
	@Test
	public void checkIfFalseValuesGivesCorrectReturn(){
		System.out.println("Is Arnesen in the map? " + 
			      map.containsKey("Arnesen"));
	}
	
	@Test
	public void checkIfWeGetAllTheValuesBehindAKey(){
		System.out.println("All values for Key Anderson: " + map.getAll("Anderson"));
	}
	
	@Test
	public void clearTheMapAndCheckIfItIsEmpty(){
		map.clear();
	    System.out.println("Entries in map: " + map);
	}

}
