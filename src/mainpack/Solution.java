package mainpack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> mainList  = new ArrayList<Long>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        for(int i=0;i<=n;i++)
        {
            mainList.add(i, 0L);
        }
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextInt();
           
                mainList.set(a, mainList.get(a)+k);
                
                mainList.set(b, mainList.get(b+1)-k);
            
            
        }
        
        long temp = 0;
        
        long max = 0;
        
        for(int i=1;i<=n;i++)
        {
        	temp = temp + mainList.get(i);
        	if(temp>max)
        		max = temp;
         
        }
        System.out.println(max);
        in.close();
    }
}
