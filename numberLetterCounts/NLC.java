public class NLC{

	String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", 
				   "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	String[] ten = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	String hundred = "hundred";
	String thousand = "thousand";

 
	public int numberStringCount( String numberString ){
		return (int) numberString.chars()
					.filter(s -> s != '-' && s != ' ')
					.count();
	}

	private String getNumberString( int number){
		String str = "";
		int n = number;

		int ones = n % 10;
		n = n/10;

		int tens = n % 10;
		n = n/10;

		int hundreds = n % 10;
		n = n/10;

		if( n > 0 ){
			str += one[n] + " " + this.thousand;
		}

		int teens = 10*tens + ones;

		if( hundreds > 0 ) {
			str += one[hundreds] + " " + this.hundred;

			if( teens > 0 )
				str += " and ";
		}

		if (teens < one.length){
			str += one[teens];
		}
		else{
			if( tens > 0 ){
				str += ( ten[tens] );
			
				if( ones != 0){
					str += "-";
				}
			}
		
			str += one[ones];
		}
		return str;
	}

	public static void main(String[] args){
//		int[] nums = {342, 115, 42, 52, 61, 71, 1, 2, 3, 4, 5};
		String numberString;
		int nCount = 0;
		long allCount = 0;
		for( int n = 0; n<= 1000; n++ ) {
			NLC nlc = new NLC();
		
			numberString = nlc.getNumberString( n );
			nCount = nlc.numberStringCount( numberString );
			allCount += nCount;

			System.out.println( numberString );
			System.out.println( nCount );
		}
		System.out.println("All Letter count:" + allCount);
	}

}
