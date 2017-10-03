import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class DivFreed2
{
	public int count(int n, int k)
	{
		int MOD = 1000000007;
		long[][] count = new long[n+1][k+1];
		for(int i=1;i<=k;i++)
			count[1][i] = 1;
		
		for(int i=2;i<=n;i++) {
			long total = 0;
			for(int x=1;x<=k;x++)
				total = (total+count[i-1][x])%MOD;
			Arrays.fill(count[i], total);
			
			//removing the divisors of the preceding number
			for(int x=1;x<=k;x++) {
				for(int y=x+x;y<=k;y+=x)
					count[i][x] = (count[i][x]-count[i-1][y])%MOD;
			}
		}
		
		long sum = 0;
		for(int i=1;i<=k;i++)
			sum = (sum+count[n][i])%MOD;
			
		//printDP(count);
		return (int)sum;
	}
	
	public void printDP(long[][] dp) {
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
