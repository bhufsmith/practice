import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class RC{

	public static void main(String[] args){

		//First we need a list of 'd' where 1/d is periodic. 
		BigDecimal d;
		BigDecimal val; 
		int n = 1000;
		int precision = 10000;
		MathContext mc = new MathContext(precision, RoundingMode.FLOOR);

		int maxD = -1;
		int maxLen = -1;
		int currLen = -1;

		//For each one that throws an exception, we found one with a periodic decimal. 
		for( int i = 2; i <= n; i++ ){
			d = BigDecimal.valueOf( i ); 
			try{
				val = BigDecimal.ONE.divide( d );
			}catch(Exception e){
				//Now we devide with a max precision and store the value as a string. 
				System.out.println("Cycle on d=" + d);
				val = BigDecimal.ONE.divide( d, mc );
				currLen = cycleLength( val.toString() );

				if( currLen > maxLen ){
					maxD = i;
					maxLen = currLen;
				}
			}
		}

		System.out.println("Max Cycle Length: " + maxLen + " d: " + maxD);	
	}

	//Given some decimal number with a repeating cycle
	//All rounding is by floor, so we will check from the end. 

	public static int cycleLength( String decimal ){
		//Remove the "0." prefix
		String num = decimal.substring(2);
		int len = 0;

		//Starting from the middle, check for the longest sequence first. 		
		int mid = decimal.length()/2;
		for( int split = decimal.length() - 1; split > mid; split-- ){
			len = decimal.length() - split;
			if( decimal.substring( split )
				.equals ( decimal.substring( split - len, split ) )){

				return len; 
			}
		}
		return -1;
	}
}
