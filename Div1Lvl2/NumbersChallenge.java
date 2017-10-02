import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NumbersChallenge
{
	
	public int MinNumber(int[] a) {
		
		int s = 0;
		for(int x: a)
			s+=x;
		boolean[] dp = getDP(a, s);
		int ans = 0;
		for(int i=1;i<dp.length;i++) {
			if(!dp[i]) {
				ans = i;
				break;
			}
		}
		if(ans == 0)
			ans = s+1;
		return ans;
	}

	public boolean[] getDP(int[] a, int S)
	{
		boolean[][] dp = new boolean[a.length][S+1];
		Arrays.fill(dp[0], false);
		dp[0][a[0]] = true;
		for(int i=0;i<a.length;i++)
			dp[i][0] = true;
			
		for(int i=1;i<a.length;i++) {
			for(int j=1;j<=S;j++) {
				if(j<a[i])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] | dp[i-1][j-a[i]];
			}
		}
		return dp[a.length-1];
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
