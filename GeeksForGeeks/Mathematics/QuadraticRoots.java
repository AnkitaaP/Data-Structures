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
		    Quadratic  obj=new Quadratic();
		    int a,b,c;
		    a=sc.nextInt();
		    b=sc.nextInt();
		    c=sc.nextInt();
		    obj.quadraticRoots(a,b,c);
		    System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Quadratic 
{
    public void quadraticRoots(int a,int b,int c)
    {
        //Your code here
        
        double D=(b*b)-(4*a*c);
        
        if(D<0){
            System.out.print("Imaginary");
        }
        
        else {
            int soln1 = (int)Math.floor((-1*b + Math.sqrt(D))/(2 *a)); //root1
    	    int soln2 = (int)Math.floor((-1*b - Math.sqrt(D))/(2 *a));
            System.out.print(soln1+" "+soln2);
        }
    }
}

