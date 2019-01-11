
import java.util.*;

public class PM{

	static int NumDigits = 9;
	
	public static void main(String[] args){
		//we are looking at numbers of the form m(1, 2, 3....n)
		//Where the concatination of each product results in a pandigital number. 
		//If n = 1, then max is at most, the largest pandigital number. 
		//int max = 987654321;

		//We are limited to n>=2, so m is at most 4 digits. Since at 5 digits, String( m(1) ) + String( m(2) ) is 10 digits minimum. 
		//A max of 9 digits is required, since we can only use each of 9 digits once. 
		
		int max = 9999;
		int maxN; //We can bound N by  Floor( 9 / len ( Str ( n ) ))


		int maxPandigital = 0;
		int currPandigital;
		String numberString;
 
		for( int m = 1; m < max; m++ ){
			maxN = (int) Math.floor( NumDigits / String.valueOf(m).length() );
			numberString = "";
			for( int n = 1; n <= maxN; n++ ){
				numberString += String.valueOf( n * m );
			}

			if( is1To9Pandigital( numberString ) ){
				currPandigital = Integer.valueOf( numberString );

				if( currPandigital > maxPandigital )
					maxPandigital = currPandigital; 
			}	
		}

		System.out.println(maxPandigital);		
	}

	//Assuming all strings are just a number
	//Just look for length 9 and no repeating digits.
	public static boolean is1To9Pandigital( String s ){
		//Yes, we are checking character integers... 
		//Makes no difference for equality check
		Set<Character> digits = new HashSet<Character>();
		int length = s.length();

		if( length != NumDigits )
			return false;
		
		for( int i = 0; i < NumDigits; i++ ){
			if ( !digits.add( s.charAt( i )) || s.charAt(i) == '0' ){
				return false;
			}
		}
		return true; 
	}
}
