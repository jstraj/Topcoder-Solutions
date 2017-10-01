import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PrimeSoccer
{
	public double getProbability(int skillOfTeamA, int skillOfTeamB)
	{
		double a = 0.01*skillOfTeamA;
		double b = 0.01*skillOfTeamB;
		double pa = getProb(a);
		double pb = getProb(b);
		return pa+pb-pa*pb;
	}
	
	public double getProb(double p) {
	
		return simple(p,2)+simple(p,3)+simple(p,5)+simple(p,7)+simple(p,11)+simple(p,13)+simple(p,17);
	}
	
	public double simple(double p, int k) {
		return Math.pow(p,k)*Math.pow(1-p, 18-k)*comb(18,k);
	}
	
	public double comb(int n, int k) {
		//nCk
		double answer = 1.0;
		for(int i=1;i<=k;i++) {
			answer*=(n+1-i);
			answer/=i;
		}
		return answer;
	}

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
