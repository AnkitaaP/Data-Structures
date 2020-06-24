//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Mathematics {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    Factorial obj=new Factorial();
		    int N;
		    N=sc.nextInt();
		   System.out.println(obj.digitsInFactorial(N));
		    
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Factorial
{
    
    public int digitsInFactorial(int N)
    {
        //Your code here
        double sum=0;
        for(int i=1;i<=N;i++){
            sum+=Math.log10(i);
        }
        
        sum=Math.floor(sum+1);
        return (int)sum;
    }

}

