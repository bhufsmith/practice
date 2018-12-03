import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.util.*;

public class HDTN{

	public static void main(String[] args ){
		HDTN hdtn = new HDTN( 2000000);
		int numDiv = 500;
		System.out.printf("Triangle number with more than %d divisors: %,d%n", numDiv, hdtn.highlyDivisible( numDiv + 1 ) );		
		//System.out.println("num factors: " + hdtn.numDivisorsTree(144));
	}

	private int[] primes;

	public HDTN( int maxPrime ){
		primes = sieveOfEratosthenes( maxPrime );
	}
	

	public long highlyDivisible(int minDiv){
		long triangle = 0;
		int numDiv = 0;
		for( int i=0; numDiv <= minDiv; i++ ){
			triangle = nthTriangle( i ); 
			numDiv = numDivisorsTree( triangle ); 
		} 

		return triangle;
	}

	private long nthTriangle( long n ){
		return (n*(n+1))/2;
	}

	private int numDivisorsTree( long value ){
		Map<Long, Long> factors = new HashMap<Long, Long>();
		long prime = 0;
		long other = value;

		long valueInMap;
		int i = 0;
		for(; (other > 1) && (i < primes.length); i++ ){

			if( other % this.primes[i] == 0) { 
				prime = this.primes[i];
				other = other / prime;
				
				if( factors.containsKey( prime ) ){
					valueInMap = factors.get(prime);
					factors.put(prime, valueInMap + 1); 
				}
				else{
					factors.put( prime, 1L );
				}

				i=-1;
			}
		}
		
		int numFactors = 1;
		for( long key : factors.keySet() ) {
			numFactors *= factors.get(key)+1;
		}
		
		return numFactors;		
	}

	//Generate our list of primes.
	private int[] sieveOfEratosthenes( int maxVal ){
		//Named notPrime, because false is the default value
		//we have no need to fill true
		//so !notPrime[ i ] is true if i is prime
		boolean[] notPrime = new boolean[ maxVal + 1 ];

		for( int prime = 2; prime*prime < maxVal; prime++ ) {
			if( ! notPrime[ prime ] ){
				for(int index = 2*prime; index <= maxVal; index += prime){
					notPrime[index] = true;			
				}
			}
		}
		int[] primes = IntStream.range(2, maxVal+1)
					.filter( i -> !notPrime[i] )
					.toArray();

		return primes;
	}
}
