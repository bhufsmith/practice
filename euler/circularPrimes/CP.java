
import java.util.*;
public class CP{

	public static void main(String[] args){
		int max = 1000000;
		boolean[] prime = sieveOfEratosthenes( max );
		int numCircularPrimes = 0;
		
		for( int i=0; i<prime.length; i++ ) {
			if( isCircularPrime( i, prime ) )  {
				numCircularPrimes++; 
				System.out.println( i );
			}
		}

		System.out.println("Number or circular primes: " + numCircularPrimes);
	}

	public static boolean isCircularPrime(int n, boolean[] prime){
		int rotated = rotate( n );
		
		if( prime[n] ){
			while( n != rotated ){
				if( !prime[ rotated ] ){
					return false; 
				}
				rotated = rotate( rotated );
			}
			return true;
		}
		return false; 		
	}
	
	public static int rotate ( int i ){
		int scalar = 1;
		int append = i/10; 
	
		int rotateDigit = i %10; 

		while( append > 0 ){
			scalar *= 10; 
			append /= 10;
		}
		
		return (rotateDigit * scalar) + (i/10);
	}


	public static boolean[] sieveOfEratosthenes(int maxVal){
		boolean[] prime = new boolean[maxVal  + 1];
		Arrays.fill( prime, true );
		prime[0] = false;
		prime[1] = false; 

		int curr = 0;
		for( int i = 2; i * i < maxVal; i++ ){
			if( prime[i] ){
				for( curr = 2 * i; curr <= maxVal; curr += i ){
					prime[ curr ] = false;
				}
			}
		}
		return prime; 
	}
}
