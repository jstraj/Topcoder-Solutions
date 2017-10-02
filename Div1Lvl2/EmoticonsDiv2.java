import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EmoticonsDiv2
{
	public int printSmiles(int n)
	{
		int res=0;
		for(int i=2;i*i<=n;i++) {
			while(n%i == 0) {
				n/=i;
				res+=i;
			}
		}
		if(n != 1)
			res+=n;
		return res;
	}


}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
