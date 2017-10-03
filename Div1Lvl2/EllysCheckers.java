import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EllysCheckers
{
	public String getWinner(String board)
	{
		int n = board.length();
		
		int dots=0;
		for(int i=0;i<=board.length()-2;i++) {
			if(board.charAt(i) == 'o') {
				dots+=n-1-i;
			}
		}
		if(dots%2==0)
			return "NO";
		return "YES";
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
