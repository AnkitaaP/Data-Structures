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
		    Modular  obj=new Modular ();
		    int a,m;
		    a=sc.nextInt();
		    m=sc.nextInt();
		    
		    
		    System.out.println(obj.modInverse(a,m));
		   
		    
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Modular 
{
    
  public int modInverse(int a, int m)
    {
      //Your code here
      a=a%m;
      for(int x=1;x<=m;x++){
          if((a*x)%m==1){
              return x;
          }
      }
      
      return -1;
    }

}

