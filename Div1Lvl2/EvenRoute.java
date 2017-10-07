import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EvenRoute
{
	public String isItPossible(int[] x, int[] y, int wantedParity)
	{
		for(int i=0;i<x.length;i++) {
			if(Math.abs(x[i]+y[i])%2 == wantedParity)
				return "CAN";
		}
		return "CANNOT";
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
