
import java.util.*;
public class AN{

	public static void main(String[] args){
		AN an = new AN();

		System.out.println("Sum: " + an.sumOfAmicableNumbers( 10000 ));
	}

	public long sumOfAmicableNumbers( int limit){
		long sum = 0;
		Map<Integer, Integer> numberFactors = new HashMap<>();
		
		List<Integer> facts;
		int listSum = 0;
		for( int num = 1; num <= limit; num++){
			facts = factors( num );
			listSum = listSum( facts ); 
			numberFactors.put( num, listSum);
			
			//System.out.println("Factors for " + num);
			//System.out.println("--" + facts.toString());
			//System.out.println("---Sum:" + listSum);
			
		}

		for( Integer key: numberFactors.keySet() ){
			Integer value = numberFactors.get( key );
			Integer amicable = numberFactors.get( value );

			if( key.equals( amicable ) && ! key.equals(value) ){
				System.out.printf("%d and %d are amiable%n", value, amicable);
				sum += key;
			} 
		}
		return sum;
	}

	private int listSum( List<Integer> list){
		return list.stream().mapToInt(i-> i).sum();
	}

	private List<Integer> factors( int n ) {
		List<Integer> factorList = new ArrayList<Integer>();
		for( int i = 1; i <= n/2; i++){
			if( n % i == 0 ){
				factorList.add(i);
			}
		}
		return factorList;
	}
}
