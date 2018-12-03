
import java.math.BigInteger;
public class FN{

	public static void main(String[] args){
		
		BigInteger min = BigInteger.valueOf(10).pow(999);
		BigInteger last = BigInteger.valueOf(1);
		BigInteger curr = BigInteger.valueOf(1);
		BigInteger tmp;
		long index = 2;
		while( curr.compareTo(min) < 0 ){
			tmp = last.add(curr);
			last = curr;
			curr = tmp;
			index ++; 
		}

		System.out.println( "Last: " + last );
		System.out.println( "Curr: " + curr );
		System.out.println( "index: " + index);
	}
}
