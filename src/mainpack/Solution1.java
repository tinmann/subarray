package mainpack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int Maxsum = -999;
        
         for(int i=0; i < 6; i++)
         {
            for(int j=0; j < 6; j++)
            {
               
                if(i > 3 || j > 3)
                    break;
                else
                {
                    int next,nextNext,down,downDown; 
                     next = i+1;
                nextNext = next +1;
                down = j+1;
                downDown = down+1;
                   int temp_sum = 0;
                    for(int ii = i;ii<=nextNext;ii++)
                    {
                        for(int jj = j; jj<=downDown;jj++)
                        {
                          
                             if((ii == next && jj == j) || (ii == next && jj == downDown))
                                continue;                          
                            temp_sum += arr[ii][jj];
                         //   System.out.println(arr[ii][jj]);
                           
                        }
                        
                    }
                     if(temp_sum>Maxsum)
                        Maxsum = temp_sum;
                }
               
            }
        }
        System.out.println(Maxsum);
    }
}
