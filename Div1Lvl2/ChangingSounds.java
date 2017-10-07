import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ChangingSounds
{
	int[] changeIntervals;
	int maxLevel;
	int[][] dp;
	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel)
	{
		this.changeIntervals = changeIntervals;
		this.maxLevel = maxLevel;
		dp = new int[maxLevel+1][changeIntervals.length+1];
		//for(int[] d: dp)
			//Arrays.fill(d, -1);
			
		return maxSound(beginLevel, 0);
	}
	
	public int maxSound(int start, int index) {
		
		if(start>maxLevel || start<0 )
			return -1;
		
		if(index >= changeIntervals.length)
			return start;
		
		if(dp[start][index] != 0)
			return dp[start][index];
		
		int best = -1;	
		best = Math.max(best, maxSound(start+changeIntervals[index], index+1));
		best = Math.max(best, maxSound(start-changeIntervals[index], index+1));
		return dp[start][index] = best;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
