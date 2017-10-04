import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CuttingBitString
{		
	HashSet<String> set;
	int[][] memo;
	
	public int getmin(String str)
	{
		generatePowersof5();
		memo = new int[str.length()][str.length()];
		for(int[] m: memo)
			Arrays.fill(m, -1);

		int res = count(str, 0, str.length()-1);
		if(res == Integer.MAX_VALUE/2)
			return -1;
		return res;
	}


	public int count(String s, int from, int to) {

		if(memo[from][to] != -1)
			return memo[from][to];
		if(check(s.substring(from, to+1)))
			return memo[from][to] = 1;

		memo[from][to] = Integer.MAX_VALUE/2;
		for(int i=from;i<to;i++) {
			memo[from][to] = Math.min(memo[from][to], count(s, from, i)+count(s, i+1, to));
		}
		//System.out.println("memo for ("+from+","+to+") = "+memo[from][to]);
		return memo[from][to];
	}


	public boolean check(String s) {

		if(s.startsWith("0"))
			return false;

		if(set.contains(s))
			return true;
		return false;
	}

	public void generatePowersof5() {

		set = new HashSet();

		for(long i=1;i<=(long)Math.pow(2,50)-1;i*=5)
			set.add(Long.toBinaryString(i));

	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
