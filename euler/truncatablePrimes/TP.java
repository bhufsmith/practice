
import java.util.Arrays;
public class TP{

	public static void main(String[] args){
		boolean[] primes = sieve(1000000);
		
		//We need to keep track of both left and right removals. 
		int rightTruncate;
		int leftTruncate; 
		int scalar;
		boolean truncatable = true;
		long sum = 0; 
		//Starting with the first double digit prime
		//We will truncate from the right, and build the left truncate 
		//Case from right to left as we go. 
		for( int i = 11; i < primes.length; i++){
			if( primes[i] ){
				rightTruncate = i;
				leftTruncate = 0;
				scalar = 1; 
				truncatable  = true;  
				while( rightTruncate >= 10 ){
					leftTruncate += scalar * (rightTruncate % 10);
					scalar *= 10;
					rightTruncate = rightTruncate / 10;

					if( ! (primes[ leftTruncate ] && primes[ rightTruncate ]) ){
					truncatable = false;
					}
				}
				if(truncatable){
					sum += i; 
					System.out.println(i);		
				}
			}
		}
		System.out.println("sum: " + sum);

	}


	public static boolean[] sieve( int max ){
		boolean[] primes = new boolean[ max + 1 ];

		Arrays.fill( primes, true);
		primes[0] = false;
		primes[1] = false; 

		for( int i=2; i*i<max; i++ ){
			if( primes[i] ){
				for( int curr = i * 2; curr < max; curr += i ){
					primes[curr] = false;
				}
			}	
		} 
		return primes;
	}
}
