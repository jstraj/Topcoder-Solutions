import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class StrIIRec
{
	public String recovstr(int n, int minInv, String minStr)
	{
		for(int i=0;i<n;i++) {
			char ch = (char)('a'+i);
			if(minStr.indexOf(ch) == -1)
				minStr+=ch;
		}
		
		String s = minStr;
		while(inversions(s) < minInv) {
			s = next(s);
		}
		return s;
	}
	
	public int inversions(String s) {
		int inv=0;
		for(int i=0;i<s.length()-1;i++) {
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)>s.charAt(j))
					inv++;
			}
		}
		return inv;
	}
	
	public String next(String s) {
		
		char[] cs = s.toCharArray();
		for(int i=cs.length-2;i>=0;i--) {
			for(int j=cs.length-1;j>i;j--) {
				if(cs[i] < cs[j]) {
					char temp = cs[i];
					cs[i] = cs[j];
					cs[j] = temp;
					return new String(cs);
				}
			}
		}
		return null;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
