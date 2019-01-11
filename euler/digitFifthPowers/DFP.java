
import java.util.ArrayList;
public class DFP{

	public static void main(String[] args){

		int bound = 99999999;
		int power = 5; 

		int number; 
		int digit;
		int sum; 
		double fifthPowerSum = 0;
	
		//Compute the fifth power of each digit only once
		//Rather than n times 

		int[] powers = new int[10];
		for ( int i = 0; i < 10; i++ ){
			powers[i] = (int) Math.pow(i, power);
		}

		for( int n = 10; n <= bound; n++ ){
			number = n;
			sum = 0;

			while ( number > 0 ){
				digit = number % 10;
				number = number / 10;
				sum += powers[ digit ]; 
			}

			if( sum == n ){
				fifthPowerSum += sum;
				System.out.println( sum ); 
			} 
		}

		System.out.println("Fifth power sum: " + fifthPowerSum );
  	}
}
