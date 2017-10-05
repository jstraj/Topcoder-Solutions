import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BearPlaysDiv2
{
	boolean[][] visited;
	public String equalPiles(int A, int B, int C)
	{
		int s = A+B+C;
		if(s%3!=0)
			return "impossible";
			
		visited = new boolean[1505][1505];
		for(boolean[] v: visited)
			Arrays.fill(v, false);
		
		visit(A,B,C);
		
		if(visited[s/3][s/3])
			return "possible";
		return "impossible";
	}
	
	public void visit(int A, int B, int C) {
		if(visited[A][B] == true)
			return;
		visited[A][B] = true;
		if(B>A)
			visit(A+A, B-A, C);
		if(A>B)
			visit(A-B, B+B, C);
		if(B>C)
			visit(A, B-C, C+C);
		if(C>B)
			visit(A, B+B, C-B);
		if(C>A)
			visit(A+A, B, C-A);
		if(A>C)
			visit(A-C, B, C+C);
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
