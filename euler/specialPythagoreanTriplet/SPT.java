public class SPT{

	public static void main(String[] args){
		SPT spt = new SPT();
		System.out.printf("The product is: %d%n", spt.specialPythagoreanProduct(1000));
	}

	public int specialPythagoreanProduct(int sum){
		//Remember a<b<c  
		int maxC = (sum/2) - 1;


		int c = 0;
		for( int b = 2; b < maxC; b++){
			for( int a = 1; a<b; a++ ){
				c = sum - a - b;
				if( (a*a) + (b*b) == (c*c) ){
					System.out.printf("[a: %d, b: %d, c: %d] sum: %d]", a, b, c, a+b+c);
					return (a*b*c);
				}	
			} 
		}
	
		return -1;	
	}
}
