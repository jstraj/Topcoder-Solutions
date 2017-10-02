import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TrafficCongestionDivTwo
{
	public long theMinCars(int treeHeight)
	{
		long nodes = (long)Math.pow(2, treeHeight+1) - 1;
		long minCars;
		if(nodes%3 == 0)
			minCars = nodes/3;
		else
			minCars = nodes/3+1;
		
		return minCars;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
