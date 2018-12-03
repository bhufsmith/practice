
public class Primes{
	public static void main(String[] args) {
		Primes p = new Primes();
		int n = 10001;
		System.out.printf("The %,dst prime is: %,d %n", n, p.sieveOfEratosthenes( 2000000000, n) );
	}

	//Here n is the largest number we will consider as part of our sieve.
	//The calculation will stop when the nthPrime has been found.  
	private int sieveOfEratosthenes(int n, int nthPrime){
		int[] sieve = new int[ n+1 ];

		//we will start at the first prime,  2.
		sieve[0] = -1;
		sieve [1] = -1;
		int prime = 2;

		int primeCount = 1;
		for(; primeCount < nthPrime && (prime*2 < n); prime = findNextPrime( prime + 1, sieve )){
			//System.out.printf("%d: %d\n", primeCount, prime);

			//fill in all multiples of the selected prime.
			sieve[ prime ] = 1 ;
			for(int curr = (2*prime); curr <= n; curr += prime){ sieve[ curr ] = -1; }
			primeCount++;
		}
		System.out.println("Prime Count: " + primeCount);
		return prime;
	}

	private int findNextPrime(int startIndex, int[] sieve){
		
		int index = startIndex;
		while( sieve[ index ] == -1 ){
			index++;
		}
		return index; 
	}

}

