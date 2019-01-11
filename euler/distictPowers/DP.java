import java.util.*;

public class DP{

	public static void main(String[] args){

		//Need all a and b of thw form a^b from  2 <= n <= 100
		int min = 2;
		int max = 5;

		Set<Double> sortedPowers = new TreeSet<Double>();
		for( int a = min; a <= max; a++ ){
			for( int b = min; b <= max; b++ ){
				sortedPowers.add( Math.pow(a, b) );
			}
		
		}

		System.out.println( sortedPowers.size() );
	
	}

}
