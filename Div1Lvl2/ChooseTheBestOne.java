import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ChooseTheBestOne
{
	public int countNumber(int N)
	{
		ArrayList<Integer> persons = new ArrayList();
		for(int i=1;i<=N;i++)
			persons.add(i);
			
		long i=0;
		for(long t=1;t<=N-1;t++) {
			int m = persons.size();
			i = (i+(t*t*t)-1)%m;
			persons.remove((int)i);
		}
		return persons.get(0);
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
