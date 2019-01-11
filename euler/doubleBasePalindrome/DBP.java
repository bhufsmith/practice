import java.util.stream.*;
public class DBP{

		public static void main(String[] args){
			//looking at all numbers less than 1 000 000
			int max = 1000000; 
			
			long sum = IntStream.range(1, max)
				.filter( i -> isPalandrome( String.valueOf(i) ) ) 
				.filter( i -> isPalandrome( Integer.toBinaryString( i ) ) )
				.sum();
			System.out.println(sum);

		}

		public static boolean isPalandrome(String s){
			for( int i=0; i < s.length()/2; i++){
				if( s.charAt(i) != s.charAt( (s.length() - 1) - i )){
					return false;
				}
			}
			return true; 
		}
}
