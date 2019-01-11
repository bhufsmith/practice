

public class DCF{


	//We will examine fractions with a singe common digit in the numerator and 
	//the denominator. 
	public static void main(String[] args){
		//Since we are interested in fractions with a single common digit 
		//in a two digit numerator and denominator, we need a numerator digit, a denominator digit
		// and one common digit. 
		double num1, num2;
		double den1, den2; 
		double comparison; 

		int numProd = 1; 
		int denProd = 1; 

		for( int n = 1; n <= 9; n++){
			for( int d = 1; d <= 9; d++){
				for( int c = 1; c <= 9; c++ ){
					//Ensure double division, rather than integer division.
					comparison = (1.0 * n)/d;

					num1 = (n * 10) + c;
					num2 = (c * 10) + n;

					den1 = (d * 10) + c;
					den2 = (c * 10) + d;

					if( num1 < den1 && num1/den1 == comparison){
						System.out.println( num1 + "/" + den1 );
						numProd *= num1; 
						denProd *= den1;
					}

					if( num1 < den2 && num1/den2 == comparison){
						System.out.println( num1 + "/" + den2 );
						numProd *= num1; 	
						denProd *= den2;

					}

					if( num2 < den1 && num2/den1 == comparison){
						System.out.println( num2 + "/" + den1 );
						numProd *= num2; 
						denProd *= den1;
					}

					if( num2 < den2  && num2/den2 == comparison){
						System.out.println( num2 + "/" + den2 );
						numProd *= num2; 
						denProd *= den2;					
					}
				}
			}
		}

		System.out.println(numProd + "/" + denProd);
	}


	public static void printReduced( int numerator, int denominator ){
		
	}

}
