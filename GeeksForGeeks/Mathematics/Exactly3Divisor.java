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
		    Divisors obj=new Divisors();
		    int N;
		    N=sc.nextInt();
		    
		    System.out.println(obj.exactly3Divisors(N));
		   
		    
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Divisors
{
    
    public int exactly3Divisors(int N)
    {
        //Your code here
        boolean count[]=new boolean[N+1];
    Arrays.fill(count, true);
    for(int p=2;p*p<=N;p++){
        if(count[p]==true){
            for(int i=p*2;i<=N;i+=p){
                count[i]=false;
            }
        }
    }
    
    int k=0;
    for(int i=2;i*i<=N;i++){
        if(count[i]==true && i*i<=N){
           k++;
        }
    }
    
    return k;
    }
}

