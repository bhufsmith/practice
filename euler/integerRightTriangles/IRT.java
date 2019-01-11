
import java.util.*;
public class IRT{

	public static void main(String[] args){

		Map<Integer, List<String> > perimTriplets = new HashMap<>();

		int max = 1000; 
		double c;
		List<String> triplets;
		int perimeter; 

		for ( int a = 1; a < max; a++){
			for ( int b = 1; b<max; b++ ){
				c = Math.sqrt( Math.pow( a, 2) + Math.pow(b, 2) ); 
				if( c == Math.floor( c ) ) {
					perimeter = a + b + (int)c;
					if( perimeter <= 1000 ){ 
						triplets = (perimTriplets.containsKey( perimeter ))? perimTriplets.get( perimeter ) : new ArrayList<>();
						triplets.add( String.format("{%d, %d, %.0f}", a, b, c) );
						perimTriplets.putIfAbsent( perimeter, triplets);
					}
				}	
				
			}
		}

		int maxPerim = 0;
		List<String> maxTriplets = new ArrayList<>();
		triplets = new ArrayList<>();
		for( Integer perimKey : perimTriplets.keySet() ){
			triplets = perimTriplets.get( perimKey );
			if( triplets.size() > maxTriplets.size() ){
				maxPerim = perimKey;
				maxTriplets = triplets;
			}
		}
		System.out.println("Perimeter: " + maxPerim );
		System.out.println("Triplets: " + maxTriplets.toString());
	}
}
