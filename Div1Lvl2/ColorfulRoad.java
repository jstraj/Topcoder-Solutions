import java.io.*;
import java.util.*;

public class ColorfulRoad {

	static int minCost = Integer.MAX_VALUE;

	public static void recur(String a, int index, int cost) {

		if(index == a.length()-1)
			minCost = Math.min(minCost, cost);

		for(int i=index+1;i<a.length();i++) {
			if(a.charAt(i) == getNextChar(a.charAt(index))) {
				int c = i-index;
				int cc = c*c;
				recur(a, i, cost+cc);
			}
		}
	}

	public static int solveDP(String a, int n) {

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int i=0;i<n;i++) {
			if(dp[i]!=Integer.MAX_VALUE) {
				for(int j=i+1;j<n;j++) {
					if(a.charAt(j) == getNextChar(a.charAt(i))) {
						dp[j] = Math.min(dp[j], (j-i)*(j-i)+dp[i]);
					}
				}
			}
		}
		return dp[n-1];
	}

	public static char getNextChar(char c) {
		if(c == 'R')
			return 'G';
		if(c == 'G')
			return 'B';
		if(c == 'B')
			return 'R';
		return 0;
	}

	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		recur(a, 0, 0);
		System.out.println(minCost);
		System.out.println(solveDP(a, a.length()));
	}
}