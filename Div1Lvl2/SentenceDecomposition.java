import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SentenceDecomposition
{
	String sentence;
	String[] validWords;
	int[] dp;
	int INF = 1000000000;
	public int decompose(String sentence, String[] validWords)
	{
		this.sentence = sentence;
		this.validWords = validWords;
		dp = new int[200];
		Arrays.fill(dp, -1);
		int res = calc(sentence.length());
		if(res == INF)
			res = -1;
		return res;
	}
	
	public int calc(int len) {
		int res = dp[len];
		if(res!=-1) {
			return res;
		}
		res = INF;
		if(len == 0)
			res = 0;
		for(String w: validWords) {
			int len2 = w.length();
			if(len2 > len)
				continue;
			int v = match(sentence.substring(len-len2, len), w);
			if(v == -1)
				continue;
			//System.out.print("Checking for substring = "+sentence.substring(len-len2, len)+", v = "+v);
			//System.out.println("\tfor word: "+w+" len = "+len);
			res = Math.min(res, v+calc(len-len2));
			dp[len] = res;
			//System.out.println("res = "+res);
		}
		return res;
	}
	
	public int match(String a, String b) {
		if(a.length() != b.length())
			return -1;
		char[] c1 = a.toCharArray(); Arrays.sort(c1);
		char[] c2 = b.toCharArray(); Arrays.sort(c2);
		String c = new String(c1);
		String d = new String(c2);
		if(!c.equals(d))
			return -1;
		int cost = 0;
		for(int i=0;i<a.length();i++)
			if(a.charAt(i)!=b.charAt(i))
				cost++;
		return cost;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
