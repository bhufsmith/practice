import java.util.Arrays;

public class QP{
	

	public static void main(String[] args){

		//First we need the primes. 
		boolean[] primes = sieveOfEratosthenes(10000000);
		int maxPrimes = 0;
		int A = -999999;
		int B = -999999;		


		//Working with n^2 + an + b
		//Define the set of equations to test
		// |a| < 1000 && |b| <= 1000
		int primeCount = 0;
		for( int a = -999; a < 1000; a++ ){
			for( int b = 0; b <= 1000; b++ ) {
				//Test and return the number of found primes.
				primeCount = numPrimes(a, b, primes);

				if( primeCount > maxPrimes ) {
					A = a;
					B = b;
					maxPrimes = primeCount;

					System.out.printf("n^2 + %dn + %d: count:%d%n", A, B, maxPrimes);
				}
			}
		} 
		System.out.printf("Product of a and b is %d * %d: %d%n", A, B, A*B);
	}

	//This is the helper that will evaluate our equations given a and b
	public static int numPrimes(int a, int b, boolean[] prime) {
		//n^2 + an + b
		int primeCount = 0;

		//Eval for n  = 0;
		int value = b;
 				
		for( int n=1; (value > 0 && prime[ value ]); n++ ){
			primeCount ++;
			value = (n*n + a*n + b);
		}

		return primeCount;
	}

	public static boolean[] sieveOfEratosthenes(int max){
		boolean[] prime = new boolean[ max + 1 ];
		
		Arrays.fill( prime, true );
		prime[0] = false;
		prime[1] = false;

		for( int num=2; (num * num)< max; num++){
			if( prime[ num ] ){
				for( int scale = 2; (scale * num) < max; scale ++ ){
					prime[ scale * num ] = false;
				}
			} 
		}
		return prime;
	}


}
