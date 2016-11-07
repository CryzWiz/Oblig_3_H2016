package abstractGraphTests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import abstractGraph.AbstractGraph;
import abstractGraph.Graph;
import abstractGraph.UnweightedGraph;


/* Since we have a dfs method that works, we can
 * base all our test on the fact that if our method 
 * don't return the same as the dfs method provided in the book
 * we have a error
 * And we added a third dfs to test a unConnected tree
 */
public class AbstractGraphTest {
	String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
		      "Denver", "Kansas City", "Chicago", "Boston", "New York",
		      "Atlanta", "Miami", "Dallas", "Houston"};
	int[][] edges = {
		      {0, 1}, {0, 3}, {0, 5},
		      {1, 0}, {1, 2}, {1, 3},
		      {2, 1}, {2, 3}, {2, 4}, {2, 10},
		      {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
		      {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
		      {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
		      {6, 5}, {6, 7},
		      {7, 4}, {7, 5}, {7, 6}, {7, 8},
		      {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
		      {9, 8}, {9, 11},
		      {10, 2}, {10, 4}, {10, 8}, {10, 11},
		      {11, 8}, {11, 9}, {11, 10}
		    };
	int[][] disconnectededges = {
		      {0, 1}, {0, 3}, {0, 5},
		      {1, 0}, {1, 2}, {1, 3},
		      {2, 1}, {2, 3}, {2, 4}, {2, 10},
		      {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
		      {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
		      {9, 8}, {9, 11},
		      {10, 2}, {10, 4}, {10, 8}, {10, 11},
		      {11, 8}, {11, 9}, {11, 10}
		    };
	public Graph<String> connectedgraph = new UnweightedGraph<>(vertices, edges);
	public Graph<String> disconnectedgraph = new UnweightedGraph<>(vertices, disconnectededges);
	public AbstractGraph<String>.Tree dfsWithDeque = connectedgraph.dfsWithDeque(connectedgraph.getIndex("Houston"));
	public AbstractGraph<String>.Tree dfsWithDequeDisConnected = disconnectedgraph.dfsWithDeque(disconnectedgraph.getIndex("Houston"));
	public AbstractGraph<String>.Tree dfs = connectedgraph.dfs(connectedgraph.getIndex("Houston"));
	
	@Test 
	public void checkIfdfsWithDequeReturnsCorrectPath() {
		for(int i = 0; i < 11; i++)
		assertEquals(dfsWithDeque.getPath(i), dfs.getPath(i));
	}
	
	@Test
	public void checkNewdfsAgainstgetNumberOfVerticesFound(){
		assertEquals(dfsWithDeque.getNumberOfVerticesFound(), dfs.getNumberOfVerticesFound());
		
	}
	@Test
	public void checkIfSearchOrdersAreTheSame(){
		List<Integer> searchOrdersdfs = dfs.getSearchOrder();
		List<Integer> searchOrdersdfsWithDeque = dfs.getSearchOrder();
		for (int i = 0; i < searchOrdersdfsWithDeque.size(); i++)
			assertEquals(connectedgraph.getVertex(searchOrdersdfsWithDeque.get(i)), connectedgraph.getVertex(searchOrdersdfs.get(i)));
	}
	@Test
	public void checkIfWeGetCorrectPathInReturnFromThenewGetPathMethod(){
		String CorrectPathFromHoustonToSeattle = "[Houston, Dallas, Los Angeles, San Francisco, Seattle]";
		String CorrectPathFromAtlantaToSeattle = "[Atlanta, Kansas City, Denver, Seattle]";
		String CorrectPathFromBostonToDenver = "[Boston, Chicago, Denver, Los Angeles]";
		assertEquals(dfs.getPath(0,11).toString(), CorrectPathFromHoustonToSeattle);
		assertEquals(dfsWithDeque.getPath(0,11).toString(), CorrectPathFromHoustonToSeattle);
		assertEquals(dfs.getPath(0,8).toString(), CorrectPathFromAtlantaToSeattle);
		assertEquals(dfsWithDeque.getPath(0,8).toString(), CorrectPathFromAtlantaToSeattle);
		assertEquals(dfs.getPath(2,6).toString(), CorrectPathFromBostonToDenver);
		assertEquals(dfsWithDeque.getPath(2,6).toString(), CorrectPathFromBostonToDenver);
	}
	@Test
	public void testIfisConnectedReturnsTrueForConnectedTree(){
		assertTrue(dfsWithDeque.isConnected());
		assertTrue(dfs.isConnected());
	}
	@Test
	public void testIfisConnectedReturnsFalseForUnConnectedTree(){
		assertFalse(dfsWithDequeDisConnected.isConnected());
	}
}

