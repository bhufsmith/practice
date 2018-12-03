import java.util.stream.IntStream;
public class SOP{

	public static void main(String[] args){
		SOP sop = new SOP();
		System.out.printf("Sum of primes: %,.0f%n", sop.sumOfPrimesBelowN( 2000000 ) );
	}

	public double sumOfPrimesBelowN(int n){
		int[] primes = sieveOfEratosthenes( n );

		return IntStream.range(2, primes.length)
				.filter( i -> primes[i] == 1 )
				.mapToDouble(i -> i)
				.sum();
	}
	
	public int[] sieveOfEratosthenes(int limit){
		int[] sieve = new int[ limit + 1 ];
		
		int prime = 2;
		for(; prime <= limit; ){
			sieve[prime] = 1;
			for( int num = 2*prime; num <= limit; num += prime){
				//Mark the prime.
				sieve[num] = -1;
			}

			//find the next prime
			while ( prime <= limit && sieve[prime] != 0 ){
				prime++;
			}
		}
		return sieve;
	}
}
