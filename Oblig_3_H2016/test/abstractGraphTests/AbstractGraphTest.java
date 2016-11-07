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
	public Graph<String> graph = new UnweightedGraph<>(vertices, edges);
	public AbstractGraph<String>.Tree dfsWithDeque = graph.dfsWithDeque(graph.getIndex("Houston"));
	public AbstractGraph<String>.Tree dfs = graph.dfs(graph.getIndex("Houston"));
	
	@Test 
	public void checkIfdfsWithDequeReturnsCorrectPath() {
		assertEquals(dfsWithDeque.getPath(0), dfs.getPath(0));
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
			assertEquals(graph.getVertex(searchOrdersdfsWithDeque.get(i)), graph.getVertex(searchOrdersdfs.get(i)));
	}
	@Test
	public void checkIfWeGetCorrectPathInReturnFromThenewGetPathMethod(){
		String CorrectResponce = "[Houston, Dallas, Los Angeles, San Francisco, Seattle]";
		assertEquals(dfs.getPath(0,11).toString(), CorrectResponce);
	}
}

