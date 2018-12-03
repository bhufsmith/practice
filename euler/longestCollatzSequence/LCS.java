
public class LCS{

	//Largest chain under 1 million starting point
	//n > 0
	//n → n/2 (n is even)
	//n → 3n + 1 (n is odd)

	public static void main(String[] args){
		System.out.println("Largest Chain Starter: " + new LCS().longestCollatz( 1000000 ));
	}

	public long longestCollatz( int largestConsidered ){
		long largestChainLength = 1;
		long largestChainStart = 0;
		
		int currChainLength;
		long curr;
		for( long start = 2; start <= largestConsidered; start++ ){

			currChainLength = 1;
			for(curr = start; curr > 1; ){
				currChainLength++;
				curr = ( curr % 2 == 0 )? (curr / 2) : (3*curr + 1);
			}
			
			if( currChainLength > largestChainLength ) {
				System.out.printf("Start: %d, length %d%n", start, currChainLength); 

				largestChainStart = start;
				largestChainLength = currChainLength;
			}
		}

		System.out.println("Longest Chain: " + largestChainLength );
		return largestChainStart;
	}
}
