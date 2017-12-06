package mainpack;

public class Solution4 {
	
	public static void main(String[] args) {
		
		Solution4 obj = new Solution4();
		
		//System.out.println(obj.getAllPrime(1000000).length);
		
		long[] array1 = obj.getAllPrime(100000);
		
		System.out.println("done "+array1.length);
		
		System.out.println(obj.isPrime(1000013, array1));
		
		/*for(int i=0;i<)*/
		
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
