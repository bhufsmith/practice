public class SM{

	public static void main(String[] args){
		SM sm = new SM();
	//	sm.test(630);
		System.out.println( "Smallest 10: " + sm.smallestMultipleUpToN(20) );
	}


	//This method will find the smallest multiple that is divisible by all numbers from 1 to n inclusive 
	public int smallestMultipleUpToN( int n ){
		//first factorize the biggest number. This gives us the array we need. 
		int[] factors = factorize(n);
		
		//Now do this for all numbers less than n, and merge them together. 
		int[] mergeFactors;
		for( int i = n-1; i>1; i--){
			mergeFactors = factorize(i);
			for(int j = 2; j<mergeFactors.length; j++){
				//We need to ensure we have at least the same number of factors for each
				if( mergeFactors[j] > factors[j] ){
					factors[j] = mergeFactors[j];
				}
			}
		}

		//Now multiply to find the answer.
		int ans = 1; 
		for( int i=2; i<factors.length; i++ ) {
			if( factors[i] != 0 ){
				System.out.printf("%d: %d\n", i, factors[i] ); 
				ans *= Math.pow(i,  factors[i]);
			}
		}
		return ans; 
	}

	public int[] factorize(int n){
		//First determine a factor;
		int max = n/2;
		int smallest = 1;
		int factor2 = 0;

		int[] factors = new int[n+1];

		for( int i=2; i<=max; i++){
			if( n % i == 0){
				smallest = i;
				break;	
			}
		}

		if( smallest == 1){
			factors[n]++;
		}
		else{
			//Find the multiplyer
			factor2 = n / smallest;
			//Increment the counts.
			factors [smallest]++;

			//Account for any factors of our multiplyer 
			int[] subfactors = factorize( factor2 );
			for(int i=2; i<subfactors.length; i++){
				factors[i] += subfactors[i];
			}
		}
		return factors;
	}
}
