import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NoRepeatPlaylist
{
	int P,M,N;
	long[][][] memo;
	int MOD = 1000000007;
	public int numPlaylists(int N, int M, int P)
	{
		this.N = N;
		this.P = P;
		this.M = M;
		memo = new long[101][101][101];
		for(long[][] mm: memo)
			for(long[] m: mm)
				Arrays.fill(m, -1);
		
		return (int)countPlaylists(0,0,N);
	}
	
	public long countPlaylists(int position, int XS, int YS) {
		if(position == P)
			return YS == 0?1:0; //completeness rule
			
		if(memo[position][XS][YS] != -1)
			return memo[position][XS][YS];
		
		long result = 0;
		if(YS>0)
			result+=countPlaylists(position+1, XS+1, YS-1)*YS;
		
		if(XS>M)
			result+=countPlaylists(position+1, XS, YS)*(XS-M);
		
		memo[position][XS][YS] = result%MOD;
		return memo[position][XS][YS];
	}
	
<%:testing-code%>
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
