import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PillarsDivTwo
{
	public double maximalLength(int[] height, int w)
	{
		int n = height.length;
		double[][] dp = new double[n][101];
		for(int i=1;i<n;i++) {	//Each pillar
			for(int j=1;j<=height[i];j++) { 	//Trying out each height for pillar i
				for(int k=1;k<=height[i-1];k++) { //Trying out each height for pillar (i-1)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+length(k,j,w));
				}
			}
		}
		double answer = 0;
		for(int i=1;i<=height[n-1];i++)
			answer = Math.max(answer, dp[n-1][i]);
		return answer;
	}
	
	public double length(int l1, int l2, int base) {
		int height = Math.abs(l1-l2);
		return Math.sqrt(base*base+height*height);
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
