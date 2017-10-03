import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RouteIntersection
{
	public String isValid(int N, int[] coords, String moves)
	{
		HashMap<Integer, Integer> current_pos = new HashMap<Integer, Integer>();
		ArrayList<HashMap<Integer, Integer>> points = new ArrayList<HashMap<Integer, Integer>>();
		
		points.add((HashMap<Integer, Integer>)current_pos.clone());
		for(int i=0;i<coords.length;i++) {
			int j = coords[i];
			//If the dimension is not in our HashMap
			if(!current_pos.containsKey(j))
				current_pos.put(j, 0);
				
			if(moves.charAt(i) == '+')
				current_pos.put(j, current_pos.get(j)+1);
			else
				current_pos.put(j, current_pos.get(j)-1);
			
			points.add((HashMap<Integer, Integer>)current_pos.clone());
		}
		
		//After all points are added we check them one by one
		for(HashMap<Integer, Integer> A: points) {
			for(HashMap<Integer, Integer> B: points) {
				if(A == B)
					continue;
				if(equal(A, B, N))
					return "NOT VALID";
			}
		}
		return "VALID";
	}
	
	public boolean equal(HashMap<Integer, Integer> A, HashMap<Integer, Integer> B, int N) {
	
		for(int k: A.keySet()) {
			int val = A.get(k);
			if(!B.containsKey(k)) {
				if(val == 0)
					continue;
				return false;
			}
			if(B.get(k) != val)
				return false;
		}
		for(int k: B.keySet()) {
			int val = B.get(k);
			if(!A.containsKey(k)) {
				if(val == 0)
					continue;
				return false;
			}
			if(A.get(k) != val)
				return false;
		}
		
		return true;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
