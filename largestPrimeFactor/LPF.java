public class LPF{
	public static void main(String[] args){
		LPF lpf = new LPF();		
		System.out.println("Largest prime factor of 60085147514 is:"+ lpf.largestPrimeFactorTree(600851475143.0));
	}

	//Largest Prime factor with a factorization tree. 
	public Double largestPrimeFactorTree(double d){

		//First find the smallest prime factor.
		Double i = Math.floor(d);
		Double smallestPrime;
		Double multiple; 

		//If the input was prime, then we can just return itself. 
		if( isPrime( i ) ) {
			return i;
		}
		smallestPrime = smallestPrimeFactor( d );
		multiple = d / smallestPrime;

		System.out.printf("Factors of %.0f: %.0f, %.0f%n", i, smallestPrime, multiple);
		return Math.max(smallestPrime, largestPrimeFactorTree(multiple) );
	}

	private Double smallestPrimeFactor( Double d ) {
                Double maxVal = Math.floor( d / 2 );

                Double smallestPrime = 0.0;
                for( double f = 2; f<maxVal; f++ ){
                        if( d % f == 0  && isPrime(f) ){
				return f;
                        }
               	}
		return null;
	}

	private boolean isPrime( double d ) {
		double maxVal = Math.floor(d/2);
		System.out.printf("Testing: %.0f", d );

		for( double curr = 2; curr < maxVal; curr ++){
			if( d % curr == 0 ){
				System.out.println("is not prime");
				return false;
			} 
		}

		System.out.println(" is prime");
		return true; 
	}

}
