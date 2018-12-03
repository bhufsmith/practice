
public class SSD{

	public static void main(String[] args){
		SSD ssd = new SSD();
		int n = 100; 
		System.out.printf("The sum square difference for the first %d natural numbers is: %.0f\n", n, ssd.squaredSumDifference(n));
	}
	
	//Here, n is the last number in the sum. 
	public double squaredSumDifference(int n){

		double sumSquared = 0;
		double squaresSummed = 0;
		
		for( int i=1; i <= n; i++ ){
			sumSquared += i;
			squaresSummed += (i*i);
		}
		sumSquared *= sumSquared;
		
		return Math.abs( squaresSummed - sumSquared);
	}
}
