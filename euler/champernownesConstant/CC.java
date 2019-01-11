

import java.util.*;
public class CC{

	public static void main(String[] args){
		
		StringBuilder champer = new StringBuilder(".");
		String champerStr;
		char zero = '0';

		int maxLen = 1000000;
		for( int i = 1; champer.length() <=  maxLen; i++ ) {
			champer.append(i);
		} 
		
		//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
		int[] indexes = {1, 10, 100, 1000, 10000, 100000, 1000000}; 		
		
		champerStr = champer.toString();
		long ans = champerStr.charAt( indexes[0]) - zero;
		for ( int i = 1; i<indexes.length; i++){
			ans *= ( champerStr.charAt( indexes[i] ) - zero );
		} 
		System.out.println(ans); 
	}
}
