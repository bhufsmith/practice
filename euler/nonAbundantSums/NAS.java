import java.util.*;
import java.util.stream.IntStream;
public class NAS{

	private int limit = 28123;
//	private int limit = 999999;

	public static void main(String[] args){
		NAS nas = new NAS();

		System.out.println("NAS: " + nas.nonAbundantSum() );

//		for(int i=0; i< 99999; i++){
//			nas.isAbundant(i);
//		}
	}
	
	public long nonAbundantSum(){
		//Here are all the abundant numbers.
		int[] abundantNumbers = IntStream.range(1, this.limit + 1)
							.filter( i -> isAbundant( i ) )
							.toArray();

		//Here we will mark all the numbers that can be summed to by abundant integers.
		boolean[] abundantSummable = new boolean[this.limit + 1];

		//For every sum 
		int sumable = 0;
		for( int i = 0; i<abundantNumbers.length; i++){
			for( int j = 0; sumable <= limit && j < abundantNumbers.length; j++){
				abundantSummable[ sumable ] = true;
				sumable = abundantNumbers[ i ] + abundantNumbers[ j ];
			}
			sumable = 0;
		}
		
		long sum = 0;
		for( int i=0; i < abundantSummable.length; i++ ){
			if( !abundantSummable[i] ){
				sum += i;
			}
		}

		return sum;
	}

	public boolean isAbundant(int n){
		List<Integer> factors = factorList(n);
		long sum = factors.stream()
				.map(i -> Long.valueOf(i))
				.reduce( 0L, (s, i) -> s + i );

//		System.out.println(n);
//		System.out.println("--" + factors);
//		System.out.println("---Sum: " + sum + " abundant: " + (sum>n) );
		 
		return sum > n;
	}

	public List<Integer> factorList( int n ){
		List<Integer> factors = new ArrayList<>();

		for( int i = 1; i <= (n/2); i++){
			if( n % i  == 0 ){
				factors.add(i);
			}
		} 
		return factors;
	}

}
