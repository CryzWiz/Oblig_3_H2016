package myHashMapTests;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import myHashMap.MyHashMap;
import myHashMap.MyMap;
import org.junit.Before;
import org.junit.Test;
 
public class MyHashMapTest {
	
	
	public MyMap<String, Integer> map;
	public String[] OrgKeys = {"Smith", "Anderson", "Anderson", "Lewis", "Cook", "Smith"};
	public int[] OrgValues = {30,31,32,29,29,65};
	public String[] KeysMinusSmith = {"Anderson", "Anderson", "Lewis", "Cook", "Smith"};
	public int[] FalseValues = {1,3,66,94,106,28,19};
	Set<Integer> AndersonOrgValues;
	
	
	@Before
	public void initialize(){
		map = new MyHashMap<>();
		for(int i = 0; i < OrgKeys.length; i++){
			map.put(OrgKeys[i], OrgValues[i]);
		}
	}
	
	@Test
	public void getTheFullMapDeleteOneAndCheckIfMapIsAccurateAfterwards(){
		assertTrue(map.size() == 6);
		map.remove("Smith");
		for(int i = 0; i < KeysMinusSmith.length; i++){
			assertTrue(map.containsKey(KeysMinusSmith[i]));
		}
		assertTrue(map.size() == 5);	
	}
	
	@Test
	public void checkIfWeCanLocateAllTheKeys(){
		for(int i = 0; i < OrgKeys.length; i++){
			assertTrue(map.containsKey(OrgKeys[i]));
		}
	}
	
	@Test
	public void checkIfWeCanFindAllTheValues() {
		for(int i = 0; i < OrgValues.length; i++){
			assertTrue(map.containsValue(OrgValues[i]));
		}
	}
	
	@Test
	public void checkIfFalseValuesGivesCorrectReturn(){
		for(int i = 0; i < FalseValues.length; i++){
			assertFalse(map.containsValue(FalseValues[i]));
		}
	}
	
	@Test
	public void checkIfWeGetAllTheValuesBehindAKey(){
		Set<Integer> AndersonRealValues = new HashSet<Integer>();
		AndersonRealValues.add(31);AndersonRealValues.add(32);
		assertEquals(map.getAll("Anderson"), AndersonRealValues);
		map.put("Anderson", 51);AndersonRealValues.add(51); // Add one more Anderson
		assertEquals(map.getAll("Anderson"), AndersonRealValues); // And check that we now have 3 Andersons
	}
	
	@Test
	public void clearTheMapAndCheckIfItIsEmpty(){
		map.clear();
		String m = map.toString();
		assertEquals(m, "[]");
	}

}
