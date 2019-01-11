

public class DF{


	//We are looking for the factorial of each digit summed to equal the number in question. 
	//e.g. 145 = 1! + 4! + 5! 
	//We can bound this potential by looking at 9!. 
	//9! * 8 = 2,903,040  
	//e.g. if we have 8 digits, we can not possible add up to that value, even if all digits are 9. 
	//So we can use a naive bound of 9! * 7 = 2,540,160, but this could be limited further.
	public static void main(String[] args){
		int MAX = 2540160;
		long digitFactorialSum = 0;
		int curr; 
		int sum; 
		int digit; 
		for( int i = 3; i < MAX; i++ ){
			curr = i;
			sum = 0; 
			while( curr > 0 ){
				digit = curr % 10; 
				curr = curr / 10;

				sum += fact(digit); 					
			} 

			if( sum == i ){
				System.out.println( i ); 
				digitFactorialSum += i; 
			}
		}

		System.out.println("total: " + digitFactorialSum); 
	}

	public static int fact(int n){

		if( n <= 1 ) {
			return 1; 
		}
		return n * fact( n - 1 ); 
	}
}
