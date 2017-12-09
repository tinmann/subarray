package mainpack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution6 {
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	        Scanner in = new Scanner(System.in);
			
			long n = in.nextLong();
			long c = in.nextLong();
			
			//System.out.println(n +" " + c);
			

			
			BigInteger totalCombination =  new BigInteger("1");
			
			//long totalCombination = 1L;
			
			if(n == 1)
				totalCombination = BigInteger.valueOf(c);
			else if(c==2)
				totalCombination = new BigInteger("2");
			else if(c == 1 && n > 1)
				totalCombination = new BigInteger("0");
			else if((n+c) <= 14)
			{
	        for(long i = n;i >= 1; i--)
	        {
	            long single;
	            long straight;
	            long inverse;
	            
	            if(i==1)
	            {
	            	totalCombination = totalCombination.multiply(BigInteger.valueOf((c-1)));
	            }
	          
	            else if(i == n)
	            {
	            	long totalCombinationDup = 1L;
	            	single = c;
	            	straight = (long) Math.pow((c-1),(i-1));	   
	            	inverse = (long) Math.pow((c-1),(i-1));	    
	            	totalCombinationDup = (long) (single*straight*inverse);
	            	totalCombination = totalCombination.multiply(BigInteger.valueOf(totalCombinationDup));
	            	long madValNew = (long) (Math.pow(10, 9)+7);
	            	int res  = totalCombination.compareTo(BigInteger.valueOf(madValNew));
	            	if(res == 1)
	            	{
	            		totalCombination = totalCombination.mod(BigInteger.valueOf(madValNew));
	            	}
	            }
	          
	            else
	            {
	            	long totalCombinationDup = 1L;
	            	single = (c-1);
	            	/*straight = (long) Math.pow((i-1),(c-2));	   
	            	inverse = (long) Math.pow((i-1),(c-1));	    */ 
	            	straight = (long) Math.pow((c-2),(i-1));	   
	            	inverse = (long) Math.pow((c-1),(i-1));	    
	            	totalCombinationDup = (long) (single*straight*inverse);
	            	totalCombination = totalCombination.multiply(BigInteger.valueOf(totalCombinationDup));
	            	
	            	//long madValDup = (long) (Math.pow(10, 18)+7);
	            	long madValNew = (long) (Math.pow(10, 9)+7);
	            	int res  = totalCombination.compareTo(BigInteger.valueOf(madValNew));
	            	if(res == 1)
	            	{
	            		totalCombination = totalCombination.mod(BigInteger.valueOf(madValNew));
	            	}
	            }
	        }
			}
			 long madVal = (long) (Math.pow(10, 9)+7);
				//totalCombination  = (long) ((totalCombination) % (Math.pow(10, 7)+7));
				 totalCombination = totalCombination.mod(BigInteger.valueOf(madVal));
			//totalCombination  = (long) ((totalCombination) % (Math.pow(10, 7)+7));
			System.out.println(totalCombination);
	    }

}
