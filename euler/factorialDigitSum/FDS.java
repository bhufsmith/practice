
import java.math.BigInteger;
public class FDS{

	public static void main( String[] args ){
		BigInteger factorial = BigInteger.valueOf(1);

		for( int i = 2; i<=100; i++){
			factorial = factorial.multiply( BigInteger.valueOf(i) ) ;
		}
		
		long sum = 0;
		BigInteger zero = BigInteger.ZERO;
		BigInteger ten = BigInteger.TEN;

		while ( factorial.compareTo( zero ) > 0 ){
			sum += factorial.mod( ten ).longValue();
			factorial = factorial.divide( ten );
		}

		System.out.println("Sum: " +  sum );
	}
}
