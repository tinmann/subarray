package mainpack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CandidateCode {
	
	public static String orignial(String input1)
    {
         char[] arrayStringInput = input1.toCharArray();	
		 char[] toManipul= new char[arrayStringInput.length+1];
		 
		 for(int i=0;i<arrayStringInput.length;i++)
		 {
			 int tempLength = (arrayStringInput.length)-i;
			 
			 if(i == arrayStringInput.length-1)
			 {
				 toManipul[i+1] = arrayStringInput[i];
				 toManipul[arrayStringInput.length-1] = arrayStringInput[arrayStringInput.length-3];				 
			 }			 
             else if((tempLength)%2 == 1)
			 {           	  
            	 int k = 0;
 		    	 while(toManipul[((tempLength)/2) +1 + k] != '\u0000') 		    		
 		    		 k++;		    	 
				 
				 if( toManipul[(tempLength)/2 + 1 + k ] == '\u0000')				 
					 toManipul[(tempLength)/2 + 1+ i] = arrayStringInput[i];				 				
			 }
		     else
			 {
		    	 int k = 0;
		    	 while(toManipul[((tempLength)/2) + k] != '\u0000') 
		    		 k--;
		    	 
		    	 if( toManipul[((tempLength)/2) + k] == '\u0000')				 
		    		 toManipul[((tempLength)/2) + k] =  arrayStringInput[i];				 		    			
			 }
		 }
		 		
		 return new String(toManipul, 1, arrayStringInput.length);
    }
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String output;
        String ip1 = in.nextLine().trim();
        output = orignial(ip1);
        System.out.println(String.valueOf(output));
    }

}
