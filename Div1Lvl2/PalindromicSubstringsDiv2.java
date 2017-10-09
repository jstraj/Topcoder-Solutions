import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PalindromicSubstringsDiv2
{
	public int count(String[] S1, String[] S2)
	{
		String str = "";
		for(String s: S1)
			str+=s;
		for(String s: S2)
			str+=s;
		return count(str);
	}
	
	int count(String s) {
		int n = s.length();
		int res = 0;
		for(int m=0;m<n;m++) {
			for(int even=0;even<=1;even++) {
				int i,j;
				boolean palin = true;
				if(even == 1) {
					i = m;
					j = m+1;
					res++;
				} else {
					i = m-1;
					j = m+1;
				}
				while(i>=0 && j<n) {
					palin = palin && (s.charAt(i) == s.charAt(j));
					if(palin == true)
						res++;
					i--;
					j++;
				}
			}
		}
		return res;
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
