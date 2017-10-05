import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class HandsShaking
{
	long[] memo;
	public long countPerfect(int n)
	{
		memo = new long[n+1];
		Arrays.fill(memo, 0);
		memo[0] = 1;
		memo[2] = 1;
		return count(n);
	}
	
	public long count(int n) {
			
		if(n == 0)
			return 1;
			
		if(memo[n] != 0)
			return memo[n];
			
		long c=0;
		for(int i=1;i<n;i+=2) {
			c+=count(i-1)*count(n-i-1);
		}
		memo[n] = c;
		return memo[n];
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
