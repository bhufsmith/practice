import java.util.*;
import java.util.stream.IntStream;
public class PDS{

	public static void main(String[] args){
		new PDS().powersOfTwo( 1000 );
	}

	public void powersOfTwo(int nthPower){
		List<Byte> digits = new ArrayList<Byte>(301);
		digits.add( (byte)2);

		byte multiplyer = 2;
		byte additive = 0;
		
		byte curr = 0;
		for ( int i=1; i< nthPower; i++){
			for(int d = 0; d < digits.size(); d++){
				//Get our digit
				curr = digits.get(d);
				
				//multiply and add in the spill over
				curr *= multiplyer;
				curr += additive;

				//Now that we hav multiplied the digit we need to check for > 10 result. 
				additive = (byte)(curr/ 10); //the spill over (integer division truncates)
				curr = (byte)(curr % 10);  

				//Update the value
				digits.set(d, curr);
			}

			//Is there a remainder to spill over into another digit
			if ( additive > 0 ){
				digits.add(additive);
				additive = 0;
			}
		}

		printAndSumDigits(digits);
	}

	private void printAndSumDigits( List<Byte> digits ){
		long sum = 0;
		byte digit = 0;
		for( int i = digits.size() - 1; i>=0; i--){
			digit = digits.get(i);
			sum += digit;
			System.out.print( digit );
		}

		System.out.println("Sum: " + sum);
	}
}
