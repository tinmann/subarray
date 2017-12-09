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
              if((tempLength)%2 == 1)          	              					 
			   toManipul[(tempLength)/2 + i] = arrayStringInput[i];				 				
		     else			 		    	
		        toManipul[(arrayStringInput.length-1) - (((tempLength)/2) + i)] =  arrayStringInput[i];	 		    	 			 
		 }		 
		 return new String(toManipul);	 				
    }
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String output;
        String ip1 = in.nextLine().trim();
        output = orignial(ip1);
        System.out.println(String.valueOf(output));
    }

}
