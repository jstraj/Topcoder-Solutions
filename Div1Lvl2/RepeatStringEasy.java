import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/* Uses Longest Common Subsequence Technique */
public class RepeatStringEasy
{
	public int maximalLength(String s)
	{
		int max = 0;
		for(int i=0;i<s.length()-1;i++) {
			String a = s.substring(0,i+1);
			String b = s.substring(i+1);
			//System.out.println(a+", "+b);
			int l = longestCommonSub(a,b);

			if(l>max)
				max = l;
		}
		return max*2;
	}
	
	public int longestCommonSub(String a, String b) {
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int[] d: dp)
			Arrays.fill(d, 0);
			
		for(int i=1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[a.length()][b.length()];
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
