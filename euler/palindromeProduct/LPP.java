public class LPP{
	
	public static void main(String[] args){
		LPP lpp = new LPP();
		System.out.println( lpp.largestPalandromicProduct(3) );
	}


	public int largestPalandromicProduct(int numdigits){
		int largest = 9;
		int smallest = 1;
		for( int d=0; d<numdigits - 1 ; d++){ 
			largest *= 10;
			largest += 9;
			smallest *= 10;		
		}

		
		int largestPalindrome = -1;
		int product = 0;
		for(int l = largest; l>=smallest; l--){
			for( int v = l; v >= smallest; v--){
				product = v * l;
				if( isPalandromic(product)  && product > largestPalindrome){
					largestPalindrome = product; 
				} 
			} 

		}
		return largestPalindrome;
	}

	public boolean isPalandromic(int i){
		String digits = String.valueOf(i); 
		
		int beginning = 0;
		int end = digits.length() - 1;
		
		for(; beginning <= end;){
			if( digits.charAt(beginning) != digits.charAt(end) ) {
				return false;
			}
			beginning++;
			end--;

		} 
		return true;
	}
	
}
