import java.util.stream.IntStream;
public class LPIS{
	
	//Used for finding int values from char values. 
	char zero = '0'; 

	public static void main(String[] args){
		LPIS lpis = new LPIS();

		 String series = "73167176531330624919225119674426574742355349194934"
                        + "96983520312774506326239578318016984801869478851843"
                        + "85861560789112949495459501737958331952853208805511"
                        + "12540698747158523863050715693290963295227443043557"
                        + "66896648950445244523161731856403098711121722383113"
                        + "62229893423380308135336276614282806444486645238749"
                        + "30358907296290491560440772390713810515859307960866"
                        + "70172427121883998797908792274921901699720888093776"
                        + "65727333001053367881220235421809751254540594752243"
                        + "52584907711670556013604839586446706324415722155397"
                        + "53697817977846174064955149290862569321978468622482"
                        + "83972241375657056057490261407972968652414535100474"
                        + "82166370484403199890008895243450658541227588666881"
                        + "16427171479924442928230863465674813919123162824586"
                        + "17866458359124566529476545682848912883142607690042"
                        + "24219022671055626321111109370544217506941658960408"
                        + "07198403850962455444362981230987879927244284909188"
                        + "84580156166097919133875499200524063689912560717606"
                        + "05886116467109405077541002256983155200055935729725"
                        + "71636269561882670428252483600823257530420752963450";


		double ans = lpis.largestProductInSeries(series, 13);
		System.out.printf("The max product for 13 adjacent numbers is: %,.0f\n", ans);
	}

	public double largestProductInSeries(String series, int numDigits){
		
		double maxProduct =IntStream.range(0, series.length() - numDigits) 
						.mapToObj( 
							//get each set of n digits as a string.
							i-> series.substring(i, i+numDigits)
						)

						//map each set of n digits to a double by multiplying
						.mapToDouble( s->  multiplyDigits( s ) )

						//Find the max value 
						.max().getAsDouble();
		
		return maxProduct;
	}

	private double multiplyDigits( String s ){
		return 	s.chars()
			.mapToDouble(c -> (c - zero) )
                	.reduce(1, (product, next ) -> product * next);
	}
}
