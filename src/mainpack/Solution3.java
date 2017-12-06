package mainpack;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Solution3 obj = new Solution3();

		long sumOfFirst = 0;
		long sumOfSecond = 0;
		long finalSum = 0;

		/* long i,j; */
		long n = in.nextLong();
		long m = in.nextLong();

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
			sumOfFirst = obj.recursivePrimeSum(array1, array1[1][3], currentIint, currentJ, n, primeSumOne);
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
			sumOfSecond = obj.recursivePrimeSum(array2, array2[1][3], currentIint, currentJ, m, primeSumOne);
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
			long primeSumOne) {
		if (array1[currentI + 1][3] == -999 || currentI > iLimit) {
			return primeSumOne;
		}

		int localCount = 0, primeCount = 0;
		long valA = 0, valB = 0;
		long otherPrime = 0;

		int secRecI = 0, secRecJ = 0;

		if (isPrime(array1[currentI][3])) {
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

					if (isPrime(array1[i][j])) {

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
				if (secRecursivePrimeSum(array1, array1[currentI][3], otherPrime, secRecI, secRecJ, iLimit)) {
					primeSumOne += array1[currentI][3];
					currentI = currentI + 1;
					return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne);
				}

			}

			if (primeCount >= 3) {
				primeSumOne += array1[currentI][3];
				currentI = currentI + 1;
				return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne);
			}

			currentI = currentI + 1;
			return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne);

		}

		currentI = currentI + 1;
		return recursivePrimeSum(array1, array1[currentI][3], currentI, currentJ, iLimit, primeSumOne);

	}

	public boolean secRecursivePrimeSum(long array1[][], long oldPrime, long otherPrime, int secRecI, int secRecJ,
			long iLimit) {

		if (otherPrime == 2 || otherPrime == 3) {
			return true;
		}
		if (otherPrime == 1) {
			return false;
		}

		if (isPrime(otherPrime)) {
			for (int j = secRecJ - 1; j <= secRecJ + 1; j++) {
				if (j < 0 || j > 5)
					break;

				for (int i = secRecI - 1; i <= secRecI + 1; i++) {

					if (i < 0 || (i > iLimit + 1))
						break;
					if (i == 0 || (array1[i][j] == -999))
						continue;

					if (isPrime(array1[i][j])) {

						if (array1[i][j] != otherPrime && array1[i][j] != oldPrime) {
							return true;
						}

					}

				}

			}

		}

		return false;
	}

	public boolean isPrime(long n) {
		// check if n is a multiple of 2
        
    
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds till half
		for (int i = 3; i * i <= (n + 1); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}