import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class MutaliskEasy
{
	int[][][] dp = new int[61][61][61];
	public int minimalAttacks(int[] x)
	{
		
		constructDP();
		if(x.length == 1)
			return dp[x[0]][0][0];
		if(x.length == 2)
			return dp[x[0]][x[1]][0];
		return dp[x[0]][x[1]][x[2]];	
		
	}
	
	public void constructDP() {
		for(int i=0;i<=60;i++) {
			for(int j=0;j<=60;j++) {
				for(int k=0;k<=60;k++) {
					if(i == 0 && j == 0 && k == 0)
						dp[i][j][k] = 0;
					else {
						int result = Integer.MAX_VALUE;
						result = Math.min(result, dp[b(i-9)][b(j-3)][b(k-1)]);
						result = Math.min(result, dp[b(i-9)][b(j-1)][b(k-3)]);
						result = Math.min(result, dp[b(i-3)][b(j-1)][b(k-9)]);
						result = Math.min(result, dp[b(i-3)][b(j-9)][b(k-1)]);
						result = Math.min(result, dp[b(i-1)][b(j-3)][b(k-9)]);
						result = Math.min(result, dp[b(i-1)][b(j-9)][b(k-3)]);
						dp[i][j][k] = result+1;
					}
				}
			}
		}
	}
	
	public int b(int n) {
		return Math.max(n, 0);
	}
	
<%:testing-code%>
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
