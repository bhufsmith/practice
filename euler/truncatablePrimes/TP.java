
import java.util.Arrays;
public class TP{

	public static void main(String[] args){
		boolean[] primes = sieve(1000000);
		
		int curr;
		int reverse; 
		int scalar;
		boolean truncatable = true;
		long sum = 0; 
		//Starting with the first double digit prime
		for( int i = 11; i < primes.length; i++){
			if( primes[i] ){
				curr = i;
				reverse = 0;
				scalar = 1; 
				truncatable  = true;  
				while( curr >= 10 ){
					reverse += scalar * (curr % 10);
					scalar *= 10;
					curr = curr / 10;

					if( ! (primes[reverse] && primes[curr]) ){
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
