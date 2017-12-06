package mainpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Solution2 obj = new Solution2();

		long sumOfFirst = 0;
		long sumOfSecond = 0;
		long finalSum = 0;

		/* long i,j; */
		long n = in.nextLong();
		long m = in.nextLong();
		long[] primeNumbers;
		
		if(n>=m)
		{
			long lastElementOfFirstRowN = n + 1 ;
			long elementOneBigin = (lastElementOfFirstRowN - 1) * (2 + (lastElementOfFirstRowN - 2)) / 2 ;
			
			
			
			primeNumbers = obj.getAllPrime(elementOneBigin);
		}
			
		else
		{
			long lastElementOfFirstRowN = m + 1 ;
			long elementOneBigin = (lastElementOfFirstRowN - 1) * (2 + (lastElementOfFirstRowN - 2)) / 2 ;
			
			primeNumbers = obj.getAllPrime(elementOneBigin);
		}
			
			System.out.println("complex");

		if (n > 2) {
			long lastElementOfFirstRowN = n - 2;
			long elementOneBigin = (lastElementOfFirstRowN - 1) * (2 + (lastElementOfFirstRowN - 2)) / 2 + 1;
			
			
			
			long[][] array1 = new long[(int) (n + 3)][6];

			for (long j = 1; j <= 5; j++) {
				for (long i = 1; i <= n + 2; i++) {
					if ((j == 1 && i > n - 2) || (j == 2 && i > n - 1) || (j == 3 && i > n) || (j == 4 && i > n + 1)
							|| (j == 5 && i > n + 2)) {
						array1[(int) i][(int) j] = -999;
					} else {
						array1[(int) i][(int) j] = elementOneBigin;
						elementOneBigin++;
					}

				}
			}
			long primeSumOne = 0L, currentI = 1L;
			int currentIint = (int) currentI, currentJ = 3;
			sumOfFirst = obj.recursivePrimeSum(array1, array1[1][3], currentIint, currentJ, n, primeSumOne,primeNumbers);
		}

		else if (n == 1 || n == 0) {
			sumOfFirst = 0;
		} else if (n == 2) {
			sumOfFirst = 2 + 3;
		}

		if (m > 2) {
			long lastElementOfFirstRowM = m - 2;
			long elementTwoBegin = (lastElementOfFirstRowM - 1) * (2 + (lastElementOfFirstRowM - 2)) / 2 + 1;
			long[][] array2 = new long[(int) (m + 3)][6];
			for (long j = 1; j <= 5; j++) {
				for (long i = 1; i <= m + 2; i++) {
					if ((j == 1 && i > m - 2) || (j == 2 && i > m - 1) || (j == 3 && i > m) || (j == 4 && i > m + 1)
							|| (j == 5 && i > m + 2)) {
						array2[(int) i][(int) j] = -999;
					} else {
						array2[(int) i][(int) j] = elementTwoBegin;
						elementTwoBegin++;
					}

				}
			}
			long primeSumOne = 0L, currentI = 1L;
			int currentIint = (int) currentI, currentJ = 3;
			sumOfSecond = obj.recursivePrimeSum(array2, array2[1][3], currentIint, currentJ, m, primeSumOne,primeNumbers);
		}
		else if (m == 1 || m == 0) {
			sumOfSecond = 0;
		} else if (m == 2) {
			sumOfSecond = 2 + 3;
		}

		finalSum = sumOfFirst + sumOfSecond;
		in.close();

		System.out.println(finalSum);

	}

	public long recursivePrimeSum(long[][] array1, long valueOfElement, int currentI, int currentJ, long iLimit,
			long primeSumOne,long[] primeNumbers) {
		if (array1[currentI + 1][3] == -999 || currentI > iLimit) {
			return primeSumOne;
		}

		int localCount = 0, primeCount = 0;
		long valA = 0, valB = 0;
		long otherPrime = 0;
		int secRecI = 0, secRecJ = 0;

		if (isPrime(array1[currentI][3],primeNumbers)) {
			for (int j = currentJ - 1; j <= currentJ + 1; j++) {
				if (j < 0 || j > 4)
					break;
				if (j < 2)
					continue;

				for (int i = currentI - 1; i <= currentI + 1; i++) {

					if (i < 0 || (i > iLimit + 1))
						break;
					if (i == 0 || i < 1 || array1[i][j] == -999)
						continue;

					if (isPrime2(array1[i][j],primeNumbers)) {

						if (array1[i][j] != valueOfElement) {
							otherPrime = array1[i][j];
							secRecI = i;
							secRecJ = j;
						}
						primeCount++;
						localCount += 1;

					}

				}

			}

			if (primeCount == 2) {
				if (secRecursivePrimeSum(array1, array1[currentI][3], otherPrime, secRecI, secRecJ, iLimit,primeNumbers)) {
					primeSumOne += array1[currentI][3];
					currentI = currentI + 1;
					return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne,primeNumbers);
				}

			}

			if (primeCount >= 3) {
				primeSumOne += array1[currentI][3];
				currentI = currentI + 1;
				return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne,primeNumbers);
			}

			currentI = currentI + 1;
			return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne,primeNumbers);

		}

		currentI = currentI + 1;
		return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne,primeNumbers);

	}

	public boolean secRecursivePrimeSum(long array1[][], long oldPrime, long otherPrime, int secRecI, int secRecJ,
			long iLimit,long[] primeNumbers) {

		if (otherPrime == 2 || otherPrime == 3) {
			return true;
		}
		if (otherPrime == 1) {
			return false;
		}

		if (isPrime2(otherPrime,primeNumbers)) {
			for (int j = secRecJ - 1; j <= secRecJ + 1; j++) {
				if (j < 0 || j > 5)
					break;

				for (int i = secRecI - 1; i <= secRecI + 1; i++) {

					if (i < 0 || (i > iLimit + 1))
						break;
					if (i == 0 || (array1[i][j] == -999))
						continue;

					if (isPrime2(array1[i][j],primeNumbers)) {

						if (array1[i][j] != otherPrime && array1[i][j] != oldPrime) {
							return true;
						}

					}

				}

			}

		}

		return false;
	}
	
	public long[] getAllPrime(long n)
	{
		long[] primeNumbers = new long[(int) (n/2)];
		primeNumbers[0]=(long) 2;
		int k=1;
	    for (long i = 3; i <= n; i+=2) 
	    { // skip over even numbers since they are not prime
	        boolean isPrime = true;
	       // check current prime numbers to see if it evenly divides into number
	        for(int b=0;b<=k;b++)
	        {
	         
	        	if(primeNumbers[b] == 0)
	        		break;
	        	if (i % primeNumbers[b] == 0) { // when number is not prime
	                isPrime = false;
	                break; // optimization: stop checking when number is already not prime
	            }
	        }
	        if (isPrime) {
	        	primeNumbers[k]=i;
	        	k++;
	        }
	        
	        
	    }
	    
	    long[] primeNumbersFilter = new long[k+2]; 
	    
	    for(int j=0;j<=k ;j++)
	    {
	    	primeNumbersFilter[j] = primeNumbers[j];
	    	
	    }
	    
	    
	    
	    return primeNumbersFilter;
	}

	public boolean isPrime(long n,long[] primeNumbers) {
		// check if n is a multiple of 2
		
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		
		/*if(Arrays.binarySearch(primeNumbers,n)>=0)
		{
		  return true;	
		}*/
		
		
		// if not, then just check the odds till half
		/*for (int i = 3; i * i <= (n + 1); i += 2) {
			if (n % i == 0)
				return false;
		}*/
		
		return false;
		
	}
	
	public boolean isPrime2(long n,long[] primeNumbers) {
		// check if n is a multiple of 2
		
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		
		
		
		for (int i = 3; i * i <= (n + 1); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}