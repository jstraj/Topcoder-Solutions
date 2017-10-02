import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RGBStreet
{
	public int estimateCost(String[] houses)
	{
		int[][] paintCost = convertToArray(houses);
		int n = paintCost.length;
		int[][] dp = new int[n][3];
		dp[0][0] = paintCost[0][0];
		dp[0][1] = paintCost[0][1];
		dp[0][2] = paintCost[0][2];
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.min(dp[i-1][1] + paintCost[i][0], dp[i-1][2] + paintCost[i][0]);
			dp[i][1] = Math.min(dp[i-1][0] + paintCost[i][1], dp[i-1][2] + paintCost[i][1]);
			dp[i][2] = Math.min(dp[i-1][1] + paintCost[i][2], dp[i-1][0] + paintCost[i][2]);
		}
		//printDP(dp);
		return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
	}
	
	public void printDP(int[][] dp) {
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
	}
	
	public int[][] convertToArray(String[] houses) {
		int[][] arr = new int[houses.length][3];
		for(int i=0;i<houses.length;i++) {
			String[] tokens = houses[i].split(" ");
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		return arr;
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
