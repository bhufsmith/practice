
import java.util.*;
public class PP{

	public static void main(String[] args) {
		PP pp = new PP();

		int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Set<Integer> products = pp.permutations(digits, new int[ digits.length ], 0);


		int sum = 0;
		for( int product : products ){
			System.out.println(product );
			sum += product;
		}
		System.out.println("products: " + products.size() + " productSum:" + sum);
	}

	public Set<Integer> permutations( int[] digits, int[] prefix, int index){
		
		Set<Integer> perms = new HashSet<>();

		if ( digits.length == 0 ){

			perms = pandigitalProducts( prefix );
			return perms;
		}

		int[] nextPrefix;
		int[] remainingDigits;
		for( int i = 0; i < digits.length; i++ ){
			nextPrefix = prefix.clone();
			nextPrefix[index] = digits[i];
			
			remainingDigits = new int[ digits.length - 1 ];
			System.arraycopy( digits, 0, remainingDigits, 0, i);
			System.arraycopy( digits, i+1, remainingDigits, i, digits.length - i - 1 );
			
			perms.addAll( permutations( remainingDigits, nextPrefix, index + 1 ) );
		}

		return perms;
	} 


	//Given a permutation of digits, determine if we can split them to be a product. 
	private Set<Integer> pandigitalProducts(int[] permutation){

		Set<Integer> products = new HashSet<>();
		//For each potential product
		int product;
		int multiplier;
		int multiplicand;
		int[] productArr;
		for ( int j = permutation.length - 1; j>=0; j--){
			//Check if the remaining digits could form the product.
			product = digitsToNum( permutation, j, permutation.length); 
			
			for( int i = 0; i < j; i++ ){
				multiplier = digitsToNum( permutation, 0, i); 
				multiplicand = digitsToNum( permutation, i, j);
				
				if( multiplier * multiplicand == product ){
					//multiplier x multiplicand = product 
					products.add( product );
				}
			}
		}
		return products;
	}

	private int digitsToNum(int[] digits, int start, int end){
		int num = 0;
		for( int i = start; i < end; i++){
			num = (10 * num) + digits[i] ;
		}

		return num;
	}

}
